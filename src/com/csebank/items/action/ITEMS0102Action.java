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
import com.csebank.items.form.ITEMS0102Form;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0102Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS01DTO dto = new ITEMS01DTO();
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========类型新增处理开始========");
			ITEMS0102Form form = (ITEMS0102Form)actionForm;
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setItemsCategory(form);
			try {
				dto = items01BL.insertItemsCategoryAction(dto);
			} catch (BLException e) {
				return mapping.findForward("ERROR");
			}
//			if(dto == null){
//				return mapping.findForward("ERROR");
//			}
			dto.addMessage(new ActionMessage("ITEMS0101.I001","物品信息"));
			log.debug("========类型新增处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		return mapping.findForward("DISP");
	}
	
}