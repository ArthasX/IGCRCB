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
import com.deliverik.infogovernor.form.IGCOM0308Form;
import com.deliverik.infogovernor.vo.IGCOM03081VO;

/**
 * 配置信息历史记录画面Action处理
 *
 */
public class IGCOM0308Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0308Action.class);
	
	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCOM0308Form form = (IGCOM0308Form)actionForm;
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//配置信息历史记录画面初期显示处理
			log.debug("========配置信息历史记录画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgcom0308Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGCOM0308Action(dto);
			
			
			//将配置信息历史记录检索结果设定到VO中
			IGCOM03081VO vo = new IGCOM03081VO(dto.getEntityItemVWInfoSOC(), dto.getConfigItemMapSOC());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCOM03081VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "TOPOLOGY_DISP".equals(mapping.getParameter())){
			
			log.debug("========配置信息画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgcom0308Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.showConfigAction(dto);
			
			//将配置信息历史记录检索结果设定到VO中
			IGCOM03081VO vo = new IGCOM03081VO(dto.getEntityItemVWInfoSOC(), dto.getConfigItemMapSOC());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCOM03081VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========配置信息画面初期显示处理终了========");
			return mapping.findForward("TOPOLOGY_DISP");
		}
		if ("BACK".equals(mapping.getParameter())) {
			//配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
	
	
}
