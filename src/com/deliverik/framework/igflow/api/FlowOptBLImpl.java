/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.parameter.ProcessGroupInfo;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.ProcessRecordInfo;
import com.deliverik.framework.igflow.parameter.SuspendProcessInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG485BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * ���̴�����API
 */
public class FlowOptBLImpl extends BaseBLImpl implements FlowOptBL {

    /** �Զ���������־*/
    private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	/** ���̶���BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
	/** ����BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** �û�BL */
	protected UserBL userBL;

	/** ��ɫBL */
	protected RoleBL roleBL;
	
	/** �����鶨��BL */
	protected IG480BL ig480BL;
	
	/** �������Ա����BL */
	protected IG481BL ig481BL;
	
	/** �������ϵ����BL */
	protected IG482BL ig482BL;
	
	/** ������ʵ��BL */
	protected IG483BL ig483BL;
	
	/** �������Աʵ��BL */
	protected IG484BL ig484BL;
	
	/** �������ϵʵ��BL */
	protected IG485BL ig485BL;
	
    /**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * ����BL�趨
	 * 
	 * @param workFlowOperationBL ����BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * �û�BL�趨
	 * 
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ��ɫBL�趨
	 * 
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * �����鶨��BL�趨
	 * 
	 * @param ig480BL �����鶨��BL
	 */
	public void setIg480BL(IG480BL ig480BL) {
		this.ig480BL = ig480BL;
	}
	
	/**
	 * �������Ա����BL�趨
	 * 
	 * @param ig481BL �������Ա����BL
	 */
	public void setIg481BL(IG481BL ig481BL) {
		this.ig481BL = ig481BL;
	}
	
	/**
	 * �������ϵ����BL�趨
	 * @param ig482BL �������ϵ����BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}

	/**
	 * ������ʵ��BL�趨
	 * 
	 * @param ig483BL ������ʵ��BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}
	
	/**
	 * �������Աʵ��BL�趨
	 * 
	 * @param ig484BL �������Աʵ��BL
	 */
	public void setIg484BL(IG484BL ig484BL) {
		this.ig484BL = ig484BL;
	}
	
	/**
	 * �������ϵʵ��BL�趨
	 * 
	 * @param ig485BL �������ϵʵ��BL
	 */
	public void setIg485BL(IG485BL ig485BL) {
		this.ig485BL = ig485BL;
	}

	/**
	 * �����鷢��
	 * 
	 * @param processGroupInfo �����鷢����Ϣ
	 * @return ������ID
	 * @throws BLException
	 */
	public Integer initProcessGroupAction(ProcessGroupInfo processGroupInfo) throws BLException {
		
		igflowlog.debug("==========�����鷢����ʼ==========");
		
		//��ǰ����ʱ��
		String datetime = IGStringUtils.getCurrentDateTime();
		
		//�����鶨��
		IG480Info ig480 = null;
		if(processGroupInfo.getDefid().length() == 7) {
			ig480 = this.ig480BL.searchIG480ByPK(processGroupInfo.getDefid());//�����鶨��ID
		} else {
			IG480SearchCondImpl cond = new IG480SearchCondImpl();
			cond.setPgdid_like(processGroupInfo.getDefid());//�����鶨��IDǰ5λ
			cond.setPgdstatus(processGroupInfo.getDefstatus());//�����鶨��״̬
			ig480 = this.ig480BL.searchIG480(cond).get(0);
		}
		
		//������
		User user = userBL.searchUserByKey(processGroupInfo.getCrtuserid());
		
		//������ʵ��
		IG483TB ig483 = this.ig483BL.getIG483TBInstance();
		ig483.setPgruserid(processGroupInfo.getCrtuserid());//�����鷢����id
		ig483.setPgrusername(user.getUsername());//�����鷢��������
		ig483.setPgropentime(datetime);//�����鷢��ʱ��
		ig483.setPgrtitle(processGroupInfo.getTitle());//���������
		ig483.setPgrorgid(user.getOrgid());//�����鷢���˻�����
		ig483.setPgrorgname(user.getOrgname());//�����鷢���˻�������
		ig483.setPgdid(ig480.getPgdid());//�����鶨��id
		ig483.setPgdname(ig480.getPgdname());//�����鶨������
		ig483.setPttype(this.workFlowDefinitionBL.searchProcessTemplateByKey(ig480.getPtid()).getPttype());//����ģ������
		//�ж��Ƿ��������
		if(IGPRDCONSTANTS.PGD_STATUS_TESTABLE.equals(ig480.getPgdstatus())) {
			ig483.setIstest("1");
		} else {
			ig483.setIstest("0");
		}
		//�鿴������ɷ����������̶���
		IG481SearchCondImpl cond_IG481 = new IG481SearchCondImpl();
		cond_IG481.setPgdid(processGroupInfo.getDefid());//������ID
		cond_IG481.setCreateType("0");//�ⲿ����
		List<IG481Info> lst_IG481Info = this.ig481BL.searchIG481(cond_IG481);
		if(lst_IG481Info.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "������ID��" + processGroupInfo.getDefid() + "��������̶���");
		}
		
