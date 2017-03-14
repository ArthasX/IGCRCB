/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������������ѯVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC04011VO extends BaseVO{

	/** ������Ϣ���� */
	protected List<IG500Info> prList;

	/**
	 * ������Ϣ����ȡ��
	 * @return prList ������Ϣ����
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param prList ������Ϣ����
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
}
