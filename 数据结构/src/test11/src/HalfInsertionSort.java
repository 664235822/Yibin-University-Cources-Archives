public class HalfInsertionSort {
    int[] list;

    public HalfInsertionSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int i = 2; i < list.length; i++) {
            if (list[i] < list[i - 1]) {
                int temp = list[i];
                int low = 0;
                int high = i;
                while (low <= high) {
                    int m = (low + high) / 2;
                    if (temp < list[m]) {
                        high = m - 1;
                    } else {
                        low = m + 1;
                    }
                }
                int j;
                for (j = i-1; j >= high+1; j--) {
                    list[j + 1] = list[j];
                }
                list[j+1] = temp;
            }
        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        HalfInsertionSort halfInsertionSort = new HalfInsertionSort(new int[]{
                12, 33, 15, 10, 8
        });

        halfInsertionSort.sort();

        halfInsertionSort.print();
    }
}
