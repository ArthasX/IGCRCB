/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0103Form;
import com.deliverik.infogovernor.dwp.util.IGDWPUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作任务发起Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0103Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDWP0103Action.class);
		//BL取得
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//实例化dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//form取得
		IGDWP0103Form form = (IGDWP0103Form) actionForm;
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setForm(actionForm);
		dto.setUser(user);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============页面初始化操作开始===============");
			dto = ctlBL.initDayWorkPlanAction(dto);
			saveToken(request);
			log.debug("==============页面初始化操作结束===============");
		}
		//任务登记操作
		if("INSERT".equals(mapping.getParameter())){
			log.debug("==============日常工作计划登记操作开始================");
			if (isTokenValid(request, true)){
				if(form.getId() != null && form.getId() > 0){
					//调用BL更新
					dto = ctlBL.changeDayWorkPlanAction(dto);
				}else{
					//调用BL新增
					dto = ctlBL.insertDayWorkPlanAction(dto);
					/**
					 * 1、流程、或指派短信需要分派，则跳转到分派也
					 * 2、任务登记到流程需要跳转到流程发起页
					 */
					if(form.getPmode().equals("1")){
					if(IGDWPUtils.ASSIGN_FLAG_YES.equals(dto.getAssignFlag())){
						return new ActionForward("/IGDWP0106_Disp.do?planid=" + form.getId(),true);
					}else{
						return new ActionForward("/IGDWP0105_Disp.do?id=" + form.getId(),true);
					}
					}
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==============日常工作计划登记操作结束================");
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
