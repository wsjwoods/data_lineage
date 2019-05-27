package com.woods.hiveparse1.util;

import org.junit.Test;

public class CheckTests {
    //~ Methods ----------------------------------------------------------------

    @Test
    public void checkBooleanArray() {
        boolean[] tmp = new boolean[3];
        System.out.println(Check.isEmpty(tmp));
    }

    @Test
    public void checkLongArray() {
        Long[] notNull = new Long[3];
        System.out.println(Check.isEmpty(notNull));
    }
}

// End CheckTests.java
