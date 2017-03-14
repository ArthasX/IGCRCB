/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

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
import com.deliverik.infogovernor.prd.form.IGPRD0141Form;
import com.deliverik.infogovernor.prd.vo.IGPRD0141VO;

/**
 * 变量查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0141Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0141Action.class);

	/**
	 * 变量查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRD0141Form form = (IGPRD0141Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//按钮事件定义添加查询画面初期显示处理		
		log.debug("========按钮事件定义画面初期显示处理开始========");		
		dto.setIgPRD0141Form(form);
	
		if ("Disp".equals(mapping.getParameter())) {		 
			dto = ctlBL.searchProcessButtonDef(dto);
			IGPRD0141VO vo = new IGPRD0141VO();
			vo.setProcessButtonDefList(dto.getProcessButtonDefList());
			super.<IGPRD0141VO>setVO(req, vo);
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());	
			req.setAttribute("psdcode", form.getPsdcode());
			req.setAttribute("form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========按钮事件画面初期显示处理终了========");
		 }else if ("List".equals(mapping.getParameter())) {
		  		
				//将变量信息检索结果设定到VO中
				dto = ctlBL.searchProcessStatusButtonDefAction(dto);		
				IGPRD0141VO vo = new IGPRD0141VO();
				vo.setProcessStatusButtonDefList(dto.getProcessStatusButtonDefList());
				super.<IGPRD0141VO>setVO(req, vo);
				req.setAttribute("pdid", form.getPdid());
				req.setAttribute("psdid", form.getPsdid());
				req.setAttribute("psdcode", form.getPsdcode());
				req.setAttribute("form", form);
				addMessage(req, new ActionMessage("IGCO10000.I003"));
				log.debug("========按钮事件画面初期显示处理终了========");
		  }
		 else if ("Insert".equals(mapping.getParameter())) {
			 
			 if(form.getMode().equals("1")){
				 dto = ctlBL.updateProcessStatusButtonDefAction(dto); 
			 }
			 else{
				 if (isTokenValid(req, true)){
					//调用BL新增
					dto = ctlBL.insertProcessStatusButtonDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			 }	
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("psdcode", form.getPsdcode());
			req.setAttribute("form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========按钮事件画面初期显示处理终了========");
		 }else if ("Update".equals(mapping.getParameter())) {
			  
			dto = ctlBL.searchProcessStatusButtonDefByPK(dto);
			dto = ctlBL.searchProcessButtonDef(dto);
			IGPRD0141VO vo = new IGPRD0141VO();
			vo.setProcessButtonDefList(dto.getProcessButtonDefList());
			super.<IGPRD0141VO>setVO(req, vo);
			form.setMode("1");
				//将变量信息检索结果设定到VO中				
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("psdcode", form.getPsdcode());
			req.setAttribute("form", form);	
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========前后处理画面初期显示处理终了========");
		}else if ("Delete".equals(mapping.getParameter())) {
			  
			dto = ctlBL.deleteProcessStatusButtonDefAction(dto);
				
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("psdcode", form.getPsdcode());
			req.setAttribute("form", form);	
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========前后处理画面初期显示处理终了========");
	  }
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//历史版本下的查看
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward("DISP");
	}
}
