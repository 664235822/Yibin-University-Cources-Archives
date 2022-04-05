public class List {

    ListStruct list = null;

    public List() {
        list = new ListStruct();
    }

    public Object GetData(int index) {
        ListStruct listStruct = list;
        for (int i = 0; i < index; i++) {
            listStruct = listStruct.next;
        }
        return listStruct.data;
    }

    public void SetData(int index, Object data) {
        ListStruct listStruct = list;
        for (int i = 0; i < index; i++) {
            listStruct = listStruct.next;
        }
        listStruct.data = data;
    }

    public void AddData(int index, Object data) {
        ListStruct listStruct = list;
        for (int i = 0; i < index; i++) {
            listStruct = listStruct.next;
        }
        ListStruct object = new ListStruct();
        object.next = listStruct.next;
        object.data = data;
        listStruct.next = object;
    }

    public void RemoveData(int index) {
        ListStruct listStruct = list;
        for (int i = 0; i < index; i++) {
            listStruct = listStruct.next;
        }
        ListStruct temp = listStruct.next.next;
        listStruct.next = temp;
    }

    public void PrintAll() {
        ListStruct listStruct = list;
        while (listStruct.next != null) {
            listStruct = listStruct.next;
            System.out.println(listStruct.data);
        }
    }

    public int GetLength() {
        ListStruct listStruct = list;
        int i = 0;
        while (listStruct.next != null) {
            i++;
            listStruct = listStruct.next;
        }

        return i;
    }

    public void Transpose() {
        ListStruct listStruct = list;
        ListStruct[] temp = new ListStruct[GetLength()];
        for (int i = GetLength() - 1; i >= 0; i--) {
            listStruct = listStruct.next;
            temp[i] = listStruct;
        }

        for (ListStruct object : temp) {
            System.out.println(object.data);
        }
    }

    public boolean Palindromic() {
        int middle = GetLength() / 2;
        boolean Singular = false;
        if (GetLength() % 2 == 1) {
            Singular = true;
        }
        ListStruct listStruct = list;
        ListStruct[] left = new ListStruct[middle];
        ListStruct[] right = new ListStruct[middle];
        for (int i = 0; i < middle; i++) {
            listStruct = listStruct.next;
            left[i] = listStruct;
        }
        if (Singular) {
            listStruct = listStruct.next;
        }
        for (int i = middle - 1; i >= 0; i--) {
            listStruct = listStruct.next;
            right[i] = listStruct;
        }
        for (int i = 0; i < middle; i++) {
            if (!left[i].data.equals(right[i].data)) {
                return false;
            }
        }
        return true;
    }
}
