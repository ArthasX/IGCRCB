/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.dto;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01DTO extends BaseDTO{
	
	/** ���� */
	protected Integer id;
	
	/** �û���Ϣ */
	protected User user;

	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/** �ճ������ƻ���Ϣ���� */
	protected List<IGDWP0001Info> dayWorkPlanList;
	
	/** ���̶�����Ϣ */
	protected Map<IG259Info, List<IG380Info>> processDefinitionMap;
	
	/** �ƻ���Ϣ */
	protected IGDWP0001Info plan;
	
	/** ������Ϣ */
	protected IGDWP0002Info process;
	
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
	
	/** ���ɱ�ʶ */
	protected String assignFlag;
	
	/** ������Ϣ���� */
	protected Map<IG333Info,Map<Role, List<UserInfo>>> assignInfoMap;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �ճ������ƻ���Ϣ����ȡ��
	 * @return dayWorkPlanList �ճ������ƻ���Ϣ����
	 */
	public List<IGDWP0001Info> getDayWorkPlanList() {
		return dayWorkPlanList;
	}

	/**
	 * �ճ������ƻ���Ϣ�����趨
	 * @param dayWorkPlanList �ճ������ƻ���Ϣ����
	 */
	public void setDayWorkPlanList(List<IGDWP0001Info> dayWorkPlanList) {
		this.dayWorkPlanList = dayWorkPlanList;
	}

	/**
	 * ������Ϣȡ��
	 * @return process ������Ϣ
	 */
	public IGDWP0002Info getProcess() {
		return process;
	}

	/**
	 * ������Ϣ�趨
	 * @param process ������Ϣ
	 */
	public void setProcess(IGDWP0002Info process) {
		this.process = process;
	}

	/**
	 * ���̶�����Ϣȡ��
	 * @return processDefinitionMap ���̶�����Ϣ
	 */
	public Map<IG259Info, List<IG380Info>> getProcessDefinitionMap() {
		return processDefinitionMap;
	}

	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinitionMap ���̶�����Ϣ
	 */
	public void setProcessDefinitionMap(
			Map<IG259Info, List<IG380Info>> processDefinitionMap) {
		this.processDefinitionMap = processDefinitionMap;
	}

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

	/**
	 * ���ɱ�ʶȡ��
	 * @return assignFlag ���ɱ�ʶ
	 */
	public String getAssignFlag() {
		return assignFlag;
	}

	/**
	 * ���ɱ�ʶ�趨
	 * @param assignFlag ���ɱ�ʶ
	 */
	public void setAssignFlag(String assignFlag) {
		this.assignFlag = assignFlag;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return assignInfoMap ������Ϣ����
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfoMap() {
		return assignInfoMap;
	}

	/**
	 * ������Ϣ�����趨
	 * @param assignInfoMap ������Ϣ����
	 */
	public void setAssignInfoMap(
			Map<IG333Info, Map<Role, List<UserInfo>>> assignInfoMap) {
		this.assignInfoMap = assignInfoMap;
	}
}
