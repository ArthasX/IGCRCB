/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.zwj.igflow.event.status;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: һ���¼��������ر�Ԥ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0101BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL; 
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/** ϵͳ��API */
	protected SysManageBL sysManageBL;
	
	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ��ѯ��API�趨
	 * @param sysManageBL ��ѯ��API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) 
			throws BLException {
		//��ѯ��������Ϣ
		UserInfo user = sysManageBL.searchUserInfo(bean.getCrtuserid());
		//��ѯ����������
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		String formValue = null;
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����������");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("����������");
			value.setFormvalue(user.getUsername());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������ϵ��ʽ");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("��������ϵ��ʽ");
			value.setFormvalue(user.getUsermobile());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�������ʼ�");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("�������ʼ�");
			value.setFormvalue(user.getUseremail());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�����˿���");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("�����˿���");
			value.setFormvalue(user.getOrgid() + "_OrgTree_" + user.getOrgname());
			flowSetBL.setPublicProcessInfoValue(value);
		}
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
