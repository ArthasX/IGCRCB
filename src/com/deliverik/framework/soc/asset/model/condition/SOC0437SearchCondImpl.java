/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ��ռ䷥ֵ�趨��������ʵ��
  * ��������: ��ռ䷥ֵ�趨��������ʵ��
  * ������¼: 
  * �޸ļ�¼: 
  */
public class SOC0437SearchCondImpl implements
		SOC0437SearchCond {
	
	
	protected String dB_eq;
	
	protected String instance_eq;
	
	protected String tablespace_eq;
	
	protected String eid;

	public String getDB_eq() {
		return dB_eq;
	}

	public void setDB_eq(String db_eq) {
		dB_eq = db_eq;
	}

	public String getInstance_eq() {
		return instance_eq;
	}

	public void setInstance_eq(String instance_eq) {
		this.instance_eq = instance_eq;
	}

	public String getTablespace_eq() {
		return tablespace_eq;
	}

	public void setTablespace_eq(String tablespace_eq) {
		this.tablespace_eq = tablespace_eq;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	
}