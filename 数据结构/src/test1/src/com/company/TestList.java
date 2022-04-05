package com.company;

public class TestList {

    private Object[] List;

    public TestList(Object[] obj) {
        List = obj;
    }

    public TestList(int length) {
        List = new Object[length];
    }

    public void Set(Object value, int index) {
        List[index] = value;
    }

    public Object Get(int index) {
        for (int i = 0; i < List.length; i++) {
            if (i == index) {
                return List[i];
            }
        }

        return null;
    }

    public void Add(Object value, int index) throws Exception {
        if(index<0)
            throw new Exception("插入位置非法");

        Object[] temp = List;
        List = new Object[List.length + 1];
        for (int i = 0; i < List.length + 1; i++) {
            if (i == index) {
                List[i] = value;
            } else if (i < index) {
                List[i] = temp[i];
            } else if (i > index) {
                if (i < List.length) {
                    List[i] = temp[i - 1];
                }
            }
        }
    }

    public void Remove(int index) {
        Object[] temp = List;
        List = new Object[List.length - 1];
        for (int i = 0; i < List.length; i++) {
            if (i < index) {
                List[i] = temp[i];
            } else if (i >= index) {
                List[i] = temp[i + 1];
            }
        }
    }

    public int GetLength() {
        int i = 0;
        for (int j = 0; j < List.length; j++) {
            i++;
        }
        return i;
    }

    public void PrintAll() {
        for (int i = 0; i < List.length; i++) {
            System.out.print(List[i]);
            if (i < List.length - 1) {
                System.out.print(",");
            }
        }
    }
}
