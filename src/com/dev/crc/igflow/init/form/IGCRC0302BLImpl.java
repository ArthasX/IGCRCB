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
 *   问题管理流程待发起状态表单值初始化
 * </p>
 */
public class IGCRC0302BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGCRC0302BLImpl.class);
	
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
		log.debug("======== 问题流程待发起节点初始化处理开始========");
		//表单值集合返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//如果主流程id不为空，说明该问题整改流程是从别的流程发起的
		if(param.getParprid() != null){
			//获取主流程
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("问题描述", prInfo.getPrdesc());
			}
		}
		log.debug("======== 问题流程待发起节点初始化处理结束========");
		return map;
		
	}

}
