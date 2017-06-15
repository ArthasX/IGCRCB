package com.deliverik.infogovernor.drm.igflow.init.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.drm.bl.task.DrillplanBL;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;

public class IGDRMINIT0701BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{
	
	static Log log = LogFactory.getLog(IGDRMINIT0701BLImpl.class);
	
	private DrillplanBL  drillplanBL; 
	
	/**
	 * drillplanBL的设定
	 * @param drillplanBL 
	 */
	public void setDrillplanBL(DrillplanBL drillplanBL) {
		this.drillplanBL = drillplanBL;
	}

	public Map<String, Object> initForm(WorkFlowParameterInfo bean) throws BLException {
		// TODO Auto-generated method stub
		log.debug("========发起节点表单初始化处理-演练计划发起页面处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
        String parameter = bean.getParameters();
        
        if(StringUtils.isNotEmpty(parameter)){
        	String diid = parameter;
        	map = getDrillPlanVWInfoByDid(Integer.parseInt(diid), map);
        }
		
		log.debug("========发起节点表单初始化处理-演练计划发起页面处理结束========");
		return map;
	}
 
	private Map<String,Object> getDrillPlanVWInfoByDid(int diid,Map<String,Object> map) throws BLException{
		DrillplanVWInfo drillplanVWInfo = drillplanBL.getDrillPlanVWByDiid(diid);
		if(null != drillplanVWInfo){
			map.put("演练计划名称", drillplanVWInfo.getDname());
			map.put("计划创建时间", drillplanVWInfo.getCrttime());
			map.put("演练负责部门", drillplanVWInfo.getDidutyorg());
			map.put("演练参与部门", drillplanVWInfo.getPartorg());
			map.put("演练内容", drillplanVWInfo.getDicontant());
			map.put("计划任务id", String.valueOf(diid));
		}
		return map;
	}
}
