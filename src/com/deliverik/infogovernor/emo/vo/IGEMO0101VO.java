/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ����: ���ð�����ϵ��ʾVO
 * ��������: ���ð�����ϵ��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGEMO0101VO extends BaseVO implements Serializable{
	
	
	/**����SQL*/
	protected String initSQLStr;
	
	/**�����Ự*/
	protected String initSessionStr;
	
	/**�ʲ�ID*/
	protected String eid;
	
	/**
	 * ���캯��
	 * @param 
	 */
	public IGEMO0101VO(String initSQLStr,String initSessionStr,String eid) {
		this.initSQLStr = initSQLStr;
		this.initSessionStr = initSessionStr;
		this.eid = eid;
	}

	/**
	 * ���췽��
	 */
	public IGEMO0101VO() {
		super();
	}

	public String getInitSQLStr() {
		return initSQLStr;
	}

	public void setInitSQLStr(String initSQLStr) {
		this.initSQLStr = initSQLStr;
	}

	public String getInitSessionStr() {
		return initSessionStr;
	}

	public void setInitSessionStr(String initSessionStr) {
		this.initSessionStr = initSessionStr;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
}


