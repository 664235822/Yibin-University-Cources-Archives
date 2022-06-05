package entity;

import java.util.Arrays;

public class User {
	private String userName;
	private String[] hobby;//兴趣爱好
	private String[] friends;//朋友
	private String carrer;
	private String houseRegister;
	private String remark;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	public String getCarrer() {
		return carrer;
	}
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	public String getHouseRegister() {
		return houseRegister;
	}
	public void setHouseRegister(String houseRegister) {
		this.houseRegister = houseRegister;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", hobby=" + Arrays.toString(hobby) +
				", friends=" + Arrays.toString(friends) +
				", carrer='" + carrer + '\'' +
				", houseRegister='" + houseRegister + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
