package controller;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import entity.MultiFileDomain;
@Controller
public class MutiFilesController {
	// 得到一个用来记录日志的对象，这样打印信息时，能够标记打印的是哪个类的信息
	private static final Log logger = LogFactory.getLog(MutiFilesController.class);
	/**
	 * 多文件上传
	 */
	@RequestMapping("/multifile")/*MultiFileDomain为自定义类，其中利用MultipartFile来进行接收文件*/
	public String multiFileUpload(@ModelAttribute("multiFileDomain") MultiFileDomain multiFileDomain, HttpServletRequest request){
		System.out.println("MutiFilesController执行multiFileUpload方法");
		System.out.println(multiFileDomain);
		String realpath = request.getServletContext().getRealPath("uploadfiles");
		System.out.println("realpath:"+realpath);
//		比如：realpath:E:\\JavaEEBookCode\\book\\SpringMVC\\ch2_6\\out\\artifacts\\ch2_6_war_exploded\\uploadfiles
		File targetDir = new File(realpath);
		if(!targetDir.exists()){
			targetDir.mkdirs();
			System.out.println("目标目录不存在，创建");
        }
		List<MultipartFile> files = multiFileDomain.getMyfile();
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String fileName = file.getOriginalFilename();
//			System.out.println(i+":"+fileName);
			if(fileName==""){
//				System.out.println("文件名为空，跳过");
				continue;
			}
			File targetFile = new File(realpath,fileName);
			//上传 
	        try {  
	        	file.transferTo(targetFile);//把上传的文件保存到指定目录
//	        	MultipartFile.transferTo（）
/*file.transferTo 方法调用时，判断如果是相对路径，则使用temp目录，为父目录 一则，位置不对，二则没有父目录存在*/
				logger.info(fileName+"上传成功");
	        } catch (Exception e) {
				logger.info(fileName+"上传失败 ");
				e.printStackTrace();
	        }  
		}
		return "showMulti";
	}

}
