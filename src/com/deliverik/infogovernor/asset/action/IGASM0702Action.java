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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0702Form;
import com.deliverik.infogovernor.asset.vo.IGASM07021VO;

/**
 * 机房编辑画面Action处理
 *
 * @author
 */
public class IGASM0702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0702Action.class);

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
		IGASM0702Form form = (IGASM0702Form)actionForm;
		
		//BL取得
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO生成
		IGASM07DTO dto = new IGASM07DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//机房登记画面初期显示处理
			log.debug("========机房登记画面初期显示处理开始========");
			
			form = new IGASM0702Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			req.setAttribute("IGASM0702Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","机房基本信息"));
			log.debug("========机房登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//机房登记画面再显示处理
			log.debug("========机房登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========机房登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//机房编辑处理
			if (form.getMode().equals("0")){
				//机房登记处理
				log.debug("========机房登记处理开始========");

				//DTO输入参数设定
				dto.setIgasm0702Form(form);
				
				//机房信息登记逻辑调用
				dto = ctlBL.insertEntityItemAction(dto);
				
				//将登记完了的机房信息设定到VO中
				IGASM07021VO vo = new IGASM07021VO(dto.getIgasm0702Form());
				
				super.<IGASM07021VO>setVO(req.getSession(), vo);
				
				log.debug("========机房登记处理终了========");
				
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
