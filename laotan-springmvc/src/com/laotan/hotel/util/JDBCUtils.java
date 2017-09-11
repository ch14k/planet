package com.laotan.hotel.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource dataSource = null;

	static {
		// 导入配置信息
		Properties prop = new Properties();
		try {
			prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			// DBCP核心类
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 使用dbcp获取一个数据源
	 * 
	 * @return 返回DataSource实例（数据源）
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获取一个连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	static ComboPooledDataSource ds = new ComboPooledDataSource();

	public static QueryRunner getQueryRunner() {
//		return new QueryRunner(ds);
		return new QueryRunner(dataSource);

	}

}
