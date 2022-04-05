public class Main {

    public static void main(String[] args) {
        // write your code here

        List list = new List();

        System.out.println("添加4个元素");
        list.AddData(0, "朱");
        list.AddData(1, "方");
        list.AddData(2, "灏");
        list.AddData(3, "钧");
        list.AddData(4, "灏");
        list.AddData(5, "方");
        list.AddData(6, "朱");

        list.PrintAll();

        if (list.Palindromic()) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }

        System.out.println("删除第3个元素");
        list.RemoveData(2);
        list.PrintAll();

        System.out.println("更改第一个元素为2");
        list.SetData(1, 2);
        list.PrintAll();

        System.out.println("第3个元素的值为：" + list.GetData(3));

        System.out.println("链表长度为：" + list.GetLength());

        System.out.println("转置后的元素输出");
        list.Transpose();

        if (list.Palindromic()) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
