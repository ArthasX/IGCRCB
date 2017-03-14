package com.deliverik.plugin.change.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.justobjects.pushlet.util.Log;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG505BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.plugin.change.bl.task.InitiateChangLogBL;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCondImpl;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������־����BLʵ��
 * </p>
 * 
 * @author dinghaonan@deliverik.com
 * @version 1.0
 */
public class IGCHANGE01BLImpl implements IGCHANGE01BL {

	/** �����־BL */
	protected InitiateChangLogBL initiateChangLogBL;

	/** ���̶���ҵ�� */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	protected FlowOptBL flowOptBL;

	/** �������ֵBL */
	protected IG505BL ig505BL;
	/** ���̱�����Ϣʵ��BL */
	protected IG599BL ig599BL;

	protected IG036BL ig036BL;
	
	protected IG500BL ig500BL;
	
	
	protected IG224BL ig224BL;
	
	
	protected IG337BL ig337BL;
	
	protected FlowSearchBL flowSearchBL;
	
	protected FlowSetBL flowSetBL;
	
	protected UserRoleBL userRoleBL;
	
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected UserBL userBL;
	
	 /** ϵͳ����API�� */
    private SysManageBL sysManageBL;
    
    /** �������� */
    private String CHANGE_STATUSNAME_BMSP = "��������";
    
    /** �����������ĸ����� */
    private Integer roleid_1227 = 1227;
    
    /** ϵͳ�������ĸ����� */
    private Integer roleid_1228 = 1228;
    
    /** ����������ĸ����� */
    private Integer roleid_1229 = 1229;
    
    /** �ۺϹ��������� */
    private Integer roleid_1230 = 1230;
    
