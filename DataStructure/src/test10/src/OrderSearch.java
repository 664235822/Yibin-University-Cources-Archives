public class OrderSearch {

    int[] list;

    int length;

    public OrderSearch(int length, int[] values) {
        this.length = length;
        list = values;
    }

    public void search(int index) {
        int result = -1;
        for (int i = 0; i < length; i++) {
            if (list[i] == index) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            System.out.println("查无此项");
        } else {
            System.out.println(result + 1);
        }
    }

    public static void main(String[] args) {
        // write your code here
        OrderSearch orderSearch = new OrderSearch(5, new int[]{
                12, 33, 15, 10, 8
        });
        orderSearch.search(20);

        orderSearch = new OrderSearch(6, new int[]{
                12, 33, 15, 10, 8, 77
        });
        orderSearch.search(12);
    }
}
