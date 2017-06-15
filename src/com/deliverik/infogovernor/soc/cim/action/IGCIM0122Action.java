package com.deliverik.infogovernor.soc.cim.action;

import java.util.Date;
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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0122Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01221VO;

/**
 * 应用编辑画面Action处理
 *
 * @author
 */
public class IGCIM0122Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0122Action.class);

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
		IGCIM0122Form form = (IGCIM0122Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//应用登记画面初期显示处理
			log.debug("========应用登记画面初期显示处理开始========");
			form = new IGCIM0122Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			dto.setIgasm0802Form(form);
			
			dto = ctlBL.searchEntityItemLableActionApp(dto);			
			
			req.setAttribute("IGCIM0122Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","应用基本信息"));
			log.debug("========应用登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//应用登记画面再显示处理
			log.debug("========应用登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========应用登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//应用编辑处理
			if (form.getMode().equals("0")){
				//应用登记处理
				log.debug("========应用登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO输入参数设定
				dto.setIgasm0802Form(form);
				
				//应用信息登记逻辑调用
				dto = ctlBL.insertEntityItemActionApp(dto);
				
				//将登记完了的应用信息设定到VO中
				IGCIM01221VO vo = new IGCIM01221VO(dto.getIgasm0802Form());
				
				super.<IGCIM01221VO>setVO(req.getSession(), vo);
				
				log.debug("========应用登记处理终了========");
				
				forward = "DISP";

			}
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
