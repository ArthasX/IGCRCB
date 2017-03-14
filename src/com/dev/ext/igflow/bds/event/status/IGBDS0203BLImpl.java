/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�о���ά����������ά 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0203BLImpl implements WorkFlowEventHandlerBL{

	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ���̴���api */
	protected FlowOptBL flowOptBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/** ��BL */
	protected IG500BL ig500BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/**
	 * ����BL�趨
	 * @param organizationBL ����BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ��BL�趨
	 * @param ig500BL ��BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * ��ѯ��api�趨
	 * @param flowSearchBL ��ѯ��api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���̴���api�趨
	 * @param flowOptBL ���̴���api
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	/**
	 * ������api�趨
	 * @param flowSetBL ������api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String flag = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�Ƿ���������ά");
		if("��".equals(flag)){
			
			//������ط�����ID
			String userid = bean.getLogInfo().getExecutorid();
			//������ط����˽�ɫID
			Integer roleid = bean.getLogInfo().getExecutorRoleid();
			
			//��ѯ���ִ�����ڵ��ɫ�µ�һ����	1031
			UserRoleBL userRoleBL = (UserRoleBL)WebApplicationSupport.getBean("userRoleBL");
			
			UserRoleSearchCondImpl userRoleSearchCondImpl = new UserRoleSearchCondImpl();
			
			userRoleSearchCondImpl.setRoleid(1031);
			
			List<UserRole> listOfUserRole = userRoleBL.searchUserRole(userRoleSearchCondImpl);
			
			//���ȡһ������Ϊ������	���û�������õ�ǰ�ڵ�´����˴���
			if(CollectionUtils.isNotEmpty(listOfUserRole)){
				userid = listOfUserRole.get(0).getUserid();
				roleid = 1031;
			}
			
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(userid);//���÷�����ID
			logInfo.setExecutorRoleid(roleid);//���÷����˽�ɫID
			
			IG500BL ig500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
			
			FlowOptBL flowOptBL = (FlowOptBL)WebApplicationSupport.getBean("flowOptBL");
			
			IG512BL ig512BL = (IG512BL)WebApplicationSupport.getBean("ig512BL");
			
			IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
			
			//������������
			ProcessRecord processRecord = new ProcessRecord(logInfo);//������ʱû����Ӧ�����̴�����־
			processRecord.setCrtuserid(userid);//�������̷�����ID
			processRecord.setDefid("01280");//�������̶���IDʡ������IDΪ01060
			processRecord.setDefstatus("a");//��������״̬_�����Ĳŷ���
			processRecord.setDescription(ig500Info.getPrdesc());//��������
			//û����Ҫ��ʼ���ı�
			//processRecord.setFormvalue(valueMap);//���ñ���Ϣֵ
			processRecord.setRoleid(roleid);//�������̷����˽�ɫID
			processRecord.setTitle(ig500Info.getPrtitle());//��������
			//�������ʡ������
			int districtPrid = flowOptBL.initProcessAction(processRecord);
			
			IG512TB ig512TB = new IG512TB();
			//������prid
			ig512TB.setParprid(bean.getLogInfo().getPrid());
			//������prid
			ig512TB.setCldprid(districtPrid);
			//����ʱ��
			ig512TB.setPrrinstime(IGStringUtils.getCurrentDateTime());
			
			ig512BL.registIG512Info(ig512TB);
			
			
			
			
			
			
//			List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
//			ProcessRecord record = new ProcessRecord(bean.getLogInfo());
//			record.setCrtuserid(bean.getLogInfo().getExecutorid());
//			record.setDefid("0130001");
//			record.setTitle(processInfos.get(0).getPrtitle() + "�·���������ά");
//			record.setDescription(processInfos.get(0).getPrtitle() + "�·���������ά");
//			record.setRoleid(bean.getLogInfo().getExecutorRoleid());
//			Integer prid = flowOptBL.initProcessAction(record);
//			flowSetBL.setProcessRelation(bean.getLogInfo().getPrid(), prid);
			
			
			//String orgname = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�·�����");
//			if(StringUtils.isNotEmpty(orgname)){
//				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
//				cond.setOrgname(orgname);
//				List<Organization> list = organizationBL.searchOrganization(cond);
//				if(list != null && list.size() > 0){
//					IG500Info ig500 = ig500BL.searchIG500InfoByKey(prid);
//					IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500);
//					ig500TB.setProrgid(list.get(0).getOrgsyscoding());
//					ig500TB.setProrgname(orgname);
//					ig500BL.updateIG500Info(ig500TB);
//				}
//			}
		}
	}

}
