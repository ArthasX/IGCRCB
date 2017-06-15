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
import com.csebank.items.form.ITEMS0175Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0175Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0145Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//取得动态下拉
		req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		
		if( "DISP".equals(mapping.getParameter())){
		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			ITEMS0175Form form = (ITEMS0175Form)actionForm;
			form = (ITEMS0175Form) req.getSession().getAttribute("ITEMS0175Form");
			form.setCategory("");
			form.setTypecode_q("");
			return mapping.findForward("DISP");
			
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========下拨物品查询处理开始========");
			saveToken(req);
			ITEMS0175Form form = (ITEMS0175Form)actionForm;
			form = (ITEMS0175Form) req.getSession().getAttribute("ITEMS0175Form");

			dto.setItems0175form(form);
			dto.setCategory(form.getCategory());
			dto.setTypecode_q(form.getTypecode_q());//物品名称
			
			//调用BL查询
			//dto = items01BL.searchStockForOrgAction(dto);
			dto = items01BL.searchStockAction(dto, "");
			//构造VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setStockList(dto.getStockList());
			//ITEMS01081VO vo = new ITEMS01081VO();
			//vo.setItemsCategoryList(dto.getItemsCategoryList());
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========下拨物品查询处理终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========下拨物品'下拨'处理开始========");
			ITEMS0175Form form = (ITEMS0175Form)actionForm;
			dto.setOutstockorg(form.getOutstockorg());
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			dto.setStockid(form.getStockid());
			dto.setItems0175form(form);
			if(isTokenValid(req, true)){
			//调用BL
			dto = items01BL.doStock(dto,"orgOutStockAction");
			
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			if("XB_REQSTATUS_ERROR".equals(dto.getGoToError())){
				//页面提交记录的出库状态与数据库中记录的出库状态不一致
				saveToken(req);
				return mapping.findForward("XB_REQSTATUS_ERROR");//返回错误提示信息页
			}
			
			log.debug("========下拨物品'下拨'处理终了========");
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
