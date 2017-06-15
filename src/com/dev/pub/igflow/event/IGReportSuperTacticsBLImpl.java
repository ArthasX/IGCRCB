/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.pub.igflow.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;

/**
 * ���������̲����б����ϼ���ʵ��(ͨ�ø�����)
 * �������������̲����б����ϼ���ʵ��(ͨ�ø�����)
 * ������¼��2014/06/17
 * (1)�����ޱ���������Ӧ����
 * �޸ļ�¼��
 */
public class IGReportSuperTacticsBLImpl extends BaseBLImpl implements WorkFlowTacticsHandlerBL {

	static Log log = LogFactory.getLog(IGReportSuperTacticsBLImpl.class);
	
	/** ������������ */
	/** ����֪ͨ�������� */
	public String smsNotify;
	public String smsReport;
	public String mailTitleNotify;
	public String mailContentNotify;
	public String mailTitilReport;
	public String mailContectReport;
	
	/** ����BL */
	protected SendMessageBL sendMessageBL;
	
	/** �ʼ�BL */
	protected SendMailBL sendMailBL;
	
	/** �û�BL */
	protected UserBL userBL;

	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** ��������CodeDetailBL */
	protected CodeDetailBL codeDetailBL;
	
	/** �����ϼ�ָ����Ա��ѯBL */
	protected IG237BL processNoticeStrategyUserBL;
	
	/** ֪ͨ���Ի�����Ϣ��ѯBL */
	protected IG334BL ig334BL;
	
	/** ���̶���״̬��Ϣ��ѯBL */
	protected IG333BL ig333BL;
	
	/** ����ԾǨBL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ���ܲ�ѯBL */
	protected FlowSearchBL flowSearchBL;
	
	/** ���̲���ҵ���ѯBL */
	protected  IG256BL ig256BL;
	
