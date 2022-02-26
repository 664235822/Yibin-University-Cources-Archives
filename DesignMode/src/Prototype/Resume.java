package Prototype;

import java.util.Collection;

public class Resume implements ICloneable {

    private String name;

    private String sex;

    private int age;

    private WorkExperience work;

    public Object clone() {
        Resume objResume = new Resume(this.work);
        return objResume;
    }

    public Resume() {
        work = new WorkExperience();
    }

    private Resume(WorkExperience work) {
        this.work = (WorkExperience) work.clone();
    }

    public void setPersonInfo(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperiences(String workDate, String company) {
        work.setWorkInfo(workDate, company);
    }

    public String toString() {
        return "hash:" + this.hashCode() + " name:" + name + " sex:" + sex + " age:" + age + "\n" + work.toString();
    }
}
