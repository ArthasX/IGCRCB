package com.deliverik.infogovernor.mnu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Action;

import java.util.*;

public class IGMNU0101Action extends BaseAction {
	static Log log= LogFactory.getLog(IGMNU0101Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		UserPermission per = (UserPermission) (req.getSession().getAttribute("UserPermission"));
		List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> firstList = per.getActionList();
		List<Map<Action, List<Map<Action, List<Action>>>>> secList = new ArrayList();
		List<Map<Action, List<Action>>> thirdList =new ArrayList();
		secList=per.getMenuList("ACT02SVC", firstList);
		thirdList=per.getMenuList("ACT02SVC06", secList);
		req.getSession().setAttribute("secList", secList);
		req.getSession().setAttribute("thirdList", thirdList);
		return mapping.findForward("DISP");
	}
	
	
	 
}
