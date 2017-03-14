/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.job;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;

/**
 * 概述: 流程策略轮询Job执行
 * 创建记录：2013/09/05
 * 修改记录：
 */
public class ProcessTacticsPollingJob implements Job {

    private static Log log = LogFactory.getLog(ProcessTacticsPollingJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	log.debug("========流程策略轮询Job执行处理开始========");
    	JobKey key = context.getJobDetail().getKey();
		if (key != null)
			return;
    	//获取BL
        IG334BL ig334BL = (IG334BL) WebApplicationSupport.getBean("ig334BL");
        //获取BL
        IG335BL ig335BL = (IG335BL) WebApplicationSupport.getBean("ig335BL");
        //获取job名称
        String jobName = key.getName();
        //根据job名称截取字符串,后面为pdid
        String[] jobNames = jobName.split(ProcessTacticsPollingJobInit.JOB_NAME);
        //当有pdid时
        if(jobNames.length == 2){
        	try {
        		//按流程状态
        		//根据pdid获取流程策略信息 
        		IG334SearchCondImpl ig334Cond = new IG334SearchCondImpl();
        		ig334Cond.setPdid_like(jobNames[1]);
        		List<IG334VWInfo> ig334vwInfos = ig334BL.findByCondTactics(ig334Cond);
        		
				//调用流程策略设定的BL执行init方法
				for (int i = 0; i < ig334vwInfos.size(); i++) {
					//设定BL执行，未设定不操作。
					if(StringUtils.isNotEmpty(ig334vwInfos.get(i).getProcessbl())) {
						WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(ig334vwInfos.get(i).getProcessbl());
						wfthBL.initExecute(ig334vwInfos.get(i).getPdid(),ig334vwInfos.get(i).getPsdid());
					}else {//为空时调用默认的流程状态策略处理方法
						WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(IGPRDCONSTANTS.PROCESS_TACTICS_STATUS);
						wfthBL.initExecute(ig334vwInfos.get(i).getPdid(),ig334vwInfos.get(i).getPsdid());
					}
				}
				
				
				//按流程整体
				ig334Cond = new IG334SearchCondImpl();
				ig334Cond.setPdid_eq(jobNames[1]);
				List<IG334Info> ig334Infos = ig334BL.searchIG334(ig334Cond);
				if (!ig334Infos.isEmpty()) {
					String pididTemp = ig334Infos.get(0).getPidid();
					IG335SearchCondImpl ig335Cond = new IG335SearchCondImpl();
					ig335Cond.setPidid_eq(pididTemp);
					ig335Cond.setPsdid_eq(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);//IG335中与配置整体流程相关的默认值
					List<IG335Info> ig335Infos = ig335BL.searchIG335(ig335Cond);
					if(!ig335Infos.isEmpty()){
						for(IG335Info ig335Info : ig335Infos){//整体策略现在存储IG335表所以可能会存在多条所以要进行循环处理
							if(StringUtils.isNotEmpty(ig335Info.getProcessbl())) {
								WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(ig335Info.getProcessbl());
								wfthBL.initExecute(ig335Info.getPdid(),null);
							}else {//为空时调用默认的流程整体策略处理方法
								WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE);
								wfthBL.initExecute(ig335Info.getPdid(),null);
							}
						}
					}
				}
			} catch (BLException e) {
				log.debug(e.getMessage());
			}
        }
		log.debug("========流程策略轮询Job执行处理结束========");
    }
}