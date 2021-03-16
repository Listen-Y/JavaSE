package com.set;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 16:56
 */
public class MySetIterator<T> implements Iterator<T> {

    private T[] tables;
    private int count;

    public MySetIterator(T[] tables) {
        this.tables = tables;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count < tables.length;
    }

    @Override
    public T next() {
        return tables[count++];
    }
}
