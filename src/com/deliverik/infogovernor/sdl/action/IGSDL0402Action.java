/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.infogovernor.sdl.bl.IGSDL04BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0402Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息新增修改ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0402Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0402Action.class);
	
	/**
	 * <p>
	 * Description: 信息新增修改action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSDL0402Form form = (IGSDL0402Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========信息新增画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I001","登记基本信息"));
			saveToken(request);
			log.debug("========信息新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSDL04BL ctlBL = (IGSDL04BL) getBean("igSDL04BL");
		//实例化DTO
		IGSDL04DTO dto = new IGSDL04DTO();
		String forward = "DISP";
		//信息新增
		if( "INSERT".equals(mapping.getParameter())){
			if ("1".equals(form.getMode())){
				//信息变更
				log.debug("========信息变更处理开始========");
				dto.setSdlInfo(form);
				//调用BL变更
				dto = ctlBL.updateSdlInfoAction(dto);
				forward = "DETAIL";
				log.debug("========信息变更处理终了========");
			} else {
				log.debug("========信息新增处理开始========");
				dto.setSdlInfo(form);
				if (isTokenValid(request, true)){
					//调用BL新增
					dto = ctlBL.insertSdlInfoAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========信息新增处理终了========");
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========信息变更初期显示处理开始========");
			//
			dto.setIgsdl0402Form(form);
			dto = ctlBL.initSdlInfoAction(dto);
			log.debug("========信息变更初期显示处理终了========");
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
