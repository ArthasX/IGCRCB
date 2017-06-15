/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������ϢVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01051VO extends BaseVO{

	/** �ƻ���Ϣ */
	protected IGDWP0001Info plan;
	
	/** ���̶�����Ϣ */
	protected IG380Info processDefinition;
	
	/** ״̬������Ϣ */
	protected IG333Info processStatusDef;
	
	/** �����б���Ϣ */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** ���̱��ⶨ����Ϣ */
	protected IG243Info ptdInfo;
	
	/** ���̱�������Ϣ���� */
	protected List<IG007Info> processInfoList;

	/**
	 * �ƻ���Ϣȡ��
	 * @return plan �ƻ���Ϣ
	 */
	public IGDWP0001Info getPlan() {
		return plan;
	}

	/**
	 * �ƻ���Ϣ�趨
	 * @param plan �ƻ���Ϣ
	 */
	public void setPlan(IGDWP0001Info plan) {
		this.plan = plan;
	}

	/**
	 * ���̶�����Ϣȡ��
	 * @return processDefinition ���̶�����Ϣ
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinition ���̶�����Ϣ
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * ״̬������Ϣȡ��
	 * @return processStatusDef ״̬������Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ״̬������Ϣ�趨
	 * @param processStatusDef ״̬������Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * �����б���Ϣȡ��
	 * @return labelValueBeanList �����б���Ϣ
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * �����б���Ϣ�趨
	 * @param labelValueBeanList �����б���Ϣ
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * ���̱��ⶨ����Ϣȡ��
	 * @return ptdInfo ���̱��ⶨ����Ϣ
	 */
	public IG243Info getPtdInfo() {
		return ptdInfo;
	}

	/**
	 * ���̱��ⶨ����Ϣ�趨
	 * @param ptdInfo ���̱��ⶨ����Ϣ
	 */
	public void setPtdInfo(IG243Info ptdInfo) {
		this.ptdInfo = ptdInfo;
	}

	/**
	 * ���̱�������Ϣ����ȡ��
	 * @return processInfoList ���̱�������Ϣ����
	 */
	public List<IG007Info> getProcessInfoList() {
		return processInfoList;
	}

	/**
	 * ���̱�������Ϣ�����趨
	 * @param processInfoList ���̱�������Ϣ����
	 */
	public void setProcessInfoList(List<IG007Info> processInfoList) {
		this.processInfoList = processInfoList;
	}
}
