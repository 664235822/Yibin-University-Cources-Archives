import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        try {
            if (str.isEmpty()) {
                throw new Exception("输入值为空");
            }
            if (str.length() < 1 || str.length() > 6) {
                throw new Exception("输入值长度不正确");
            }
            int i = Integer.parseInt(str);
            if (i < 197807 || i > 198706) {
                throw new Exception("年份超出限制");
            }
            int month = Integer.parseInt(str.substring(4));
            if (month < 1 || month > 12) {
                throw new Exception("月份超出限制");
            }
            System.out.println("输入值正确");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
