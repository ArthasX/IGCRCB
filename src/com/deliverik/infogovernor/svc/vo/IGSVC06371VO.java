/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���top5ͳ������vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06371VO extends BaseVO{
	
	/** ���ŷ���top5ͳ������ */
	protected List<ServiceTopFiveVWInfo> serviceTopFiveList;

	/**
	 * ���ŷ���top5ͳ������ȡ��
	 * @return serviceTopFiveList ���ŷ���top5ͳ������
	 */
	public List<ServiceTopFiveVWInfo> getServiceTopFiveList() {
		return serviceTopFiveList;
	}

	/**
	 * ���ŷ���top5ͳ�������趨
	 * @param serviceTopFiveList ���ŷ���top5ͳ������
	 */
	public void setServiceTopFiveList(List<ServiceTopFiveVWInfo> serviceTopFiveList) {
		this.serviceTopFiveList = serviceTopFiveList;
	}
}
