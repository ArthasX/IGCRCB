/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.drm.util.ComputingTime;

/**
 * 应急演练流程-关闭节点前处理
 * 
 * 更新演练计划表和计划任务表 修改状态为已演练
 * 
 * @author zyl
 *
 * 2015年3月16日13:34:06
 */
public class IGDRMEVENT0105BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0105BLImpl.class);
   
    private IG599BL ig599BL;
    private IG333BL ig333BL;
    
    
	/**  
	 * 获取ig599BL  
	 * @return ig599BL 
	 */
	public IG599BL getIg599BL() {
		return ig599BL;
	}

	/**  
	 * 设置ig599BL  
	 * @param ig599BL
	 */
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**  
	 * 获取ig333BL  
	 * @return ig333BL 
	 */
	public IG333BL getIg333BL() {
		return ig333BL;
	}

	/**  
	 * 设置ig333BL  
	 * @param ig333BL
	 */
	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/**
	 * 添加预计时间值
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	Integer prid = bean.getLogInfo().getPrid();
    	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
    	ig599Cond.setPrid(prid);
    	ig599Cond.setPivarname("场景应急处置步骤");
    	List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
    	if(ig599List!=null && ig599List.size()>0){
    		IG599Info ig599Info =  ig599List.get(0);
    		String pdid = ig599Info.getPivarvalue();
    		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
    		ig333Cond.setPdid(pdid);
    		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
    		Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
    		if(ig333List!=null && ig333List.size()>0){
    			for(IG333Info ig333Info:ig333List){
    					ig333Map.put(ig333Info.getPsdid(), ig333Info);
    			}
    		}
    		if(ig333Map.size()>2){
    			ComputingTime computingTime = new ComputingTime();
    			Integer countTotalTime = computingTime.countTotalTime(ig333Map);
    			ig599Cond.setPivarname("预计恢复时间");
    			List<IG599Info> ig599List1 = ig599BL.searchIG599InfosByCond(ig599Cond);
    			if(ig599List1!=null && ig599List1.size()>0){
    				IG599TB ig599TB = (IG599TB) ig599List1.get(0);
    				ig599TB.setPivarvalue(countTotalTime.toString());
    				ig599BL.updateIG599Info(ig599TB);
    			}
    		}
    		
    	}
    }

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL#afterTreatmentExecute(com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo)
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		
	}
    
}
