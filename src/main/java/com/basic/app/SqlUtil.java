package com.basic.app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlUtil {
	public static List<Map<String, Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		 List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		while (rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>(columns);
			for (int i = 1; i <= columns; ++i) {
				Object object = null;
				if(rs.getObject(i) instanceof Date) {
					Date date = (Date) rs.getObject(i);
					java.util.Date utilDate = new java.util.Date(date.getTime());
					object = utilDate;
				} else {
					object = rs.getObject(i)==null ? "" : rs.getObject(i);
				}
				row.put(md.getColumnName(i).toLowerCase(), object);
			}
			list.add(row);
		}

		return list;
	}
	
	public static List<Map<String, Object>> resultSetToArrayListNoLowerCase(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		 List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		while (rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i)==null ? "" : rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}
	
	public static void getHeaderListByRs(ResultSet rs, List<String> headerList) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; ++i) {
			headerList.add(md.getColumnName(i).toLowerCase());
		}
	}
}