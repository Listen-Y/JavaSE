package com.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 16:21
 */
public class MySet2<E> {

    private E[] table;
    private int size;

    public MySet2(int capacity) {
        this.size = 0;
        this.table = (E[])new Object[capacity];
    }

    public void add(E data) {
        int hash = getHash(data);
        if (table[hash] != null) {
            while (table[hash] != null && !table[hash].equals(data)) {
                hash++;
                if (hash == table.length) {
                    hash = 0;
                }
            }
        }
        table[hash] = data;
    }

    private int getHash(E data) {
        return data.hashCode() & table.length;
    }

    public MySetIterator<E> get() {
        return new MySetIterator<>(table);
    }
}



