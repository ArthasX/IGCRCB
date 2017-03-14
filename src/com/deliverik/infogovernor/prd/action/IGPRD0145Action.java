/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0145Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01451VO;

/**
 * 概述: 自定义流程表单查询条件定义Action
 * 功能描述: 自定义流程表单查询条件定义Action
 * 创建记录: 2013/03/13
 * 修改记录: 
 */
public class IGPRD0145Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//跳转标识
		String forward = "DISP";
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0145Action.class);
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//实例化dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//form取得
		IGPRD0145Form form = (IGPRD0145Form) actionForm;
		//dto参数设定
		dto.setForm(actionForm);
		dto.setPdid(form.getPdid());
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============查询条件配置页初始化操作开始=================");
			dto = ctlBL.getProcessInfoQueryInfo(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//实例化vo
			IGPRD01451VO vo = new IGPRD01451VO();
			vo.setPdList(dto.getPdList());
			vo.setPqList(dto.getPqList());
			vo.setQueryShowColumnList(dto.getQueryShowColumnList());
			vo.setQueryShowColumnMap(dto.getQueryShowColumnMap());
			vo.setQueryList(dto.getQueryList());
			vo.setQueryMap(dto.getQueryMap());
			super.<IGPRD01451VO>setVO(request, vo);
			// saveToken(request);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
			}
			log.debug("==============查询条件配置页初始化操作结束=================");
		}
		//操作
		if("EDIT".equals(mapping.getParameter())|| "WIDTH".equals(mapping.getParameter())){
			log.debug("=============查询条件编辑操作开始==============");
			// if(isTokenValid(request,true)){
					dto = ctlBL.changeProcessQueryAction(dto);
			// }else{
			// addMessage(request, new ActionMessage("IGCO00000.E007"));
			// return mapping.findForward("/error1");
			// }
			log.debug("=============查询条件编辑操作结束==============");
			if ("EDIT".equals(mapping.getParameter())) {
				return new ActionForward("/IGPRD0145_Disp.do?pdid=" + dto.getPdid(), true);
			} else {
				return new ActionForward("/IGPRD0146_Disp.do?pdid=" + dto.getPdid(), true);
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