	/**
	 * ����BL�趨
	 *
	 * @param sendMessageBL ����BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �ʼ�BL�趨
	 *
	 * @param sendMailBL �ʼ�BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
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
	 * ��������CodeDetailBL�趨
	 *
	 * @param codeDetailBL ��������CodeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
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
	 * ֪ͨ���Ի�����Ϣ��ѯBL�趨
	 *
	 * @param ig334BL ֪ͨ���Ի�����Ϣ��ѯBL
	 */
	public void setIg334BL(IG334BL ig334BL) {
		this.ig334BL = ig334BL;
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
	 * ����ԾǨBL�趨
	 *
	 * @param workFlowOperationBL ����ԾǨBL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ���ܲ�ѯBL�趨
	 *
	 * @param flowSearchBL ���ܲ�ѯBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
	 * ��ʼ�����
	 * 
	 * @param pdid
	 * @param psdid
	 * @throws BLException 
	 * @throws JobExecutionException 
	 * @throws JobExecutionException 
	 */
	public void initExecute(String pdid, String psdid) throws BLException{
		//�����ϼ�
		try {
			this.reportSuperior(pdid, psdid);
		} catch (JobExecutionException e) {
			e.printStackTrace();
			throw new BLException("���̱����ϼ�ʧ�ܣ�");
		}
		this.regulation(pdid, psdid);
	}
	
	/**
	 * �����ϼ���Ҫ�ķ���
	 * @throws JobExecutionException 
	 * @throws BLException 
	 */
	public void reportSuperior(String pdid, String psdid) throws JobExecutionException, BLException{
		//û����������IDʱ��������ϼ�����
		if(StringUtils.isEmpty(pdid)){
			log.debug("��������IDΪ����Ϊ�ա�");
			return;
		}
		
		//�����ϼ�ʱ���趨
		Integer reportd = 0;//��
		Integer reporth = 0;//Сʱ
		Integer reportm = 0;//��
		
		//���̲����趨��Ϣ��ѯ����ʵ����
		IG334SearchCondImpl condIg334 = new IG334SearchCondImpl();
		//���̲����趨��Ϣ��ѯ
		condIg334.setPdid_like(pdid);
		List<IG334VWInfo> lstTactics = this.ig334BL.findByCondTactics(condIg334);
		
		//û�����̲����趨��Ϣʱ��������ϼ�����
		if(lstTactics == null || lstTactics.size() <= 0){
			log.debug("��������IDΪ��"+pdid +"��������û������֪ͨ�������á�");
			return;
		}
			
		//����pidid�Ǳ���ص��ж�
		String pidid = lstTactics.get(0).getPidid();		
		//������
		String pidname = lstTactics.get(0).getPidname();
		
		//��װ���̲�����Ϣ
		Map<String, Map<String, IG334VWInfo>> map = new LinkedHashMap<String, Map<String,IG334VWInfo>>();
		for (IG334VWInfo info : lstTactics) {
			if(map.get(info.getPsdcode()) != null){
				if(map.get(info.getPsdcode()).get(info.getPivalue()) == null){
					map.get(info.getPsdcode()).put(info.getPivalue(), info);
				}
			} else{
				Map<String, IG334VWInfo> mapIg334 = new LinkedHashMap<String, IG334VWInfo>();
				mapIg334.put(info.getPivalue(), info);
				map.put(info.getPsdcode(), mapIg334);
			}
		}
		
		//������������ID��ѯ����δ�رյ�����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		cond.setPrpdid(pdid);
		
		//����״̬��Ϣ
		if(StringUtils.isNotEmpty(psdid)){
			IG333Info ig333Info = this.ig333BL.searchIG333InfoByKey(psdid);
			cond.setPrstatus(ig333Info.getPsdcode());
		}
		
		//��ѯ������Ϣ
		List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
		
		//û��δ�ر����̲�������ϼ�����
		if(lstIG500Info != null && lstIG500Info.size() > 0){
			//��ǰ����ָ������ֵ
			String pivalue = "";
			for (IG500Info info : lstIG500Info) {
				if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
					//֪ͨ��������޹�
					pivalue = IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE;
				} else {
					pivalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), pidname);
					pivalue = StringUtils.isEmpty(pivalue) ? "#" : pivalue;					
				}
				//��ȡ��ǰ״̬�Ĳ����趨��Ϣ
				if(map.get(info.getPrstatus()) == null ){
					log.debug("���̡�"+info.getPrtitle() +"���еĶ�Ӧ״̬��ʶΪ��"+info.getPrstatus()+"����״̬û�б����ϼ����̲��Ե����á�");
					continue;
				}
				
				//��ȡָ��״̬��ָ����ֵ��Ӧ�Ĳ����趨��Ϣ
				IG334VWInfo tactics = map.get(info.getPrstatus()).get(pivalue);
				
				//��ǰ״ָ̬����ֵ��Ӧ�����̲��Բ�����ʱ������һ��ѭ��
				if(tactics == null){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//֪ͨ��������޹�
						log.debug("���̡�"+info.getPrtitle() +"����û�б����ϼ������á�");
					} else {
						log.debug("���̡�"+info.getPrtitle() +"���еĶ�Ӧ��"+pidname+"���С�"+ ("#".equals(pivalue) ? "ȱʡ" :pivalue)+"��û�б����ϼ������á�");
					}
					continue;
				}
				reportd = tactics.getReportd();//��
				reporth = tactics.getReporth();//Сʱ
				reportm = tactics.getReportm();//��
				//û���趨�ٴ�֪ͨʱ��ʱ������һ��ѭ��
				if((reportd == null || reportd == 0) 
						&& (reporth == null || reporth == 0) 
						&& (reportm == null || reportm == 0)){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//֪ͨ��������޹�
						log.debug("���̡�"+info.getPrtitle() +"���е�״̬��"+ tactics.getPsdname()+"��û�����ñ����ϼ����ʱ�䡣");
					} else {
						log.debug("���̡�"+info.getPrtitle() +"���е�״̬��"+ tactics.getPsdname()+"����Ӧ��"+pidname+"���С�"+("#".equals(pivalue) ? "ȱʡ" :pivalue)+"��û�����ñ����ϼ����ʱ�䡣");
					}
					continue;
				}
				
				//��ѯ�Ƿ񷢹�������Ϣ
				IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(info.getPrid());
				ig256Cond.setPrstatus(info.getPrstatus());
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_SEND_MANAGER);// ֪ͨ��ʶ ֵ�� 0:֪ͨ 1:��ʱ2:�����ϼ�
				List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
				//�ѷ��͹�����֪ͨ����Ҫ�ٴμ�����ϼ�����
				if(ig256Infos != null && ig256Infos.size() > 0){
					continue;
				}
				
				//�Ƿ��͹������ϼ���ʶ
				boolean sendflag = false;
				
				//��ȡ�ϱ���Ϣģ��
				getSendMessage();
				
				//������Ϣ����
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));//���̹�����
				args.add(String.valueOf(info.getPrtitle()));//��������
				args.add(String.valueOf(tactics.getPsdname()));//����״̬
				args.add(getReportTime(reportd, reporth, reportm));//�����ϼ�ʱ��
				
				
				//��ѯ������Ա
				//��������״̬������ID��ȡ��״̬�µĲ�������Ϣ
				List<Integer> lstRoleid = new ArrayList<Integer>();
				List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(info.getPrid(), info.getPrstatus());
				if(ig337Infos.size() == 0 || !getNotifyTime(reportd, reporth, reportm, ig337Infos.get(0).getPpinittime())){
					continue;
				}
				
				//�ϱ�����ɫ������
				if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_ROLEMANAGER.equals(tactics.getRolemanager())){
					//�������˷��Ͷ���
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(tactics.getSms())){
						for (IG337Info info337 : ig337Infos) {
							//ͬһ��ɫ����Ҫ���������ظ����Ͷ���
							if(!lstRoleid.contains(info337.getPproleid())){
								lstRoleid.add(info337.getPproleid());
								args.add(getCurrentPersonOrRoleName(tactics,info337));
								//�ϱ�����ɫ������
								sendMessage(info337.getPproleid(),null,smsReport,args);
							}
							
						}
						sendflag = true;
					}
					//�������˷����ʼ�
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(tactics.getEmail())){
						for (IG337Info info337 : ig337Infos) {
							//ͬһ��ɫ����Ҫ���������ظ����Ͷ���
							if(!lstRoleid.contains(info337.getPproleid())){
								lstRoleid.add(info337.getPproleid());
								args.add(getCurrentPersonOrRoleName(tactics,info337));
								//�ϱ�����ɫ������
								sendMail(mailTitilReport,args,mailContectReport,args,info337.getPproleid(),null);
							}
							
						}
						sendflag = true;
					}
					
				//�ϱ���ָ����ѡ
				} else if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_USER.equalsIgnoreCase(tactics.getRolemanager())){
					//��ָ����ѡ���Ͷ���
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(tactics.getSms())){
						//�ϱ���ָ����ѡ
						IG237SearchCondImpl cond237 = new IG237SearchCondImpl();
						cond237.setPsdid(tactics.getPsdid());
						cond237.setPsdconfirm(tactics.getPsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond237);
						if(userInfoList!=null && userInfoList.size()>0){
						    //��װ���д�����
						    StringBuffer ppusname = new StringBuffer();
						    ppusname.append("��Ϊ��");
						    for (int i = 0; i < ig337Infos.size(); i ++) {
						        ppusname.append(ig337Infos.get(i).getPpusername());
						        if(i < ig337Infos.size() - 1){
						            ppusname.append(" , ");
						        }
						    }
						    ppusname.append("��");
						    args.add(ppusname.toString());
						    
							for(IG237Info userInfo : userInfoList){
								sendMessage(null,userInfo.getUserid(),smsReport,args);
							}
						}
						sendflag = true;
					}
					//��ָ����ѡ�����ʼ�
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(tactics.getEmail())){
						IG237SearchCondImpl cond237 = new IG237SearchCondImpl();
						cond237.setPsdid(tactics.getPsdid());
						cond237.setPsdconfirm(tactics.getPsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond237);
						if(userInfoList!=null && userInfoList.size()>0){
						  //��װ���д�����
                            StringBuffer ppusname = new StringBuffer();
                            ppusname.append("��Ϊ��");
                            for (int i = 0; i < ig337Infos.size(); i ++) {
                                ppusname.append(ig337Infos.get(i).getPpusername());
                                if(i < ig337Infos.size() - 1){
                                    ppusname.append(" , ");
                                }
                            }
                            ppusname.append("��");
                            args.add(ppusname.toString());
                            
							for(IG237Info userInfo : userInfoList){
								sendMail(mailTitilReport,args,mailContectReport,args,null,userInfo.getUserid());
							}
						}
						sendflag = true;
					}
				}
				
				//��¼����ʱ�����ѵ�
				if(sendflag){
					saveRemindMessage(info.getPrid(), pdid, info.getPrstatus(), null, null, IGPRDCONSTANTS.PROCESS_STATUS_SEND_MANAGER);
				}
			}//end for
		}//end if
	}
	
	/**
	 * ����״̬�����ж�
	 * 
	 * @param pdid 
	 * @throws BLException
	 */
	public void regulation(String pdid, String psdid) throws BLException {}
	
	/**
	 * ����״̬���Դ����Ķ����¼�
	 * 
	 * @param ig334VWInfo 
	 * @param action_flag ������ʶ(true:����ʱ��false:��������)
	 * @throws BLException
	 */
	public void event(IG334VWInfo ig334VWInfo, IG500Info info, Integer begintime, boolean action_flag) throws BLException {
		/**
		 * 1����ѯ�Ƿ񷢹����ѻ�����
		 * 2�����ݶ�����ʶ����ǳ�ʱ���ҷ������������״̬Ϊ�ѳ�ʱ
		 * 3��δ�����������ȷ������ڼ�¼��ʱ����������²����ڣ�
		 * 4�����ݶ�����ʶ��������ѣ��ҷ������������κβ���
		 * 5��δ�����������ѯ��״̬�µ����в����ˣ�����������Ϣ
		 */
		//��ȡ����ID
		Integer prid = info.getPrid();
		//��ȡ���̵�ǰ״̬
		String prstatus = info.getPrstatus();
		
		//��ʱ����ʱ���趨
		Integer notifyd = ig334VWInfo.getNotifyd();//��
		Integer notifyh = ig334VWInfo.getNotifyh();//Сʱ
		Integer notifym = ig334VWInfo.getNotifym();//��
		
		//û���趨�ٴ�֪ͨʱ��
		if((notifyd == null || notifyd == 0) 
				&& (notifyh == null || notifyh == 0) 
				&& (notifym == null || notifym == 0)){
			log.debug(ig334VWInfo.getPsdname()+"״̬û�����ó�ʱ���Ѽ��ʱ��");
			return;
		}
		
		//��ȡ�ϱ���Ϣģ��
		getSendMessage();
		if(begintime != null && begintime > 0){
			smsNotify = "�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬���ڡ�{3}���ڳ�ʱ��������ʱ����";
			mailTitleNotify = "�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬���ڡ�{3}���ڳ�ʱ��������ʱ����";
			mailContentNotify = "�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬���ڡ�{3}���ڳ�ʱ��������ʱ����";
		}
		
		//������Ϣ����
		List<String> args = new ArrayList<String>();
		args.add(String.valueOf(info.getPrserialnum()));
		args.add(String.valueOf(info.getPrtitle()));
		args.add(String.valueOf(ig334VWInfo.getPsdname()));
		if(begintime != null && begintime > 0){
			args.add(begintime+"����");
		} else{
			Integer finishtime = 0;
			if(notifyd != null && notifyd > 0){
				finishtime += notifyd * 24 * 60;
			}
			if(notifyh != null && notifyh > 0){
				finishtime += notifyh * 60;
			}
			if(notifym != null && notifym > 0){
				finishtime += notifym;
			}
			args.add(finishtime+"����");
		}
		
		//��ѯ�Ƿ񷢹�������Ϣ
		IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
		ig256Cond.setPrid(prid);
		ig256Cond.setPrstatus(prstatus);
		ig256Cond.setFlag_in(new String[]{IGPRDCONSTANTS.PROCESS_STATUS_SEND,IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME});// ֪ͨ��ʶ ֵ�� 0:֪ͨ 1:��ʱ
		List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
		//�ѷ���������Ϣ
		if(!ig256Infos.isEmpty()){
			//�ж��Ƿ��ǳ�ʱ����
			if(action_flag){
				//��ʱ����flagֵΪ1
				for (IG256Info ig256Info : ig256Infos) {
					IG256TB ig256tb = (IG256TB)SerializationUtils.clone(ig256Info);
					ig256tb.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					ig256BL.updateIG256(ig256tb);
				}
				//��ѯ�Ƿ��¼��״̬��ʱ��Ϣ
				ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(prid);
				ig256Cond.setPrstatus(prstatus);
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
				ig256Infos = ig256BL.searchIG256(ig256Cond);
				//û�����¼����״̬��ʱ��Ϣ
				if(ig256Infos.isEmpty()) {
					//��¼����״̬��ʱ��Ϣ
					saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, null, ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
				}
			}
		//δ����������Ϣ
		} else{
			//��ָ����ɫ���Ͷ���
			if(ig334VWInfo.getRoleid() != null && ig334VWInfo.getRoleid() > 0){
				UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
				urcond.setRoleid(ig334VWInfo.getRoleid());
				List<UserRole> searchUserRole = userRoleBL.searchUserRole(urcond);
				if(searchUserRole != null && searchUserRole.size() > 0){
					for(UserRole userRole : searchUserRole) {
						//���ݲ��Է���֪ͨ
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())){//�ʼ�֪ͨ
							sendMail(mailTitleNotify, args, mailContentNotify, args, null, userRole.getUserid());
							
						}
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){//����֪ͨ
							sendMessage(null, userRole.getUserid(), smsNotify, args);
						}
						//�ж϶�����ʶ
						if(action_flag) {
							//��¼������ϢΪ��ʱ
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRole.getUserid(), ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
						} else{
							//��¼������ϢΪ����
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRole.getUserid(), ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
						}
					}
				}
			}
			
			//��������״̬������ID��ȡ��״̬�µĲ�������Ϣ
			List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(prid, prstatus);
			for(int i = 0; i < ig337Infos.size(); i++) {
				//���������ָ������ɫ ͨ����ɫid��ȡ��ɫ�������˷�֪ͨ
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
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())){//�ʼ�֪ͨ
							sendMail(mailTitleNotify, args, mailContentNotify, args, null, userRoleInfos.get(j).getUserid());
							
						}
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){//����֪ͨ
							sendMessage(null, userRoleInfos.get(j).getUserid(), smsNotify,args);
						}
						//�ж϶�����ʶ
						if(action_flag) {
							//��¼������ϢΪ��ʱ
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRoleInfos.get(j).getUserid(), userRoleInfos.get(j).getUsername(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
						} else{
							//��¼������ϢΪ����
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRoleInfos.get(j).getUserid(), userRoleInfos.get(j).getUsername(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
						}
					}
				//ָ������ֱ�ӷ�֪ͨ
				} else{
					//�ʼ�֪ͨ
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())) {
						sendMail(mailTitleNotify,args,mailContentNotify,args,null,ig337Infos.get(i).getPpuserid());
					}
					//����֪ͨ
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){
						sendMessage(null,ig337Infos.get(i).getPpuserid(),smsNotify,args);
					}
					//�ж϶�����ʶ
					if(action_flag) {
						//��¼������ϢΪ��ʱ
						saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, ig337Infos.get(i).getPpuserid(), ig337Infos.get(i).getPpusername(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					} else{
						//��¼������ϢΪ����
						saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, ig337Infos.get(i).getPpuserid(), ig337Infos.get(i).getPpusername(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
					}
				}//end if
			}//end for
			//��¼����״̬��ʱ��Ϣ
			if(action_flag) {
				saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, null, ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
			}
		}//end if
	}
	
	/**
	 * �Ƚ�״̬��Ӳ�����ʱ���ʱ��
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private boolean getNotifyTime(Integer timed, Integer timeh,Integer timem,String ppinittime){
		long timeNumber = 0; 
		long mins = 60L * 1000L;
		//��
		if(timed != null && timed > 0){
			timeNumber = timed * 24 * 60;
		}
		//Сʱ
		if(timeh != null && timeh > 0  && timeNumber == 0){
			timeNumber = timeh * 60;
		}
		//����
		if(timem != null && timem > 0  && timeNumber == 0){
			timeNumber = timem;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = null;
		try {
			d1 = df.parse(ppinittime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d2 = new Date();
		return ((d2.getTime() - d1.getTime()) / mins - timeNumber ) > 0;
	}
	
	/**
	 * ��ȡ��֪ͨ��ָ����Ա���ǽ�ɫ������
	 * @param info
	 * @return
	 */
	private String getCurrentPersonOrRoleName(IG334VWInfo info,IG337Info info337){
		if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_ROLEMANAGER.equals(info.getRolemanager())){
			return "��ɫΪ��"+info337.getPprolename()+"��";
		}else{
			return "��Ϊ��"+info337.getPpusername()+"��";
		}
	}
	
	/**
	 * ȡ��֪ͨ��Ϣ�е�ʱ�����
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private String getReportTime(Integer timed, Integer timeh,Integer timem){	
		//��
		if(timed != null && timed > 0){
			return timed+"��";
		}
		//Сʱ
		if(timeh != null && timeh > 0){
			return timeh+"Сʱ";
		}
		//����
		if(timem != null && timem > 0){
			return timem+"����";
		}
		return "";
	}
	
	/**
	 * �����Ϣ��ʾģ��
	 */
	public void getSendMessage(){
		CodeDetailSearchCondImpl codecond = new CodeDetailSearchCondImpl();
		codecond.setCcid("156");
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(codecond, 2);//������
		for(CodeDetail detail : codeDetailList){
			//����֪ͨ��������
			if("3".equalsIgnoreCase(detail.getCid())){
				smsNotify = detail.getCvalue();
			}
			//�����ϱ���������
			if("4".equalsIgnoreCase(detail.getCid())){
				smsReport = detail.getCvalue();
			}
			//�ʼ�֪ͨ���ѱ���
			if("5".equalsIgnoreCase(detail.getCid())){
				mailTitleNotify = detail.getCvalue();
			}
			//�ʼ�֪ͨ��������
			if("6".equalsIgnoreCase(detail.getCid())){
				mailContentNotify = detail.getCvalue();
			}
			//�ʼ��ϱ����ѱ���
			if("7".equalsIgnoreCase(detail.getCid())){
				mailTitilReport = detail.getCvalue();
			}
			//�ʼ��ϱ���������
			if("8".equalsIgnoreCase(detail.getCid())){
				mailContectReport = detail.getCvalue();
			}
		}
		smsNotify = StringUtils.isEmpty(smsNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ���":smsNotify;
		smsReport = StringUtils.isEmpty(smsReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ�����ǰ����{4},���ע��":smsReport;
		
		mailTitleNotify = StringUtils.isEmpty(mailTitleNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ���":mailTitleNotify;
		mailContentNotify = StringUtils.isEmpty(mailContentNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ���":mailContentNotify;
		mailTitilReport = StringUtils.isEmpty(mailTitilReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ�����ǰ����{4}�����ע��":mailTitilReport;
		mailContectReport = StringUtils.isEmpty(mailContectReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}��������ͣ�ڡ�{2}��״̬����״̬δ�ڡ�{3}���ڴ�����ǰ����{4}�����ע��":mailContectReport;
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