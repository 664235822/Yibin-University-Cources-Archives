public class InsertionSort {

    int[] list;

    public InsertionSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] < list[j]) {
                    int temp = list[i];
                    for (int k = i; k > j; k--) {
                        list[k] = list[k - 1];
                    }
                    list[j] = temp;
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
        InsertionSort insertionSort = new InsertionSort(new int[]{
                12, 33, 15, 10, 8
        });

        insertionSort.sort();

        insertionSort.print();
    }
}
