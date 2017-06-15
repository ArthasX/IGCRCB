package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCondImpl;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
 * 
 * 功能：指派检查工作。设置检查工作的完成情况为已完成
 * @author 史凯龙   2014-9-9
 */
public class IGVEN0107BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(IGVEN0107BLImpl.class);

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	private IG599BL ig599BL;
	
	/** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;
	
	/**  监测工作填报表业务逻辑接口BL*/
	protected MonitoringWorkBL monitoringWorkBL;
	
	/**  风险监测任务表业务逻辑接口 */
	protected RiskMonitoringBL riskMonitoringBL;
    
	/** 执行工作 */
	private String STATUSNAME_ZXGZ = "执行工作";


	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	/**
	 * 监测工作填报表业务逻辑接口BL设定
	 * @param monitoringWorkBL the 监测工作填报表业务逻辑接口BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * @param ig599bl the ig599BL to set
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * 风险监测任务表业务逻辑接口设定
	 * @param riskMonitoringBL the 风险监测任务表业务逻辑接口
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}
	/** 后处理 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** 前处理 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========指派工作流程部门审批前处理设置参与者处理开始========");

		    //日志参数信息设定
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //封装流程状态名称
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        setNextPoint(bean);
	        
	        	        
			log.debug("========指派工作流程部门审批前处理设置参与者处理结束========");
	}
	
	/**
	 * 设置下一个节点
	 * @param bean
	 */
	@SuppressWarnings("unused")
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub

		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "人员");
		String result = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "检查结果");
		String resultCommont = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "结果说明");
		String ret = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "附件");
		String resultABC = "";
		if("正常".equals(result)){
			resultABC = "A";
		}else if("存在问题".equals(result)){
			resultABC = "B";
		}else if("存在重大问题".equals(result)){
			resultABC = "C";
		}
		
        if(StringUtils.isNotEmpty(rcrid)){
        	
        	MonitoringWorkTB rcrBean = (MonitoringWorkTB) monitoringWorkBL.searchMonitoringWorkByPK(Integer.parseInt(rcrid));
        	
        	
        	RiskMonitoringTB riskMonitoringtb = (RiskMonitoringTB) riskMonitoringBL.searchRiskMonitoringByPK(rcrBean.getRmid());
        	
        	MonitoringWorkSearchCondImpl cond = new MonitoringWorkSearchCondImpl();
        	cond.setRmid(riskMonitoringtb.getRmid());
        	Integer sum = monitoringWorkBL.getSearchCount(cond);
        	cond.setResult_isNotNull("1");
        	//查询出已经处理的工作数量
			int count = monitoringWorkBL.getSearchCount(cond);
			//计算出已处理完成的数量
			Integer rate = (int) ((((double)(count+1) /(double)sum))*100);
			
			//如果进度为100,则该任务已完成
			if(rate == 100){
				Date time  = new Date();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				//插入完成时间
				riskMonitoringtb.setRmenddate(format1.format(time));
			}
			//插入进度
			riskMonitoringtb.setRmrate(rate.toString());
			//更新任务
			this.riskMonitoringBL.updateRiskMonitoring(riskMonitoringtb);
			
        	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
        	ig599Cond.setPrid(bean.getLogInfo().getPrid());
        	ig599Cond.setPivarname("附件");
        	
        	List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
        	
        	if(rcrBean!=null){
        		MonitoringWorkTB rcrTB = (MonitoringWorkTB)SerializationUtils.clone(rcrBean);
        		//设置结果
        		rcrTB.setResult(resultABC);
        		//设置结果说明
        		rcrTB.setResultdesc(resultCommont);
        		if(ig599InfoList!=null && ig599InfoList.size()>0){
        			rcrTB.setMwattachkey(ig599InfoList.get(0).getPiattkey());        			
        		}
        		monitoringWorkBL.updateMonitoringWork(rcrTB);
        	}			
        }
	}
}