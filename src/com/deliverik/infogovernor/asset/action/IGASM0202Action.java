package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0202Form;
import com.deliverik.infogovernor.asset.vo.IGASM02021VO;

/**
 * 配置项编辑画面Action处理
 *
 * @author
 */
public class IGASM0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0202Action.class);

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
		IGASM0202Form form = (IGASM0202Form)actionForm;
		
		//BL取得
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO生成
		IGASM02DTO dto = new IGASM02DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//配置项登记画面初期显示处理
			log.debug("========配置项登记画面初期显示处理开始========");
			form = new IGASM0202Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			req.setAttribute("IGASM0202Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","配置项基本信息"));
			log.debug("========配置项登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//配置项登记画面再显示处理
			log.debug("========配置项登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========配置项登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//配置项编辑处理
			if (form.getMode().equals("0")){
				//配置项登记处理
				log.debug("========配置项登记处理开始========");
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO输入参数设定
				dto.setIgasm0202Form(form);
				
				//配置项信息登记逻辑调用
				dto = ctlBL.insertEntityItemAction(dto);
				
				//将登记完了的配置项信息设定到VO中
				IGASM02021VO vo = new IGASM02021VO(dto.getIgasm0202Form());
				
				super.<IGASM02021VO>setVO(req.getSession(), vo);
				
				log.debug("========配置项登记处理终了========");
				
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
