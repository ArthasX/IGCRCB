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
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0111Form;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0111Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0111Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0111Form form = (ITEMS0111Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH".equals(mapping.getParameter())){
			saveToken(req);
			dto.setCategory(form.getCategory());
			dto.setSeqcode(form.getSeqcode());
			//分页信息
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			try {
				dto = items01BL.searchInStockAction(dto);
			} catch (BLException e) {
			}
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setInStockList(dto.getInStockList());
			super.<ITEMS01011VO>setVO(req, vo);
		} else if("ADJUST".equals(mapping.getParameter())){
			
			form.setUserid(user.getUserid());
			form.setUsername(user.getUsername());
			dto.setItems0111form(form);
			try {
				if(isTokenValid(req, true)){
					dto = items01BL.doStock(dto, "adjustStockAction");
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			} catch (BLException e) {
				return mapping.findForward("ERROR");
			}
//			if(null == dto){
//				return mapping.findForward("ERROR");
//			}
		}
		return mapping.findForward("DISP");
	}
	
}