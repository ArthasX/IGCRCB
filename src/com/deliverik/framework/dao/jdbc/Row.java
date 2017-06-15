package com.deliverik.framework.dao.jdbc;

import java.util.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Blob;

@SuppressWarnings("rawtypes")
public class Row {
	private IndexedMap data = null;

	protected Row(IndexedMap columnData) {
		this.data = columnData;
	}

	public String getString(String colName) {
		return (String) this.getObject(colName);
	}

	public String getString(int colIndex) {
		return (String) this.getObject(colIndex);
	}

	public Date getDate(String colName) {
		return (Date) this.getObject(colName);
	}

	public Date getDate(int colIndex) {
		return (Date) this.getObject(colIndex);
	}

	public Time getTime(String colName) {
		return (Time) this.getObject(colName);
	}

	public Time getTime(int colIndex) {
		return (Time) this.getObject(colIndex);
	}

	public Timestamp getTimestamp(String colName) {
		return (Timestamp) this.getObject(colName);
	}

	public Timestamp getTimestamp(int colIndex) {
		return (Timestamp) this.getObject(colIndex);
	}

	public long getLong(String colName) {
		return getBigDecimal(colName).longValue();
	}

	public long getLong(int colIndex) {
		return getBigDecimal(colIndex).longValue();
	}

	public int getInt(String colName) {
		return getNumber(colName).intValue();
	}

	public long getInt(int colIndex) {
		return getNumber(colIndex).intValue();
	}

	public double getDouble(String colName) {
		return getNumber(colName).doubleValue();
	}

	public double getDouble(int colIndex) {
		return getNumber(colIndex).doubleValue();
	}

	public float getFloat(int colIndex) {
		return getNumber(colIndex).floatValue();
	}

	public float getFloat(String colName) {
		return getNumber(colName).floatValue();
	}

	public BigDecimal getBigDecimal(int colIndex) {
		Number n = this.getNumber(colIndex);
		return getBigDecimal(n);
	}

	protected BigDecimal getBigDecimal(Number n) {
		BigDecimal bd = null;
		if (n instanceof BigDecimal) {
			bd = (BigDecimal) n;
		} else {
			bd = new BigDecimal(n.doubleValue());
		}
		return bd;
	}

	public BigDecimal getBigDecimal(String colName) {
		Number n = this.getNumber(colName);
		return getBigDecimal(n);
	}

	public boolean getBoolean(int colIndex) {
		return ((Boolean) this.getObject(colIndex)).booleanValue();
	}

	public boolean getBoolean(String colName) {
		return ((Boolean) this.getObject(colName)).booleanValue();
	}

	public Blob getBlob(int colIndex) {
		return ((Blob) this.getObject(colIndex));
	}

	public Blob getBlob(String colName) {
		return ((Blob) this.getObject(colName));
	}

	public Class getColumnType(int colIndex) {
		Object o = this.getObject(colIndex);
		return o.getClass();
	}

	public Object getObject(String colName) {
		return this.data.get(colName.toUpperCase());
	}

	public Object getObject(int colIndex) {
		return this.data.get(colIndex);
	}

	public Number getNumber(int colIndex) {
		Number n = (Number) this.getObject(colIndex);
		return n;
	}

	public Number getNumber(String colName) {
		Number n = (Number) this.getObject(colName);
		return n;
	}

	public int getColumnCount() {
		return this.data.keySet().size();
	}

	public Set getColumnNames() {
		return this.data.keySet();
	}

	public Class[] getColumnTypes() {
		Class[] classArray = new Class[this.getColumnCount()];
		for (int i = 0; i < classArray.length; i++) {
			classArray[i] = this.getColumnType(i);
		}
		return classArray;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ColumnCount=");
		sb.append(getColumnCount());
		sb.append(" [ ");
		Object[] colNames = getColumnNames().toArray();
		for (int i = 0; i < colNames.length; i++) {
			String name = (String) colNames[i];
			sb.append(name);
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
