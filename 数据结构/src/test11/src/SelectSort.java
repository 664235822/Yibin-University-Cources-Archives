public class SelectSort {

    int[] list;

    public SelectSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i; j < list.length; j++) {
                if (list[j] < list[min])
                    min = j;
            }
            if (min != i) {
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }

        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort(new int[]{
                12, 33, 15, 10, 8
        });

        selectSort.sort();

        selectSort.print();
    }
}
