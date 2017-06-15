/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCond;
import com.deliverik.infogovernor.svc.model.dao.OrganizationServiceDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class OrganizationServiceBLImpl extends BaseBLImpl implements OrganizationServiceBL{

	/** ���ŷ���ͳ��DAO */
	protected OrganizationServiceDAO organizationServiceDAO;

	/**
	 * ���ŷ���ͳ��DAO�趨
	 * @param organizationServiceDAO ���ŷ���ͳ��DAO
	 */
	public void setOrganizationServiceDAO(
			OrganizationServiceDAO organizationServiceDAO) {
		this.organizationServiceDAO = organizationServiceDAO;
	}
	
	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<OrganizationServiceVWInfo> searchOrganizationService(OrganizationServiceSearchCond cond){
		return organizationServiceDAO.searchOrganizationService(cond);
	}
}
