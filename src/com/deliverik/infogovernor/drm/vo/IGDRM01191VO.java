/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;

/**
 * 
 * �����ʲ���ѯҳ��VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01191VO extends BaseVO implements Serializable {


	/** ������Ӧ���Լ��� */
	protected List<ResponseStrategyInfo> responseStrategyList;

	protected ResponseStrategyInfo responseStrategyInfo;;

	/** ������Ϣ */
	protected PlanInfo planInfo;

	/**
	 * Ԥ�ڻָ�ʱ��
	 */
	protected String expectTime;

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public List<ResponseStrategyInfo> getResponseStrategyList() {
		return responseStrategyList;
	}

	public void setResponseStrategyList(List<ResponseStrategyInfo> responseStrategyList) {
		this.responseStrategyList = responseStrategyList;
	}

	public ResponseStrategyInfo getResponseStrategyInfo() {
		return responseStrategyInfo;
	}

	public void setResponseStrategyInfo(ResponseStrategyInfo responseStrategyInfo) {
		this.responseStrategyInfo = responseStrategyInfo;
	}

}
