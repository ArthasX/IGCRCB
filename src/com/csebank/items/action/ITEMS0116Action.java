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
import com.csebank.items.form.ITEMS0116Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;

public class ITEMS0116Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0116Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp)throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0116Form form = (ITEMS0116Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH".equals(mapping.getParameter())){
			saveToken(req);
			String orgid=ResourceUtility.getString("XB_ORG");
			dto.setCategory(form.getCategory());
			dto.setSeqcode(form.getSeqcode());
			dto.setUserorg(user.getOrgid());
			dto.setUser(user);
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(orgid.equals(user.getOrgid())||flag){
				req.setAttribute("updateOrg","Y");
			}else{
				req.setAttribute("updateOrg","N");
			}
			getPaginDTO(req,"ITEMS0116");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");

			int maxCnt = getMaxDataCount("ITEMS0116");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setShowNoneStock(false);
			if(form.getOuttype().equals(DefineUtils.ITEMSCODES_OUTTYPE_SY)){//查询使用
				try {
					dto = items01BL.searchInStockAction(dto);
				} catch (BLException e) {
				}
				ITEMS01011VO vo = new ITEMS01011VO();
				vo.setInStockList(dto.getInStockList());
				super.<ITEMS01011VO>setVO(req, vo);
				return mapping.findForward("SY");
			} else if(form.getOuttype().equals(DefineUtils.ITEMSCODES_OUTTYPE_SH)){//查询损耗
				try {
					dto = items01BL.searchInStockAction(dto);
				} catch (BLException e) {
				}
				ITEMS01011VO vo = new ITEMS01011VO();
				vo.setInStockList(dto.getInStockList());
				super.<ITEMS01011VO>setVO(req, vo);
				return mapping.findForward("SH");
			} else if(form.getOuttype().equals(DefineUtils.ITEMSCODES_OUTTYPE_XH)){//查询销毁
				try {
					dto = items01BL.searchInStockAction(dto);
//					dto = items01BL.searchCanDestroyAction(dto);
				} catch (BLException e) {
				}
				ITEMS01011VO vo = new ITEMS01011VO();
				vo.setInStockList(dto.getInStockList());
				super.<ITEMS01011VO>setVO(req, vo);
				return mapping.findForward("XH");
			}
		} else if("USE".equals(mapping.getParameter())){
			
			form.setUserid(user.getUserid());
			form.setUsername(user.getUsername());
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
				dto.setUserorg(DefineUtils.DEFAULT_ORGNO);
			}else{
				dto.setUserorg(user.getOrgid());
			}
			
			dto.setItems0116form(form);
			try {
				if(isTokenValid(req, true)){
					dto = items01BL.doStock(dto, "useItemsAction");
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			} catch (BLException e) {
				return mapping.findForward("ERROR");
			}
		} else if("WASTE".equals(mapping.getParameter())){
			form.setUserid(user.getUserid());
			form.setUsername(user.getUsername());
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
				dto.setUserorg(DefineUtils.DEFAULT_ORGNO);
			}else{
				dto.setUserorg(user.getOrgid());
			}
			dto.setItems0116form(form);
			try {
				if(isTokenValid(req, true)){
					dto = items01BL.doStock(dto, "wasteItemsAction");
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			} catch (BLException e) {
				return mapping.findForward("ERROR");
			}
		} else if("DESTROY".equals(mapping.getParameter())){
			form.setUserid(user.getUserid());
			form.setUsername(user.getUsername());
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
				dto.setUserorg(DefineUtils.DEFAULT_ORGNO);
			}else{
				dto.setUserorg(user.getOrgid());
			}
			dto.setItems0116form(form);
			try {
				if(isTokenValid(req, true)){
					dto = items01BL.doStock(dto, "destroyItemsAction");
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			} catch (BLException e) {
				return mapping.findForward("ERROR");
			}
		}
		
		return mapping.findForward("DISP");
		
	}
	
}