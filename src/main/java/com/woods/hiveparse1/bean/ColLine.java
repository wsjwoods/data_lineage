package com.woods.hiveparse1.bean;

import lombok.Getter;
import lombok.Setter;
import com.woods.hiveparse1.util.Check;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 生成的列的血缘关系
 *
 * @author yangyangthomas
 */
public class ColLine {
    //~ Static fields/initializers ---------------------------------------------

    private static final String CON_COLFUN = "COLFUN:";

    //~ Instance fields --------------------------------------------------------

    /**
     * 解析sql出来的列名称
     */
    @Getter
    @Setter
    private String toNameParse;

    /**
     * 带条件的源字段
     */
    @Getter
    @Setter
    private String colCondition;

    /**
     * 源字段
     */
    @Getter
    @Setter
    private Set<String> fromNameSet = new LinkedHashSet<>();

    /**
     * 计算条件
     */
    @Getter
    @Setter
    private Set<String> conditionSet = new LinkedHashSet<>();

    /**
     * 解析出来输出表
     */
    @Getter
    @Setter
    private String toTable;

    /**
     * 查询元数据出来的列名称
     */
    @Getter
    @Setter
    private String toName;

    private Set<String> allConditionSet = new LinkedHashSet<>();

    //~ Constructors -----------------------------------------------------------

    public ColLine() {}

    public ColLine(String toNameParse, String colCondition,
                   Set<String> fromNameSet, Set<String> conditionSet, String toTable,
                   String toName) {
        this.toNameParse = toNameParse;
        this.colCondition = colCondition;
        this.fromNameSet = fromNameSet;
        this.conditionSet = conditionSet;
        this.toTable = toTable;
        this.toName = toName;
    }

    //~ Methods ----------------------------------------------------------------

    public Set<String> getAllConditionSet() {
        this.allConditionSet.clear();
        if (needAdd()) {
            this.allConditionSet.add(CON_COLFUN + this.colCondition);
        }
        this.allConditionSet.addAll(this.conditionSet);
        return this.allConditionSet;
    }

    private boolean needAdd() {
        if (!Check.isEmpty(this.colCondition)) {
            if (Check.isEmpty(this.fromNameSet)) { // 1+1 as num �����
                return true;
            }
            String[] split = this.colCondition.split("&");
            if (split.length > 0) {
                for (String string : split) {
                    if (!Check.isEmpty(this.fromNameSet) && !this.fromNameSet.contains(string)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ColLine [toNameParse=" + this.toNameParse
                + ", colCondition=" + this.colCondition
                + ", fromNameSet=" + this.fromNameSet
                + ", conditionSet=" + this.conditionSet
                + ", toTable=" + this.toTable
                + ", toName=" + this.toName + "]";
    }
}

// End ColLine.java
