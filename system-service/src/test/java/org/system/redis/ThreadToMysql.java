package org.system.redis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ThreadToMysql extends Thread
{
	public String uname;
	public String upass;
	public JedisPool pool;

	public ThreadToMysql(String uname, String upass, JedisPool pool)
	{// 构造函数传入要查询登录的老师姓名和密码

		this.uname = uname;
		this.upass = upass;
		this.pool = pool;
	}

	public void run()
	{
		Jedis jedis = pool.getResource();
		Long startTime = System.currentTimeMillis();// 开始时间
		if (jedis.get(uname) != null)
		{
			Long entTime = System.currentTimeMillis();// 开始时间
			System.out.println(currentThread().getName() + " 缓存得到的结果: " + jedis.get(uname) + " 开始时间:" + startTime
					+ "  结束时间:" + entTime + "  用时:" + (entTime - startTime) + "ms");
			pool.returnResource(jedis);
			System.out.println("释放该redis连接");
		}
		else
		{

			String url = "jdbc:mysql://127.0.0.1/test";
			String name = "com.mysql.jdbc.Driver";
			String user = "root";
			String password = "123456";
			Connection conn = null;
			try
			{
				Class.forName(name);
				conn = DriverManager.getConnection(url, user, password);// 获取连接
				conn.setAutoCommit(false);// 关闭自动提交，不然conn.commit()运行到这句会报错
			}
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			if (conn != null)
			{

				String sql = "select uname from user where uname='" + uname + "' and upass='"
						+ upass + "' ";// SQL语句
				String t_name = null;
				try
				{
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);// 获取结果集
					if (rs.next())
					{
						t_name = rs.getString("uname");
						jedis.set(uname, t_name);
						System.out.println("释放该连接");
					}
					conn.commit();
					stmt.close();
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				finally
				{
					pool.returnResource(jedis);
					System.out.println("释放该连接");
				}
				Long end = System.currentTimeMillis();
				System.out.println(currentThread().getName() + "  数据库得到的查询结果:" + t_name + "   开始时间:" + startTime
						+ "  结束时间:" + end + "  用时:" + (end - startTime) + "ms");

			}
			else
			{
				System.out.println(currentThread().getName() + "数据库连接失败:");
			}

		}
	}
}
