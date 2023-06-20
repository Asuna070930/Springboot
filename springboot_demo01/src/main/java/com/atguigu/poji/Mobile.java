package com.atguigu.poji;

public class Mobile {
    private String num;
    private String brand;

    @Override
    public String toString() {
        return "Mobile{" +
                "num='" + num + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
