/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
 * 
 * �����ʲ���ѯҳ��VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01081VO extends BaseVO implements Serializable {

	/** ������Ϣ */
	protected PlanInfo planInfo;

	/***
	 * Ӧ����Դ����
	 * */
	protected List<SOC0118VWInfo> zyList;
	/**
	 * Ԥ�ڻָ�ʱ��
	 */
	protected String expectTime;
	
	/**  
	 * ��ȡexpectTime  
	 * @return expectTime 
	 */
	public String getExpectTime() {
		return expectTime;
	}

	/**  
	 * ����expectTime  
	 * @param expectTime
	 */
	
	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public List<SOC0118VWInfo> getZyList() {
		return zyList;
	}

	public void setZyList(List<SOC0118VWInfo> zyList) {
		this.zyList = zyList;
	}

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

}
