/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * ����: ����״̬�����ɫ����VO
 * ��������: ����״̬�����ɫ����VO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD01421VO extends BaseVO implements Serializable {
	protected List<IG333TB> psdTBList;

	public List<IG333TB> getPsdTBList() {
		return psdTBList;
	}

	public void setPsdTBList(List<IG333TB> psdTBList) {
		this.psdTBList = psdTBList;
	}
	
}
