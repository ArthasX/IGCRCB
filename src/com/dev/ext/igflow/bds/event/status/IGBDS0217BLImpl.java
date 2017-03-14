/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ԥ�ô�����
 * </p>
 * 
 * @author zhangze@deliverik.com
 * @version 1.0
 */
public class IGBDS0217BLImpl implements WorkFlowEventHandlerBL{

	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/** userRole */
	protected UserRoleBL userRoleBL;
	
	/** ig500BL */
	protected IG500BL ig500BL;
	
	/** flowOptBL */
	protected FlowOptBL flowOptBL;
	
	/** ig512BL */
	protected IG512BL ig512BL;
	
	/**
	 * ��ѯ��api�趨
	 * @param flowSearchBL ��ѯ��api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������api�趨
	 * @param flowSetBL ������api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * userRole�趨
	 * @param userRole
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * ig500BL�趨
	 * @param ig500BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	
	/**
	 * flowOptBL �趨
	 * @param flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	
	/**
	 * ig512BL �趨
	 * @param ig512BL
	 */
	public void setIg512BL(IG512BL ig512BL) {
		this.ig512BL = ig512BL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		//������ط�����ID
		String userid = bean.getLogInfo().getExecutorid();
		//������ط����˽�ɫID
		Integer roleid = bean.getLogInfo().getExecutorRoleid();
		
		//��ѯ�оִ�����ڵ��ɫ�µ�һ����	1029
		//UserRoleBL userRoleBL = (UserRoleBL)WebApplicationSupport.getBean("userRoleBL");
		
		UserRoleSearchCondImpl userRoleSearchCondImpl = new UserRoleSearchCondImpl();
		
		userRoleSearchCondImpl.setRoleid(1029);
		
		List<UserRole> listOfUserRole = userRoleBL.searchUserRole(userRoleSearchCondImpl);
		
		//���ȡһ������Ϊ������	���û�������õ�ǰ�ڵ�´����˴���
		if(CollectionUtils.isNotEmpty(listOfUserRole)){
			userid = listOfUserRole.get(0).getUserid();
			roleid = 1029;
		}
		
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setExecutorid(userid);//���÷�����ID
		logInfo.setExecutorRoleid(roleid);//���÷����˽�ɫID
		//��Ϊ������s��username
		//String comment = "���ؼ�"+ig500Info.getProrgname()+"��"+ig500Info.getPrusername()+"����";
		//logInfo.setComment(comment);//������־����
		
		//IG500BL ig500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
		
		//FlowOptBL flowOptBL = (FlowOptBL)WebApplicationSupport.getBean("flowOptBL");
		
		//IG512BL ig512BL = (IG512BL)WebApplicationSupport.getBean("ig512BL");
		
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		
		//�����о�����
		ProcessRecord processRecord = new ProcessRecord(logInfo);//������ʱû����Ӧ�����̴�����־
		processRecord.setCrtuserid(userid);//�������̷�����ID
		processRecord.setDefid("01220");//�������̶���IDʡ������IDΪ01060
		processRecord.setDefstatus("a");//��������״̬_�����Ĳŷ���
		processRecord.setDescription(ig500Info.getPrdesc());//��������
		//û����Ҫ��ʼ���ı�
		//processRecord.setFormvalue(valueMap);//���ñ���Ϣֵ
		processRecord.setRoleid(roleid);//�������̷����˽�ɫID
		processRecord.setTitle(ig500Info.getPrtitle());//��������
		//�������ʡ������
		int cityPrid = flowOptBL.initProcessAction(processRecord);
		
		IG512TB ig512TB = new IG512TB();
		//������prid
		ig512TB.setParprid(bean.getLogInfo().getPrid());
		//������prid
		ig512TB.setCldprid(cityPrid);
		//����ʱ��
		ig512TB.setPrrinstime(IGStringUtils.getCurrentDateTime());
		
		ig512BL.registIG512Info(ig512TB);
		
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
