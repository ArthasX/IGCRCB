/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR07BL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0701Form;
import com.deliverik.infogovernor.smr.vo.IGSMR04021VO;
import com.deliverik.infogovernor.smr.vo.IGSMR07011VO;

/**
 * 年报发起Action处理
 *
 */
public class IGSMR0701Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSMR0701Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGSMR0701Form form = (IGSMR0701Form)actionForm;
		
		//BL取得
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
		
		//DTO生成
		IGSMR07DTO dto = new IGSMR07DTO();
		
		IGSMR07011VO vo = new IGSMR07011VO();
		
		//DTO输入参数设定
		dto.setIgSMR0701Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//年报发起处理画面初期显示处理
			log.debug("========不定期报表发起页面显示处理开始========");
			//初始化获得不定期报表列表
			ctlBL.initSMR0701Action(dto);

			vo.setIg380List(dto.getIg380List());
			
			saveToken(req);
			
			super.<IGSMR07011VO>setVO(req, vo);
			log.debug("========不定期报表发起页面显示处理结束========");
		} else if( "INSERT".equals(mapping.getParameter())){
			//年报发起处理处理
			log.debug("========不定期报表发起处理开始========");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR0701Action(dto);//不定期报表发起
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========年报发起处理结束========");
			
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
		
}
