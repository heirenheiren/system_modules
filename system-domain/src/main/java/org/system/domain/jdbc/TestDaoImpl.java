package org.system.domain.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TestDaoImpl extends JdbcDaoSupport implements TestDao
{
	@Override
	public void get(String id) 
	{
		this.getJdbcTemplate().update("");
	}

}
