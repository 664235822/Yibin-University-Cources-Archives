package Prototype;

public class WorkExperience implements ICloneable {

    private String workDate;

    private String company;

    public Object clone() {
        WorkExperience obj = new WorkExperience();
        return obj;
    }

    public void setWorkInfo(String workDate, String company) {
        this.workDate = workDate;
        this.company = company;
    }

    public String toString() {
        return "hash:" + this.hashCode() + " workDate:" + workDate + " company:" + company;
    }
}
