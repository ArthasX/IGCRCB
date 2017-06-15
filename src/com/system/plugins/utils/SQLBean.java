package com.system.plugins.utils;

import java.io.Serializable;

public class SQLBean implements Serializable{

	private static final long serialVersionUID = -6278992645668981048L;

	protected String sql;
	
	protected String selectSql;
	
	protected String updateSql;
	
	protected String[] values;
	
	protected String[] pkvalues;//only for update
	
	protected String[] pks;
	
	protected String[] columntypes;
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getSelectSql() {
		return selectSql;
	}

	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	
	public String getValue(){
		String value = "";
		if(values!=null){
			for(String v:values){
				value+="["+v+"]";
			}
		}
		return value;
	}
	
	public String getpk(){
		String value = "";
		if(pks!=null){
			for(String v:pks){
				value+="["+v+"]";
			}
		}
		return value;
	}
	public String getpkvalue(){
		String value = "";
		if(pkvalues!=null){
			for(String v:pkvalues){
				value+="["+v+"]";
			}
		}
		return value;
	}
	

	/**
	 * updateSql取得
	 *
	 * @return updateSql updateSql
	 */
	public String getUpdateSql() {
		return updateSql;
	}

	/**
	 * updateSql设定
	 *
	 * @param updateSql updateSql
	 */
	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}

	/**
	 * pkvalues取得
	 *
	 * @return pkvalues pkvalues
	 */
	public String[] getPkvalues() {
		return pkvalues;
	}

	/**
	 * pkvalues设定
	 *
	 * @param pkvalues pkvalues
	 */
	public void setPkvalues(String[] pkvalues) {
		this.pkvalues = pkvalues;
	}

	/**
	 * pks取得
	 *
	 * @return pks pks
	 */
	public String[] getPks() {
		return pks;
	}

	/**
	 * pks设定
	 *
	 * @param pks pks
	 */
	public void setPks(String[] pks) {
		this.pks = pks;
	}

	public String[] getColumntypes() {
		return columntypes;
	}

	public void setColumntypes(String[] columntypes) {
		this.columntypes = columntypes;
	}




}