		//��ѯ���вο�״̬�����̶��壬��Щ���̶���Ӧ���ȷ����ݲ����Ǽ���Լ�����ǲο������
		IG482SearchCondImpl cond_IG482 = new IG482SearchCondImpl();
		cond_IG482.setPgdid(processGroupInfo.getDefid());//������ID
		List<IG482Info> lst_IG482Info = this.ig482BL.searchIG482(cond_IG482);
		List<IG481Info> lst_IG481Info_Init = new ArrayList<IG481Info>();
		for(IG481Info ig481 : lst_IG481Info) {
			for(IG482Info ig482 : lst_IG482Info) {
				if(ig481.getPdid().equals(ig482.getRpdid())) {
					lst_IG481Info_Init.add(ig481);
					break;
				}
			}
		}
		for(IG481Info ig481 : lst_IG481Info) {
			if(!lst_IG481Info_Init.contains(ig481)) {
				lst_IG481Info_Init.add(ig481);
			}
		}

		ig483.setOcount(lst_IG481Info.size());//������������
		ig483.setCcount(0);//�ر���������
		//����������ʵ��
		IG483Info ig483Info = ig483BL.registIG483(ig483);
        
		// �趨��������Ϣ
        IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
        cond_IG380.setPdstatus("a");//���������̶���
        
        //���̶����Ӧ�ķ����������
        Map<String, ProcessRecord> map_ProcessRecord = new LinkedHashMap<String, ProcessRecord>();
        
        //��У��
        for(IG481Info info : lst_IG481Info_Init) {
        	//��־��Ϣ
        	WorkFlowLog logInfo = new WorkFlowLog();
        	logInfo.setAuthuserid(null);
        	logInfo.setExecutorid(processGroupInfo.getCrtuserid());
        	
        	//������Ϣ
			ProcessRecord processRecord = new ProcessRecord(logInfo);
			//�ݲ�У�����̶����Ƿ�ͣ��???????????????????????????????????????????
			processRecord.setDefid(info.getPdid());
			//������������û���������з��������̵�Ȩ�ޣ��������쳣��Ĭ��ȡ���ⷢ���ɫ����������
			List<LabelValueBean> lst_Role = this.workFlowDefinitionBL.searchInitProcessParticipantRole(
					processGroupInfo.getCrtuserid(), processRecord.getDefid());
			if(lst_Role.isEmpty()) {
				throw new BLException("IGFLOW0000.E000", "���������̶���ID��" + processRecord.getDefid() + "���ķ����ɫ");
			} else {
		        logInfo.setExecutorRoleid(new Integer(lst_Role.get(0).getValue()));
			}
			processRecord.setLogInfo(logInfo);
			processRecord.setTitle(processGroupInfo.getTitle() + "_"
					+ this.workFlowDefinitionBL.searchProcessDefinitionByKey(info.getPdid()).getPdname()
					+ processGroupInfo.getProcessTitle(info.getPdid().substring(0, 5)));//����ID�����汾��
			//processRecord.setDescription(processGroupInfo.getDescription());
			processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//���̶����������״̬
			processRecord.setGroupID(ig483Info.getPgrid());//������ʵ��ID
			processRecord.setGroupDefID(ig483Info.getPgdid());//�����鶨��ID
			map_ProcessRecord.put(processRecord.getDefid(), processRecord);
		}
        
        //�������̣��������������Աʵ����
        cond_IG482 = new IG482SearchCondImpl();
		for(String pdid : map_ProcessRecord.keySet()) {
			Integer prid = launchProcess(map_ProcessRecord.get(pdid), IGPRDCONSTANTS.BUTTON_SUBMIT);//����ʵ��ID
			//��ȡ�������ϵ����
			cond_IG482.setPgdid(ig483Info.getPgdid());//�����鶨��ID
			cond_IG482.setRpdid(pdid);//�ο����̶���ID
			List<IG482Info> lst_IG482 = this.ig482BL.searchIG482(cond_IG482);
			//���ݷ��������ʵ��ID�����������ϵʵ����Ϣ
			for(IG482Info info : lst_IG482) {
				IG485TB ig485 = this.ig485BL.getIG485TBInstance();
				ig485.setPgreid(info.getPgreid());//�������ϵ����ID
				ig485.setPgrid(ig483Info.getPgrid());//������ʵ��ID
				ig485.setPrid(prid);//�ο�����ʵ��ID
				ig485.setPgrrstatus("0");//״̬��δ���
				this.ig485BL.registIG485(ig485);
			}
		}
		
