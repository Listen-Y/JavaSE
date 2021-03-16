package com.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 15:27
 */
public class MySet<E> {

    private E[] data;
    // 定义数组中存放数据大小
    private int size;

    // 有参构造方法，传入数组的容量capacity构造动态数组
    public MySet(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参构造方法，默认初始容量为capacity=10
    public MySet() {
        this(10);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

/*    // 在数组末尾添加元素
    public void addLast(E e) {
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        data[size] = e;
        size++;
    }*/

    // 在数组末尾添加元素（复用add方法）
    public void addLast(E e) {
        add(size, e);
    }

    // 在数组头部添加元素（复用add方法）
    public void addFirst(E e) {
        add(0, e);
    }

    // 数组指定位置添加元素
    public void add(int index, E e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed.Array is full.");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
            data[index] = e;
            size++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Index is illegal.");
        }
        data[index] = e;
    }

    // 查找数组中是否存在元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak 手动释放内存空间
        data[size] = null;
        return ret;
    }

    // 删除数组第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除数组最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除数组中指定元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 重写父类toString()方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

}
