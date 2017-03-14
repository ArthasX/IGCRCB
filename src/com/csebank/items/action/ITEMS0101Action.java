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
import com.csebank.items.form.ITEMS0101Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0101Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0101Form form = (ITEMS0101Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========类型查询处理开始========");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setItemsCategorySearchCond(form);
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			//调用BL查询
			dto = items01BL.searchItemsCategoryAction(dto);
			//构造VO
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setItemsCategoryList(dto.getItemsCategoryList());
			vo.setEditList(dto.getEditList());
			super.<ITEMS01011VO>setVO(req, vo);
			if(form.getPath() != null && form.getPath().equals("instock")){
				return mapping.findForward("SELECT");
			}
			
			log.debug("========类型查询处理终了========");
		} else if("CHANGE_STATUS".equals(mapping.getParameter())){
			dto.setItems0101form(form);
			items01BL.changeCategoryStatusAction(dto);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		return mapping.findForward("DISP");
	}
	
}
