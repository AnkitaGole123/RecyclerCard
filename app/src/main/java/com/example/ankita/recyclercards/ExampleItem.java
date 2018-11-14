package com.example.ankita.recyclercards;

public class ExampleItem {
    private int mImageResources;
    private String mText;

    public ExampleItem(int imageResources, String text) {

        mImageResources = imageResources;
        mText = text;
    }
    public int getmImageResources(){
        return mImageResources;
    }

    public String getmText() {
        return mText;
    }
}
