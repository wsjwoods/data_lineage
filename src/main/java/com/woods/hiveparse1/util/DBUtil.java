package com.woods.hiveparse1.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

    public enum DB_TYPE {
        META, TASK
    }

    //~ Instance fields --------------------------------------------------------

    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection conn;

    //~ Constructors -----------------------------------------------------------

    public DBUtil(DB_TYPE type) {
        this.driver = PropertyFileUtil.getProperty(type.name().toLowerCase() + ".jdbc.driverClassName");
        this.url = PropertyFileUtil.getProperty(type.name().toLowerCase() + ".jdbc.url");
        this.user = PropertyFileUtil.getProperty(type.name().toLowerCase() + ".jdbc.username");
        this.password = PropertyFileUtil.getProperty(type.name().toLowerCase() + ".jdbc.password");
    }

    //~ Methods ----------------------------------------------------------------

    private void setConn() {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException classnotfoundexception) {
            classnotfoundexception.printStackTrace();
            System.err.println("db: " + classnotfoundexception.getMessage());
        } catch (SQLException sqlexception) {
            System.err.println("db.getconn(): " + sqlexception.getMessage());
        }
    }

    public int doInsert(String sql) throws Exception {
        return doUpdate(sql);
    }

    public int doDelete(String sql) throws Exception {
        return doUpdate(sql);
    }

    public int doUpdate(String sql) throws Exception {
        Statement stmt = null;
        try {
            setConn();
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(null, stmt);
        }
    }

    public List<Map<String, Object>> doSelect(String sql) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            setConn();
            stmt = conn.createStatement(
                    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                    java.sql.ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> map = rowToMap(rs, rs.getRow());
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(rs, stmt);
        }
    }


    private Map<String, Object> rowToMap(ResultSet resultset, int rowNum) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        ResultSetMetaData rsmd = resultset.getMetaData();
        int columnNum = rsmd.getColumnCount();
        for (int i = 1; i <= columnNum; i++) {
            String columnName = rsmd.getColumnLabel(i);
            map.put(columnName, resultset.getObject(columnName));
        }
        return map;
    }
    
    /**
     * Close all the statement and conn int this instance and close the parameter ResultSet.
     */
    public void close(ResultSet rs, Statement stmt) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

// End DBUtil.java
