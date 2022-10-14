package com.motorolasolutions.motohunt;


public class Answers {
    int editTexts;
    String answer;
    int checkBox;


    public Answers(int editText ,int checkBox) {
        this.editTexts = editText;
        this.answer = answer;
        this.checkBox = checkBox;
    }


    public int getEditText() {
        return editTexts;
    }

    public void setEditText(int editTexts) {
        this.editTexts = editTexts;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(int checkBox) {
        this.checkBox = checkBox;
    }
}
