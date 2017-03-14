/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0102Form;
import com.deliverik.infogovernor.prj.vo.IGPRJ0101VO;

public class IGPRJ0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRJ0102Action.class);
	
	/**
	 * <p>
	 * Title : InfoGovernor 信息服务管理平台
	 * </p>
	 * <p>
	 * Description: 服务管理_项目管理_登记ACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//BL取得
		IGPRJ01BL prjBl = (IGPRJ01BL) getBean("igprj01BL");
		
		if("DISP".equals(mapping.getParameter())){
			IGPRJ0102Form igprj0102Form = (IGPRJ0102Form)actionForm;
			req.setAttribute("IGPRJ0102Form", igprj0102Form);
		}
		if("INSERT".equals(mapping.getParameter())){
			IGPRJ01DTO dto = new IGPRJ01DTO();
			IGPRJ0102Form igprj0102Form = (IGPRJ0102Form)actionForm;
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//保存项目发起人信息，用于过滤按钮
			igprj0102Form.setProle(user.getUserid());
			dto.setIgPrj0102Form(igprj0102Form);
			dto.setUser(user);
			if (isTokenValid(req, true)){
				dto = prjBl.insertEntityAction(dto);
				IGPRJ0101VO igPrj0101VO = new IGPRJ0101VO();
				igPrj0101VO.setProject(dto.getProject());
				if(null == igPrj0101VO.getProject()){
					return mapping.findForward("ERROR");
				}
				req.setAttribute("igPrj0101VO", igPrj0101VO);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}else{
			saveToken(req);
		}
		addMessage(req, new ActionMessage("IGCO10000.I001","项目登记信息"));
		return mapping.findForward("DISP");
	}
}
