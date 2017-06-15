/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0110Form;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0110Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0110Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0110Form form = (ITEMS0110Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			dto.setCategory(form.getCategory());
			dto.setSeqcode(form.getSeqcode());
			
			getPaginDTO(req,"ITEMS0110");
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0110Form) req.getSession().getAttribute("ITEMS0110Form");
				if ( form == null ) {
					form = new ITEMS0110Form();
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
					form = (ITEMS0110Form) req.getSession().getAttribute("ITEMS0110Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("ITEMS0110");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = items01BL.searchInStockAction(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setInStockList(dto.getInStockList());
			vo.setEditMap(dto.getEditMap());
			super.<ITEMS01011VO>setVO(req, vo);
		} else if("EDIT".equals(mapping.getParameter())){
			dto.setItems0110form(form);
			dto = items01BL.doStock(dto, "editInStockAction");
		}
	
		return mapping.findForward("DISP");
		
	}
	
}
