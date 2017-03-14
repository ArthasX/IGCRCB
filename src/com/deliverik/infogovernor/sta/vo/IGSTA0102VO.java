/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������_��ѯVO
 * </p>
 * 
 * @author yangsn@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSTA0102VO extends BaseVO implements Serializable {

	/** ����������Ϣȡ�� */
	List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList;

	/**
	 * ����������Ϣȡ��ȡ��
	 * @return riskCheckProblemSuperviseVWList ����������Ϣȡ��
	 */
	public List<RiskCheckProblemSuperviseVWInfo> getRiskCheckProblemSuperviseVWList() {
		return riskCheckProblemSuperviseVWList;
	}

	/**
	 * ����������Ϣȡ���趨
	 * @param riskCheckProblemSuperviseVWList ����������Ϣȡ��
	 */
	public void setRiskCheckProblemSuperviseVWList(
			List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList) {
		this.riskCheckProblemSuperviseVWList = riskCheckProblemSuperviseVWList;
	}
}
