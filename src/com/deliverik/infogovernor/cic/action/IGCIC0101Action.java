package com.deliverik.infogovernor.cic.action;

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
import com.deliverik.infogovernor.cic.bl.IGCIC01BL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0101Form;
import com.deliverik.infogovernor.cic.vo.IGCIC01011VO;

/**
 * @Description: 对比规则相关 业务  Action处理
 * @Author  zhangjian
 * @History 2014-04-22     新建
 */
public class IGCIC0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIC0101Action.class);

	/**
	 * 处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		IGCIC0101Form form = (IGCIC0101Form)actionForm;
		
		IGCIC01BL ctlBL = (IGCIC01BL)getBean("igcic01BL");
		
		IGCIC01DTO dto = new IGCIC01DTO();
		
		ctlBL.getSystemList(dto);
		
		IGCIC01011VO vo = new IGCIC01011VO();
		
		vo.setSystemList(dto.getSystemList());
		
		if("DISP".equals(mapping.getParameter())){
			
		}else if("SEARCH".equals(mapping.getParameter())){
			
			if(req.getParameter("flagurl")!=null){
				form = new IGCIC0101Form();
				req.setAttribute("flagurl", true);
				
			}
			
			dto.setIgcic0101Form(form);
			
			ctlBL.searchCompareRoleList(dto);
			
			
			vo.setCrList(dto.getCrList());
			
			
		}else if("EDIT".equals(mapping.getParameter())){
			
		}else if("INSERT".equals(mapping.getParameter())){
			
		}else if("DELETE".equals(mapping.getParameter())){
			form.setCrid(Integer.valueOf(req.getParameter("crid")));
			dto.setIgcic0101Form(form);
			ctlBL.delCompareRole(dto);
		}
		
		super.<IGCIC01011VO>setVO(req, vo);
		
		
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
