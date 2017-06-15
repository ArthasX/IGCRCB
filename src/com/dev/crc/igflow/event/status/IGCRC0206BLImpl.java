/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
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
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
  * ����: ���̲��Թ���ҵ���߼��ӿ�
  * ��������: ���̲��Թ���ҵ���߼��ӿ�
  * ������¼: 2013/09/04
  * �޸ļ�¼: 
  */
public class IGCRC0206BLImpl implements WorkFlowTacticsHandlerBL {

	static Log log = LogFactory.getLog(IGCRC0206BLImpl.class);
	
	/** ���¹���API�� */
	@SuppressWarnings("unused")
	private FlowSetBL flowSetBL;
	
	/** ֪ͨ���Ի�����Ϣ��ѯBL */
	protected IG334BL ig334BL;

	/** ���̶���״̬��Ϣ��ѯBL */
	protected IG333BL ig333BL;
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���̲���ҵ���ѯBL */
	protected  IG256BL ig256BL;
	
	/** ����ԾǨBL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** �û�BL */
	protected UserBL userBL;

	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** ���Ͷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** �����ʼ�BL */
	protected SendMailBL sendMailBL;
	
	/** ��������Ϣ��ѯBL */
	protected IG380BL ig380BL;
	
	/** ��������Ϣ��ѯBL */
	protected IG335BL ig335BL;
	
	/** ���̲����û���Ϣҵ��BL */
	protected IG337BL ig337BL;
	
	/** �����ϼ�ָ����Ա��ѯBL */
	protected IG237BL processNoticeStrategyUserBL;
	/**
	 * ���¹���API���趨
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ֪ͨ���Ի�����Ϣ��ѯBL�趨
	 * @param ig334bl ֪ͨ���Ի�����Ϣ��ѯBL
	 */
	public void setIg334BL(IG334BL ig334bl) {
		ig334BL = ig334bl;
	}
	
