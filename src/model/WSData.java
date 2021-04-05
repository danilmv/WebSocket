package model;

import java.util.Arrays;

public class WSData {
    Data[] data;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WSData{" +
                "data=" + Arrays.toString(data) +
                ", type='" + type + '\'' +
                '}';
    }
}

class Data{
    String[] c;
    float p;
    String s;
    String t;
    int v;

    public String[] getC() {
        return c;
    }

    public void setC(String[] c) {
        this.c = c;
    }

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Data{" +
                "c=" + Arrays.toString(c) +
                ", p=" + p +
                ", s='" + s + '\'' +
                ", t='" + t + '\'' +
                ", v=" + v +
                '}';
    }
}
