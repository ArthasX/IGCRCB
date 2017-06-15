package com.deliverik.infogovernor.drm.igflow.button;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.google.gson.Gson;

/**
 * <p>
 * �����޶� ������ڵ㣨��һҳ���������һ������ť�¼�
 * �����޶��ĳ�����������
 * 
 * </p>
 */
public class IGDRMBTN0103BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0103BLImpl.class);
	
    /** ��ѯ�๦��API�� */
	protected FlowSearchBL flowSearchBL;
    
   	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**��ɫ��Ϣҵ��BL*/
	protected UserBL userBL;
	
	/**���̲�����Ա*/
	protected IG484BL ig484BL;
	
	 /**��Ϣ����BL*/
	protected MessagePushBL messagePushBL;
	
	/** ����״̬��־��Ϣ����*/
	protected IG224BL ig224BL;
	
	/**������־*/
	protected EmergencyLogBL emergencyLogBL;
	
	/**���̲�����Ա*/
	protected IG483BL ig483BL;
	
	/**
	 * @param ig483bl the ig483BL to set
	 */
	public void setIg483BL(IG483BL ig483bl) {
		ig483BL = ig483bl;
	}

	/**
	 * @param emergencyLogBL the emergencyLogBL to set
	 */
	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	/**
	 * @param ig224bl the ig224BL to set
	 */
	public void setIg224BL(IG224BL ig224bl) {
		ig224BL = ig224bl;
	}

	/**
	 * @param flowSearchBL the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * @param userBL the userBL to set
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * @param ig484bl the ig484BL to set
	 */
	public void setIg484BL(IG484BL ig484bl) {
		ig484BL = ig484bl;
	}

	/**
	 * @param messagePushBL the messagePushBL to set
	 */
	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}
	
	/**
	 * �����޶�������ڵ㣨��һҳ���������һ������ť�¼�
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========Ԥ����������𱣴水ť����ʼ========");
		Gson gson = new Gson();
		WorkFlowLogInfo logoInfo = bean.getLogInfo();
		Integer curPrid = logoInfo.getPrid();
		Integer pgrid = null;
		String psdid = bean.getBfstatus();
		//��ǰʱ��
		String datetime = IGStringUtils.getCurrentDateTime();
		//������Ϣר��prid
		Integer sendMsgPrid = ig484BL.searchIG484PgridByPrid(curPrid);
		if(null == sendMsgPrid){
			sendMsgPrid = curPrid;
		}else{
			//�õ�һ����ʵ������ϳ����ڵ�ʵ��
			pgrid = sendMsgPrid;
		}
		//pgrid��Ϊ�� ������ʵ�����������鷢�������
		if(null!=pgrid){
			IG484SearchCondImpl ig484Cond = new IG484SearchCondImpl();
			ig484Cond.setPgrid(pgrid);
			List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484Cond);
			for(IG484Info info:ig484Lst){
				//������������ֹ����
				this.terminate(logoInfo,info.getPrid(),sendMsgPrid);
			}
			//����������ر�ʱ�� Ϊ�ѹر�
			IG483Info ig483Info = ig483BL.searchIG483ByPK(pgrid);
			IG483TB ig483TB = (IG483TB) SerializationUtils.clone(ig483Info);
			ig483TB.setPgrclosetime(IGStringUtils.getCurrentDateTime());
			ig483BL.updateIG483(ig483TB);
		}else{
			//��һ����
			//������ֹ����
			this.terminate(logoInfo,curPrid,sendMsgPrid);
		}
		//��ǰ��������ʵ����Ϣ
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(curPrid);
		ProcessStatusInfo psInfo = flowSearchBL.searchProcessStatus(psdid);
		ProcessStatusInfo ppsInfo = null;
		if(StringUtils.isNotBlank(psInfo.getPpsdid())){
			ppsInfo = flowSearchBL.searchProcessStatus(psInfo.getPpsdid());
		}
		IG380Info ig380Info = workFlowOperationBL.getProcessDefinitionByKey(pr.getPrpdid());
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		//�������ͣ�6->��ֹ(���нڵ㲻����+����ʱ��ֹͣ)
		//������
		jsonMap.put("pdname",ig380Info.getPdname());
		//���ڵ���
		jsonMap.put("ppsdname",null!=ppsInfo?ppsInfo.getPsdname():"");
		//�ڵ���
		jsonMap.put("psdname",psInfo.getPsdname());
		jsonMap.put("type","6");
		//�������ݸ�Ӧ������flex - ��ֹ
		messagePushBL.pushMessage(sendMsgPrid.toString(), gson.toJson(jsonMap));
		
		
		//****���ʹ����¼��־
		List<ProcessLogInfo> prLogList = flowSearchBL.searchProcesslog(curPrid, psdid, 
				null,logoInfo.getExecutorid());
		String noticeId = "";
		
		if(prLogList!=null&&prLogList.size()>0){
			ProcessLogInfo plBean = prLogList.get(prLogList.size()-1);
			noticeId = String.valueOf(plBean.getPlid());
		}
		
		EmergencyLogTB elTB;
		String ppString = "Ӧ������������<font color='#ff0000'><b>"+psInfo.getPsdname()+"</b></font>״̬����ֹ ";
		
		elTB = new EmergencyLogTB();
		elTB.setEllidtime(datetime);
		elTB.setElliinfo(ppString);
		elTB.setEllitype("1");
		elTB.setElprid(curPrid);
		elTB.setEluserid(logoInfo.getExecutorid());
		elTB.setElusername("sys");
		elTB.setElpsdid(psdid);
		elTB.setElpsdname(psInfo.getPsdname());
		emergencyLogBL.registEmergencyLog(elTB);
		//zyl
		//JSON������ϢMap����
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		List<Map<String, String>> list1 = new LinkedList<Map<String, String>>();
		Map<String, String> mapInList = new LinkedHashMap<String, String>();
		
		mapInList.put("pdid", pr.getPrpdid());//���̶���ID
		mapInList.put("prid", curPrid.toString());//����ʵ��ID
		mapInList.put("prtitle", pr.getPrtitle());//����ʵ������
		mapInList.put("noticeId", noticeId);//��Ϣ����ID
		mapInList.put("noticeUser", "sys");//��Ϣ������
		mapInList.put("noticeTime", datetime.split(" ")[1]);//��Ϣ����ʱ��
		mapInList.put("noticeType",elTB.getEllitype());//��Ϣ��������
		mapInList.put("flowNodeId",psInfo.getPsdid());//���ٰ�ť����
		mapInList.put("flowNodeName",psInfo.getPsdname());//��ť����
		mapInList.put("ppsdid", psInfo.getPpsdid());
		mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//��Ϣ��������
		mapInList.put("isTerminate", "1");//��ֹ
		list1.add(mapInList);
		
		noticeMap.put("data", list1);
		noticeMap.put("pdid", pr.getPrpdid());//���̶���ID
		noticeMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		messagePushBL.pushMessage(sendMsgPrid.toString(), gson.toJson(noticeMap));
	
	
	
	}
	
	/**
	 * @param prid ��Ҫ�رյ�����ʵ��id
	 * @param bean
	 * @throws BLException
	 */
	public void terminate(WorkFlowLogInfo logoInfo,Integer prid,Integer sendMsgPrid) throws BLException {
		log.debug("========��ֹ����ʼ========");
		//��ǰ��¼�����û���Ϣ
		String loginUserid = logoInfo.getExecutorid();
		User loginUser = userBL.searchUserByKey(loginUserid);
		//��ǰʱ��
		String datetime = IGStringUtils.getCurrentDateTime();
		//��ȡʱ��
		Date dateTime = new Date();
		
		//��ǰ��������ʵ����Ϣ
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
		if(pr == null){
			throw new BLException("IGCO10000.E004","��������");
		}
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(prid);
		ig224Cond.setCurrentPrstatus(true);
		List<IG224Info> ig224Lst = workFlowOperationBL.searchProcessStatusLog(ig224Cond);
		//������ǰ����ִ�нڵ��״̬��Ϣ
		for(int i=0;i<ig224Lst.size();i++){
			//��ǰ����ʵ�� ����ִ�нڵ�ID
			String psdid = ig224Lst.get(i).getPsdid();
			//��ѯ��ǰ�ڵ�ڵ������ ��ig337�����ùر��¼�
			IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
			ppcond.setPrid(pr.getPrid());
			ppcond.setPsdid(psdid);
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppcond);
			if(pplist!=null){
				for(IG337Info pp:pplist){ 
					if(StringUtils.isEmpty(pp.getPpproctime())){
						IG337TB ppTB = (IG337TB) SerializationUtils.clone(pp);
						ppTB.setPpproctime(IGStringUtils.getCurrentDateTime());
						//CommonDefineUtils.DATETIME_FORMAT.format(dateTime)
						workFlowOperationBL.updateProcessParticipant(ppTB);
					}
				}
			}
			//���µ�ǰ����״̬��־��Ϣ
			IG224Info currentRecordStatusLog = ig224Lst.get(i);
			IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
			currentRecordStatusLogTB.setRslCloseTime(dateTime);//����ʱ��
			currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
			
			//����ʵ��ig500
			IG500TB processRecord = (IG500TB)SerializationUtils.clone(pr);
			processRecord.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			processRecord.setPrclosetime(datetime);
			//����MAP - ��
			Map<Integer,FormFile> fileParam = null;
			workFlowOperationBL.updateProcessRecord(pr.getPrstatus(),processRecord,loginUser,logoInfo.getExecutorRoleid(),logoInfo.getComment(),
					IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE,fileParam,
					IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null, IGPRDCONSTANTS.PROCESS_TERMINATE);
			
		}
		
		log.debug("========��ֹ��������========");
	}

	
	
	
}
