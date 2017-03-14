package com.deliverik.infogovernor.cic.action;

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
import com.deliverik.infogovernor.cic.bl.IGCIC01BL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0102Form;
import com.deliverik.infogovernor.cic.vo.IGCIC01021VO;

/**
 * @Description: 对比规则相关 业务  Action处理
 * @Author  zhangjian
 * @History 2014-04-22     新建
 */
public class IGCIC0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIC0102Action.class);

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
		
		IGCIC0102Form form = (IGCIC0102Form)actionForm;
		
		IGCIC01BL ctlBL = (IGCIC01BL)getBean("igcic01BL");
		
		IGCIC01DTO dto = new IGCIC01DTO();
		
		
		ctlBL.getSystemList(dto);
		
		IGCIC01021VO vo = new IGCIC01021VO();
		
		vo.setSystemList(dto.getSystemList());
		
		if("DISP".equals(mapping.getParameter())){
			String crid = req.getParameter("crid");
			if(StringUtils.isNotEmpty(crid)){
			if(form==null){
				form = new IGCIC0102Form();
				form.setCrid(Integer.valueOf(crid));
				dto.setIgcic0102Form(form);
				
				ctlBL.loadCompareRoleInfo(dto);
				
				vo.setCompareRoleInfo(dto.getCompareRoleInfo());
				
				vo.setCompareObjectListJson(dto.getCompareObjectListJson());
				
				vo.setSourceHostList(dto.getSourceHostList());
				
				vo.setTargetHostList(dto.getTargetHostList());
//				req.setAttribute("IGCIC0102FORM", form);
			}
			}
		}else if("SEARCH".equals(mapping.getParameter())){

			
			
		}else if("EDIT".equals(mapping.getParameter())){
			
		}else if("INSERT".equals(mapping.getParameter())){
			
			dto.setIgcic0102Form(form);
			
			ctlBL.insertIgcic0102Action(dto);
			
			req.getSession().removeAttribute("IGCIC0102Form");
			
		}else if("DELETE".equals(mapping.getParameter())){
		}
		
		super.<IGCIC01021VO>setVO(req, vo);
		
		
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
