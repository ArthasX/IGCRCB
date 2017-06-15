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

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1112Form;

/**
 * 机柜编辑画面Action处理
 *
 * @author
 */
public class IGASM1112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1112Action.class);

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
		IGASM1112Form form = (IGASM1112Form)actionForm;
		
		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		//画面跳转设定
		String forward = null;

		if ( "DISP".equals(mapping.getParameter())) {
			//机柜登记画面初期显示处理
			log.debug("========机柜登记画面初期显示处理开始========");
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			addMessage(req, new ActionMessage("IGCO10000.I001","机柜信息"));
			log.debug("========机柜登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}

		if( "INSERT".equals(mapping.getParameter())){
			//机柜编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//机柜编辑画面按下返回按钮时的返回处理
				if (form.getMode().equals("1")){
					//返回机房列表画面
					return mapping.findForward("BACK");
				}
			}
			if (form.getMode().equals("0")){
				//机柜登记处理
				log.debug("========机柜登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgasm1112Form(form);
				
				//机柜信息登记逻辑调用
				dto = ctlBL.insertComputerContainerInfoAction(dto);
				
				log.debug("========机柜登记处理终了========");
				
				forward = "DISP";

			} else {
				//机柜变更处理
				log.debug("========机柜变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgasm1112Form(form);
				
				//机柜变更逻辑调用
				dto = ctlBL.updateComputerContainerAction(dto);
				
				log.debug("========机柜变更处理终了========");
				
				forward = "BACK";
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========机柜信息变更初期显示处理开始========");
			dto.setIgasm1112Form(form);
			
			dto = ctlBL.initIGASM1112Action(dto);
			if(EntityItemKeyWords.VALUE_PULLDOWN.equals(dto.getIgasm1112Form().getEimark()))
			{
				form.setJilabel(dto.getIgasm1112Form().getEilabel());
				form.setJidesc(dto.getIgasm1112Form().getEidesc());
				form.setJiname(dto.getIgasm1112Form().getEiname());
				form.setJ_total(dto.getIgasm1112Form().getU_total());
			}
			log.debug("========机柜信息变更初期显示处理终了========");

			forward = "DISP";
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
