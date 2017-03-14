/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * ���������ѯVO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR02021VO  extends BaseVO implements Serializable {

	/** ��������Ϣ */
	protected IG500Info ig500Info;
	
	/** ���������Ϣ���� */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;

	/**
	 * ��������Ϣȡ��
	 *
	 * @return ig500Info ��������Ϣ
	 */
	public IG500Info getIg500Info() {
		return ig500Info;
	}

	/**
	 * ��������Ϣ�趨
	 *
	 * @param ig500Info ��������Ϣ
	 */
	public void setIg500Info(IG500Info ig500Info) {
		this.ig500Info = ig500Info;
	}

	/**
	 * ���������Ϣ����ȡ��
	 *
	 * @return lstApproveSuggestionInfo ���������Ϣ����
	 */
	public List<ApproveSuggestionInfo> getLstApproveSuggestionInfo() {
		return lstApproveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�����趨
	 *
	 * @param lstApproveSuggestionInfo ���������Ϣ����
	 */
	public void setLstApproveSuggestionInfo(
			List<ApproveSuggestionInfo> lstApproveSuggestionInfo) {
		this.lstApproveSuggestionInfo = lstApproveSuggestionInfo;
	}
	
}
