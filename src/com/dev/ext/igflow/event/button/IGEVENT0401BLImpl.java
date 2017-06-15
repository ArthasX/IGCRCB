package com.dev.ext.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * 意见意见流程发起状态提交按钮动作定义
 * 判断目标部门是否存在，设定目标部门是否存在表单值
 * </p>
 */
public class IGEVENT0401BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0401BLImpl.class);
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 查询类功能API类设定
	 * 
	 * @param flowSearchBL 更新功能API类查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
		if (bean.getLogInfo().getPrid()!=null){
			log.debug("发起按钮处理1");
			//查询部门处理意见状态参与者
			List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "部门处理意见");
			
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			
			//表单名
			ppivInfo.setFormname("目标部门");
	
			if (pInfoList != null && pInfoList.size() > 0){
				//设置一级审批人是否存在表单值为1			
				//表单值
				ppivInfo.setFormvalue(pInfoList.get(0).getRolename());			
			}
			
			this.flowSetBL.setPublicProcessInfoValue(ppivInfo);

			PublicProcessInfoValue ppivInfo1 = new PublicProcessInfoValue(bean.getLogInfo());
			
			//表单名
			ppivInfo1.setFormname("目标部门是否存在");
	
			if (pInfoList != null && pInfoList.size() > 0){
				//设置目标部门是否存在表单值为1			
				//表单值
				ppivInfo1.setFormvalue("1");			
			} else {
				//设置目标部门是否存在表单值为0			
				//表单值
				ppivInfo1.setFormvalue("0");			
			}
			this.flowSetBL.setPublicProcessInfoValue(ppivInfo1);
		} else {
			log.debug("发起按钮处理2");
		}
		
	}

}
