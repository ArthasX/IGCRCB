/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

import java.util.Set;

/**
 * ��ѯ�ӿ�ʵ��
 *
 */
public class IG809SearchCondImpl implements IG809SearchCond{

	/** �ʲ�ID */
	protected Integer eiid;
	
	/** ��ϵͼ���� */
	protected String eirftype;
	
	/** ��ϵͼ�ļ��� */
	protected String eirfname;
	
	/** �ʲ�ID���� */
	protected Set<Integer> eiidList;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ϵͼ����ȡ��
	 * @return ��ϵͼ����
	 */
	public String getEirftype() {
		return eirftype;
	}

	/**
	 * ��ϵͼ�����趨
	 * @param eirftype ��ϵͼ����
	 */
	public void setEirftype(String eirftype) {
		this.eirftype = eirftype;
	}

	/**
	 * ��ϵͼ�ļ���ȡ��
	 * @return ��ϵͼ�ļ���
	 */
	public String getEirfname() {
		return eirfname;
	}

	/**
	 * ��ϵͼ�ļ����趨
	 * @param eirfname ��ϵͼ�ļ���
	 */
	public void setEirfname(String eirfname) {
		this.eirfname = eirfname;
	}

	/**
	 * �ʲ�ID����ȡ��
	 * @return �ʲ�ID����
	 */
	public Set<Integer> getEiidList() {
		return eiidList;
	}

	/**
	 * �ʲ�ID�����趨
	 * @param eiidList �ʲ�ID����
	 */
	public void setEiidList(Set<Integer> eiidList) {
		this.eiidList = eiidList;
	}
	
}
