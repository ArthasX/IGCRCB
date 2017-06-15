/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06361VO extends BaseVO{

	/** ���ŷ���ͳ�����ݼ��� */
	private List<OrganizationServiceVWInfo> organizationServiceList;
	
	/** �¼����� */
	private Integer icount;
	
	/** ������������ */
	private Integer scount;
	
	/** ������ */
	private Integer gcount;
	
	/** ���� */
	private Integer totalCount;

	/**
	 * ���ŷ���ͳ�����ݼ���ȡ��
	 * @return organizationServiceList ���ŷ���ͳ�����ݼ���
	 */
	public List<OrganizationServiceVWInfo> getOrganizationServiceList() {
		return organizationServiceList;
	}

	/**
	 * ���ŷ���ͳ�����ݼ����趨
	 * @param organizationServiceList ���ŷ���ͳ�����ݼ���
	 */
	public void setOrganizationServiceList(
			List<OrganizationServiceVWInfo> organizationServiceList) {
		this.organizationServiceList = organizationServiceList;
	}

	/**
	 * �¼�����ȡ��
	 * @return icount �¼�����
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * �¼������趨
	 * @param icount �¼�����
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * ������������ȡ��
	 * @return scount ������������
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * �������������趨
	 * @param scount ������������
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
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

	public Integer getGcount() {
		return gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}
	
	
}
