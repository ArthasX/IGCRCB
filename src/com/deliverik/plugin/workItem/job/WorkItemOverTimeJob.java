package com.deliverik.plugin.workItem.job;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

public class WorkItemOverTimeJob implements Job{
	
    private static Log log = LogFactory.getLog(WorkItemOverTimeJob.class);
	
	public static final String JOB_NAME = "WORKITEMOVERTIME_JOB";
	
	public static final String JOB_EXPRESSION = "0 0 1 * * ?";	//秒 分 时 日 月 周;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("<<<<<<<<<<实际完成时间生成Job开始>>>>>>>>>>");		
		////查询所有超过当前时间的工作项,并且所有工作项对应的工作是否都已经结束，如果已经结束，查询最大处理时间
		
		WorkInstanceBL ctlBL = (WorkInstanceBL) WebApplicationSupport.getBean("workInstanceBL");
		WorkDefinitionBL ctldefBL = (WorkDefinitionBL) WebApplicationSupport.getBean("workDefinitionBL");
		List<Map<String,String>> resultMap = ctlBL.getExcutedMaxTime();
		if(resultMap!=null&&resultMap.size()>0){
			for(Map<String,String> tempMap:resultMap){
				WorkDefinitionTB workDefinitionTB = new WorkDefinitionTB();
				//获取工作定义对象
				WorkDefinitionInfo workDefinitionInfo;
				try {
					workDefinitionInfo = ctldefBL.searchWorkDefinitionByPK(Integer.parseInt(tempMap.get("wdid")));
					//Copy工作项定义TB
					BeanUtils.copyProperties(workDefinitionInfo, workDefinitionTB);
					workDefinitionTB.setActualFinishDate(tempMap.get("maxovertime"));
					ctldefBL.updateWorkDefinition(workDefinitionTB);
					log.info("<<<<<<<<<<实际完成时间生成定时任务Job正常结束>>>>>>>>>>");
				} catch (NumberFormatException e) {
					log.debug("生成更新实际完成时间定时任务失败："+e.getMessage());
					e.printStackTrace();
				} catch (BLException e) {
					log.debug("生成更新实际完成时间定时任务失败："+e.getMessage());
					e.printStackTrace();
				}
				
			}
		}
		log.info("<<<<<<<<<<实际完成时间生成Job结束>>>>>>>>>>");
	}

}
