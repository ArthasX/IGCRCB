/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1104Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据信息编辑画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1104Action.class);

	/**
	 * 数据信息编辑画面Action处理
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
		IGSYM1104Form form = (IGSYM1104Form)actionForm;
		
		//BL取得
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO生成
		IGSYM11DTO dto = new IGSYM11DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//数据信息登记画面初期显示处理
			log.debug("========数据信息登记画面初期显示处理开始========");
			req.setAttribute("IGSYM1104Form", form);
			form.setCid(null);
			addMessage(req, new ActionMessage("IGCO10000.I001","数据信息"));
			saveToken(req);
			log.debug("========数据信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//数据信息编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//数据信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回类型登记画面
					return mapping.findForward("BACK1");
				} else if (form.getRoute().equals("1")){
					//返回类型详细 画面
					return mapping.findForward("BACK2");
				}
			}
			if (form.getMode().equals("0")){
				//数据信息登记处理
				log.debug("========数据信息登记处理开始========");

				//DTO输入参数设定
				dto.setIgsym1104Form(form);
				
				if (isTokenValid(req, true)){
					//数据信息登记逻辑调用
					dto = ctlBL.insertCodeDetailAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========数据信息登记处理终了========");
				
				if (form.getRoute().equals("0")){
					forward = "DISP";
				} else if (form.getRoute().equals("1")){
					forward = "DETAIL";
				}

			} else {
				//数据信息变更处理
				log.debug("========数据信息变更处理开始========");

				//DTO输入参数设定
				dto.setIgsym1104Form(form);
				
				//数据信息变更逻辑调用
				dto = ctlBL.updateCodeDetailAction(dto);
				
				log.debug("========数据信息变更处理终了========");
				if("1".equals(form.getClevel())){
					forward = "BACK3";
				}else{
					forward = "BACK2";
				}
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//数据信息编辑画面初期处理
			log.debug("========数据信息编辑画面初期处理开始========");

			//DTO输入参数设定
			dto.setIgsym1104Form(form);
			
			//数据信息编辑画面初期处理逻辑调用
			dto = ctlBL.initIGSYM1104Action(dto);
			
			log.debug("========数据信息变更处理终了========");

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
