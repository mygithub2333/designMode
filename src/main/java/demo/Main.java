package demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.neko233.lightrail.RailPlatform;
import com.neko233.lightrail.RailPlatformFactory;
import com.neko233.lightrail.SqlLightRail;
import com.neko233.lightrail.builder.SelectSqlBuilder;
import com.neko233.lightrail.condition.JoinCondition;
import com.neko233.lightrail.pojo.User;
import com.neko233.lightrail.util.MyDataSource;
import singleton.Multitcm;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static com.alibaba.druid.pool.DruidDataSourceFactory.*;


/**
 * @author fwx
 * @date 2022/2/25
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RailPlatform lightRailPlatform = RailPlatformFactory.createLightRailPlatform(MyDbSource.getDataSource());
        String build = SqlLightRail.selectTable("user as u").select("*").join(JoinCondition.builder().join("shop as s").on("u.id=s.user_id")).groupBy("u.id").build();
        System.out.println(build);
    }
}


class MyDbSource {
    private static DataSource dataSource;

    public static Connection getConnection() throws Exception {
        return getDataSource().getConnection();
    }

    public static DataSource getDataSource() throws Exception {
        MyDbSource.dataSource = DruidDataSourceFactory.createDataSource(getDbConfig());
        return dataSource;
    }

    /**
     * 获取数据库配置
     *
     * @return 配置信息
     */
    public static Properties getDbConfig() {
        Properties properties = new Properties();
        properties.put(PROP_URL, "jdbc:mysql://localhost:3306/demo");
        properties.put(PROP_USERNAME, "root");
        properties.put(PROP_PASSWORD, "123456");
        properties.put(PROP_INITIALSIZE, "5");
        properties.put(PROP_MINIDLE, "5");
        properties.put(PROP_MAXACTIVE, "10");
        properties.put(PROP_MAXWAIT, "10000");
        return properties;
    }

    public static ResultSet executeSelect(String sql) throws Exception {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

}


