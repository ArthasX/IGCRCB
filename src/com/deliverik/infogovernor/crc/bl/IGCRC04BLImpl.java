/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0401Form;
import com.deliverik.infogovernor.crc.form.IGCRC0402Form;
import com.deliverik.infogovernor.crc.form.IGCRC0403Form;
import com.deliverik.infogovernor.crc.form.IGCRC0405Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC04BLImpl extends BaseBLImpl implements IGCRC04BL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** ���̴�����API */
	protected FlowOptBL flowOptBL;

	protected RoleActionBL roleActionBL;

	/** ������API */
	protected FlowSetBL flowSetBL;

	/** ���̶���ҵ��BL */
	protected IG380BL ig380BL;

	/** ƽ̨�û�BL */
	protected UserBL userBL;

	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���ŷ���BL */
	protected SendMessageBL sendMessageBL;
	
	

	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * ���̴���BL�趨
	 * 
	 * @param workFlowOperationBL
	 *            ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ���̶���BL�趨
	 * 
	 * @param workFlowDefinitionBL
	 *            ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * @param roleActionBL
	 *            the roleActionBL to set
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * ���̴�����API�趨
	 * 
	 * @param flowOptBL
	 *            ���̴�����API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * ������API�趨
	 * 
	 * @param flowSetBL
	 *            ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ƽ̨�û�BL�趨
	 * 
	 * @param userBL
	 *            ƽ̨�û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ��ѯ��API�趨
	 * 
	 * @param flowSearchBL
	 *            ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���̶���ҵ��BL�趨
	 * 
	 * @param ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * ���̲�ѯ����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO searchProcessRecords(IGCRC04DTO dto) throws BLException {
		log.debug("===============���̲�ѯ������ʼ=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			// dto����ȡ��
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			// ȡ��û�а汾��pdid
			StringBuffer pdid = new StringBuffer(form.getPdid());
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like(pdid.toString());
			// ��ȡ���е���������
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);

			// ��ȡ�����̵����汾
			if(form.getPrstatus().length() == 3){
				String maxpdid = list380.get(list380.size()-1).getPdid().concat(form.getPrstatus());
				form.setPrstatus(maxpdid);
			}
			User user = dto.getUser();
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPrstatus());
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			this.copyProperties(cond, form);
			cond.setPrpdid(form.getPdid());
			cond.setPrstatus(psd.getPsdcode());
			cond.setUserid_q(user.getUserid());
			cond.setPcode("Y");
			List<IG500Info> list = workFlowOperationBL.searchProcessByType(cond, 0, 0, IGPRDCONSTANTS.SEARCH_MY_UN_PROCESSED);

			List<IG500Info> finalList = new ArrayList<IG500Info>();
			if (psd.getPsdcode() != null && psd.getPsdcode().equals("R")) {
				for (int i = 0; i < list.size(); i++) {
					Integer prid = list.get(i).getPrid();
					String className = flowSearchBL.searchPublicProcessInfo(Integer.valueOf(prid), "�������");
					if (className != null && !(className.equals("")) && !(className.contains("ϵͳ������"))) {
						finalList.add(list.get(i));
					}
				}
				dto.setProcessList(finalList);
			} else {
				dto.setProcessList(list);
			}
		}
		log.debug("===============���̲�ѯ��������=================");
		return dto;
	}

	/**
	 * �����������ҳ���ʼ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initIGCRC0402Action(IGCRC04DTO dto) throws BLException {
		log.debug("=================�����������ҳ���ʼ��������ʼ================");
		// dto����ȡ��
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0402Form) {
			IGCRC0402Form form = (IGCRC0402Form) dto.getForm();

			if (form.getPrstatus() != null) {
				form.setStatusCode(form.getPrstatus().substring(7));
			}

			if (form.getPrid() != null && form.getPrid().length > 0) {
				StringBuffer prids = new StringBuffer();
				for (int i = 0; i < form.getPrid().length; i++) {
					if (i > 0) {
						prids.append(",");
					}
					prids.append(form.getPrid()[i]);
				}
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrid_in(prids.toString());
				List<IG500Info> list = workFlowOperationBL.searchProcessByType(cond, 0, 0, null);
				dto.setProcessList(list);
			}
		}
		log.debug("=================�����������ҳ���ʼ����������================");
		return dto;
	}

	/**
	 * ��������������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO disposeAction(final IGCRC04DTO dto) throws BLException {
		log.debug("==============����������������ʼ===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0402Form) {
			// dto����ȡ��
			final IGCRC0402Form form = (IGCRC0402Form) dto.getForm();
			final User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				List<IG333Info> list = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				if (list != null && list.size() > 0) {
					form.setForward("ASSIGN");
				}
				
				Thread deployThread = new Thread(){
	     			@Override
	     			public void run() {
	     				
	     				for (Integer prid : form.getPrid()) {
	    					IG500Info pr;
							try {
								pr = workFlowOperationBL.searchProcessRecordByKey(prid);
							
		    					// ��ȡ�û������ɫ
		    					UserRoleInfo ur = workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
		    					// ȡ�ñ���Ϣ
		    					if (form.getPivarnames() != null && form.getPivarnames().length > 0 && form.getPivarvalues() != null && form.getPivarvalues().length > 0 && form.getPivarnames().length == form.getPivarvalues().length) {
		    						for (int i = 0; i < form.getPivarnames().length; i++) {
		    							WorkFlowLog logInfo = new WorkFlowLog();
		    							logInfo.setPrid(prid);
		    							logInfo.setExecutorid(user.getUserid());
		    							logInfo.setExecutorRoleid(ur.getRoleid());
		    							PublicProcessInfoValue value = new PublicProcessInfoValue(logInfo);
		    							value.setFormname(form.getPivarnames()[i]);
		    							value.setFormvalue(form.getPivarvalues()[i]);
		    							flowSetBL.setPublicProcessInfoValue(value);
		    						}
		    					}
		    					// �����־
		    					if (StringUtils.isNotEmpty(form.getRlcomment()) || (form.getFileMap() != null && !form.getFileMap().isEmpty())) {
		    						workFlowOperationBL.addRecordLog(prid, user, ur.getRoleid(), form.getRlcomment(), form.getButtonName(), form.getFileMap(), IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null);
		    					}
		    					if (!"ASSIGN".equals(form.getForward())) {
		    						String prstatus = form.getPrstatus().substring(7);
		    						if(prstatus=="015"||prstatus=="013"||prstatus=="010"||prstatus=="014"){
		    							// ԾǨ
			    						try{
			    							flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
			    						}catch (Exception e) {
			    							log.error("�����ţ�"+pr.getPrserialnum()+"�ı������ԾǨ���������ִ�нڵ�ʱ�뱤�ݻ�ͨѶʧ��");
			    				            //ʧ�ܺ��Ͷ��Ÿ�������
			    							String message = "�����ţ�"+pr.getPrserialnum()+"�ı������ԾǨ���������ִ�нڵ�ʱ�뱤�ݻ�ͨѶʧ�ܣ������ϵͳ�鿴������־��";
			    							sendMessageBL.sendSmsToUser(user.getUserid(), message);
			    				        }
		    						}else{
		    							flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
		    						}
		    						
		    					}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
	    				}
	     			}
	     		};
	     		deployThread.start();
	     		
				
				if ("ASSIGN".equals(form.getForward())) {
					dto.addMessage(new ActionMessage("IGCRC0401.I001"));
				}
			}
		}
		log.debug("==============������������������===============");
		return dto;
	}

	/**
	 * ��ʼ������ҳ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initAssignPageAction(IGCRC04DTO dto) throws BLException {
		log.debug("===============����ҳ���ʼ��������ʼ===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto����ȡ��
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			// �ɱ����ɽڵ��ѯ
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
			for (int i = 0; i < lst_ProcessStatusDef.size(); i++) {
				if (lst_ProcessStatusDef.get(i).getPsdname() != null && lst_ProcessStatusDef.get(i).getPsdname().equals("��׼���ִ��")) {
					lst_ProcessStatusDef.remove(i);
				}
			}
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// ��ѯ�ɷ��ɽ�ɫ
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				for (IG298Info psrd : lst_ProcessStatusRoleDef) {
					UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
					userInfoCond.setRoleida(psrd.getRoleid());
					if (IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						userInfoCond.setOrgida(dto.getUser().getOrgid());
					}
					map.get(psd).put(psrd.getRole(), userBL.searchUserInfo(userInfoCond));
				}
			}
			dto.setAssignInfo(map);
		}
		log.debug("===============����ҳ���ʼ����������===============");
		return dto;
	}

	/**
	 * �������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public IGCRC04DTO assignAction(IGCRC04DTO dto) throws BLException {
		log.debug("================�������������ʼ===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto����ȡ��
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
				cond380.setPdid_like("01001");// �������
				List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
				// �ɱ����ɽڵ��ѯ
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size() - 1).getPdid() + "001", "10");
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);

					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(3029);

					// ɾ��ԭ���ڵ������
					StatusParticipant participant = new StatusParticipant(logInfo);
					for (IG333Info psd : lst_ProcessStatusDef) {
						participant.setStatuscode(psd.getPsdid());
						flowSetBL.deleteStatusParticipant(participant);
					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// ԾǨ����
					flowOptBL.transitionProcess(prid, user.getUserid(), "���ͨ��", IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================���������������===============");
		return dto;
	}

	/**
	 * ��鹤������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public IGCRC04DTO assignWorkAction(IGCRC04DTO dto) throws BLException {
		log.debug("================��鹤������������ʼ===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto����ȡ��
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			form.setPrid(dto.getPrid());
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
				cond380.setPdid_like("01001");// �������
				List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
				// �ɱ����ɽڵ��ѯ
//				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size()-1).getPdid()+"001","10");
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);

					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(3029);
					// ���±�ֵ
					PublicProcessInfoValue publicProcessInfoValueInfo = new PublicProcessInfoValue(logInfo);
					publicProcessInfoValueInfo.setFormname("���ɱ�ʾ");
					// ���ִ�нڵ������Ա�����ɱ�ʾΪ1������Ϊ0
					if (form.getParticipants() != null) {
						int temp = 0;
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							cond380.setPdid_like("01140");// ��鹤������
							list380 = ig380BL.searchIG380Info(cond380);
							if ((list380.get(list380.size() - 1).getPdid() + "004").equals(info[0])) {
								publicProcessInfoValueInfo.setFormvalue("2");
								temp = 1;
							}
						}
						if (temp == 0) {
							publicProcessInfoValueInfo.setFormvalue("1");
						}
					}

					flowSetBL.setPublicProcessInfoValue(publicProcessInfoValueInfo);

					// ɾ��ԭ���ڵ������
					StatusParticipant participant = new StatusParticipant(logInfo);
//					for (IG333Info psd : lst_ProcessStatusDef) {
//						participant.setStatuscode(psd.getPsdid());
//						flowSetBL.deleteStatusParticipant(participant);
//					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// ԾǨ����
					flowOptBL.transitionProcess(prid, user.getUserid(), "�ύ", IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================��鹤��������������===============");
		return dto;
	}

	/**
	 * ��ȡ�����ɫID
	 * 
	 * @return �����ɫID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		// ��ȡ����"��������"�˵��Ľ�ɫID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname("ACT04RIS0302");
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if (lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "������ɫ");
		}
		return lst_RoleAction.get(0).getRoleid();
	}

	/**
	 * �������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignSecureAction(IGCRC04DTO dto) throws BLException {
		log.debug("================�������������ʼ===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto����ȡ��
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				// �ɱ����ɽڵ��ѯ
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// ��ȡ�û������ɫ
					UserRoleInfo ur = this.workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// ɾ��ԭ���ڵ������
					StatusParticipant participant = new StatusParticipant(logInfo);
					for (IG333Info psd : lst_ProcessStatusDef) {
						participant.setStatuscode(psd.getPsdid());
						flowSetBL.deleteStatusParticipant(participant);
					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// ԾǨ����
					flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================���������������===============");
		return dto;
	}

	/**
	 * ��ȡ���̱������ѯ����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getPivarQueryInfoAction(IGCRC04DTO dto) throws BLException {
		log.debug("=================��ȡ�������ѯ����������ʼ=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			// dto����ȡ��
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			List<IG108Info> piqueryList = workFlowDefinitionBL.searchFormQueryDefByPdid(form.getPdid());
			if (piqueryList != null) {
				Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
				for (IG108Info pq : piqueryList) {
					IG007TB pid = pq.getPidTB();
					map.put(pid.getPidname(), pid);
				}
				dto.setProcessInfoQueryMap(map);
			}
		}
		log.debug("=================��ȡ�������ѯ������������=================");
		return dto;
	}

	/**
	 * �����������Excel
	 * 
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getExcelDataList(IGCRC04DTO dto) throws BLException {
		log.debug("=================��ȡ���������Ӧ���ݼ���ʼ=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if (StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())) {
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// ��ѯ������Ϣ����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// ����������ͱ��
		cond.setPrpdid(form.getPrpdid());
		cond = copyPropertie(dto.getIgwkm0101form(), cond);
		// ��ѯ������Ϣ
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0, form.getType()));

		// ��ѯ����Ϣ����
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// ����������ͱ��
		processInfoCond.setPdid(form.getPrpdid());
		// ��ѯ����Ϣ
		dto.setProcessInfoList(workFlowOperationBL.searchProcessInfoByCond(processInfoCond));

		// ��ѯ��������Ϣ����(����)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// ��ѯ��������Ϣ
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));

		// ��ѯ��״̬������Ϣ����
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// ����������ͱ��
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// ��ѯ��״̬����
		dto.setProcessStatusDefList(workFlowDefinitionBL.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================��ȡ���������Ӧ���ݼ�����=================");
		return dto;
	}

	/**
	 * ȡ����������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getParentProcessInfoAction(IGCRC04DTO dto) throws BLException {
		log.debug("================ȡ����������Ϣ������ʼ=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			IG500Info info = workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
			Map<String, String> map = new HashMap<String, String>();
			if (info.getPrpdname().indexOf("���򿪷�") >= 0) {
				map.put("prtitle", info.getPrtitle());
				map.put("prdesc", info.getPrdesc());
				map.put("type", "success");
			} else {
				map.put("type", "other");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("================ȡ����������Ϣ��������=================");
		return dto;
	}

	/**
	 * ��������
	 * 
	 * @param form
	 * @param cond
	 * @return
	 */
	private IG500SearchCondImpl copyPropertie(IGWKM0101Form form, IG500SearchCondImpl cond) {
		// ���ƹ���������
		if (form.getPrserialnum() != null && !(form.getPrserialnum().equals(""))) {
			cond.setPrserialnum(form.getPrserialnum());
		}
		// ���ƹ������Ƶ�����
		if (form.getPrtitle() != null && !(form.getPrtitle().equals(""))) {
			cond.setPrtitle(form.getPrtitle());
		}
		// ���Ʋ�ѯ��ʼʱ��
		if (form.getPropentime() != null && !(form.getPropentime().equals(""))) {
			cond.setPropentime(form.getPropentime());
		}
		// ���Ʋ�ѯ����ʱ��
		if (form.getPrclosetime() != null && !(form.getPrclosetime().equals(""))) {
			cond.setPrclosetime(form.getPrclosetime());
		}
		// �жϹ���״̬
		if (form.getPrstatus() != null && !(form.getPrstatus().equals(""))) {
			cond.setPrstatus(form.getPrstatus());
		}
		// �жϷ�����
		if (form.getPrusername() != null && !(form.getPrusername().equals(""))) {
			cond.setPrusername(form.getPrusername());
		}
		// ���Ʊ�����
		if (form.getVarnames() != null && form.getVarnames().length > 0) {
			cond.setVarnames(form.getVarnames());
		}
		// ���Ʊ�ֵ
		if (form.getVarvalues() != null && form.getVarvalues().length > 0) {
			cond.setVarvalues(form.getVarvalues());
		}
		return cond;
	}

	/**
	 * ȡ����־����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getRecordLogAttachmentAction(IGCRC04DTO dto) throws BLException {
		log.debug("=================��־����ȡ�ò�����ʼ===================");
		// dto����ȡ��
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0405Form) {
			IGCRC0405Form form = (IGCRC0405Form) dto.getForm();
			// ������Ϣ��ѯ
			IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			// ��ѯ������
			List<ParticipantInfo> ppList = flowSearchBL.searchStatusParticipant(form.getPrid(), "��׼���ִ��");
			// ȡ����־��Ϣ
			List<IG036Info> recordList = dto.getRecordList();
			boolean flag = true;
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			for (int i = recordList.size() - 1; i >= 0; i--) {
				IG036Info rl = recordList.get(i);
				if (rl.getAttachmentList() != null && rl.getAttachmentList().size() > 0) {
					if (rl.getRluserid().equals(pr.getPruserid()) || checkPP(ppList, rl.getRluserid())) {
						map.put("status", "success");
						List<Map<String, String>> list = new ArrayList<Map<String, String>>();
						for (Attachment att : rl.getAttachmentList()) {
							Map<String, String> temp = new HashMap<String, String>();
							temp.put("attid", att.getAttid() + "");
							temp.put("attname", att.getAttname().substring(att.getAttname().indexOf("_") + 1));
							list.add(temp);
						}
						map.put("content", list);
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				map.put("status", "error");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("=================��־����ȡ�ò�������===================");
		return dto;
	}

	private boolean checkPP(List<ParticipantInfo> ppList, String rluserid) {
		if (ppList != null && ppList.size() > 0) {
			for (ParticipantInfo pp : ppList) {
				if (rluserid.equals(pp.getUserid())) {
					return true;
				}
			}
		}
		return false;
	}
}
