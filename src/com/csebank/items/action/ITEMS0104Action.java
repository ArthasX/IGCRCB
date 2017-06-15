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
import com.csebank.items.form.ITEMS0104Form;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0104Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0104Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws BLException {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		ITEMS0104Form form = (ITEMS0104Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			dto.setItemsCategory(form);
			//调用BL查询
			try {
				dto = items01BL.findItemsCategoryByPkAction(dto);
			} catch (BLException e) {
			}
			//构造VO
			//ITEMS01011VO vo = new ITEMS01011VO();
			form.setCategory(dto.getItemsCategory().getCategory());
			form.setSeqcode(dto.getItemsCategory().getSeqcode());
			form.setTypecode(dto.getItemsCategory().getTypecode());
			form.setType(dto.getItemsCategory().getType());
			form.setStatus(dto.getItemsCategory().getStatus());
			form.setDesc(dto.getItemsCategory().getDesc());
			form.setIcid(dto.getItemsCategory().getIcid());

			//vo.setItemsCategory(dto.getItemsCategory());
			//super.<ITEMS01011VO>setVO(req, vo);
		} else if("EDIT".equals(mapping.getParameter())){
			dto.setItemsCategory(form);
			//try {
				dto = items01BL.insertItemsCategoryAction(dto);
			//} catch (BLException e) {
			//	return mapping.findForward("ERROR");
			//}
//			if(dto == null){
//				return mapping.findForward("ERROR");
//			}
			dto.addMessage(new ActionMessage("IGCO00000.I002"));
		}
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}