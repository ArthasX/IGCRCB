/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status.job;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;
/***
 * ���ռƻ���ʱ����ָ�ɹ��� 
 * @time 2014/07/26
 * @author 
 * @email 
 * @version 1.0
 */
public class IGFXKRiskPlanJOB implements Job {
	
	/** ��ʼ����־*/
	private static Log log = LogFactory.getLog(IGFXKRiskPlanJOB.class);
	
	/**������ռƻ���ʱ���� ����*/
	public static final String JOB_NAME = "RISKPLAN_JOB";
	public static final String GROUP_NAME = "RISKPLAN_GROUP";
	public static final String TRIGGER_NAME = "RISKPLAN_TRIGGER";
	public static final String TRIGGERGROUP_NAME = "RISKPLAN_TRIGGERGROUP";
	public static final String RISKPLAN_CRON_EXPRESSION="0 */10 * * * ?";//�� �� ʱ �� �� ��
	
	/**
	 * ִ�����
	 */
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		log.debug("====================���ռƻ���ʱ����ʼ=========================");
		//ʱ���ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:ss");
		
		/** ��ȡ���̴���API */
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		/** ��ȡ���̲�ѯAPI */
		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
		
		//����������װ
		IG500SearchCondImpl cond_500 = new IG500SearchCondImpl();
		cond_500.setPrpdid(IGFXK03BLType.PROCESS_RISK_PDID);	//���ռ�¼��������ID
		cond_500.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_END_STATUS); //����״̬�����ڹر�
		
		//��ѯ����״̬���ǡ��رա��ķ��ռƻ�����
		List<IG500Info> lst_ProcessRecord = workFlowOperationBL.searchProcessRecord(cond_500);

