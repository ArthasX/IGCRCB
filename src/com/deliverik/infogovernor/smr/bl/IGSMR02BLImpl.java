/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
 * 审批意见业务逻辑实现
 *
 */
public class IGSMR02BLImpl  extends BaseBLImpl implements IGSMR02BL{

	static Log log = LogFactory.getLog(IGSMR02BLImpl.class);
	
	/** 审批意见BL */
	protected ApproveSuggestionBL approveSuggestionBL;
	
	/** 流程主信息BL */
	protected IG500BL ig500BL;
	
	/** 表单信息BL */
	protected IG007BL ig007BL;
	
	/**
	 * 审批意见BL设定
	 *
	 * @param approveSuggestionBL 审批意见BL
	 */
	public void setApproveSuggestionBL(ApproveSuggestionBL approveSuggestionBL) {
		this.approveSuggestionBL = approveSuggestionBL;
	}
	
	/**
	 * 流程主信息BL设定
	 *
	 * @param ig500BL 流程主信息BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 表单信息BL设定
	 *
	 * @param ig007BL 表单信息BL
	 */
	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	/**
	 * 表单中有效审批意见信息查询方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestion(IGSMR02DTO dto) throws BLException{
		log.debug("=========审批意见查询处理开始=========");
		IGSMR0201Form form = dto.getIgSMR0201Form();
		
		//查询流程信息
		IG500Info ig500Info = this.ig500BL.searchIG500InfoByKey(form.getPrid());
		dto.setIg500Info(ig500Info);
		
		//查询表单信息
		dto.setPidname(this.ig007BL.searchIG007InfoByKey(form.getPidid()).getPidname());
		
		// 获取查询条件
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(form.getPrid());
		cond.setPidid_eq(form.getPidid());
		cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);
		cond.setPsdcode_eq(ig500Info.getPrstatus());
		cond.setRownumber_eq(form.getRownumber());
		
		// 查询某个表单中有效的审批意见
		List<ApproveSuggestionInfo> lstApprove = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
		if(lstApprove != null && lstApprove.size() > 0){
			dto.setApproveSuggestionInfo(lstApprove.get(0));
		}
		
		log.debug("=========审批意见查询处理结束=========");
		return dto;
	}
	
	/**
	 * 表单所有审批意见信息查询方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestionAllByPidid(IGSMR02DTO dto) throws BLException{
		log.debug("=========审批意见查询处理开始=========");
		IGSMR0202Form form = dto.getIgSMR0202Form();
		
		// 获取查询条件
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(form.getPrid());
		cond.setPidid_eq(form.getPidid());
		cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);
		cond.setRownumber_eq(form.getRownumber());
		
		// 查询某个表单的所有审批意见
		List<ApproveSuggestionInfo> lstApprove = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
		dto.setLstApproveSuggestionInfo(lstApprove);
		
		//查询流程信息
		IG500Info ig500Info = this.ig500BL.searchIG500InfoByKey(form.getPrid());
		dto.setIg500Info(ig500Info);
		
		log.debug("=========审批意见查询处理结束=========");
		return dto;
	}
	
	/**
	 * 审批意见保存方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO saveApproveSuggestion(IGSMR02DTO dto) throws BLException{
		log.debug("=========审批意见保存处理开始=========");
		// 获取登录用户
		User user = dto.getUser();
		// 获取审批意见Form
		IGSMR0201Form form = dto.getIgSMR0201Form();
		
		// 获取审批意见实体
		ApproveSuggestionTB instance = this.approveSuggestionBL.getApproveSuggestionTBInstance();
		
		if(form.getId() != null && form.getId() != 0){
			instance.setId(form.getId()); // 审批意见主键
		}
		
		instance.setPidid(form.getPidid());// 表单定义主键
		instance.setPrid(form.getPrid());
		instance.setPsdcode(form.getPsdcode());//状态标识
		instance.setPsdname(form.getPsdname());//状态名称
		instance.setStatus(IGSMRCONSTANT.APPROVE_STATUS_YES);//意见状态
		instance.setSuggestion(form.getSuggestion());//意见信息
		instance.setUserid(user.getUserid());//驳回人用户ID
		instance.setUsername(user.getUsername());//驳回人名称
		instance.setInserttime(IGStringUtils.getCurrentDateTime());//驳回时间
		instance.setRownumber(form.getRownumber());
		// 保存审批意见
		ApproveSuggestionInfo approveSuggestionInfo = null;
		if(form.getId() != null && form.getId() > 0){
			instance.setId(form.getId()); // 审批意见主键
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				approveSuggestionInfo = this.approveSuggestionBL.updateApproveSuggestionInfo(instance);
			} else {
				this.approveSuggestionBL.deleteApproveSuggestionInfoByPK(form.getId());
			}
		} else {
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				approveSuggestionInfo = this.approveSuggestionBL.registApproveSuggestionInfo(instance);
			}
		}
		
		dto.setApproveSuggestionInfo(approveSuggestionInfo);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "审批意见保存") );
		
		log.debug("=========审批意见保存处理结束=========");
		return dto;
	}
}
