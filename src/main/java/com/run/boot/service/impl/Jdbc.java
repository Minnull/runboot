package com.run.boot.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.run.boot.util.common.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * @ClassName: JdbcUtilsTest
 * @Description:测试dbutils的demo
 * @author: null
 * @date: 2019年1月13日
 * 测试前先修改JdbcUtils的数据库连接信息
 */
public class Jdbc {

    public void testArrayHandler() throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";
        Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
        System.out.println(Arrays.asList(result));  //list  toString()
    }

    public void testArrayListHandler() throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";
        List<Object[]> list = (List) qr.query(sql, new ArrayListHandler());
        for(Object[] o : list){
            System.out.println(Arrays.asList(o));
        }
    }

    public void testColumnListHandler() throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";
        List list = (List) qr.query(sql, new ColumnListHandler("id"));
        System.out.println(list);
    }

    public void testKeyedHandler() throws Exception{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";

        Map<Integer,Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
        for(Map.Entry<Integer, Map> me : map.entrySet()){
            int  id = me.getKey();
            Map<String,Object> innermap = me.getValue();
            for(Map.Entry<String, Object> innerme : innermap.entrySet()){
                String columnName = innerme.getKey();
                Object value = innerme.getValue();
                System.out.println(columnName + "=" + value);
            }
            System.out.println("----------------");
        }
    }

    public void testMapHandler() throws SQLException{

        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";

        Map<String,Object> map = (Map) qr.query(sql, new MapHandler());
        for(Map.Entry<String, Object> me : map.entrySet())
        {
            System.out.println(me.getKey() + "=" + me.getValue());
        }
    }

    public void testMapListHandler() throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from util_common_jdbcutils_user";
        List<Map> list = (List) qr.query(sql, new MapListHandler());
        for(Map<String,Object> map :list){
            for(Map.Entry<String, Object> me : map.entrySet())
            {
                System.out.println(me.getKey() + "=" + me.getValue());
            }
        }
    }

    public void testScalarHandler() throws SQLException{
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from util_common_jdbcutils_user";  //[13]  list[13]
        int count = ((Long)qr.query(sql, new ScalarHandler(1))).intValue();
        System.out.println(count);
    }

    public void testinsert() throws SQLException{
        int count = 0;
        String sql = "insert into util_common_jdbcutils_user (name) values (?)";  //
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        Object[][] params = new Object[1][];
        params[count] = new Object[] {"test"};
        int[] batch = qr.batch(sql,params);
    }
}