		igflowlog.debug("==========�����鷢�������==========");
		
		return ig483Info.getPgrid();
	}

	/**
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer initProcessAction(ProcessRecordInfo processRecordInfo) throws BLException {
		return launchProcess(processRecordInfo, IGPRDCONSTANTS.BUTTON_SUBMIT);
	}
	
	/**
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer saveProcessAction(ProcessRecordInfo processRecordInfo) throws BLException {
		return launchProcess(processRecordInfo, IGPRDCONSTANTS.BUTTON_UPDATE);
	}
	
	/**
	 * 
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @param action ��������
	 * @return ����ID
	 * @throws BLException
	 */
	private Integer launchProcess(ProcessRecordInfo processRecordInfo,String action) throws BLException{
		igflowlog.debug(">>>�������̷�����ʼ");
		User user = userBL.searchUserByKey(processRecordInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(processRecordInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(processRecordInfo.getLogInfo().getAuthuserid());
		}
		//�����߽�ɫ
		Role role = roleBL.searchRoleByKey(processRecordInfo.getLogInfo().getExecutorRoleid());
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(processRecordInfo.getDefid());
		cond.setPdstatus(processRecordInfo.getDefstatus());
		List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_ProcessDefinition.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "���̶���ID��" + processRecordInfo.getDefid() + "��");
		} else {
			IG259Info processTemplate = workFlowDefinitionBL.searchProcessTemplateByKey(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPtid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
			psdCond.setPsdcode(Constants.PROCESS_STATUS_START);
			psdCond.setFatherflag("Y");//Ӧ���ϰ�
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "����״̬");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "����״̬");
			} else {
				List<IG599Info> prInfoList = new ArrayList<IG599Info>();
				//��ѯ���̱�������Ϣ
				List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
				if(processInfoDefList != null){
					Map<String, String> formvalue = processRecordInfo.getFormvalue();
					if(formvalue == null){
						formvalue = new HashMap<String, String>();
					}
					IG599TB prInfo = null;
					for(IG007Info processInfoDef:processInfoDefList){
						String value = formvalue.get(processInfoDef.getPidname());
						prInfo = workFlowOperationBL.getProcessInfoTBInstance();
						prInfo.setPivarlabel(processInfoDef.getPidlabel());
						prInfo.setPivarname(processInfoDef.getPidname());
						prInfo.setPivartype(processInfoDef.getPidtype());
						prInfo.setPivarvalue(value);
						prInfo.setPidid(processInfoDef.getPidid());
						prInfo.setPidmode(processInfoDef.getPidmode());
						prInfo.setPrivatescope(processInfoDef.getPrivatescope());
						prInfo.setPidaccess("3");//��д
						prInfoList.add(prInfo);
					}
				}
				IG500TB instance = workFlowOperationBL.getProcessRecordTBInstance();
				instance.setPrpdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());//���̶���ID
				instance.setPrpdname(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdname());//���̶�������
				instance.setPrtitle(processRecordInfo.getTitle());//���̱���
				instance.setPrdesc(processRecordInfo.getDescription());//��������
				instance.setPrtype(processTemplate.getPttype());//��������
				instance.setPrinfo(user.getUsermobile());//���̷�������ϵ��ʽ
				instance.setPruserid(user.getUserid());//���̷�����ID
				instance.setPrusername(user.getUsername());//���̷���������
				instance.setPrroleid(role.getRoleid());//���̷����߽�ɫID
				instance.setPrrolename(role.getRolename());//���̷����߽�ɫ����
				instance.setProrgid(user.getOrgid());//���̷����߻��������
				instance.setProrgname(user.getOrgname());//���̷����߻�������
				instance.setPid(processRecordInfo.getGroupID());//������ʵ��ID��Ӧ���ϰ�
				instance.setPname(processRecordInfo.getGroupDefID());//�����鶨��ID
				//�Ƿ��������
				if(IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdstatus())){
					instance.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				IG500Info processRecord = workFlowOperationBL.launchProcess(instance, user,
						processRecordInfo.getLogInfo().getExecutorRoleid(),
						null, null, processTemplate.getPttype(), prInfoList, processRecordInfo.getLogInfo().getComment(),
						lst_ProcessStatusDef.get(lst_ProcessDefinition.size() - 1).getPsdid(), action, null, authorizeuser,null,null,new HashMap<String, List<IG506TB>>(),null,null);
				//�������ԱID����
				if(StringUtils.isNotEmpty(processRecordInfo.getGroupDefID())) {//Ӧ���ϰ�
					IG484TB ig484 = this.ig484BL.getIG484TBInstance();
					ig484.setPgrid(processRecordInfo.getGroupID());//������ʵ��ID
					ig484.setPdid(instance.getPrpdid());//���̶���ID
					ig484.setPrid(processRecord.getPrid());//����ʵ��ID
					this.ig484BL.registIG484(ig484);
				}
				igflowlog.debug(">>>�������̷������������������ID��" + processRecord.getPrid());
				return processRecord.getPrid();
			}
		}
		
	}
	
	/**
	 * ������ֹ
	 * 
	 * @param suspendProcessInfo ������ֹ��Ϣ
	 * @throws BLException
	 */
	public void suspendProcess(SuspendProcessInfo suspendProcessInfo) throws BLException {
	    igflowlog.debug(">>>����������ֹ����ʼ��");
		User user = userBL.searchUserByKey(suspendProcessInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(suspendProcessInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(suspendProcessInfo.getLogInfo().getAuthuserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(suspendProcessInfo.getLogInfo().getPrid());
		IG500TB instance = (IG500TB)SerializationUtils.clone(process);
		instance.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
		instance.setPrclosetime(IGStringUtils.getCurrentDateTime());
		workFlowOperationBL.updateProcessRecord(process.getPrstatus(),instance, user, suspendProcessInfo.getLogInfo().getExecutorRoleid(),
				suspendProcessInfo.getLogInfo().getComment(),IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE, null,
				IGPRDCONSTANTS.RECORDLOG_TYPE_CL, authorizeuser, null,null);
		igflowlog.debug(">>>����������ֹ���������");
	}
	
	/**
	 * ����ԾǨ
	 * ֻ֧����ͨģʽ�µ���ͨ�ڵ㣬֧�ְ�ťԾǨ���򵫲�֧�ֱ�ԾǨ����
	 * 
	 * @param prid ����ID
	 * @param userid �����û�ID
	 * @param action ��ť����
	 * @param datetime ����ʱ��
	 * @throws BLException
	 */
	public void transitionProcess(Integer prid, String userid, String action, String datetime) throws BLException {
	    igflowlog.debug(">>>��������ԾǨ����ʼ��");
//	    doFlow(List<IG599Info> prInfoList,Integer prid, User user,Integer roleid, String datetime, String rolename,
//				String psdid,String action,String desc,String nodeType,
//				Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {
	    //��ȡ��ǰ��¼�û�
	    User user = userBL.searchUserByKey(userid);
	    //��ȡ������Ϣ
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//��ȡ״̬ID
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(process.getPrpdid());
		cond_IG333.setPsdcode(process.getPrstatus());
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333).get(0);
		//��ȡ�û������ɫ
		UserRoleInfo userRoleInfo = this.workFlowOperationBL.getUserRolesInProcessParticipants(
				prid, userid, psd.getPsdid()).get(0);
		//��ȡ���Ӱ�ť
		List<IG309Info> lst_ParticipantVisibleButtonVWInfo = workFlowDefinitionBL.searchVisibleButton(psd.getPsdid(), userRoleInfo.getRoleid());
		String vbid = "";
		//ID��"1"��ͷ��Ϊ����ť
		for(IG309Info button : lst_ParticipantVisibleButtonVWInfo) {
			if(button.getVbid().startsWith("1") && button.getVbname().equals(action)) {
				vbid = button.getVbid();
				break;
			}
		}
		//��ѯ�����û���Ӧ�Ĳ�����ʵ��
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(psd.getPsdid());
		cond.setPpproctimeIsNull("Y");
		cond.setPproleid(userRoleInfo.getRoleid());
		cond.setPpuserid(userid);
		List<IG337Info> lst_IG337Info = this.workFlowOperationBL.searchProcessParticipants(cond);
		if(lst_IG337Info.isEmpty()) {
			//��ѯ�Ƿ�ָֻ�����˽�ɫ
			cond.setPpuserid(null);
			lst_IG337Info = this.workFlowOperationBL.searchProcessParticipants(cond);
		}
		if(lst_IG337Info.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "������" + userid + "��" + userRoleInfo.getRoleid() + "��");
		} else {
			IG337TB participant = (IG337TB)SerializationUtils.clone(lst_IG337Info.get(0));
			participant.setPpproctime(datetime);
			participant.setPpuserid(userid);
			participant.setPbdid(vbid);
			//���´�������Ϣ���������ʱ�䣩
			this.workFlowOperationBL.updateProcessParticipant(participant, user, userRoleInfo.getRoleid(), null, 
					psd.getPsdname(), 
					null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,null,null, vbid,null);
		}
		//ԾǨ
	    this.workFlowOperationBL.doFlow(prid, user,
	    		userRoleInfo.getRoleid(), datetime,
	    		userRoleInfo.getRolename(),
	    		psd.getPsdid(), 
	    		vbid, null, IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL, null, null, null);
		igflowlog.debug(">>>��������ԾǨ���������");
	}

}
