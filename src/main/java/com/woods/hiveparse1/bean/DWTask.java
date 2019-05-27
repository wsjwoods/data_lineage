package com.woods.hiveparse1.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据仓库任务
 *
 * @author yangyangthomas
 */
public class DWTask {
    //~ Instance fields --------------------------------------------------------

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String path;

    @Getter
    @Setter
    private String user;

    @Getter
    @Setter
    private String mail;
}

// End DWTask.java
