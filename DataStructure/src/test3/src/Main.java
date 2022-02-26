public class Main {

    public static void main(String[] args) {
        // write your code here
        CustomQueue queue = new CustomQueue();
        System.out.println("前进");
        queue.enqueue("第一页");
        queue.enqueue("第二页");
        queue.enqueue("第三页");
        queue.enqueue("第四页");
        System.out.println("后退");
        while (!queue.empty()) {
            System.out.println(queue.dequeue());
        }
    }
}
