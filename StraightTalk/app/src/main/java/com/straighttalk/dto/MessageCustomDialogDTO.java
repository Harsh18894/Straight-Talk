package com.straighttalk.dto;

import android.content.Context;

/**
 * Created by Harsh on 8/6/2016.
 */
public class MessageCustomDialogDTO {
    private Context context;
    private String title;
    private int type;
    private String message;
    private String button;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageCustomDialogDTO [context=" + context + ", title="
                + title + ", message=" + message + "]";
    }




}
