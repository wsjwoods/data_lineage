package bean;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 解析的SQL块
 *
 * @author yangyangthomas
 */
public class Block {
    //~ Instance fields --------------------------------------------------------

    /**
     *
     */
    @Getter
    @Setter
    private String condition;

    /**
     *
     */
    @Getter
    @Setter
    private Set<String> colSet = new LinkedHashSet<>();
}

// End Block.java
