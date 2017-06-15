package com.deliverik.infogovernor.drm.igflow.init.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;

public class IGDRMINIT0901BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{
	private FlowSearchBL flowSearchBL;
	private IG500BL ig500BL;
	   
	/**
	 * @param ig500bl the ig500BL to set
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * @param flowSearchBL the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	public Map<String, Object> initForm(WorkFlowParameterInfo bean)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
        String parameter = bean.getParameters();
        if(StringUtils.isNotEmpty(parameter)&&"flag".equals(parameter.split("_")[0])){
        	String prid = parameter.split("_")[1];
        	String startTime = flowSearchBL.searchPublicProcessInfo(Integer.parseInt(prid), "事件发生时间");
        	IG500Info ig500Info = ig500BL.searchIG500InfoByKey(Integer.parseInt(prid));
        	map.put("事件名称", ig500Info.getPrtitle());
        	map.put("事件发生时间", startTime);
        	map.put("紧急事件prid", prid);
        }else{
        	map.put(IGDRMCONSTANTS.PRACTISE_PRID_LABEL, StringUtils.isNotEmpty(parameter)?parameter:StringUtils.EMPTY);
        }
		return map;
	}

}
