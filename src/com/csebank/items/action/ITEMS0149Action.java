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
import com.csebank.items.form.ITEMS0144Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0149Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0149Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS0144Form form = (ITEMS0144Form)actionForm;
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		req.setAttribute("reqstatus_options", items01BL.getPartItemsCodesFor0144(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS));
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========耗材通知查询处理开始========");
			
		
			dto.setOutstockorg(user.getOrgid());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());

			//获取分页Bean
			getPaginDTO(req,"ITEMS0173");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
				if ( form == null ) {
					form = new ITEMS0144Form();
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
					form = (ITEMS0144Form) req.getSession().getAttribute("ITEMS0144Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("ITEMS0173");
			
			//根据用户ID判断当前用户是否为耗材管理角色负责人
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
				//角色负责人默认为总行用户
				form.setFlag("1");		
			}else{
				//否则取用户所属机构
				if(!"admin".equals(user.getUserid()) && user.getOrgid().length()>=DefineUtils.ZONGH_ORGNO.length() && DefineUtils.ZONGH_ORGNO.equals(user.getOrgid().substring(0, DefineUtils.ZONGH_ORGNO.length()))){
					//总行用户
					form.setFlag("1");			
				}else if(!"admin".equals(user.getUserid()) && user.getOrgid().length()>=DefineUtils.ZHIH_ORGNO.length() && DefineUtils.ZHIH_ORGNO.equals(user.getOrgid().substring(0, DefineUtils.ZHIH_ORGNO.length()))){
					//支行用户
					form.setFlag("2");
				}else{
					form.setFlag("0");
				}
			}
			
			dto.setItems0144form(form);
			
			dto.setOutStockSearchVWCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		
			
			
			if(!"0".equals(form.getFlag())){
				//调用BL查询
				dto = items01BL.searchOutStockForNoticeAction(dto);
				//构造VO
				ITEMS01081VO vo = new ITEMS01081VO();
				vo.setOutStockList(dto.getOutStockList());
				super.<ITEMS01081VO>setVO(req, vo);
			}
			
			
			if("1".equals(form.getFlag()) && dto.getOutStockList()!=null && dto.getOutStockList().size()>0){
				addMessage(req, new ActionMessage("ITEMS0173.I001"));		
			}else if("2".equals(form.getFlag()) && dto.getOutStockList()!=null && dto.getOutStockList().size()>0){
				addMessage(req, new ActionMessage("ITEMS0173.I002"));
			}else{
				return mapping.findForward("IGCOM0212");
			}
			
			
			log.debug("========耗材通知查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		if("0".equals(form.getFlag())){
			return mapping.findForward("IGCOM0212");
		}else{
			return mapping.findForward("DISP");
		}
		
	}
	
}
