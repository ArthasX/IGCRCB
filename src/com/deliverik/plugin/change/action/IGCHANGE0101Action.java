package com.deliverik.plugin.change.action;

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
import com.deliverik.infogovernor.cic.vo.IGCIC01011VO;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;
import com.deliverik.plugin.change.form.IGCHANGE0101Form;

/**
 * @Description:  Action处理
 * @Author  dinghaonan@deliverik.com
 * @History 2014-04-22     新建
 */
public class IGCHANGE0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCHANGE0101Action.class);

	/**
	 * 发起变更流程日志
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
		
		
		IGCHANGE0101Form form =(IGCHANGE0101Form) actionForm;
		
		IGCHANGE01BLImpl ctlBL = (IGCHANGE01BLImpl)getBean("iGCHANGE01BLImpl");
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCHANGE01DTO dto = new IGCHANGE01DTO();
		
		//ctlBL.getSystemList(dto);
		
		IGCIC01011VO vo = new IGCIC01011VO();
		
		
		if("DISP".equals(mapping.getParameter())){
			
			
			
		}else if("SEARCH".equals(mapping.getParameter())){
			dto.setIcid(req.getParameter("icid"));
			dto.setIgchange0101Form(form);
			ctlBL.registIGCHANGEAction(dto,null);
			//ctlBL.searchCompareRoleList(dto);
			
			
			
		}else if("EDIT".equals(mapping.getParameter())){
			
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
