public class QuickSort {

    int[] list;

    public QuickSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        sort(0, list.length - 1);
    }

    void sort(int left, int right) {
        int l = left;
        int r = right;
        int pivot = list[(left + right) / 2];
        while (l < r) {
            while (list[l] < pivot) {
                l++;
            }
            while (list[r] > pivot) {
                r--;
            }
            if (l > r) {
                break;
            }

            int temp = list[l];
            list[l] = list[r];
            list[r] = temp;

            if (list[l] == pivot) {
                r--;
            }

            if (list[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            sort(left, r);
        }

        if (right > l) {
            sort(l, right);
        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(new int[]{
                12, 33, 15, 10, 8
        });

        quickSort.sort();

        quickSort.print();
    }
}
