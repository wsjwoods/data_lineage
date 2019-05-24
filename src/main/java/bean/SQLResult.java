package bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

public class SQLResult {
    //~ Instance fields --------------------------------------------------------

    @Getter
    @Setter
    private Set<String> outputTables;

    @Getter
    @Setter
    private Set<String> inputTables;

    @Getter
    @Setter
    private List<ColLine> colLineList;
}

// End SQLResult.java
