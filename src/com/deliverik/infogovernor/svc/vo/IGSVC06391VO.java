/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG160Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��vo
 * </p>
 */
@SuppressWarnings("serial")
public class IGSVC06391VO extends BaseVO{

	/** ���ŷ���ͳ�����ݼ��� */
	private List<IG160Info> summaryCountList;
	
	/**��Ա�������Ǹ�ͳ��Json��ʽ  ��Ա��Ϣ */
	private String presonsJson;
	/**��Ա������ͳ�� Json ��ʽͳ������*/
	private String acountJson;

	public List<IG160Info> getSummaryCountList() {
		return summaryCountList;
	}

	public void setSummaryCountList(List<IG160Info> summaryCountList) {
		this.summaryCountList = summaryCountList;
	}

	public String getPresonsJson() {
		return presonsJson;
	}

	public void setPresonsJson(String presonsJson) {
		this.presonsJson = presonsJson;
	}

	public String getAcountJson() {
		return acountJson;
	}

	public void setAcountJson(String acountJson) {
		this.acountJson = acountJson;
	}
	
	



}
