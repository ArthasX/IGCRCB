/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.eventProcess.bl;

import java.util.Date;
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
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������ͬ�����BLʵ��
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public class EVEProBLImpl extends BaseBLImpl implements EVEProBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(EVEProBLImpl.class);
	
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
	
	/** ���̲����û���Ϣҵ��BL */
	protected IG337BL ig337BL;
	
	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** ����̨��ɫid*/
	protected static final Integer SERVER_ROLEID = 1205;
	
	/** �Ƽ��ܾ����ɫid*/
	protected static final Integer MANAGER_ROLEID = 1221;
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
	 * ���̲����û���Ϣҵ��BL
	 * @param ig337bl ���̲����û���Ϣҵ��
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	/**
	 * �¼����̳�ʱ����ͬ��
	 * @throws BLException
	 */
	public void dataSynchronism() throws BLException{
		log.debug("=========�¼����̳�ʱ����ͬ��=========");
		this.regulation("01080");
    	log.debug("=========�¼����̳�ʱ����ͬ��=========");
    }
	
	/**
	 * ����״̬�����жϵĹ�����¼�
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	public void regulation(String pdid) throws BLException{
		String type = "�������";
		String flag = "";
		//û����������IDʱ��������ϼ�����
		if(StringUtils.isEmpty(pdid)){
			log.debug("��������IDΪ����Ϊ�ա�");
			return;
		}else{
			IG380SearchCondImpl ig380Cond = new IG380SearchCondImpl();
			ig380Cond.setPdid_like(pdid);
			//�����������Ͳ�ѯ������������
			List<IG380Info> ig380InfoList = ig380BL.searchIG380Info(ig380Cond);
			if(ig380InfoList == null || ig380InfoList.size()==0){
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
				//��ѯ�Ƿ񷢹�������Ϣ
				IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(info.getPrid());
				ig256Cond.setPrstatus(info.getPrstatus());
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);// ֪ͨ��ʶ ֵ�� 0:֪ͨ 1:��ʱ2:�����ϼ�
				List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
				//�ѷ��͹�����֪ͨ����Ҫ�ٴμ�����ϼ����ԣ��ѷ��Ͷ��Ÿ��Ƽ��ܾ���ͷ���̨��
				if(ig256Infos != null && ig256Infos.size() > 0){
					continue;
				}
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
				IG599SearchCondImpl picond = new IG599SearchCondImpl();
				picond.setPrid(info.getPrid());//����ID
				List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(picond);
				Map<String, String> piMap = new HashMap<String, String>();
				for(IG599Info pi:piList){
					piMap.put(pi.getPivarname(), pi.getPivarvalue());
				}
				String reason = piMap.get("���׹���/�ж�");
				if(StringUtils.isBlank(reason)){
					continue;
				}
				String initTimeDate = ig337InfoList.get(0).getPpinittime();//���̵ķ�������ʱ��
				String currTimeDate = IGStringUtils.getCurrentDateTime();//ϵͳ��ǰʱ��
				String grade = piMap.get("�¼�����");
				String eventtype = piMap.get("�¼���Դ");
				Integer reportd = 0;
				Integer reporth = 0;
				Integer reportm = 0;
				//��ѯ�Ƿ񷢹�������Ϣ
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_SEND);// ֪ͨ��ʶ ֵ�� 0:֪ͨ 1:��ʱ2:�����ϼ�
				List<IG256Info>	ig256Infos2 = ig256BL.searchIG256(ig256Cond);
				//��ͨ�¼���ʱ���A���¼����ﴦ��ڵ㣩��5�����ڴ�����δȷ���¼����ط����Ѷ��š�
				//�澯�¼���ʱ���A���¼����ﴦ��ڵ㣩��2�����ڴ�����δȷ���¼����ط����Ѷ��š� 
				//���¼�Ϊ�澯ʱ�䲢��û�з����ط����Ѷ���(��һ���ط�����)
				if(ig256Infos2 ==null || ig256Infos2.size() < 1){
					IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
					cond337.setPpbacktime_isNull("1");
					cond337.setPpstatus("W");
					cond337.setPpproctimeIsNull("Y");
					cond337.setPrid(prid);
					List<IG337Info> info337 = ig337BL.getIG337Infos(cond337);
					if(info337 != null){
						if("��ظ澯".equals(eventtype)){
							reportm = 2;
							//����Ǽ�ظ澯��ֻ������һ������
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							
						}else{
							reportm = 5;
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
						}
					}else{
						if("��ظ澯".equals(eventtype)){
							//����Ǽ�ظ澯��ֻ������һ������
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							//����Ǽ�ظ澯�������4
							saveRemindMessageAndDate(info.getPrid(),
									info.getPrpdid(),info.getPrstatus() , 
									"000000", "000000" , 
									IGPRDCONSTANTS.PROCESS_STATUS_FLAG,
									CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
						}else{
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							//���¼��Ѿ�ȷ�����
							saveRemindMessageAndDate(info.getPrid(),
									info.getPrpdid(),info.getPrstatus() , 
									"000000", "000000" , 
									flag,
									CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
						}
						continue;
					}
				}else if(ig256Infos2!=null && ig256Infos2.size() > 0){
					//
					if("��ظ澯".equals(eventtype)){
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
					if(StringUtils.isBlank(grade)){
						//����Ϣ������
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
					if(type.indexOf(grade) == 2){
						//���¼�Ĭ�϶����ַ����10����
						reportm = 10;
						flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
					}else if(type.indexOf(grade) == 3){
						//�����¼�
						if(StringUtils.isNotBlank(reason)){
							if(reason.equals("����")){
								//���������¼������ַ�����Ϊ1Сʱ
								reporth = 1;
								flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
							}else if(reason.equals("�ж�")){
								//�����ж��¼������ַ�����Ϊ30����
								reportm = 30;
								flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
							}
						}else{
							//û����д���׹���/�жϱ�
							for(IG256Info ig256info :ig256Infos2){
								((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
								ig256BL.registIG256(ig256info);
							}
							continue;
						}
					}else{
						//���Ǣ󼶺͢���
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
				}
				Long nodifyMin = getWholeNodifyMinutes(reportd, reporth, reportm);//��ȡ�������峬ʱ֪ͨ�������õĳ�ʱʱ��
				Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//��ȡ��ǰʱ���
				if(dMin >= nodifyMin){//����ǰʱ�������������峬ʱ����ʱ��ʱ���ͳ�ʱ֪ͨ
					//��ʱ֪ͨ���ò���IG500���м�¼�ѷ��ͳ�ʱ����
					IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
					ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
					
					//����ǵ�һ�α������������еĲ����˷��Ͷ�������
					if( IGPRDCONSTANTS.PROCESS_STATUS_SEND.equals(flag)){
						if("��ظ澯".equals(eventtype)){
							for(IG337Info ig337info : ig337InfoList){
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate,ig337info.getPpuserid(),IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							}
						}else{
							for(IG337Info ig337info : ig337InfoList){
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate,ig337info.getPpuserid(),IGPRDCONSTANTS.PROCESS_STATUS_SEND);
							}
						}
						
					}else if(IGPRDCONSTANTS.PROCESS_STATUS_FLAG.equals(flag)){
						//��ѯ�Ƽ��ܾ���
						UserRoleVWSearchCondImpl userRoleVWSearchCondImpl = new UserRoleVWSearchCondImpl();
						userRoleVWSearchCondImpl.setRoleid(MANAGER_ROLEID);
						List<UserRoleInfo> userRoleManager = userRoleBL.searchUserRoleVW(userRoleVWSearchCondImpl);
						if(userRoleManager!=null && userRoleManager.size()>0){
							for(UserRoleInfo userRoleInfo : userRoleManager){
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate,userRoleInfo.getUserid(),flag);
							}
						}
						//��ѯ����̨
						UserRoleVWSearchCondImpl userRoleVWSearchCondServer = new UserRoleVWSearchCondImpl();
						userRoleVWSearchCondServer.setRoleid(SERVER_ROLEID);
						List<UserRoleInfo> userRoleServer = userRoleBL.searchUserRoleVW(userRoleVWSearchCondServer);
						if(userRoleServer!=null && userRoleServer.size()>0){
							for(UserRoleInfo userRoleInfo : userRoleServer){
								//���ͳ�ʱ֪ͨ��Ϣ
								this.processSend(ig334Info, ig500Info, currTimeDate,userRoleInfo.getUserid(),flag);
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
	public void processSend(IG334Info info, IG500Info ig500Info, String now,String reportUserid,String process_status) throws BLException{
		/**
		 * �������̲�ѯ��ǰ������ �����Ͷ��Ż��ʼ�����Ա���ɫ
		 */
		//����userid��ѯuser
		User reportUser = userBL.searchUserByKey(reportUserid);
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
		
		//�ʼ�֪ͨ
		if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())) {
			
			if(StringUtils.isEmpty(reportUser.getUseremail())){
				log.debug("�û�"+reportUser.getUserid()+"û���������䣡�޷������ʼ�");
				return;
			}
			String[] address = new String[1];
			address[0] = reportUser.getUseremail();
			//��ŷ����û���Ϣ
			sendMailUserInfo.put(reportUser.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//					sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
		}
		//����֪ͨ
		if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
			//��ŷ����û���Ϣ
			sendSmsUserInfo.put(reportUser.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//					sendMessageBL.sendSmsToUser(ig337Infos.get(i).getPpuserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
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
		saveRemindMessageAndDate(ig500Info.getPrid(),
						ig500Info.getPrpdid(),ig500Info.getPrstatus() , 
						reportUser.getUserid(), reportUser.getUsername() , 
						process_status ,
						CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
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
	 * ������Ϣ����
	 * @param prid ����ID
	 * @param pdid ���̶���ID
	 * @param prstatus ����״̬
	 * @param ppuserid ������id
	 * @param ppusername ����������
	 * @param flag ���ѻ�ʱ���
	 * @param date �����ŵ�ʱ��
	 * @throws BLException
	 */
	private void saveRemindMessageAndDate(Integer prid, String pdid, String prstatus, String ppuserid, String ppusername, String flag,String date) throws BLException {
		IG256TB ig256tb = ig256BL.getIG256TBInstance();
		ig256tb.setFlag(flag);
		ig256tb.setPdid(pdid);
		ig256tb.setPrid(prid);
		ig256tb.setPpuserid(ppuserid);
		ig256tb.setPpusername(ppusername);
		ig256tb.setPrstatus(prstatus);
		ig256tb.setFingerPrint(date);
		ig256BL.registIG256(ig256tb);
	}
	
}
