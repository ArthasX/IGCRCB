/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/**
 * <p>
 * 程序更新    发起状态表单值初始化
 * </p>
 */
public class IGCRC1002BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGCRC1002BLImpl.class);
	
	/** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /**
     * @param 查询类功能API类 the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== 程序更新流程待发起节点初始化处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
		if(param.getParprid() != null && param.getParprid() > 0){
			ProcessRecordInfo info = flowSearchBL.searchProcessInfo(param.getParprid(), null).get(0);
			if(info.getPrpdid().startsWith("01100") || info.getPrpdid().startsWith("01101")){
				map.put("程序开发描述",flowSearchBL.searchPublicProcessInfo(param.getParprid(), "服务请求描述"));
			}else {
				map.put("程序开发描述", info.getPrdesc());
			}
		}
		log.debug("======== 程序更新流程待发起节点初始化处理结束========");
		return map;
		
	}

}
