public class HeapSort {

    int[] list;

    public HeapSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            heapAdjust(i, list.length);
        }
        for (int i = list.length - 1; i > 0; i--) {
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            heapAdjust(0, i);
        }
    }

    void heapAdjust(int s, int m) {
        int temp = list[s];
        for (int j = 2 * s + 1; j < m; j *= 2 + 1) {
            if (j + 1 < m && list[j] < list[j + 1]) {
                j++;
            }
            if (temp >= list[j]) {
                break;
            } else {
                list[s] = list[j];
                s = j;
            }
        }
        list[s] = temp;
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(new int[]{
                12, 33, 15, 10, 8
        });

        heapSort.sort();

        heapSort.print();
    }
}
