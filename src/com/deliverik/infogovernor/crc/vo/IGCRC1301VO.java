/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�ĵ���Ϣ��ѯVO 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1301VO extends BaseVO{

	/** �ĵ���Ϣ���� */
	protected List<IGCRC1301VWInfo> igcrc1301VWList;

	/**
	 * �ĵ���Ϣ����ȡ��
	 * @return prList �ĵ���Ϣ����
	 */
	public List<IGCRC1301VWInfo> getIgcrc1301VWList() {
		return igcrc1301VWList;
	}

	/**
	 * �ĵ���Ϣ�����趨
	 * @param prList �ĵ���Ϣ����
	 */
	public void setIgcrc1301VWList(List<IGCRC1301VWInfo> igcrc1301vwList) {
		igcrc1301VWList = igcrc1301vwList;
	}
}
