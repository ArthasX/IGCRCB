/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0216Form;
import com.csebank.lom.vo.IGLOM02161VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class IGLOM0216Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
		IGLOM0216Form form = (IGLOM0216Form) actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		if("SEARCH".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIglom0216Form(form);
			form.setGiodoutype("true");
			dto = ctlBL.searchGoodsIODetailAction(dto);
			//构造VO
			IGLOM02161VO vo = new IGLOM02161VO();
			vo.setGiostockdetailList(dto.getGIOStockDetailList());
			vo.setTotalStockNum(dto.getTotalStockNum());
			vo.setGname(dto.getGname());
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				req.setAttribute("vo", vo);			
				req.setAttribute("form", form);
				return mapping.findForward("REPORT");
			}
			super.<IGLOM02161VO>setVO(req, vo);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
