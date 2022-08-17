package com.haliron.watercalculator;

import java.io.Serializable;

public class Items implements Serializable {
    private int inputIcon1;
    private int inputIcon2;
    private int inputIcon3;
    private int inputIcon4;
    private String inputText1;
    private String inputText2;
    private String inputText3;
    private String inputText4;

    public Items(String inputText1, int inputIcon1,String inputText2, int inputIcon2, String inputText3, int inputIcon3, String inputText4, int inputIcon4)
    {
        this.inputText1 = inputText1;
        this.inputText2 = inputText2;
        this.inputText3 = inputText3;
        this.inputText4 = inputText4;

        this.inputIcon1 = inputIcon1;
        this.inputIcon2 = inputIcon2;
        this.inputIcon3 = inputIcon3;
        this.inputIcon4 = inputIcon4;

    }

    public int getInputIcon1() {
        return inputIcon1;
    }

    public void setInputIcon1(int inputIcon1) {
        this.inputIcon1 = inputIcon1;
    }

    public int getInputIcon2() {
        return inputIcon2;
    }

    public void setInputIcon2(int inputIcon2) {
        this.inputIcon2 = inputIcon2;
    }

    public int getInputIcon3() {
        return inputIcon3;
    }

    public void setInputIcon3(int inputIcon3) {
        this.inputIcon3 = inputIcon3;
    }

    public int getInputIcon4() {
        return inputIcon4;
    }

    public void setInputIcon4(int inputIcon4) {
        this.inputIcon4 = inputIcon4;
    }

    public String getInputText1() {
        return inputText1;
    }

    public void setInputText1(String inputText1) {
        this.inputText1 = inputText1;
    }

    public String getInputText2() {
        return inputText2;
    }

    public void setInputText2(String inputText2) {
        this.inputText2 = inputText2;
    }

    public String getInputText3() {
        return inputText3;
    }

    public void setInputText3(String inputText3) {
        this.inputText3 = inputText3;
    }

    public String getInputText4() {
        return inputText4;
    }

    public void setInputText4(String inputText4) {
        this.inputText4 = inputText4;
    }









}