package com;

public class CustomString {

    String str;

    public CustomString(String str) {
        this.str = str;
    }

    public int search(String searchStr) {
        for (int i = 0; i < str.length(); i++) {
            int k = i;
            int j = 0;
            while (str.charAt(k) == searchStr.charAt(j)) {
                k++;
                j++;
                if (j == searchStr.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String replace(String searchStr, String replaceStr) {
        int index = search(searchStr);
        String frontStr = str.substring(0, index);
        String nextStr = str.substring(index + searchStr.length());
        return frontStr + replaceStr + nextStr;
    }
}
