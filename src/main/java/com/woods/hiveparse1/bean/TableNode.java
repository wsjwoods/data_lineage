package com.woods.hiveparse1.bean;

import lombok.Getter;
import lombok.Setter;

public class TableNode {
    //~ Instance fields --------------------------------------------------------

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String table;

    @Getter
    @Setter
    private String db;
}

// End TableNode.java
