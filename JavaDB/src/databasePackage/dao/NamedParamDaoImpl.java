package databasePackage.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class NamedParamDaoImpl extends NamedParameterJdbcDaoSupport 
{
	public int getCircleCount()
	{
		String sql = "SELECT COUNT(*) FROM circle";
		return this.getNamedParameterJdbcTemplate().getJdbcOperations().queryForObject(sql, Integer.class);
	}

}
