package bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解析的子查询树形结构
 *
 * @author yangyangthomas
 */
public class QueryTree {
    //~ Instance fields --------------------------------------------------------

    /**
     * 当前子查询节点id
     */
    @Getter
    @Setter
    private int id;

    /**
     * 父节点子查询树id
     */
    @Getter
    @Setter
    private int pId;

    @Getter
    @Setter
    private String current;

    /**
     * 只需父节点的名字
     */
    @Getter
    @Setter
    private String parent;

    @Getter
    @Setter
    private Set<String> tableSet = new HashSet<>();

    @Getter
    @Setter
    private List<QueryTree> childList = new ArrayList<>();

    @Getter
    @Setter
    private List<ColLine> colLineList = new ArrayList<>();

    @Override
    public String toString() {
        return "QueryTree [current=" + this.current
                + ", parent=" + this.parent
                + ", pId=" + this.pId
                + ", childList=" + this.childList + "]";
    }
}

// End QueryTree.java
