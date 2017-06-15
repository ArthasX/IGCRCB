/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * �����������VO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR02011VO  extends BaseVO implements Serializable {

	/** ���������Ϣ */
	protected ApproveSuggestionInfo approveSuggestionInfo;

	/** ��������Ϣ */
	protected IG500Info ig500Info;

	/** ������ */
	protected String pidname;
	
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
	 * ���������Ϣȡ��
	 *
	 * @return approveSuggestionInfo ���������Ϣ
	 */
	public ApproveSuggestionInfo getApproveSuggestionInfo() {
		return approveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�趨
	 *
	 * @param approveSuggestionInfo ���������Ϣ
	 */
	public void setApproveSuggestionInfo(ApproveSuggestionInfo approveSuggestionInfo) {
		this.approveSuggestionInfo = approveSuggestionInfo;
	}

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �������趨
	 * 
	 * @param pidname ������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

}
