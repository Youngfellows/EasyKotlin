package com.easykotlin.learn.study9;

/**
 * 电视
 */
public class Television {
    /**
     * 名称
     */
    private String name;

    /**
     * 大小
     */
    private int size;

    /**
     * 颜色
     */
    private String color;

    public Television() {

    }

    public Television(String name, int size, String color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Television{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * 介绍
     */
    public void introduce(int a, String city) {
        System.out.println(this.toString());
    }
}
