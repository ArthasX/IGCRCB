package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0161Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01611VO;

/**
 * 流程状态基本信息编辑画面Action处理
 *
 */
public class IGPRD0161Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0161Action.class);

	/**
	 * 流程状态处理
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
		IGPRD0161Form form = new IGPRD0161Form();
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		IGPRD01DTO dto =new IGPRD01DTO();
		
		//画面跳转设定
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			
			//流程外部调用信息登记画面初期显示处理
			log.debug("========流程外部调用信息登记画面初期显示处理开始========");
			if(StringUtils.isEmpty(form.getMode())){
				form.setMode("0");
			}
			
		 	req.setAttribute("IGPRD0161Form", form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","流程外部调用基本信息"));
			
			log.debug("========流程外部调用信息登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		}else if( "DISP1".equals(mapping.getParameter())){
			
			//流程外部调用信息登记画面初期显示处理
			log.debug("========流程外部调用信息登记画面初期显示处理开始========");
			
				form.setMode("0");
			
			
		 	req.setAttribute("IGPRD0161Form", form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","流程外部调用基本信息"));
			
			log.debug("========流程外部调用信息登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		} else if ("Update".equals(mapping.getParameter())) {
			IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			
			dto.setIgPRD0161Form(form1);
			  
			dto = ctlBL.searchProcessExternalDefByPK(dto);
			form1.setMode("1");
				//将变量信息检索结果设定到VO中				

			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========前后处理画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ("INSERT".equals(mapping.getParameter())){
			IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			dto.setIgPRD0161Form(form1);
			 if(form1.getMode().equals("1")){
				 dto = ctlBL.updateProcessExternalDefAction(dto); 
				 addMessage(req, new ActionMessage("IGDAF0304.I001"));
			 }
			 else{
				 if (isTokenValid(req, true)){
					//调用BL新增
					dto = ctlBL.insertProcessExteralDefAction(dto);
					addMessage(req, new ActionMessage("IGDAF0303.I001"));
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			 }	
			//req.setAttribute("Pedeventid", form1.getPedeventid());
			//req.setAttribute("Pedaction", form1.getPedaction());
		//	req.setAttribute("Peddesc", form1.getPeddesc());
			req.setAttribute("form", form1);
			
			log.debug("========按钮事件画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if ("Delete".equals(mapping.getParameter())) {
            IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			dto.setIgPRD0161Form(form1);
			dto = ctlBL.deleteProcessExternalDefAction(dto);
				

			addMessage(req, new ActionMessage("IGDAF0302.I001"));
			log.debug("========外部事件画面初期显示处理终了========");
			return mapping.findForward("DISP");
	  }else if ("LIST".equals(mapping.getParameter())) {
			//IGPRD0158Form form1 = (IGPRD0158Form)actionForm;
			//dto.setIgPRD0158Form(form1);
			//将变量信息检索结果设定到VO中
			dto = ctlBL.searchProcessExternalDefAction(dto);		
     		IGPRD01611VO vo = new IGPRD01611VO(dto.getProcessExternalDefList());
		
                	super.<IGPRD01611VO>setVO(req, vo); 
			
	//		req.setAttribute("pdid", form.getPdid());
	//		req.setAttribute("psdid", form.getPsdid());
	//  	req.setAttribute("psdcode", form.getPsdcode());
	//	    req.setAttribute("form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========外部事件画面初期显示处理终了========");
			return mapping.findForward("DISP");
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
