/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>����:���̼�¼������û���Ϣʵ������</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
public class IG677PK extends BasePK implements Serializable {

	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̲����û���ϢID
	 */
	protected Integer ppid;
	
	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ����̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ܣ����̲����û���ϢIDȡ��
	 * @return ���̲����û���ϢID
	 */
	public Integer getPpid() {
		return ppid;
	}

	/**
	 * ���ܣ����̲����û���ϢID�趨
	 * @param ppid ���̲����û���ϢID
	 */
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	
	/**
	 * ���ܣ�ȱʡ���캯��
	 */
	public IG677PK(){}
	
	/**
	 * ���ܣ����캯��
	 * @param prid
	 * @param ppid
	 */
	public IG677PK(Integer prid, Integer ppid) {
		this.prid = prid;
		this.ppid = ppid;
	}
}
