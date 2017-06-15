/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**	
 * 概述:变更 待发起后处理
 * 保存远程发起流程时的attkey
 *         
 */

public class IGCRC3003BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{

	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC3003BLImpl.class);
	
    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /** 日志信息操作 */
	private IG036BL ig036BL;

	/**
	 * 注入查询功能API类
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
	/**
	 * @param ig036bl the 日志信息操作 to set
	 */
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}
    
	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeFlowSystemState(prid, "0",null);
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=================保存远程发起流程时的attkey处理开始=================");
		Integer prid = bean.getLogInfo().getPrid();
		String attkey = flowSearchBL.searchPublicProcessInfo(prid, "隐藏附件ID");
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setNotEqualrlType("0");
		cond.setPrid(prid);
		List<IG036Info> ig036List = ig036BL.searchIG036InfoByCond(cond);
		if(ig036List != null && ig036List.size() > 0 && attkey!= null && !"".equals(attkey)){
			IG036Info ig036Info = ig036List.get(0);
			IG036TB ig036tb = (IG036TB)SerializationUtils.clone(ig036Info);
			ig036tb.setRlattkey(attkey);
			ig036BL.updateG036Info(ig036tb);
		}
		
		log.debug("=================保存远程发起流程时的attkey处理结束=================");
	}


}