	/**
	 * ���̶���״̬��Ϣ��ѯBL�趨
	 *
	 * @param ig333BL ���̶���״̬��Ϣ��ѯBL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	/**
	 * ��ѯ�๦��API���趨
	 * @param flowSearchBL ��ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ����ԾǨBL�趨
	 *
	 * @param workFlowOperationBL ����ԾǨBL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * ���̲���ҵ���ѯBL�趨
	 *
	 * @param ig256BL ���̲���ҵ���ѯBL
	 */
	public void setIg256BL(IG256BL ig256BL) {
		this.ig256BL = ig256BL;
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
	 * �û���ɫBL�趨
	 *
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
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
	 * ��������Ϣ��ѯBL�趨
	 *
	 * @param ig380BL ��������Ϣ��ѯBL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
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
	 * ���̲����û���Ϣҵ��BL
	 * @param ig337bl ���̲����û���Ϣҵ��
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	
	/**
	 * �����ϼ�ָ����Ա��ѯBL�趨
	 *
	 * @param processNoticeStrategyUserBL �����ϼ�ָ����Ա��ѯBL
	 */
	public void setProcessNoticeStrategyUserBL(IG237BL processNoticeStrategyUserBL) {
		this.processNoticeStrategyUserBL = processNoticeStrategyUserBL;
	}

	/**
	 * ��ʼ�����
	 * 
	 * @param pdid
	 * @param psdid
	 * @throws BLException 
	 * @throws JobExecutionException 
	 * @throws JobExecutionException 
	 */
	public void initExecute(String pdid, String psdid) throws BLException{
		System.out.println("**********************************************");
		//�����ϼ�
		this.regulation(pdid, psdid);
		System.out.println("**********************************************");
	}
	/**
	 * ����״̬�����жϵĹ�����¼�
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	public void regulation(String pdid, String psdid) throws BLException{
		String type = "�������";
		//û����������IDʱ��������ϼ�����
		if(StringUtils.isEmpty(pdid)){
			log.debug("��������IDΪ����Ϊ�ա�");
			return;
		}else{
			//�����������Ͳ�ѯ������������
			IG380Info ig380Info = ig380BL.searchIG380InfoByKey(pdid);
			if(ig380Info == null){
				log.debug("���������ͱ���û�д����͵����̡�");
				return;
			}
		}
		//��ѯ�����Ƿ�����֪ͨ������Ϣ
		IG334SearchCondImpl ig334cond = new IG334SearchCondImpl();
		ig334cond.setPdid_like(pdid);
		List<IG334Info> lstIG334 = this.ig334BL.searchIG334(ig334cond);
		if(lstIG334 != null && lstIG334.size() > 0){//���ڽ��ʱ����֪ͨ����
			IG334Info ig334Info = lstIG334.get(0);//һ��ֻ�����һ�м�¼
			String pidid = ig334Info.getPidid();//��ȡ��Ӧ��ID(�ޱ����ʱ��ID��000����)
			//��Ҫ��ѯIG335���й������������֪ͨ��������
			IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
			ig335cond.setPsdid_eq(psdid);
			ig335cond.setPidid_eq(pidid);
			ig335cond.setPdid_eq(pdid);
			List<IG335Info> lstIG335 = ig335BL.searchIG335(ig335cond);
			if(lstIG335 != null && lstIG335.size() > 0){//���ڽ��ʱ����֪ͨ����
				for(IG335Info ig335Info : lstIG335){
					String roleManager = ig335Info.getRolemanager();//֪ͨ�������ý�ɫID
					String processbl = ig335Info.getProcessbl();//֪ͨ����ִ��BL
					if(StringUtils.isEmpty(ig335Info.getProcessbl())) {//Ϊ��ʱ����ΪĬ�ϵ������������BL
						processbl = IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE;
					}
					if(StringUtils.isNotEmpty(roleManager) && roleManager.equals("1") && StringUtils.isNotEmpty(processbl)){//���ڽ�ɫID�Ҵ���֪ͨ����ִ��BLʱ
						
						//������������ID��ѯ����δ�رյ�����
						IG500SearchCondImpl cond = new IG500SearchCondImpl();
						cond.setPrpdid(pdid);
						cond.setPrstatus("W");
						List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
						//û��δ�ر����̲���Ҫ���г�ʱУ��
						if(lstIG500Info == null || lstIG500Info.isEmpty()){
							log.debug("�¼����͵�����û��δ�رյ���Ҫִ��֪ͨ�����жϡ�");
							return;
						}
						
						for(IG500Info info : lstIG500Info){
							
							Integer prid = info.getPrid();
							//�������̵ķ���ʱ��͵�ǰʱ���(�����������ʾ)�������������õĲ���(�����������ʾ)���бȽ��ж��Ƿ�ʱ
							//���뵽�ýڵ��ʱ��
							IG337SearchCondImpl ig337Cond = new IG337SearchCondImpl();
							ig337Cond.setPrid(prid);
							ig337Cond.setPpstatus("W");
							ig337Cond.setPpproctimeIsNull("Y");
							List<IG337Info> ig337InfoList = ig337BL.getIG337Infos(ig337Cond);
							if(ig337InfoList == null || ig337InfoList.size()<1 
									|| StringUtils.isNotEmpty(ig337InfoList.get(0).getPpproctime())){
								continue;
							}
							/*IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
							ig256Cond.setPrid(prid);
							ig256Cond.setFlag("4");
							List<IG256Info> ig256InfoList = ig256BL.searchIG256(ig256Cond);
							if(ig256InfoList!=null && ig256InfoList.size()>0){
								continue;
							}*/
							String initTimeDate = ig337InfoList.get(0).getPpinittime();//���̵ķ�������ʱ��
							String currTimeDate = IGStringUtils.getCurrentDateTime();//ϵͳ��ǰʱ��
							Long nodifyMin = getWholeNodifyMinutes(ig335Info.getReportd(), ig335Info.getReporth(), ig335Info.getReportm());//��ȡ�������峬ʱ֪ͨ�������õĳ�ʱʱ��
							Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//��ȡ��ǰʱ���
							if(dMin > nodifyMin){//����ǰʱ�������������峬ʱ����ʱ��ʱ���ͳ�ʱ֪ͨ
								//��ʱ֪ͨ���ò���IG500���м�¼�ѷ��ͳ�ʱ����
								IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
								ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_OVERTIME);
								IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
								
								//��ѯ�Ƿ񷢹�������Ϣ
								IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
								ig256Cond.setPrid(info.getPrid());
								ig256Cond.setPrstatus(info.getPrstatus());
								ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);// ֪ͨ��ʶ ֵ�� 0:֪ͨ 1:��ʱ2:�����ϼ�
								List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
								//�ѷ��͹�����֪ͨ����Ҫ�ٴμ�����ϼ�����
								if(ig256Infos != null && ig256Infos.size() > 0){
									continue;
								}
								
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate);
							
								IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
								ig599Cond.setPrid(prid);//����ID
								ig599Cond.setPivarlabel("�¼�����");//������
								List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
								if(lst_ProcessInfo.isEmpty()) {
									throw new BLException("IGFLOW0000.E001", "�����¼�����");
								} else if(lst_ProcessInfo.size() > 1) {
									throw new BLException("IGFLOW0000.E002", "�����¼�����");
								} else{
									IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
									String grade = instance.getPivarvalue();
									if(type.indexOf(grade) == 4){
										grade = "��";
									}else if(type.indexOf(grade) == -1){
										
									}else{
										//��ʱ��ļ�������һ��
										grade = type.substring(type.indexOf(grade)+1, type.indexOf(grade)+2);
									}
									instance.setPivarvalue(grade);
									workFlowOperationBL.updateProcessInfo(instance);
								}
							}
						}
					}
				}
			}
		}
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
					User user = userBL.searchUserByKey("000117");
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
					sendSmsUserInfo.put("000117", new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
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
		saveRemindMessage(ig500Info.getPrid(), ig500Info.getPrpdid(),ig500Info.getPrstatus() , "000117", "�" , IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
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
	
	/**
	 * ��ȡ��������
	 * 
	 * @param message
	 * @param args
	 * @return
	 */
	private String getMessage(String message,List<String> args){
		if(args != null && args.size() > 0){
			for(int i = 0; i< args.size(); i++){
				message = StringUtils.replace(message, "{"+i+"}", args.get(i));
			}
		}
		return message;
	}
	/**
	 * ������
	 * 
	 * @param roleid
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessage(Integer roleid, String userid, String message,List<String> args) throws BLException{
		if (StringUtils.isEmpty(userid)) {
			sendMessageToRole(roleid, message, args);
		} else {
			sendMessageToUser(userid, message, args);
		}
	}
	
	/**
	 * ���û�������
	 * 
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessageToUser(String userid,String message,List<String> args) throws BLException{
		message = getMessage(message,args);
		sendMessageBL.sendSmsToUser(userid, message);
	}
	/**
	 * ����ɫ�������ֻ�������
	 * 
	 * @param roleid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessageToRole(Integer roleid, String message, List<String> args) throws BLException{
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);
		cond.setRolemanager(true);
		List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
		for(UserRoleInfo info: userRole){
			sendMessageToUser(info.getUserid(), message, args);
		}
	}
	/**
	 * ���ʼ�
	 * 
	 * @param roleid
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMail(String title,List<String> argsTitle,String content,List<String> argsContent,Integer roleid, String userid) throws BLException{
		if (StringUtils.isEmpty(userid)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			cond.setRoleid(roleid);
			cond.setRolemanager(true);
			List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
			for(UserRoleInfo info: userRole){
				sendMailToUser(title,argsTitle,content,argsContent,info.getUserid());
			}
		} else {
			sendMailToUser(title,argsTitle,content,argsContent,userid);
		}
	}
	
	/**
	 * ���û����ʼ�
	 * 
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMailToUser(String title,List<String> argsTitle,String content,List<String> argsContent, String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		if(StringUtils.isEmpty(user.getUseremail())){
			log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
			return;
		}
		title = getMessage(title,argsTitle);
		content = getMessage(content,argsContent);
		
		String[] address = new String[1];
		address[0] = user.getUseremail();
		sendMailBL.sendMail(title, content, address);
	}
	
	/**
	 * ������Ϣ����
	 * @param prid ����ID
	 * @param pdid ���̶���ID
	 * @param prstatus ����״̬
	 * @param ppuserid ������id
	 * @param ppusername ����������
	 * @param flag ���ѻ�ʱ���
	 * @throws BLException
	 */
	private void saveRemindMessage(Integer prid, String pdid, String prstatus, String ppuserid, String ppusername, String flag) throws BLException {
		IG256TB ig256tb = ig256BL.getIG256TBInstance();
		ig256tb.setFlag(flag);
		ig256tb.setPdid(pdid);
		ig256tb.setPrid(prid);
		ig256tb.setPpuserid(ppuserid);
		ig256tb.setPpusername(ppusername);
		ig256tb.setPrstatus(prstatus);
		ig256BL.registIG256(ig256tb);
	}
	
	
}
