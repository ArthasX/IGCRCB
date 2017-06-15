package com.deliverik.infogovernor.ven.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.bl.task.RiskStrategyBL;
import com.deliverik.infogovernor.ven.bl.task.StrategyIndexRelationBL;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCondImpl;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;
/**
 * 
* @ClassName: VenCheckJob
* @Description: TODO 风险监测job
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 上午10:31:25 
*
 */
public class VenCheckJob implements Job {

    private static Log log = LogFactory.getLog(VenCheckJob.class);
    //quarz 调用插入风险监测任务，以及封风险监测工作
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
    	log.info("from RiskCheckJob triggerName = " + key.getName());
        String rsid = String.valueOf(context.getJobDetail().getJobDataMap().get("rsid"));
        context.getJobDetail().getJobDataMap().clear();
        try {
        	this.venRegist(rsid);
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }
    //具体插入操作
    private void venRegist(String rsid)throws BLException{
        RiskStrategyBL riskStrategyBL = (RiskStrategyBL) WebApplicationSupport.getBean("riskStrategyBL");
        //RiskStrategy更改为
        RiskStrategyInfo info= riskStrategyBL.searchRiskStrategyByPK(Integer.valueOf(rsid));
        //发起检查任务  风险检测表
        RiskMonitoringTB riskMonitoringTB = new RiskMonitoringTB();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        riskMonitoringTB.setRmname(info.getRsname() + format.format(new Date()));
        riskMonitoringTB.setRsid(info.getRsid());
        riskMonitoringTB.setRmstartdate(info.getRsstartdate());
        riskMonitoringTB.setRmrate("0");
        //riskMonitoringTB.setRmenddate(info.getRsenddate());
        RiskMonitoringBL riskMonitoringBL = (RiskMonitoringBL) WebApplicationSupport.getBean("riskMonitoringBL");
        RiskMonitoringInfo result = riskMonitoringBL.registRiskMonitoring(riskMonitoringTB);
        //---------------检查任务增加完毕-------------------------
        //检查任务完毕
        StrategyIndexRelationBL realtionBl= (StrategyIndexRelationBL) WebApplicationSupport.getBean("strategyIndexRelationBL");
        StrategyIndexRelationSearchCondImpl cond = new StrategyIndexRelationSearchCondImpl();
        cond.setRsid(info.getRsid());
        List<StrategyIndexRelationInfo> criList = realtionBl.searchStrategyIndexRelation(cond);
        SOC0118BL soc0118BL= (SOC0118BL)WebApplicationSupport.getBean("soc0118BL");
        //监测工作填报表（新增）                                                                     
        MonitoringWorkBL monitoringWorkBL=(MonitoringWorkBL)WebApplicationSupport.getBean("monitoringWorkBL");                      
        //循环插入检查项
        for(StrategyIndexRelationInfo cri:criList){
//      MD （没懂）     RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(cri.getRcid());
            SOC0118Info ci = soc0118BL.searchEntityItemByKey(cri.getRiid());
//      MD      if(!"1".equals(ci.getEistatus())){
//      MD          continue;
//      MD      }
            //监测工作填报表（新增）                                                                       
            MonitoringWorkTB rcrTB = new MonitoringWorkTB();
            rcrTB.setRmid(result.getRmid());
            rcrTB.setRiid(cri.getRiid());
            monitoringWorkBL.registMonitoringWork(rcrTB);
            //插入任务工作关联表(无)
        }//end for
    }//end function
    

}