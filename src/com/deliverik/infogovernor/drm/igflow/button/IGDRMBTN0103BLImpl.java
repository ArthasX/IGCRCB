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
 * 场景修订 待发起节点（第一页）点击【下一步】按钮事件
 * 将被修订的场景流程升版
 * 
 * </p>
 */
public class IGDRMBTN0103BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0103BLImpl.class);
	
    /** 查询类功能API类 */
	protected FlowSearchBL flowSearchBL;
    
   	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**角色信息业务BL*/
	protected UserBL userBL;
	
	/**流程参与人员*/
	protected IG484BL ig484BL;
	
	 /**消息推送BL*/
	protected MessagePushBL messagePushBL;
	
	/** 流程状态日志信息操作*/
	protected IG224BL ig224BL;
	
	/**推送日志*/
	protected EmergencyLogBL emergencyLogBL;
	
	/**流程参与人员*/
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
	 * 场景修订待发起节点（第一页）点击【下一步】按钮事件
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========预案定义待发起保存按钮处理开始========");
		Gson gson = new Gson();
		WorkFlowLogInfo logoInfo = bean.getLogInfo();
		Integer curPrid = logoInfo.getPrid();
		Integer pgrid = null;
		String psdid = bean.getBfstatus();
		//当前时间
		String datetime = IGStringUtils.getCurrentDateTime();
		//推送消息专用prid
		Integer sendMsgPrid = ig484BL.searchIG484PgridByPrid(curPrid);
		if(null == sendMsgPrid){
			sendMsgPrid = curPrid;
		}else{
			//该单一场景实例是组合场景内的实例
			pgrid = sendMsgPrid;
		}
		//pgrid不为空 该流程实例属于流程组发起的流程
		if(null!=pgrid){
			IG484SearchCondImpl ig484Cond = new IG484SearchCondImpl();
			ig484Cond.setPgrid(pgrid);
			List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484Cond);
			for(IG484Info info:ig484Lst){
				//流程组流程中止处理
				this.terminate(logoInfo,info.getPrid(),sendMsgPrid);
			}
			//更新流程组关闭时间 为已关闭
			IG483Info ig483Info = ig483BL.searchIG483ByPK(pgrid);
			IG483TB ig483TB = (IG483TB) SerializationUtils.clone(ig483Info);
			ig483TB.setPgrclosetime(IGStringUtils.getCurrentDateTime());
			ig483BL.updateIG483(ig483TB);
		}else{
			//单一流程
			//流程中止处理
			this.terminate(logoInfo,curPrid,sendMsgPrid);
		}
		//当前流程流程实例信息
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(curPrid);
		ProcessStatusInfo psInfo = flowSearchBL.searchProcessStatus(psdid);
		ProcessStatusInfo ppsInfo = null;
		if(StringUtils.isNotBlank(psInfo.getPpsdid())){
			ppsInfo = flowSearchBL.searchProcessStatus(psInfo.getPpsdid());
		}
		IG380Info ig380Info = workFlowOperationBL.getProcessDefinitionByKey(pr.getPrpdid());
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		//推送类型：6->终止(所有节点不高亮+已用时间停止)
		//流程名
		jsonMap.put("pdname",ig380Info.getPdname());
		//父节点名
		jsonMap.put("ppsdname",null!=ppsInfo?ppsInfo.getPsdname():"");
		//节点名
		jsonMap.put("psdname",psInfo.getPsdname());
		jsonMap.put("type","6");
		//推送数据给应急处置flex - 中止
		messagePushBL.pushMessage(sendMsgPrid.toString(), gson.toJson(jsonMap));
		
		
		//****推送处理记录日志
		List<ProcessLogInfo> prLogList = flowSearchBL.searchProcesslog(curPrid, psdid, 
				null,logoInfo.getExecutorid());
		String noticeId = "";
		
		if(prLogList!=null&&prLogList.size()>0){
			ProcessLogInfo plBean = prLogList.get(prLogList.size()-1);
			noticeId = String.valueOf(plBean.getPlid());
		}
		
		EmergencyLogTB elTB;
		String ppString = "应急处置流程在<font color='#ff0000'><b>"+psInfo.getPsdname()+"</b></font>状态被中止 ";
		
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
		//JSON传递信息Map设置
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		List<Map<String, String>> list1 = new LinkedList<Map<String, String>>();
		Map<String, String> mapInList = new LinkedHashMap<String, String>();
		
		mapInList.put("pdid", pr.getPrpdid());//流程定义ID
		mapInList.put("prid", curPrid.toString());//流程实例ID
		mapInList.put("prtitle", pr.getPrtitle());//流程实例名称
		mapInList.put("noticeId", noticeId);//信息发布ID
		mapInList.put("noticeUser", "sys");//信息发布人
		mapInList.put("noticeTime", datetime.split(" ")[1]);//信息发布时间
		mapInList.put("noticeType",elTB.getEllitype());//信息发布类型
		mapInList.put("flowNodeId",psInfo.getPsdid());//跟踪按钮分组
		mapInList.put("flowNodeName",psInfo.getPsdname());//按钮名称
		mapInList.put("ppsdid", psInfo.getPpsdid());
		mapInList.put("noticeContnt", ppString.replace("<br>", "").replace("&nbsp;", " ").trim());//信息发布内容
		mapInList.put("isTerminate", "1");//中止
		list1.add(mapInList);
		
		noticeMap.put("data", list1);
		noticeMap.put("pdid", pr.getPrpdid());//流程定义ID
		noticeMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		messagePushBL.pushMessage(sendMsgPrid.toString(), gson.toJson(noticeMap));
	
	
	
	}
	
	/**
	 * @param prid 需要关闭的流程实例id
	 * @param bean
	 * @throws BLException
	 */
	public void terminate(WorkFlowLogInfo logoInfo,Integer prid,Integer sendMsgPrid) throws BLException {
		log.debug("========中止处理开始========");
		//当前登录流程用户信息
		String loginUserid = logoInfo.getExecutorid();
		User loginUser = userBL.searchUserByKey(loginUserid);
		//当前时间
		String datetime = IGStringUtils.getCurrentDateTime();
		//获取时间
		Date dateTime = new Date();
		
		//当前流程流程实例信息
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
		if(pr == null){
			throw new BLException("IGCO10000.E004","工作基本");
		}
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(prid);
		ig224Cond.setCurrentPrstatus(true);
		List<IG224Info> ig224Lst = workFlowOperationBL.searchProcessStatusLog(ig224Cond);
		//遍历当前正在执行节点的状态信息
		for(int i=0;i<ig224Lst.size();i++){
			//当前流程实例 正在执行节点ID
			String psdid = ig224Lst.get(i).getPsdid();
			//查询当前节点节点参与人 给ig337表设置关闭事件
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
			//更新当前流程状态日志信息
			IG224Info currentRecordStatusLog = ig224Lst.get(i);
			IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
			currentRecordStatusLogTB.setRslCloseTime(dateTime);//结束时间
			currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
			
			//流程实例ig500
			IG500TB processRecord = (IG500TB)SerializationUtils.clone(pr);
			processRecord.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			processRecord.setPrclosetime(datetime);
			//附件MAP - 无
			Map<Integer,FormFile> fileParam = null;
			workFlowOperationBL.updateProcessRecord(pr.getPrstatus(),processRecord,loginUser,logoInfo.getExecutorRoleid(),logoInfo.getComment(),
					IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE,fileParam,
					IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null, IGPRDCONSTANTS.PROCESS_TERMINATE);
			
		}
		
		log.debug("========中止处理终了========");
	}

	
	
	
}
