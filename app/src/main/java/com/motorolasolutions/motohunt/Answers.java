package com.motorolasolutions.motohunt;


public class Answers {
    int editTexts;
    int checkBox;


    public Answers(int editText ,int checkBox) {
        this.editTexts = editText;
        this.checkBox = checkBox;
    }


    public int getEditText() {
        return editTexts;
    }

    public void setEditText(int editTexts) {
        this.editTexts = editTexts;
    }

    public int getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(int checkBox) {
        this.checkBox = checkBox;
    }
}
