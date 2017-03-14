/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���top5ͳ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class ServiceTopFiveVW implements ServiceTopFiveVWInfo{

	/** ���� */
	@Id
	protected Integer id;
	
	/** ʱ������ */
	protected Integer icount;
	
	/** �������� */
	protected Integer scount;
	
	/** ���񹤵����� */
	protected Integer fcount;
	
	/** ������ */
	protected String orgid;
	
	/** �������� */
	protected String orgname;
	
	/** ���� */
	protected Integer totalCount;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ʱ������ȡ��
	 * @return icount ʱ������
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * ʱ�������趨
	 * @param icount ʱ������
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * ��������ȡ��
	 * @return scount ��������
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * ���������趨
	 * @param scount ��������
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
	}

	/**
	 * ���񹤵�����ȡ��
	 * @return fcount ���񹤵�����
	 */
	public Integer getFcount() {
		return fcount;
	}

	/**
	 * ���񹤵������趨
	 * @param fcount ���񹤵�����
	 */
	public void setFcount(Integer fcount) {
		this.fcount = fcount;
	}

	/**
	 * ������ȡ��
	 * @return orgid ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ����ȡ��
	 * @return totalCount ����
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * �����趨
	 * @param totalCount ����
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
