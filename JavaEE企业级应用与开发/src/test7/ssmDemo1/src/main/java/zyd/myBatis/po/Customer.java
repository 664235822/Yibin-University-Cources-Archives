package zyd.myBatis.po;

/**
 * 客户持久化类
 */
public class Customer { // 主键id
    private String username; // 客户名称
    private String jobs;      // 职业
    private String phone;     // 电话

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [username=" + username +
                ", jobs=" + jobs + ", phone=" + phone + "]";
    }
}