//		String nowDate = IGStringUtils.getCurrentDate();
//		//��ѯ���ռƻ����췢�������
//		StringBuffer startTime = new StringBuffer();
//		startTime.append(nowDate).append(" 00:00");
//		List<ProcessRecordInfo> lst_process = new ArrayList<ProcessRecordInfo>();
//		try {
//			lst_process = flowSearchBL.searchProcessInfo(IGFXK03BLType.PROCESS_RISK_PDID, null, null);
//		} catch (BLException e) {
//			e.printStackTrace();
//			log.debug("���ռƻ����̲�ѯʧ��!");
//		}
		
		//�������̷���
		if(lst_ProcessRecord != null && lst_ProcessRecord.size() > 0){	//begin if1
			
			//�������з��ռƻ����̣���ȡ���ǡ������𡱺͡���ֹ��״̬�ķ��ռƻ�
			for (IG500Info processRecordInfo : lst_ProcessRecord) {	//begin for1
				//���ռƻ�δ�ر�ʱ����ѯ���ʽ����Ϣ
				if(!IGPRDCONSTANTS.PROCESS_TERMINATE.equals(processRecordInfo.getPrstatus())
						&& !IGPRDCONSTANTS.PROCESS_START_STATUS.equals(processRecordInfo.getPrstatus())){	//begin if2
					
					//��ȡ���ʽ����ѯBL
					IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
					
					//���ʽ����ѯʵ������
					IG898SearchCondImpl cond = new IG898SearchCondImpl();
					cond.setPrid(processRecordInfo.getPrid());	//������Ϣ����(prid)
					cond.setPidname(IGFXK03BLType.RISK_TABLE_NAME); //��ѯ�ı��ʽ������
					
					//��ѯָ��������Ϣ�еı��ʽ���������б���������Ϣ
					List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
					
					//�����кű�����ʽ����Ϣ
					Map<String, IG898Info> map_alue = new HashMap<String, IG898Info>();
					//������������������µ����б��ʽ����Ϣ
//					Map<String, List<Map<String, IG898Info>>> map_pvcolname = new HashMap<String,  List<Map<String,IG898Info>>>();
					Map<String, Map<String, IG898Info>> map_pvcolname = new HashMap<String,  Map<String,IG898Info>>();
					
					//��������������Ϣ���������������û�м�¼ֵ����ѯ��Ӧ�Ĺ�������ʱ��
					if(lst_ig898_job != null && lst_ig898_job.size() > 0){	//begin if3
						//��װ�����б��Ϻ�Map��Ϣ
						List<IG898Info> lst_job = new ArrayList<IG898Info>();
						//�������̵ı��ʽ��
						for (IG898Info ig898Info : lst_ig898_job) {
							
							//��װ���������ļ���
							if(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_JOB.equals(ig898Info.getPvcolname())){
								lst_job.add(ig898Info);
							}
							
							//�����ǰ������Map���м�¼���򽫼�¼�ı��ʽ����Ϣ��ӽ�Map�У������ǰ������Map��û�м�¼����ʼ��Map��Ϣ������¼�ı��ʽ����Ϣ��ӽ�Map��
							if(map_pvcolname.get(ig898Info.getPvcolname()) != null){
								map_pvcolname.get(ig898Info.getPvcolname()).put(ig898Info.getPvrownumber(), ig898Info);
							}else{
								//��ʼ��Map
								map_alue = new HashMap<String, IG898Info>();
								//�����кż�¼���ʽ����Ϣ
								map_alue.put(ig898Info.getPvrownumber(), ig898Info);
								//����������¼����Ϣ
								map_pvcolname.put(ig898Info.getPvcolname(), map_alue);
							}
						}
						
						//�������й���������Ϣ
						for (IG898Info ig898Info : lst_job) {	//begin for2
							//����������ֵΪ��ʱ���ж��Ƿ������ָ�ɹ���
							if(StringUtils.isEmpty(ig898Info.getPvalue())){	//begin if4
								
								//��¡"��������"��ʵ��
								IG898TB ig898TB = (IG898TB)SerializationUtils.clone(ig898Info);
								
								//�������ʱ����ڵ�ǰʱ�䣬����ָ�ɹ�������
								if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME) != null 
										&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME)
												.get(ig898Info.getPvrownumber()) != null){	//begin if5
									
									//��ȡ"��������ʱ��"
									String time_rem =  map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME)
															.get(ig898Info.getPvrownumber()).getPvalue();
									//��ȡ��ǰʱ��
									String nowTime = IGStringUtils.getCurrentDateTime();
									
									try {
										//�����������ʱ����ڵ�ǰʱ�䣬���ݸ�������Ϣ����ָ�ɹ���
										if(sdf.parse(time_rem).getTime() < sdf.parse(nowTime).getTime()){	//begin if5-1
											 
											//���ݸ�������Ϣ����ָ�ɹ���
											if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER) != null 
													&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER)
															.get(ig898Info.getPvrownumber()) != null){ //begin if5-2
												
												//��ȡ"������"��Ϣ
												String userid_username = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER)
																			.get(ig898Info.getPvrownumber()).getPvalue();
												//����ָ�ɹ���
												if(StringUtils.isNotEmpty(userid_username)){ //begin if5-3
													if(userid_username.split("_user_").length >= 3){ //begin if5-4
														try {
														
															/** 1����ȡָ�ɹ������������Ϣ */
															String title = "";//ָ�ɹ�������
															String desc = "";//ָ�ɹ�������
															String userid = "";//ָ�ɹ���������ID
															Integer roleid = 0;////ָ�ɹ��������û�ID
															//��ȡ"��������"
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME)
																			.get(ig898Info.getPvrownumber()) != null){
																title = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME)
																				.get(ig898Info.getPvrownumber()).getPvalue();
															}
															//��ȡ"����˵��"
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC)
																			.get(ig898Info.getPvrownumber()) != null){
																desc = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC)
																			.get(ig898Info.getPvrownumber()).getPvalue();
															}
															//��ȡ������ID(������ID)
															//��ȡ�����˽�ɫID(�����˽�ɫID)
															userid = userid_username.split("_user_")[0];
															roleid = Integer.valueOf(userid_username.split("_user_")[2]);
															
															/** 2�����÷��𷽷� */
															Integer procesInit = procesInit(userid,roleid, title, desc);
															
															/** 3�����¡�������������Ϣ */
															ig898TB.setPvalue(procesInit.toString());
															ig898BL.registIG898(ig898TB);
															
															/** 4�����¡�״̬�� */
															//�����Ի�ȡ��״̬����ʱ,���¸ñ���ֵΪ�������С�
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																	.get(ig898Info.getPvrownumber()) != null){
																
																//��ȡ״̬��Ϣ
																IG898TB ig898TB_status = 
																		(IG898TB)SerializationUtils.clone(map_pvcolname
																				.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																				.get(ig898Info.getPvrownumber()));
																ig898TB_status.setPvalue("������");
																//����״̬
																ig898BL.registIG898(ig898TB_status);
															}
														
														
														} catch (BLException e) {
															e.printStackTrace();
															log.debug("ָ�ɹ��������쳣!");
														}
														
													}//end if5-4
												}//end if5-3
											}//end if5-2
										}//end if5-1
									} catch (ParseException e) {
										e.printStackTrace();
										log.debug("ʱ���ʽת��ʧ��!");
									}
								}//end if5
							}//end if4
							else{
								
								try {
									//���ݡ���������������¼������ID����ѯ������ָ�ɹ���������Ϣ
									List<ProcessRecordInfo> pr_job = flowSearchBL.searchProcessInfo(Integer.valueOf(ig898Info.getPvalue()), "");
									
									//�������ָ�ɹ��������ѹرգ�����¡�״̬����Ϊ������ɡ�
									if(pr_job != null && pr_job.size() > 0){
										
										//ȡ�̹�����ָ�ɹ���������Ϣ
										ProcessRecordInfo pr = pr_job.get(0);
										//�ж�ָ�ɹ����Ƿ��ѹر�
										if(StringUtils.isNotEmpty(pr.getPrclosetime())){
											
											//����"״̬"
											if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS) != null 
													&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
															.get(ig898Info.getPvrownumber()) != null){
												//��ȡ״̬��Ϣ
												IG898TB ig898TB_status = 
														(IG898TB)SerializationUtils.clone(map_pvcolname
																.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																.get(ig898Info.getPvrownumber()).getPvalue());
												ig898TB_status.setPvalue("�����");
												//����״̬
												ig898BL.registIG898(ig898TB_status);
											}
										}
									}
									
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
									log.debug("����PRIDת��������ʧ��!");
								} catch (BLException e1) {
									e1.printStackTrace();
									log.debug("���¡�״̬����ʧ��!");
								}
								
							}
						}//end for2
					}//end if3
					
					//���µ�ǰ���̵Ĺ���������
					try {
						updateFinishByRiskRelatedProcess(processRecordInfo);
					} catch (Exception e) {
						e.printStackTrace();
						log.debug("���¡��ƻ�����������ʧ��!");
					}
				}//end if2
			}//end for1
		}//end if1
		
		log.debug("====================���ռƻ���ʱ�������=========================");
	}
	
	/**
	 * ָ�ɹ�������
	 * 
	 * @throws BLException
	 */
	private Integer procesInit(String crtuserid, Integer crtroleid, String title, String desc) throws BLException{
		/** ���̴�����API */
		FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
		WorkFlowLog wfLog = new WorkFlowLog();
		wfLog.setExecutorid(crtuserid);
		wfLog.setExecutorRoleid(crtroleid);
		wfLog.setComment("ָ�ɹ�������");
		ProcessRecord process_init = new ProcessRecord(wfLog);
		process_init.setCrtuserid(crtuserid);
		process_init.setDefid("01042");
		process_init.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		process_init.setRoleid(crtroleid);
		process_init.setTitle(title);
		process_init.setDescription(desc);
		Map<String, String> map_pivalue = new HashMap<String, String>();
		map_pivalue.put("�������ʱ��", "");
		map_pivalue.put("��������", "");
		map_pivalue.put("�����̶�", "");
		map_pivalue.put("Ӱ��̶�", "");
		map_pivalue.put("������", "");
		process_init.setFormvalue(map_pivalue);
		
		return flowOptBL.saveProcessAction(process_init);
	}

	/**
	 * ���ݹ���������Ϣ���¼ƻ�������
	 * 
	 * @param prid
	 * @throws Exception
	 */
	private void updateFinishByRiskRelatedProcess(IG500Info process) throws Exception {
		Integer prid = process.getPrid();
		/** ��ȡ���̲�ѯAPI */
		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
		/** ���̴�����API */
		FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
		 /** ��ȡ������BL */
	    IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		
		//�ж�����ID�Ƿ����
		if(prid != null){

			//��ȡ���ʽ����ѯBL
			IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
			IG898SearchCondImpl cond = new IG898SearchCondImpl();
			cond.setPrid(prid);
			//��ѯ����������Ϣ
			cond.setPidname("�����б�");
			List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
			
			//��¼������
			float finish = 0;
			
			//�������й���������Ϣ����ѯ����������
			if(lst_ig898_job != null && lst_ig898_job.size() > 0){
				int count = lst_ig898_job.size();
				int sum = 0;
				for (IG898Info ig898Info : lst_ig898_job) {
					if("��������".equals(ig898Info.getPvcolname()) && StringUtils.isNotEmpty(ig898Info.getPvalue())){
						//��ѯ������������Ϣ
						List<ProcessRecordInfo> searchProcessInfo = flowSearchBL.searchProcessInfo(Integer.valueOf(ig898Info.getPvalue()), "");
						//������������ѹرգ���Լ�¼�������̹رյı��������ۼ�
						if(searchProcessInfo != null && searchProcessInfo.size() > 0){
							ProcessRecordInfo processRecordInfo = searchProcessInfo.get(0);
							if(StringUtils.isNotEmpty(processRecordInfo.getPrclosetime())){
								sum ++;
							}
						}
					}
				}
				
				//����������
				finish = sum / count; 
			}
			//��ʽת��
		    Format format_float = new DecimalFormat("###.##");
		    String text = format_float.format(finish * 100) + "%";
		   
			//���±�������������������Ϣ
			List<IG599Info> lst_ig599 = ig599BL.searchIG599InfosByKey(prid);
			for (IG599Info ig599Info : lst_ig599) {
				if("����������".equals(ig599Info.getPivarname())){
					IG599TB ig599TB = (IG599TB)SerializationUtils.clone(ig599Info);
					ig599TB.setPivarvalue(text);
					ig599BL.saveIG599Info(ig599TB);
				}
			}
			
			//����������������Ϊ100%ʱ�����̹ر�
			if(finish == 1){
				//����ԾǨ
				flowOptBL.transitionProcess(prid, process.getPruserid(), "�ύ", IGStringUtils.getCurrentDateTime());
			}
		}
	}
}
