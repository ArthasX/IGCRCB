/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;

/**
 * 内审项目更新Action处理
 *
 * @author
 */
public class IGIAM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0102Action.class);

	/**
	 * 内审项目更新处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGIAM0101Form form = (IGIAM0101Form)actionForm;
		
		//BL取得
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO生成
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//内审项目查看
		if ("DSEARCH".equals(mapping.getParameter())) {
			log.debug("========内审项目查看处理开始========");
			
			req.setAttribute("jump", req.getParameter("jump"));
			//将form封装到dto中
			dto.setIgIAM0101Form(form);
			//调用业务方法执行主键查询操作
			dto = ctlBL.dsearchIAMAction(dto);
			//form重新赋值
			form = dto.getIgIAM0101Form();
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//将附件List封装到VO中
			vo.setAttkeyList(dto.getAttkeyList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
			log.debug("========内审项目查看处理终了========");
		}
		//跳转到内审项目查看页
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========跳转到内审项目查看页处理开始========");
			//将form封装到dto中
			dto.setIgIAM0101Form(form);
			//调用业务方法执行主键查询操作
			dto = ctlBL.dsearchIAMAction(dto);
			//form重新赋值
			form = dto.getIgIAM0101Form();
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//将附件List封装到VO中
			vo.setAttkeyList(dto.getAttkeyList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
			log.debug("========跳转到内审项目查看页处理结束========");
		}
		//内审项目修改
		if ("UPDATE".equals(mapping.getParameter())) {
			log.debug("========内审项目保存、提交处理开始========");
			//判断状态是否为空
			if (req.getParameter("iapStatus") != null) {
				//从请求中获得状态信息
				String iapStatus = req.getParameter("iapStatus");
				//将状态信息封装到form中
				form.setIapStatus(iapStatus);
			}
			//将form封装到dto中
			dto.setIgIAM0101Form(form);
			//调用业务方法进行更新操作
			dto = ctlBL.updateIAMAction(dto);
			log.debug("========内审项目保存、提交处理结束========");
		}
		//内审项目删除
		if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========内审项目删除开始========");
			//将form封装到DTO
			dto.setIgIAM0101Form(form);
			//调用业务方法删除数据
			dto = ctlBL.deleteIAMAction(dto);
			log.debug("========内审项目删除结束========");
		}
		//附件下载
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========通知附件下载处理开始========");
			
			String attId = req.getParameter("attId");
			String type="iam";
			req.setAttribute("type", type);
			req.setAttribute("attId", attId);

			log.debug("========通知附件下载处理结束========");
			return mapping.findForward("LOADFILE");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
