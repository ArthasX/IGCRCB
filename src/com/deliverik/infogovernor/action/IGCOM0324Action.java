/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0324Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资产管理_域拓扑图查看ACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGCOM0324Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0324Action.class);

	/**
	 * <p>
	 * Description:域拓扑图ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORM取得
		IGCOM0324Form form = (IGCOM0324Form)actionForm;
		
		// 获取BL接口实例
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		// 实例化DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		
		//DTO输入参数设定
		dto.setIgcom0324Form(form);
		// 选择域拓扑图查询
		log.debug("========域拓扑图查询处理开始========");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			//域拓扑图画面初期显示处理
			log.debug("========域拓扑图画面初期显示处理开始========");
			
			//域拓扑图画面初期显示逻辑调用
			dto = ctlBL.initIGCOM0324Action(dto);
			
			saveToken(request);
			log.debug("========域拓扑图画面初期显示处理终了========");
			
		}
		//页面显示信息设定
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
