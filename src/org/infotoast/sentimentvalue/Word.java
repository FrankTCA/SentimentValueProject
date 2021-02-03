package org.infotoast.sentimentvalue;

public class Word {
    private String str;
    private double value;
    public Word(String s, double v) {
        str = s;
        value = v;
    }

    public String getStr() {
        return str;
    }

    public double getValue() {
        return value;
    }
}
