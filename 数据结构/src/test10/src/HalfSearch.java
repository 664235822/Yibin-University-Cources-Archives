import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HalfSearch {

    List list;

    int length;

    public HalfSearch(int length, int[] values) {
        this.length = length;
        list = new ArrayList();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
    }

    public void search(int index) {
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        });

        deepSearch(length % 2 == 1 ? length / 2 + 1 : length / 2, length, index);
    }

    void deepSearch(int current, int lastCurrent, int index) {
        if ((current == 1 || current == length) && (int) list.get(current - 1) != index) {
            System.out.print(list.get(current - 1) + "-");
            System.out.println("查无此项");
            return;
        }

        System.out.print(list.get(current - 1) + "-");
        if ((int) list.get(current - 1) == index) {
            System.out.println(current);
        } else if ((int) list.get(current - 1) > index) {
            deepSearch(current % 2 == 1 ? current / 2 + 1 : current / 2, current, index);
        } else {
            deepSearch((lastCurrent - current) % 2 == 1 ? (lastCurrent - current) / 2 + current + 1 : (lastCurrent - current) / 2 + current, lastCurrent, index);
        }
    }

    public static void main(String[] args) {
        HalfSearch halfSearch = new HalfSearch(5, new int[]{
                8, 10, 12, 15, 33
        });
        halfSearch.search(20);

        halfSearch = new HalfSearch(9, new int[]{
                12, 15, 33, 42, 45, 77, 78, 80, 89
        });
        halfSearch.search(12);
    }
}
