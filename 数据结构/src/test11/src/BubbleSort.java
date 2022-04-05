public class BubbleSort {

    int[] list;

    public BubbleSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(new int[]{
                12, 33, 15, 10, 8
        });

        bubbleSort.sort();

        bubbleSort.print();
    }
}
