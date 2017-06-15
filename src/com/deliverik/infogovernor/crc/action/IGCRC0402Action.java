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
import com.deliverik.infogovernor.crc.form.IGCRC0402Form;
import com.deliverik.infogovernor.crc.vo.IGCRC04021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:变更批量处理Action 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0402Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCRC0402Action.class);
		//BL取得
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//实例化dto
		IGCRC04DTO dto = new IGCRC04DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		IGCRC0402Form form = (IGCRC0402Form) actionForm;
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========变更批量处理页面初始化操作开始===============");
			dto = ctlBL.initIGCRC0402Action(dto);
			//实例化vo
			IGCRC04021VO vo = new IGCRC04021VO();
			vo.setPrList(dto.getProcessList());
			super.<IGCRC04021VO>setVO(request, vo);
			saveToken(request);
			log.debug("===========变更批量处理页面初始化操作结束===============");
		}
		
		//变更批量处理操作
		if("DISPOSE".equals(mapping.getParameter())){
			log.debug("============变更批量处理操作开始=============");
			if(isTokenValid(request,true)){
				dto = ctlBL.disposeAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("============变更批量处理操作结束=============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		return mapping.findForward(form.getForward());
	}

}
