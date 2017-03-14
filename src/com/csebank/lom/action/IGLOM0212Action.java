/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0212Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02121VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class IGLOM0212Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
		IGLOM0212Form form = (IGLOM0212Form) actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			//分页信息
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0212Form) req.getSession().getAttribute("IGLOM0212Form");
				if ( form == null ) {
					form = new IGLOM0212Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0212Form) req.getSession().getAttribute("IGLOM0212Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			form.setGotype(CodeUtils.GOUTSTOCK_DESTROY);
			form.setGoorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
			dto.setGoutstockVWSearchCond(form);
			dto = ctlBL.searchGoutStockVWForDestroyAction(dto);
			
			//构造VO
			IGLOM02121VO vo = new IGLOM02121VO();
			vo.setGoutstockVWList(dto.getGoutstockVWList());
			super.<IGLOM02121VO>setVO(req, vo);
		} else if ("APPROVE".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIglom0212Form(form);
			dto = ctlBL.doStock(dto, "approveDestroyAction");
		} else if ("NOAPPROVE".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIglom0212Form(form);
			dto = ctlBL.doStock(dto, "noApproveDestroyAction");
		} 
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		req.setAttribute("gostatusList", LOMHelper.getItemsCodes(CodeUtils.OUTSTOCK_STATUS));
		return mapping.findForward("DISP");
	}
	
}
