package zyd.springboot.ch5_2bootstrap.controller;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class TestFileUpload {
	/**
	 * 进入文件选择页面
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return "uploadFile";
	}
	/**
	 * 上传文件自动绑定到MultipartFile对象中，
	 * 在这里使用处理方法的形参接收请求参数。
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/upload")
	public String upload(
			HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("myfile") MultipartFile myfile) throws IllegalStateException, IOException {
		System.out.println("文件描述：" + description);
		//如果选择了上传文件，将文件上传到指定的目录uploadFiles
		if(!myfile.isEmpty()) {
			//上传文件路径
			String path = request.getServletContext().getRealPath("/uploadFiles/");
			System.out.println("上传path:"+path);
			//获得上传文件原名
			String fileName = myfile.getOriginalFilename();
			File filePath = new File(path + File.separator + fileName);
			//如果文件目录不存在，创建目录
			if(!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件中
			myfile.transferTo(filePath);
		}
		//转发到一个请求处理方法，查询将要下载的文件
		return "forward:/showDownLoad";
	}
	/**
	 * 显示要下载的文件
	 */
	@RequestMapping("/showDownLoad")
	public String showDownLoad(HttpServletRequest request, Model model) {
		String path = request.getServletContext().getRealPath("/uploadFiles/");
		File fileDir = new File(path);
		//从指定目录获得文件列表
		File filesList[] = fileDir.listFiles();
		model.addAttribute("filesList", filesList);
		return "showFile";
	}
	/**
	 * 实现下载功能
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(
			HttpServletRequest request, 
			@RequestParam("filename") String filename,
			@RequestHeader("User-Agent") String userAgent) throws IOException {
		//下载文件路径
		String path = request.getServletContext().getRealPath("/uploadFiles/");
		System.out.println("下载path:"+path);

		//构建将要下载的文件对象
		File downFile = new File(path + File.separator + filename);
		//ok表示HTTP中的状态是200
		BodyBuilder builder =  ResponseEntity.ok();
		//内容长度
		builder.contentLength(downFile.length());
		//application/octet-stream：二进制流数据（最常见的文件下载）
		builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
		//使用URLEncoder.encode对文件名进行编码
		filename = URLEncoder.encode(filename,"UTF-8");
		/**
		 * 设置实际的响应文件名，告诉浏览器文件要用于“下载”和“保存”。
		 * 不同的浏览器，处理方式不同，根据浏览器的实际情况区别对待。
		 */
		if(userAgent.indexOf("MSIE") > 0) {
			//IE浏览器，只需要用UTF-8字符集进行URL编码
			builder.header("Content-Disposition", "attachment; filename=" + filename);
		}else {
			/**非IE浏览器，如FireFox、Chrome等浏览器，则需要说明编码的字符集
			 * filename后面有个*号，在UTF-8后面有两个单引号
			 */
			builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
		}
		return builder.body(FileUtils.readFileToByteArray(downFile));
	}
}
