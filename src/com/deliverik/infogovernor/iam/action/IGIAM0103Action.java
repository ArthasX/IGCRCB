/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;


/**
 * 内审项目新增Action处理
 *
 * @author
 */
public class IGIAM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0103Action.class);

	/**
	 * 内审项目新增处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//判断跳转
		String forwardstr = null;
		if (req.getParameter("iapStatus") != null) {
			if (req.getParameter("iapStatus").equals("0")) {			
				forwardstr = "DISP1";
			} else {
				forwardstr = "DISP2";
			}
		} else {
			forwardstr = "DISP";
		}
		//FORM取得
		IGIAM0101Form form = (IGIAM0101Form)actionForm;
		
		//BL取得
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO生成
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//内审项目登记
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========内审项目保存、提交处理开始========");
			//判断状态是否为空
			if (req.getParameter("iapStatus") != null) {
				//从请求中获得状态信息		
				String iapStatus = req.getParameter("iapStatus");
				//将状态信息封装到form中
				form.setIapStatus(iapStatus);
			}
			//设置附件
			dto.setAttachFile(form);
			//将form封装到dto中
			dto.setIgIAM0101Form(form);
			//调用业务方法执行新增操作
			dto = ctlBL.insertIAMAction(dto);
			log.debug("========内审项目保存、提交处理结束========");
		}
		return mapping.findForward(forwardstr);
	}
}
