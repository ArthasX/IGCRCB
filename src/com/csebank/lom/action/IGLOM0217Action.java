/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0217Form;
import com.csebank.lom.vo.IGLOM02171VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class IGLOM0217Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
			IGLOM0217Form form = (IGLOM0217Form) actionForm;
			IGLOM02DTO dto = new IGLOM02DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			
			//分页信息
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0217Form) req.getSession().getAttribute("IGLOM0217Form");
				if ( form == null ) {
					form = new IGLOM0217Form();
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
					form = (IGLOM0217Form) req.getSession().getAttribute("IGLOM0217Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//form.setGotype(IGLOMCONSTANTS.GIODTYPE_LY);
			List<String> gotypeList = new ArrayList<String>();
			gotypeList.add(IGLOMCONSTANTS.GIODTYPE_LY);//领用
			gotypeList.add(IGLOMCONSTANTS.GIODTYPE_TJ);//调剂
			form.setGotypeList(gotypeList);//出库类型
			form.setGoorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
			dto.setGoutstockSearchCond(form);
			dto = ctlBL.searchGoutStockAction(dto);
			//构造VO
			IGLOM02171VO vo = new IGLOM02171VO();
			vo.setGoutstockList(dto.getGoutstockTBList());
			if(StringUtils.isNotEmpty(req.getParameter("report")) && "1".equals(req.getParameter("report"))) {
				pDto.setFromCount(0);
				pDto.setPageDispCount(0);
				dto.setPagingDto(pDto);
				vo.setGoutstockList(dto.getGoutstockTBListall());
				req.setAttribute("vo", vo);			
				req.setAttribute("form", form);
				this.setPaginDTO(req, null);
				return mapping.findForward("REPORT");
			}
			super.<IGLOM02171VO>setVO(req, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		} 
		return mapping.findForward("DISP");
	}
	
}
