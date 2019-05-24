package bean;

import lombok.Getter;
import lombok.Setter;

public class ColumnNode {
    //~ Instance fields --------------------------------------------------

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String column;

    @Getter
    @Setter
    private long tableId;

    @Getter
    @Setter
    private String table;

    @Getter
    @Setter
    private String db;
}

// End ColumnNode.java