    /**���������  roleid*/
    private Integer roleid_1220 = 1220;
    
	
	/**
	 * ϵͳ����API���趨
	 * @param sysManageBL ϵͳ����API��
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}
	/**
	 * userBL�趨
	 * @param userBL userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/**
	 * workFlowOperationBL�趨
	 * @param workFlowOperationBL workFlowOperationBL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * flowSetBL�趨
	 * @param flowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	/**
	 * userRoleBL�趨
	 * @param userRoleBL userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public IGCHANGE01DTO registIGCHANGEAction(IGCHANGE01DTO dto)
			throws BLException {
		// ��������Id
		Integer prid;
		// ��ȡ�����־������Ϣ
		InitiateChangLogInfo info = initiateChangLogBL
				.searchInitiateChangLogByPK(Integer.parseInt(dto.getIcid()));
		InitiateChangLogTB entity = (InitiateChangLogTB) info;
		try {
			// ����������־����
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(info.getPruserId());
			logInfo.setExecutorRoleid(Integer.parseInt(info.getPrroleId()));

			// ��ȡ������̰汾
			IG380SearchCondImpl cond = new IG380SearchCondImpl();
			cond.setPdid_like("01084");
			List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL
					.searchProcessDefinition(cond);

			// ʵ����������Ϣ
			ProcessRecord record = new ProcessRecord(logInfo);
			// ��ȡ���汾��
			record.setDefid(lst_ProcessDefinition.get(
					lst_ProcessDefinition.size() - 1).getPdid());
			// ������Id
			record.setCrtuserid(info.getPruserId());
			// �����˽�ɫid
			record.setRoleid(Integer.parseInt(info.getPrroleId()));
			// ����
			record.setTitle(info.getChangeName());
			// ����
			record.setDescription(info.getChangeDescription());
			// ��������־���ֵ�������̱���
			Map<String, String> formvalue = new HashMap<String, String>();
			formvalue.put("�ƻ�ִ�п�ʼʱ��", info.getBeginTime());
			formvalue.put("�ƻ�ִ�н���ʱ��", info.getEndTime());
			formvalue.put("�������", info.getChangeType());
			formvalue.put("������", info.getChangeCategory());
			formvalue.put("��ѡ�������", info.getSelectedChangeType());
			formvalue.put("�������", info.getChangeClassify());
			formvalue.put("����ƽ̨", info.getUpdatePlatform());
			formvalue.put("���ԭ�����", info.getChangeReasonClassify());
			formvalue.put("���ԭ��", info.getChangeReason());
			formvalue.put("�������", info.getChangeContent());
			formvalue.put("�����Ŀ���", info.getPrjid());
			formvalue.put("�����Ŀ����", info.getPrjtitle());
			formvalue.put("�Ƿ�Ӱ��ҵ��", info.getIsBusiness());
			formvalue.put("ҵ��Ӱ�췶Χ", info.getBusinessScope());
			formvalue.put("�ƻ�Ӱ��ҵ��ʱ�������ӣ�", info.getBusinessTime());
			formvalue.put("ִ�мƻ�", info.getDeliveryProgram());
			formvalue.put("���˼ƻ�", info.getRollbackProgram());
			formvalue.put("��֤�ƻ�", info.getVerificationProgram());

			record.setFormvalue(formvalue);
			// ����
			record.setDescription(info.getChangeDescription());
			// �������� ����prid����
			prid = flowOptBL.initProcessAction(record);
			
			entity.setFingerPrint("���̷���ɹ�,");
			// ����������־��ѯ����
			IG036SearchCondImpl cond036 = new IG036SearchCondImpl();
			// ��������id
			cond036.setPrid(prid);
			// ����������ʼ��ʾ
			cond036.setPsdcode("Z");
			// ���ñ�ʾ2
			cond036.setRlType("2");
			// ����ig036
			List<IG036Info> list036 = ig036BL.searchIG036InfoByCond(cond036);
			// ����б�Ϊ��
			if (list036 != null && list036.size() > 0
					&& StringUtils.isNotBlank(dto.getAttkey())) {
				// ѭ����־�б�
				for (IG036Info info036 : list036) {
					// ����tb
					IG036TB tb = (IG036TB) info036;
					// ����attkey
					tb.setRlattkey(dto.getAttkey());
					// ����ig036��־��
					ig036BL.updateG036Info(tb);
				}
			}
			entity.setFingerPrint("���̷���ɹ�,������־����ɹ�");
//			if (StringUtils.isNotBlank(info.getRelatedPrid())) {
//				// �������̱�ֵ��ʵ��
//				IG505TB ig505tb = new IG505TB();
//				// ����id
//				ig505tb.setPrid(prid);
//				ig505tb.setPiprid(Integer.parseInt(info.getRelatedPrid()));
//				ig505tb.setPiprtype("WD");
//				ig505tb.setPiprtitle(info.getChangeName());
//				IG505Info ig505info = ig505BL.registIG505(ig505tb);
//				// ��Ӳ�ѯ����
//				IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
//				ig599cond.setPrid(prid);
//				ig599cond.setPivarname("��س��򿪷�����");
//				List<IG599Info> list = ig599BL
//						.searchIG599InfosByCond(ig599cond);
//				if (list.size() > 0) {
//					IG599TB ig599tb = (IG599TB) list.get(0);
//					// �޸����̱���ֵ
//					ig599tb.setPivarvalue(String.valueOf(ig505info.getPiprrid()));
//					// ִ���޸ķ���
//					ig599BL.updateIG599Info(ig599tb);
//				}
//			}

			// �������������id����������־��
			entity.setPrid(prid);
			// yyyy/MM/dd HH:mm
			entity.setPublishTime(IGStringUtils.getCurrentDateTime());
			// ����״̬ �ɹ�
			entity.setPublishStatus("1");
			// ���±��������־
			initiateChangLogBL.updateInitiateChangLog(entity);
			
			
			User user = userBL.searchUserByKey(info.getPruserId());
			
			
			entity.setFingerPrint("���̷���ɹ�,������־����ɹ����ɹ�����");
			if("������".equals(info.getSelectedChangeType())){
				transitionProcessBy(prid, "000127", "�ύ", IGStringUtils.getCurrentDateTime());
			}
			
			
			/**
			 *���ò��������ڵ��������
			 */
			List<UserInfo> userInfoList = new ArrayList<UserInfo>();
			List<UserInfo> userInfos = new ArrayList<UserInfo>();
			Integer roleid = null;
	        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1227Ϊ�����������ĸ�����
	        List<UserInfo> userInfoList1227 = this.sysManageBL.searchUserInfo(roleid_1227,user.getOrgid());
	        if(userInfoList1227 != null && userInfoList1227.size() != 0){
	        	roleid = roleid_1227;
	        	userInfoList.addAll(userInfoList1227);
	        }
	        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1228Ϊϵͳ�������ĸ�����
	        List<UserInfo> userInfoList1228 = this.sysManageBL.searchUserInfo(roleid_1228, user.getOrgid());
	        if(userInfoList1228 != null && userInfoList1228.size() != 0){
	        	roleid = roleid_1228;
	        	userInfoList.addAll(userInfoList1228);
	        }
	        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1229Ϊ����������ĸ�����
	        List<UserInfo> userInfoList1229 = this.sysManageBL.searchUserInfo(roleid_1229,user.getOrgid());
	        if(userInfoList1229 != null && userInfoList1229.size() != 0){
	        	roleid = roleid_1229;
	        	userInfoList.addAll(userInfoList1229);
	        	//��ѯ������������ڵĳ�Ա
	        	List<UserInfo> userInfoList1220 = this.sysManageBL.searchUserInfo(roleid_1220, "0002");
	        	userInfos.addAll(userInfoList1220);
	        }
	        // ���ݷ����˻�����ѯ�ڵ㴦���ˣ�����id=1230Ϊ�ۺϹ���������
	        List<UserInfo> userInfoList1230 = this.sysManageBL.searchUserInfo(roleid_1230, user.getOrgid());
	        if(userInfoList1230 != null && userInfoList1230.size() != 0){
	        	roleid = roleid_1230;
	        	userInfoList.addAll(userInfoList1230);
	        }
	        if (userInfoList == null || userInfoList.size() == 0) {
		        throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
		    }
	        String useridPrid = null;
		    for (UserInfo userInfo : userInfoList) {
		        //��װ���̴�����id
		        useridPrid = userInfo.getUserid();
		
		    }
		    // ������������������������Ա    ����������ڵ�������Ա���벿��������������
		    if(userInfos != null && userInfos.size() > 0){
		    	for (UserInfo userInfo : userInfos) {
		    		if(!info.getPruserId().equals(userInfo.getUserid())){//����������ڴ�������,��ȥ��������
		    		
		    			useridPrid = userInfo.getUserid();
		    			
		    		}
			    }
		    }
		    
		    
			
			
			transitionProcessBy(prid, useridPrid, "����ͨ��", IGStringUtils.getCurrentDateTime());
			// ���prid��ֵ
			if (prid != null && prid != 0) {
				dto.setResult("1");
			}

		} catch (Exception e) {
			// ����״̬ ʧ��
			entity.setPublishStatus("0");
			// ʧ����־
			entity.setRemark(e.getMessage());
			entity.setFingerPrint(e.getMessage()+"���̷���ʧ��");
			initiateChangLogBL.updateInitiateChangLog(entity);
			// ���ʧ��
			dto.setResult("0");
			e.printStackTrace();
		}
		return dto;
	}
	
	
	/***
	 * desc������������־ param��dto return��dto
	 * 
	 */
	public IGCHANGE01DTO saveInitiacteChangeAction(IGCHANGE01DTO dto)
			throws BLException {
		Log.debug("������־");
		// ��ȡʵ��
		InitiateChangLogTB tb = dto.getInitTB();
		// ��������
		InitiateChangLogInfo registInitiateChangLog = initiateChangLogBL
				.registInitiateChangLog(tb);
		// �ж��Ƿ�Ϊ��
		if (registInitiateChangLog != null)
			// �趨����
			dto.setIcid(registInitiateChangLog.getIcid() + "");

		return dto;
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
	public void transitionProcessBy(Integer prid, String userid, String action, String datetime) throws BLException {
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
	}

	
	
	
	/**
	 * ����PRID ��ѯ ���̼�¼����Ϣ
	 */
	public IGCHANGE01DTO searchInitiacteChangeAction(IGCHANGE01DTO dto)
			throws BLException {

		// ��ȡPRID
		Integer prid = dto.getPrid();
		// ʵ������ѯ
		InitiateChangLogSearchCondImpl cond = new InitiateChangLogSearchCondImpl();
		// �趨��ѯ����
		cond.setPrid(prid);
		// ���ò�ѯ������ѯ����
		List<InitiateChangLogInfo> searchInitiateChangLog = initiateChangLogBL
				.searchInitiateChangLog(cond);

		// �����Ϊ�� ���� ����������Ϊ0 ��ô��������־������������ �������ǻ�ȡ��ticketid ���͸��Է�
		if (searchInitiateChangLog != null
				&& searchInitiateChangLog.size() != 0) {

			InitiateChangLogInfo info = searchInitiateChangLog.get(0);

			// PMSϵͳ����IDȡ��
			String ticketId = info.getTicketid();
			dto.setTicketId(ticketId);
			System.out.println(ticketId);
		}

		return dto;
	}

	/**
	 * �����־BLȡ��
	 * 
	 * @return initiateChangLogBL �����־BL
	 */
	public InitiateChangLogBL getInitiateChangLogBL() {
		return initiateChangLogBL;
	}

	/**
	 * �����־BL�趨
	 * 
	 * @param initiateChangLogBL
	 *            �����־BL
	 */
	public void setInitiateChangLogBL(InitiateChangLogBL initiateChangLogBL) {
		this.initiateChangLogBL = initiateChangLogBL;
	}

	/**
	 * ���̶���ҵ��ȡ��
	 * 
	 * @return workFlowDefinitionBL ���̶���ҵ��
	 */
	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}

	/**
	 * ���̶���ҵ���趨
	 * 
	 * @param workFlowDefinitionBL
	 *            ���̶���ҵ��
	 */
	public void setWorkFlowDefinitionBL(
			WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * flowOptBLȡ��
	 * 
	 * @return flowOptBL flowOptBL
	 */
	public FlowOptBL getFlowOptBL() {
		return flowOptBL;
	}

	/**
	 * flowOptBL�趨
	 * 
	 * @param flowOptBL
	 *            flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * �������ֵBLȡ��
	 * 
	 * @return ig505BL �������ֵBL
	 */
	public IG505BL getIg505BL() {
		return ig505BL;
	}

	/**
	 * �������ֵBL�趨
	 * 
	 * @param ig505BL
	 *            �������ֵBL
	 */
	public void setIg505BL(IG505BL ig505bl) {
		ig505BL = ig505bl;
	}

	/**
	 * ���̱�����Ϣʵ��BLȡ��
	 * 
	 * @return ig599BL ���̱�����Ϣʵ��BL
	 */
	public IG599BL getIg599BL() {
		return ig599BL;
	}

	/**
	 * ���̱�����Ϣʵ��BL�趨
	 * 
	 * @param ig599BL
	 *            ���̱�����Ϣʵ��BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * ig036BL�趨
	 * 
	 * @param ig036BL
	 */
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}

	/**
	 * ig500BL�趨
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * ig224BL�趨
	 * @param ig224BL ig224BL
	 */
	public void setIg224BL(IG224BL ig224bl) {
		ig224BL = ig224bl;
	}

	/**
	 * ig337BL�趨
	 * @param ig337BL ig337BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * fsBL�趨
	 * @param fsBL fsBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
}

