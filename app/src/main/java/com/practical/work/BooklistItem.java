package com.practical.work;

public class BooklistItem {
    private String mLine1;
    private String mLine3;
    private String mLine2;
    public BooklistItem(String line1, String line2, String line3) {
        mLine3= line3;
        mLine1 = line1;
        mLine2 = line2;
    }

    public String getLine3() {
        return mLine3;
    }

    public String getLine1() {
        return mLine1;
    }
    public String getLine2() {
        return mLine2;
    }
}