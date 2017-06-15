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
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

public class IGDRMINIT0801BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{
	
	static Log log = LogFactory.getLog(IGDRMINIT0801BLImpl.class);
	//流程查询BL
	protected IG500BL ig500BL;

	/**
	 * @return the ig500BL
	 */
	public IG500BL getIg500BL() {
		return ig500BL;
	}


	/**
	 * @param ig500bl the ig500BL to set
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}


	public Map<String, Object> initForm(WorkFlowParameterInfo bean) throws BLException {
		// TODO Auto-generated method stub
		log.debug("========发起节点表单初始化处理-演练计划发起页面处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
        //获取演练流程prid
		String ylPrid = bean.getParameters();
        if(StringUtils.isNotEmpty(ylPrid)){
        	IG500Info ig500Info = ig500BL.searchIG500InfoByKey(Integer.parseInt(ylPrid));
        	map.put("演练流程名称", ig500Info.getPrtitle());
        	map.put("演练流程prid", ylPrid);
        }
		log.debug("========发起节点表单初始化处理-演练计划发起页面处理结束========");
		return map;
	}
 
}
