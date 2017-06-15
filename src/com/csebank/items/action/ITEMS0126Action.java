/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.ArrayList;
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

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0126Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0126Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0126Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0126Form form = (ITEMS0126Form)actionForm;

		if("SEARCH".equals(mapping.getParameter())){
			ArrayList<String> outtypelist = new ArrayList<String>();
			outtypelist.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);
			outtypelist.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);
			outtypelist.add(DefineUtils.ITEMSCODES_OUTTYPE_SY);//使用
			form.setOuttypelist(outtypelist);
			form.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			form.setReqstatusa(DefineUtils.ITEMSCODES_REQSTATUS_DJS);
			ITEMS01DTO dto = new ITEMS01DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			
			//分页信息
			getPaginDTO(req,"ITEMS0126");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0126");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto.setOutStockSearchCond(form);
			dto = items01BL.searchOutStockAction(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setOutStockList(dto.getOsList());
			vo.setEditMap(dto.getEditMap());
			super.<ITEMS01011VO>setVO(req, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			//根据结账状态来判断查询条件
//			if(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ.equals(form.getAccountstatus())){
//				req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
//				req.setAttribute("accountstatusList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS));
//				if(StringUtils.isNotEmpty(req.getParameter("report"))) {
//					pDto.setFromCount(0);
//					pDto.setPageDispCount(0);
//					dto.setPagingDto(pDto);
//					dto = items01BL.searchOutStockAction(dto);
//					vo.setOutStockList(dto.getOsList());
//					vo.setEditMap(dto.getEditMap());
//					req.setAttribute("vo", vo);
//					req.setAttribute("form", form);
//					return mapping.findForward("REPORT");
//				}
//				return mapping.findForward("VIEW"); 
//			}
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				pDto.setFromCount(0);
				pDto.setPageDispCount(0);
				dto.setPagingDto(pDto);
				dto = items01BL.searchOutStockAction(dto);
				vo.setOutStockList(dto.getOsList());
				vo.setEditMap(dto.getEditMap());
				req.setAttribute("vo", vo);
				req.setAttribute("form", form);
				this.setPaginDTO(req, null);
				return mapping.findForward("REPORT");
			}
			
		} else if("PAY".equals(mapping.getParameter())){
			ITEMS01DTO dto = new ITEMS01DTO();
			dto.setItems0126form(form);
			items01BL.doStock(dto, "payAction");
		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		req.setAttribute("accountstatusList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS));
		if(StringUtils.isNotEmpty(req.getParameter("report"))) {
			return mapping.findForward("REPORT");
		}
		
		return mapping.findForward("DISP");
		
	}
	
}
