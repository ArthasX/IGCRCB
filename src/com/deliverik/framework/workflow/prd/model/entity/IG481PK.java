/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �������Ա��ʵ��
  * ��������: �������Ա��ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG481PK extends BasePK implements Serializable {

	/** ������id */
	protected String pgdid;

	/** ��������id */
	protected String pdid;
	
	public IG481PK() {}

	public IG481PK(String pgdid, String pdid) {
		super();
		this.pgdid = pgdid;
		this.pdid = pdid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * ������id�趨
	 *
	 * @param pgdid ������id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������id�趨
	 *
	 * @param pdid ��������id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}