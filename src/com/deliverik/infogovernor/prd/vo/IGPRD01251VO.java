/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG286Info;

/**
 * ���̱�����VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01251VO extends BaseVO implements Serializable {

	/** ���̱�����List */
	protected List<IG286Info> processLinkageDefList;

	public List<IG286Info> getProcessLinkageDefList() {
		return processLinkageDefList;
	}

	public void setProcessLinkageDefList(
			List<IG286Info> processLinkageDefList) {
		this.processLinkageDefList = processLinkageDefList;
	}
	
	
}
