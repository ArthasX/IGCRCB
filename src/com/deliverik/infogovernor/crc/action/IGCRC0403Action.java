/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

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
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0403Form;
import com.deliverik.infogovernor.crc.vo.IGCRC04031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0403Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCRC0403Action.class);
		//BL取得
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//实例化dto
		IGCRC04DTO dto = new IGCRC04DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//form取得
		IGCRC0403Form form = (IGCRC0403Form) actionForm;
		//dto参数取得
		dto.setUser(user);
		dto.setForm(form);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============变更批量分派页面初始化操作开始================");
			dto = ctlBL.initAssignPageAction(dto);
			//实例化dto
			IGCRC04031VO vo = new IGCRC04031VO();
			vo.setAssignInfo(dto.getAssignInfo());
			super.<IGCRC04031VO>setVO(request, vo);
			saveToken(request);
			log.debug("==============变更批量分派页面初始化操作结束================");
		}
		
		//分派操作
		if("ASSIGN".equals(mapping.getParameter())){
			log.debug("=============变更批量分派操作开始===============");
			if (isTokenValid(request, true)){
				dto = ctlBL.assignAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============变更批量分派操作结束===============");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}
