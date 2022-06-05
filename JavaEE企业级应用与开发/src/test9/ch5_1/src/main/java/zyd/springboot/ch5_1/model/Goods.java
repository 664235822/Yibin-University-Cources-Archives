package zyd.springboot.ch5_1.model;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
public class Goods {
	@NotBlank(message="商品名必须输入")
	@Length(min=1, max=5, message="商品名长度在1到5之间")
	private String gname;
	@Range(min=0,max=100,message="商品价格在0到100之间")
	private double gprice;
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
}
