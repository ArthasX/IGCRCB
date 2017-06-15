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
import com.deliverik.infogovernor.dwp.vo.IGDWP01061VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划分派页面Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0106Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDWP0106Action.class);
		//BL取得
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//实例化dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//登录用户
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("============日常工作计划分派页面初始化操作开始============");
			dto = ctlBL.initDayWorkPlanAssignAction(dto);
			//实例化vo
			IGDWP01061VO vo = new IGDWP01061VO();
			vo.setAssignInfoMap(dto.getAssignInfoMap());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("============日常工作计划分派页面初始化操作结束============");
		}
		//分派操作
		if("ASSIGN".equals(mapping.getParameter())){
			log.debug("==============日常工作计划分派操作开始================");
			if (isTokenValid(request, true)){
				dto = ctlBL.saveAssignAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==============日常工作计划分派操作结束================");
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