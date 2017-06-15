/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCond;
import com.deliverik.infogovernor.svc.model.dao.ServiceTopFiveVWDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���top5ͳ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ServiceTopFiveVWBLImpl extends BaseBLImpl implements ServiceTopFiveVWBL{
	
	/** ���ŷ���top5ͳ��DAO */
	protected ServiceTopFiveVWDAO serviceTopFiveVWDAO;

	/**
	 * ���ŷ���top5ͳ��DAO�趨
	 * @param serviceTopFiveVWDAO ���ŷ���top5ͳ��DAO
	 */
	public void setServiceTopFiveVWDAO(ServiceTopFiveVWDAO serviceTopFiveVWDAO) {
		this.serviceTopFiveVWDAO = serviceTopFiveVWDAO;
	}

	/**
	 * ͳ�����ݲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<ServiceTopFiveVWInfo> searchServiceDate(ServiceTopFiveSearchCond cond){
		return serviceTopFiveVWDAO.searchServiceDate(cond);
	}
}
