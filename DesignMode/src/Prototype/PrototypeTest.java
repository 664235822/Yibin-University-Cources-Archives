package Prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        // write your code here

        Resume zhangsan = new Resume();
        zhangsan.setPersonInfo("张三", "男", 29);
        zhangsan.setWorkExperiences("1998-2000", "xxx公司");
        System.out.println(zhangsan);

        Resume lisi = (Resume) zhangsan.clone();
        lisi.setPersonInfo("李四", "男", 22);
        lisi.setWorkExperiences("2002-2004", "yyy公司");
        System.out.println(lisi);
    }
}
