package entity;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
public class MultiFileDomain {
	private List<String> description;
	private List<MultipartFile> myfile;
	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}
	public List<MultipartFile> getMyfile() {
		return myfile;
	}
	public void setMyfile(List<MultipartFile> myfile) {
		this.myfile = myfile;
	}
	@Override
	public String toString() {
		return "MultiFileDomain{" +
				"description=" + description +
				", myfile=" + myfile +
				'}';
	}
}
