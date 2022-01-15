package com.easykotlin.learn.study4;

/**
 * 在Java中，Object类是所有类的根类。为了集合类的通用性。
 * 我们把元素的类型定义为Object，当放入具体的类型的时候，再作强制类型转换。
 */
public class RawArrayList {

    /**
     * 数组长度
     */
    public int length = 0;

    /**
     * 数组
     */
    private Object[] elements;

    public RawArrayList(int length) {
        this.length = length;
        this.elements = new Object[length];
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("array index out of bounds");
        }
        return elements[index];
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, Object element) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("array index out of bounds");
        }
        elements[index] = element;
    }
}
