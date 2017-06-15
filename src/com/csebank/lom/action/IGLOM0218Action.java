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
import com.csebank.lom.form.IGLOM0218Form;
import com.csebank.lom.vo.IGLOM02181VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class IGLOM0218Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
		IGLOM0218Form form = (IGLOM0218Form) actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		if("SEARCH".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIglom0218Form(form);
			form.setGiodoutype("true");
			//分页信息
			getPaginDTO(req,"DEFAULT");
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("DEFAULT");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchGoodsIODetail0218Action(dto);
			//构造VO
			IGLOM02181VO vo = new IGLOM02181VO();
			vo.setGiostockdetailList(dto.getGIOStockDetailList());
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				pDto.setFromCount(0);
				pDto.setPageDispCount(0);
				dto.setPagingDto(pDto);
				dto = ctlBL.searchGoodsIODetail0218Action(dto);
				vo.setGiostockdetailList(dto.getGIOStockDetailList());
				req.setAttribute("vo", vo);			
				req.setAttribute("form", form);
				this.setPaginDTO(req, null);
				return mapping.findForward("REPORT");
			}
			super.<IGLOM02181VO>setVO(req, vo);
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
