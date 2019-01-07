package com.basic.app.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Repository;

import com.basic.app.SqlUtil;

@Repository
public class CustomRepository {

	@PersistenceContext
	private EntityManager em;

	public Session getSession() {
		return em.unwrap(Session.class);
	}

	public Connection getConnection() {
		Session session = getSession();
		return ((SessionImpl) session).connection();
	}

	public List<Map<String, Object>> callListProvince() throws SQLException {
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		StringBuilder sb = new StringBuilder();
		sb.append("{ ? = call list_province() }");
		CallableStatement callableStatement = conn.prepareCall(sb.toString());
		callableStatement.registerOutParameter(1, Types.VARCHAR);
		callableStatement.execute();
		ResultSet rs = (ResultSet) callableStatement.getObject(1);
		List<Map<String, Object>> list = SqlUtil.resultSetToArrayList(rs);
		rs.close();
		callableStatement.close();
		conn.close();
		return list;		
	}
}
