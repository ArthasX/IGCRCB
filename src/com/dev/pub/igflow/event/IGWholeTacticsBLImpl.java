/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.pub.igflow.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * �������������峬ʱ��ʵ��BL
 * �����������������峬ʱ��ʵ��BL
 * ������¼��2014/06/10
 * (1)�˷������������峬ʱ���Ե�֪ͨ����
 * (2)�˷������������̽���ʱ������ʱ��������
 * �޸ļ�¼��
 */
public class IGWholeTacticsBLImpl extends BaseBLImpl implements WorkFlowTacticsHandlerBL {
//extends IGReportSuperTacticsBLImpl
	static Log log = LogFactory.getLog(IGWholeTacticsBLImpl.class);
	
	/** ������תBL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ��ѯ�๦��API�� */
	protected FlowSearchBL flowSearchBL;
	
	/** ��ѯ��ɫ��Ȩ��ϢBL */
	protected UserRoleBL userRoleBL;

	/** ��ѯ�û���ϢBL */
	protected UserBL userBL;
	
	/** ���Ͷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** �����ʼ�BL */
	protected SendMailBL sendMailBL;
	
	/** ֪ͨ���Ի�����Ϣ��ѯBL */
	protected IG334BL ig334BL;
	
	/** ��������Ϣ��ѯBL */
	protected IG335BL ig335BL;
	
	/** ��������Ϣ��ѯBL */
	protected IG380BL ig380BL;
			
	/**
	 * ������תBL�趨
	 *
	 * @param workFlowOperationBL ������תBL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * ��ѯ�๦��API���趨
	 *
	 * @param flowSearchBL ��ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ��ѯ��ɫ��Ȩ��ϢBL�趨
	 *
	 * @param userRoleBL ��ѯ��ɫ��Ȩ��ϢBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ѯ�û���ϢBL�趨
	 *
	 * @param userBL ��ѯ�û���ϢBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ���Ͷ���BL�趨
	 *
	 * @param sendMessageBL ���Ͷ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �����ʼ�BL�趨
	 *
	 * @param sendMailBL �����ʼ�BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * ֪ͨ���Ի�����Ϣ��ѯBL�趨
	 *
	 * @param ig334BL ֪ͨ���Ի�����Ϣ��ѯBL
	 */
	public void setIg334BL(IG334BL ig334BL) {
		this.ig334BL = ig334BL;
	}
	
	/**
	 * ��������Ϣ��ѯBL�趨
	 *
	 * @param ig335BL ��������Ϣ��ѯBL
	 */
	public void setIg335BL(IG335BL ig335BL) {
		this.ig335BL = ig335BL;
	}
	
	/**
	 * ��������Ϣ��ѯBL�趨
	 *
	 * @param ig380BL ��������Ϣ��ѯBL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * ���̳�ʱ�ж�
	 */
	public void initExecute(String pdid, String psdid) throws BLException {
		//�������̳�ʱ�ж�
		this.processTactics(pdid, psdid);
	}

