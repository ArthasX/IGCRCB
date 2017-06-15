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
import com.csebank.items.form.ITEMS0121Form;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0121Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0121Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS0121Form form = (ITEMS0121Form)actionForm;
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		boolean flag = items01BL.checkRoleManagerByUserID(dto);
		if(flag){
			dto.setUserorg(DefineUtils.DEFAULT_ORGNO);
		}else{
			dto.setUserorg(user.getOrgid());
		}
		
		dto.setItems0121form(form);
		if(DefineUtils.ITEMSCODES_REQSTATUS_SHDSP.equals(form.getApproveType())){ //损耗审批
			if("true".equals(form.getApprove())){
				try {
					dto = items01BL.doStock(dto, "approveWaste");
				} catch (BLException e) {
					return mapping.findForward("ERROR");
				}
			} else if ("false".equals(form.getApprove())){
				try {
					dto = items01BL.doStock(dto, "noApproveWaste");
				} catch (BLException e) {
					return mapping.findForward("ERROR");
				}
			}
		} else if(DefineUtils.ITEMSCODES_REQSTATUS_XHDSP.equals(form.getApproveType())){ //销毁审批
			if("true".equals(form.getApprove())){
				try {
					dto = items01BL.doStock(dto, "approveDestroy");
				} catch (BLException e) {
					return mapping.findForward("ERROR");
				}
			} else if ("false".equals(form.getApprove())){
				try {
					dto = items01BL.doStock(dto, "noApproveDestroy");
				} catch (BLException e) {
					return mapping.findForward("ERROR");
				}
			}
		}
//		if(null == dto){
//			return mapping.findForward("ERROR");
//		}
		return mapping.findForward("DISP");
	}
	
}