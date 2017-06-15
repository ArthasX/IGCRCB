/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.dev.crc.igflow.event.status.bl.IGFXKDataSendBL;
import com.dev.crc.igflow.event.status.job.IGFXKDataSendJOB;

/***
 * 风险管理关闭的前置处理
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGFXK0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGFXK0101BLImpl.class);
	
	/** 查询类API */
	private FlowSearchBL flowSearchBL;
	
	/** 提醒发送BL */
	private IGFXKDataSendBL igFXKDataSendBL;
	
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 提醒发送BL设定
	 * @param igFXKDataSendBL 提醒发送BL
	 */
	public void setIgFXKDataSendBL(IGFXKDataSendBL igFXKDataSendBL) {
		this.igFXKDataSendBL = igFXKDataSendBL;
	}

	
	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo arg0)
			throws BLException {

	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================风险管理关闭前置处理开始=====================");
		
		//表单值取得
		String planBeginTime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "计划开始时间");
		String planEndTime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "计划结束时间");
		String planType = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "风险计划类型");
		
		/**查询页面表单信息*/
		List<ProcessRecordInfo> searchProcessInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
		
		if(null != searchProcessInfo && searchProcessInfo.size() != 0){
			
			Date date=new Date();
			/**设置时间格式*/
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
			
			try {
				/**当前时间String类型*/
				String currTime=sdf.format(date);
				/**在时间以毫米为单位*/
				long nowTime = sdf.parse(currTime).getTime();
				/** 计划结束时间以毫米为单位*/
				long endTime = sdf.parse(planEndTime).getTime();
			
				/**添加 计划开始时间、计划结束时间、计划标题*/
				Map<String, Object> map = new HashMap<String, Object>();
					map.put("bTime", planBeginTime);
					map.put("eTime", planEndTime);
					map.put("title",searchProcessInfo.get(0).getPrtitle());
					map.put("prid",bean.getLogInfo().getPrid());
						
				/**执行一直风险管理提醒*/
				igFXKDataSendBL.dataSend(planBeginTime, planEndTime, searchProcessInfo.get(0).getPrtitle());
				
				if ((endTime > nowTime) &&"年度计划".equals(planType)) {
					/**计划任务时间设定*/
					StringBuffer bf=new StringBuffer();
						bf.append("0 ");
						bf.append(currTime.substring(14, 16));
						bf.append(" ");
						bf.append(currTime.substring(11, 13));
						bf.append(" ");
						bf.append(currTime.substring(8, 10));
						bf.append(" ");
						bf.append(currTime.substring(5, 7));
						bf.append(" ?");
						//向工作流中添加定时任务
					JobManager.addJob(IGFXKDataSendJOB.JOB_NAME+ bean.getLogInfo().getPrid(),new IGFXKDataSendJOB(), bf.toString(),map);
				} 
			} catch (Exception e) {
				log.error("",e);
			}
		}
		log.debug("=====================风险管理关闭前处理结束=====================");
	}
}
