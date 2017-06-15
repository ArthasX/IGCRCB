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
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.form.ITEMS0141Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0141Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0141Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		String requestStatus = 
			items01BL.getRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS);
		if(DefineUtils.ITEMSCODES_REQUEST_TRUE.equals(requestStatus)){
			req.setAttribute("isDisabled", "");
			req.setAttribute("canSearch", "查询");
			req.setAttribute("message", "申领物品");
		} else if(DefineUtils.ITEMSCODES_REQUEST_FALSE.equals(requestStatus)){
			req.setAttribute("isDisabled", "true");
			req.setAttribute("canSearch", "当前申领功能已经关闭");
			req.setAttribute("message", "当前申领功能已经关闭");
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========物品申领查询初始化处理开始========");
			saveToken(req);
			log.debug("========物品申领查询初始化处理终了========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========物品申领查询处理开始========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//返回页.do
				form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
			}
			//获取分页Bean
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
				if ( form == null ) {
					form = new ITEMS0106Form();
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
					form = (ITEMS0106Form) req.getSession().getAttribute("ITEMS0106Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setItems0106form(form);
			//dto.setStockSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setCategory(form.getCategory());
			dto.setTypecode_q(form.getTypecode_q());//物品名称
			dto.setStockorg_q(DefineUtils.DEFAULT_ORGNO);//设置默认机构号为总行机构号
			//调用BL查询
			dto = items01BL.searchStockForInsertOutStockAction(dto);
			//构造VO
			
//			String requestStatus = 
//				items01BL.getRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS);
//			if(DefineUtils.ITEMSCODES_REQUEST_TRUE.equals(requestStatus)){
//				req.setAttribute("isDisabled", "");
//				req.setAttribute("canSearch", "查询");
//				req.setAttribute("message", "申领物品");
//			} else if(DefineUtils.ITEMSCODES_REQUEST_FALSE.equals(requestStatus)){
//				req.setAttribute("isDisabled", "true");
//				req.setAttribute("canSearch", "当前申领功能已经关闭");
//				req.setAttribute("message", "当前申领功能已经关闭");
//			}
			
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setItemsCategoryList(dto.getItemsCategoryList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========物品申领查询处理终了========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========物品申领查看详细处理开始========");
			saveToken(req);
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			dto.setStockid(Integer.valueOf(form.getSid()));
			//调用BL查询
			dto = items01BL.searchStockDetailAction(dto);
			
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStock(dto.getStock());
			super.<ITEMS01081VO>setVO(req, vo);
			log.debug("========物品申领查看详细处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========申领物品处理开始========");
			ITEMS0141Form form = (ITEMS0141Form)actionForm;
			
			
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			dto.setItems0141form(form);
			
			//调用BL
			if(isTokenValid(req, true)){
				dto = items01BL.doStock(dto,"insertOutStockAction");
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========申领物品处理终了========");
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
