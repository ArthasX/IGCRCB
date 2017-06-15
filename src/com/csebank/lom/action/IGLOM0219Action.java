/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.ArrayList;
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
import com.csebank.lom.form.IGLOM0219Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02191VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class IGLOM0219Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
		IGLOM0219Form form = (IGLOM0219Form) actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		List<String> gouttypeList = new ArrayList<String>();
		gouttypeList.add("1");
		gouttypeList.add("2");
		getPaginDTO(req,"ITEMS0106");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
		if(form.getGotype() == null || "".equals(form.getGotype())) {
			form.setGotypeList(gouttypeList);
		}
		if("SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			//分页信息
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0219Form) req.getSession().getAttribute("IGLOM0219Form");
				if ( form == null ) {
					form = new IGLOM0219Form();
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
					form = (IGLOM0219Form) req.getSession().getAttribute("IGLOM0219Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGLOM0219");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			form.setGiodtype(CodeUtils.GIODTYPE_INSTOCK);
			form.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
			dto.setGoutstockSearchCond(form);
			dto = ctlBL.searchGoutStockAction(dto);
			
			//构造VO
			IGLOM02191VO vo = new IGLOM02191VO();
			vo.setGoutstockList(dto.getGoutstockTBList());
			//this.setPaginDTO(req, null);
			super.<IGLOM02191VO>setVO(req, vo);
		}else if("EXPORT".equals(mapping.getParameter())){
			int maxCntExport = getMaxDataCount("IGLOM0219");
			dto.setMaxSearchCount(maxCntExport);
			dto.setGoutstockSearchCond(form);
//			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//pDto.setFromCount(0);
			//pDto.setPageDispCount(0);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchGoutStockAction(dto);
			
			IGLOM02191VO vo = new IGLOM02191VO();
			vo.setGoutstockList(dto.getGoutstockTBList());
			
			req.setAttribute("vo", vo);			
			req.setAttribute("form", form);
			return mapping.findForward("DISP");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		req.setAttribute("outstock_type", LOMHelper.getItemsCodes(CodeUtils.OUTSTOCK_TYPE));
		return mapping.findForward("DISP");
	}
	
}