	/**
	 * ���̳�ʱ����
	 * @throws BLException 
	 */
	public void processTactics(String pdid, String psdid) throws BLException{
		log.debug("========�������峬ʱ�жϲ��Դ���ʼ========");
		//�����������Ͳ�ѯ������������
		IG380Info ig380Info = ig380BL.searchIG380InfoByKey(pdid);
		if(ig380Info == null){
			log.debug("���������ͱ���û�д����͵����̡�");
			return;
		}
		String pdname = ig380Info.getPdname();//������������
		//��ѯ�����Ƿ�����֪ͨ������Ϣ
		IG334SearchCondImpl ig334cond = new IG334SearchCondImpl();
		ig334cond.setPdid_like(pdid);
		List<IG334Info> lstIG334 = this.ig334BL.searchIG334(ig334cond);
		if(lstIG334 != null && lstIG334.size() > 0){//���ڽ��ʱ����֪ͨ����
			IG334Info ig334Info = lstIG334.get(0);//һ��ֻ�����һ�м�¼
			String pidid = ig334Info.getPidid();//��ȡ��Ӧ��ID(�ޱ����ʱ��ID��000����)
			//��Ҫ��ѯIG335���й������������֪ͨ��������
			IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
			ig335cond.setPsdid_eq(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);
			ig335cond.setPidid_eq(pidid);
			ig335cond.setPdid_eq(pdid);
			List<IG335Info> lstIG335 = ig335BL.searchIG335(ig335cond);
			if(lstIG335 != null && lstIG335.size() > 0){//���ڽ��ʱ����֪ͨ����
				for(IG335Info ig335Info : lstIG335){
					Integer roleid = ig335Info.getRoleid();//֪ͨ�������ý�ɫID
					String processbl = ig335Info.getProcessbl();//֪ͨ����ִ��BL
					if(StringUtils.isEmpty(ig335Info.getProcessbl())) {//Ϊ��ʱ����ΪĬ�ϵ������������BL
						processbl = IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE;
					}
					if(roleid > 0 && StringUtils.isNotEmpty(processbl)){//���ڽ�ɫID�Ҵ���֪ͨ����ִ��BLʱ
						//������������ID��ѯ����δ�رյ�����
						IG500SearchCondImpl cond = new IG500SearchCondImpl();
						cond.setPrActive("Y");
						cond.setPrpdid(pdid);
						List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
						
						//û��δ�ر����̲���Ҫ���г�ʱУ��
						if(lstIG500Info == null || lstIG500Info.isEmpty()){
							log.debug(pdname+"���͵�����û��δ�رյ���Ҫִ��֪ͨ�����жϡ�");
							return;
						}
						
						for(IG500Info info : lstIG500Info) {
							boolean isMatch = true;//�Ƿ�ƥ��Ĭ��ƥ�伴����֪ͨ���Դ���
							//��ȡ��ǰ���̶�Ӧ��������б��ֵ�Ƿ���IG335���н������õ�ֵ��ͬ
							String pivarvalue = "";
							if(StringUtils.isNotEmpty(ig334Info.getPidname())){
								pivarvalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), ig334Info.getPidname());
							}
							if(StringUtils.isNotEmpty(pivarvalue)){
								if(!pivarvalue.equals(ig335Info.getPivalue())){
									isMatch = false;
								}
							}
							if(!isMatch){//��ֵ�����õ�ֵ��ƥ��ʱԾ����������¸������ж�
								continue;
							}
							//�ѳ�ʱ�����̲���Ҫ�ٴν��г�ʱ����
							if(StringUtils.isNotEmpty(info.getPrPriority()) && IGPRDCONSTANTS.PROCESS_OVERTIME.equals(info.getPrPriority())){
								continue;
							}
							
							//�������̵ķ���ʱ��͵�ǰʱ���(�����������ʾ)�������������õĲ���(�����������ʾ)���бȽ��ж��Ƿ�ʱ
							String initTimeDate = info.getPropentime();//���̵ķ�������ʱ��
							String currTimeDate = IGStringUtils.getCurrentDateTime();//ϵͳ��ǰʱ��
							Long nodifyMin = getWholeNodifyMinutes(ig335Info.getNotifyd(), ig335Info.getNotifyh(), ig335Info.getNotifym());//��ȡ�������峬ʱ֪ͨ�������õĳ�ʱʱ��
							Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//��ȡ��ǰʱ���
							
							if(dMin > nodifyMin){//����ǰʱ�������������峬ʱ����ʱ��ʱ���ͳ�ʱ֪ͨ
								//��ʱ֪ͨ���ò���IG500���м�¼�ѷ��ͳ�ʱ����
								IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
								ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_OVERTIME);
								IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
								
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate);
							}
						}
					}
				}
			} else {
				log.debug(pdname+"���͵�����δ������������֪ͨ���Ե����á�");
			}
		} else {
			log.debug(pdname+"���͵�����δ����֪ͨ���Ե����á�");
		}
		log.debug("========�������峬ʱ�жϲ��Դ������========");
	}
	
	/**
	 * ���̳�ʱ��������
	 * 
	 * @param info
	 * @throws BLException
	 */
	public void processSend(IG334Info info, IG500Info ig500Info, String now) throws BLException{
		/**
		 * �������̲�ѯ��ǰ������ �����Ͷ��Ż��ʼ�����Ա���ɫ
		 */
		//��Ϣ������Map Mail
		Map<String,String[]> sendMailUserInfo = new HashMap<String, String[]>();
		//��Ϣ������Map Sms
		Map<String,String[]> sendSmsUserInfo = new HashMap<String, String[]>();
		
		
		//����prid���̵�ǰ״̬��״̬����
		List<ProcessStatusInfo> psiCList = flowSearchBL.searchCurrentStatus(ig500Info.getPrid());
		String psdName = "";
		if (psiCList != null && psiCList.size() > 0) {
			ProcessStatusInfo psdInfo = flowSearchBL.searchProcessStatus(psiCList.get(0).getPsdid());
			psdName = psdInfo.getPsdname();
		}
		
		//�������˷�������
		if(ig500Info != null){
			//���Ͷ���
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
				//��ŷ����û���Ϣ
				sendSmsUserInfo.put(ig500Info.getPruserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//				sendMessageBL.sendSmsToUser(ig500Info.getPruserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
			}			
			//�����ʼ�
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){	
				User user = userBL.searchUserByKey(ig500Info.getPruserid());
				if(StringUtils.isEmpty(user.getUseremail())){
					log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
					return;
				}
				String[] address = new String[1];
				address[0] = user.getUseremail();
				//��ŷ����û���Ϣ
				sendMailUserInfo.put(ig500Info.getPruserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//				sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
			}
		}
		
		//��������״̬������ID��ȡ��״̬�µĲ�������Ϣ
		List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(ig500Info.getPrid(), ig500Info.getPrstatus());
		for(int i = 0; i < ig337Infos.size(); i++) {
			//���������ָ������ɫͨ����ɫid��ȡ��ɫ�������˷�֪ͨ
			if(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE.equals(ig337Infos.get(i).getPptype())){
				if(ig337Infos.get(i).getPproleid() > 0){
					continue;
				}
				//��ȡ��ɫ��������
				UserRoleVWSearchCondImpl urvwCond = new UserRoleVWSearchCondImpl();
				urvwCond.setRoleid(ig337Infos.get(i).getPproleid());
				List<UserRoleInfo> userRoleInfos = userRoleBL.searchUserRoleVW(urvwCond);
				for(int j = 0; j < userRoleInfos.size(); j++) {
					//���ݲ��Է���֪ͨ
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){//�ʼ�֪ͨ
						User user = userBL.searchUserByKey(userRoleInfos.get(j).getUserid());
						if(StringUtils.isEmpty(user.getUseremail())){
							log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
							return;
						}						
						String[] address = new String[1];
						address[0] = user.getUseremail();
						//��ŷ����û���Ϣ
						sendMailUserInfo.put(userRoleInfos.get(j).getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now,address[0]});
//						sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now),	address);
					}
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){//����֪ͨ
						//��ŷ����û���Ϣ
						sendSmsUserInfo.put(userRoleInfos.get(j).getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//						sendMessageBL.sendSmsToUser(userRoleInfos.get(j).getUserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
					}
				}
			//ָ������ֱ�ӷ�֪ͨ
			} else{
				//�ʼ�֪ͨ
				if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())) {
					User user = userBL.searchUserByKey(ig337Infos.get(i).getPpuserid());
					if(StringUtils.isEmpty(user.getUseremail())){
						log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
						return;
					}
					String[] address = new String[1];
					address[0] = user.getUseremail();
					//��ŷ����û���Ϣ
					sendMailUserInfo.put(ig337Infos.get(i).getPpuserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//					sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
				}
				//����֪ͨ
				if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
					//��ŷ����û���Ϣ
					sendSmsUserInfo.put(ig337Infos.get(i).getPpuserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//					sendMessageBL.sendSmsToUser(ig337Infos.get(i).getPpuserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
				}
			}//end if
		}//end for
		
		//��ѯָ����ɫ��Ȩ��Ա
		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
		//û��ָ���Ľ�ɫ����������
		if(info.getRoleid() != null && info.getRoleid() > 0){
			urcond.setRoleid(info.getRoleid());
			List<UserRole> lstUserRole = userRoleBL.searchUserRole(urcond);
			//ָ����ɫ��û���˲���������
			if(lstUserRole != null && lstUserRole.size() > 0){
				for(UserRole userRole : lstUserRole) {
					//���Ͷ���
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
						//��ŷ����û���Ϣ
						sendSmsUserInfo.put(userRole.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//						sendMessageBL.sendSmsToUser(userRole.getUserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
					}
					
					//�����ʼ�
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){			
						User user = userBL.searchUserByKey(userRole.getUserid());
						if(StringUtils.isEmpty(user.getUseremail())){
							log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
							return;
						}
						String[] address = new String[1];
						address[0] = user.getUseremail();
						//��ŷ����û���Ϣ
						sendMailUserInfo.put(userRole.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//						sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now),	address);
					}
				}
			}
		}
		
		//�����ʼ�
		if(!sendMailUserInfo.isEmpty()) {
			Set<String> userIds = sendMailUserInfo.keySet();
			for(String userid : userIds) {
				String[] messageInfos = sendMailUserInfo.get(userid);
				sendMailBL.sendMail(messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]), 
									messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]), 
									new String[]{messageInfos[4]});
			}
		}
		
		//���Ͷ���
		if(!sendSmsUserInfo.isEmpty()) {
			Set<String> userIds = sendSmsUserInfo.keySet();
			for(String userid : userIds) {
				String[] messageInfos = sendSmsUserInfo.get(userid);
				sendMessageBL.sendSmsToUser(userid, messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]));
			}
		}
	}
	
	/**
	 * ��ʾ��Ϣģ��
	 * 
	 * @param prstatus
	 * @param prserialnum
	 * @param prtitle
	 * @param now
	 * @return
	 */
	private String messageFormatFactory(String prstatus, String prserialnum, String prtitle, String now) {
		return "�������ѣ���ǰʱ��Ϊ��" + now + "������ע��״̬Ϊ ��"+prstatus+"�� �Ĺ�����Ϊ��" + prserialnum + "���� ��" + prtitle + "�������Ѿ���ʱ���������Ա������ɹ���";
	}
	
	/**
	 * Tools
	 */
	/**
	 * ����IG335�����õĳ�ʱ������\Сʱ\���Ӽ��㳬ʱ��ʱ��(�����������ʾ)
	 * @param notifyd ��ʱ��
	 * @param notifyh ��ʱСʱ
	 * @param notifym ��ʱ����
	 * @return
	 */
	private Long getWholeNodifyMinutes(Integer notifyd, Integer notifyh, Integer notifym) {
		long result = 0l;//Ԥ�����ý��
		if(notifyd != null){
			result += (notifyd * 24 * 60);
		}
		if(notifyh != null){
			result += (notifyh * 60);
		}
		if(notifym != null){
			result += notifym;
		}
		return result;
	}
}