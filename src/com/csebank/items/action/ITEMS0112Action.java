/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0112Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0112Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0112Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			ITEMS0112Form form = (ITEMS0112Form)actionForm;
			ITEMS01DTO dto = new ITEMS01DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			//分页信息
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0112Form) req.getSession().getAttribute("ITEMS0112Form");
				if ( form == null ) {
					form = new ITEMS0112Form();
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
					form = (ITEMS0112Form) req.getSession().getAttribute("ITEMS0112Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto.setCategory(form.getCategory());
			dto.setSeqcode(form.getSeqcode());
			dto.setItemsname(form.getItemsname());
			//dto.setStockorg_q(form.getStockorg_q());
			//调用BL查询
			
			dto.setStockorg_q(user.getOrgid());
			dto = items01BL.searchStockAction(dto);
			//构造VO
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setStockList(dto.getStockList());
			super.<ITEMS01011VO>setVO(req, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
//		req.setAttribute("outStockList", items01BL.getPartOutStockTypeCodes(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE));
		return mapping.findForward("DISP");
		
	}
	
}