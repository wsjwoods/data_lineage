package util;

import bean.ColumnNode;
import dao.MetaDataDao;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MetaCache {
    //~ Static fields/initializers ---------------------------------------------

    @Getter
    private static Map<String, List<ColumnNode>> cMap = new HashMap<>();

    @Getter
    private static Map<String, Long> tableMap = new HashMap<>();

    @Getter
    private static Map<String, Long> columnMap = new HashMap<>();

    //~ Instance fields --------------------------------------------------------

    private MetaDataDao dao = new MetaDataDao();

    //~ Singleton initializers -------------------------------------------------

    private static MetaCache instance = new MetaCache();

    private MetaCache(){}

    public static MetaCache getInstance(){
        return instance;
    }

    //~ Methods ----------------------------------------------------------------

    public void init(String table){
        String[] pdt = ParseUtil.parseDBTable(table);
        List<ColumnNode> list = this.dao.getColumn(pdt[0], pdt[1]);
        if (!Check.isEmpty(list)) {
            cMap.put(table.toLowerCase(), list);
            tableMap.put(table.toLowerCase(), list.get(0).getTableId());
            for (ColumnNode cn : list) {
                columnMap.put((cn.getDb()+"."+cn.getTable()+"."+cn.getColumn()).toLowerCase(),cn.getId());
            }
        }
    }

    public void release(){
        cMap.clear();
        tableMap.clear();
        columnMap.clear();
    }

    public List<String> getColumnByDBAndTable(String table){
        List<ColumnNode> list = cMap.get(table.toLowerCase());
        List<String> list2 = new ArrayList<>();
        if (!Check.isEmpty(list)) {
            for (ColumnNode columnNode : list) {
                list2.add(columnNode.getColumn());
            }
        }
        return list2;
    }
}

// End MetaCache.java
