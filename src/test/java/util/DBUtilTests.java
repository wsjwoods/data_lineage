package util;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DBUtilTests {
    //~ Methods ----------------------------------------------------------------

    @Test
    public void test() {
        try {
            DBUtil db = new DBUtil(DBUtil.DB_TYPE.META);
            List<Map<String, Object>> rs = db.doSelect("select * from t_user limit 5");
            for (Map<String, Object> map : rs) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// End DBUtilTests.java
