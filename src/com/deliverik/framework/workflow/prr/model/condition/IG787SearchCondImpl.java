/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���̹�ͨ������ͼ��ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG787SearchCondImpl implements IG787SearchCond {


	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ��ͨ����ID
	 */
	protected Integer pidgid;
	
	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}
	
	/**
	 * ���ܣ����̼�¼ID����
	 * @param pidgid
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * ���ܣ���ͨ����IDȡ��
	 * @return ��ͨ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ���ͨ����ID����
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	
	
}
