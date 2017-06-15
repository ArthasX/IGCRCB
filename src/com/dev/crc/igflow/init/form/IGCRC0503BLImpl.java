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
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/**
 * <p>
 * 服务请求    发起状态表单值初始化
 * </p>
 */
public class IGCRC0503BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGCRC0503BLImpl.class);
	
	/** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /** 系统类功能API类 */
    private SysManageBL sysManageBL;
    
    /**
     * @param 查询类功能API类 the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
    /**
     * @param 系统类功能API类 the flowSearchBL to set
     */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== 服务请求流程待发起节点初始化处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
		if(param.getParprid() != null){
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("服务请求描述", prInfo.getPrdesc());
			}
		}
		
//		String userid = param.getPruserid();
//		
//		List<Integer> roleList = sysManageBL.searchRoleListByUserid(userid);
//		
//		String isCentreRole = "否";
//		
//		for (Integer roleid : roleList) {
//			String rolename = sysManageBL.searchRoleInfo(roleid).getRolename();
//			if ("中心负责人".equals(rolename)) {
//				isCentreRole = "是";
//			}
//		}
//		
//		map.put("是否中心负责人", isCentreRole);
		
		log.debug("======== 服务请求流程待发起节点初始化处理结束========");
		return map;
		
	}

}
