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
import com.csebank.items.form.ITEMS0114Form;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0114Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0114Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0114Form form = (ITEMS0114Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
//		if(StringUtils.isNotEmpty(req.getParameter("seqcode"))){
//			//String seqcode = new String(req.getParameter("seqcode").getBytes("iso-8859-1"),"UTF-8");
//			form.setSeqcode(URLDecoder.decode(req.getParameter("seqcode"),"UTF-8"));
//		}
//		
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserorg(user.getOrgid());
		dto.setUser(user);
		dto.setCategory(form.getCategory());
		dto.setSeqcode(form.getSeqcode());
		
		getPaginDTO(req,"ITEMS0114");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");

		int maxCnt = getMaxDataCount("ITEMS0114");
		dto.setMaxSearchCount(maxCnt);
		dto.setPagingDto(pDto);
		dto = items01BL.searchInStockAction(dto);
		
		ITEMS01011VO vo = new ITEMS01011VO();
		vo.setInStockList(dto.getInStockList());
		super.<ITEMS01011VO>setVO(req, vo);
		return mapping.findForward("DISP");
		
	}
	
}
