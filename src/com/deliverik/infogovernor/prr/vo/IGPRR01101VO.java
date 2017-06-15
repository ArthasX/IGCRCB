/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * @Description: ����״̬��־�鿴VO
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01101VO extends BaseVO implements Serializable {

	/** ����״̬��־���� */
	protected List<IG224Info> recordStatusLogList;

	/**
	 * ���췽��
	 * @param recordStatusLogList ����״̬��־����
	 */
	public IGPRR01101VO(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	/**
	 * ����״̬��־����ȡ��
	 * @return ����״̬��־����
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}
	
}