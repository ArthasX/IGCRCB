package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * 
 * 功能：指派检查工作。如果有执行人，跳转到执行状态
 * @author   2014-9-11
 */
public class IGVEN0105BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(IGVEN0105BLImpl.class);

	/** 流程主表BL */
	private IG500BL ig500BL;

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 用户信息查询BL */
	private UserBL userBL;
	
	/** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;
    
    /** 流程状态定义BL */
    protected IG333BL ig333BL;
    
	/** 检查分派 */
	private String STATUSNAME_JCFP = "检查分派";
	
	/** 检查执行 */
	private String STATUSNAME_JCZX = "检查执行";


	/**
	 * 流程主表BL设置
	 * 
	 * @param ig500bl 流程主表BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 用户信息查询BL设置
	 * 
	 * @param userBL 用户信息查询BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 流程状态定义BL设置
	 * 
	 * @param ig333bl 流程状态定义BL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/** 前处理 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		log.debug("========指派工作流程如果有执行人，跳转到执行状态处理开始========");
		Integer prid = bean.getLogInfo().getPrid();
		List<ParticipantInfo> lst_StatusParticipant = flowSearchBL.searchStatusParticipant(prid, STATUSNAME_JCZX);
		if(lst_StatusParticipant != null && lst_StatusParticipant.size() > 0){
			//获取当前登录用户
		    User user = userBL.searchUserByKey(bean.getCrtuserid());
		    //获取授权用户
		    User authorizeuser = null;
		    if(StringUtils.isNotEmpty(bean.getLogInfo().getAuthuserid())){
		    	authorizeuser = userBL.searchUserByKey(bean.getLogInfo().getAuthuserid());
		    }
		    
		    //获取当前流程
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			IG500TB processTB = (IG500TB)SerializationUtils.clone(process);
			
			processTB.setPrstatus("X");
			ig500BL.updateIG500Info(processTB);
			
			//查询流程状态信息
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPdid(processTB.getPrpdid());
			cond333.setPsdname(STATUSNAME_JCFP);
			IG333Info fpsd = ig333BL.searchIG333Info(cond333).get(0);
			cond333.setPsdname(STATUSNAME_JCZX);
			IG333Info tpsd = ig333BL.searchIG333Info(cond333).get(0);
			
			//添加流程日志
			workFlowOperationBL.addRecordLog(prid, user, bean.getCrtroleid(), 
					"流程跃迁成功", STATUSNAME_JCZX, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, "10", null);
			//添加流程状态日志
			workFlowOperationBL.addRecordStatusLog(processTB, fpsd, null, new String[]{tpsd.getPsdid()}, 
					WorkFlowConstDefine.STATUSTYPE_NORMAL, user,  bean.getCrtroleid(), authorizeuser, "10");
			
		}
	        	        
		log.debug("========指派工作流程如果有执行人，跳转到执行状态处理结束========");
	}

	/** 后处理 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
}