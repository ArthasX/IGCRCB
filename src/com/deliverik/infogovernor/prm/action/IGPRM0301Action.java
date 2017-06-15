/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prm.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0301Form;
import com.deliverik.infogovernor.prm.form.IGPRM0302Form;
import com.deliverik.infogovernor.prm.vo.IGPRM03011VO;

public class IGPRM0301Action extends BaseAction {

	/**
	 * <p>
	 * Title : InfoGovernor 信息服务管理平台
	 * </p>
	 * <p>
	 * Description: 系统管理_模板管理_查询ACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGPRM01BL igprm01BL = (IGPRM01BL)this.getBean("IGPRM01BL");
		IGPRM01DTO dto = new IGPRM01DTO();
		if("DELETE".equals(mapping.getParameter())){
			String pdid = req.getParameter("pdid");
			IGPRM0301Form form = (IGPRM0301Form)actionForm;
			String[] pidids = form.getPidid();
			dto.setPidids(pidids);
			if (isTokenValid(req, true)){
				//调用BL发起
				igprm01BL.deleteProcessInfoDef(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			ActionForward af = new ActionForward("/IGPRM0301_Disp.do?pdid=" + pdid);
			return af;
		} else {
			IGPRM0302Form form = (IGPRM0302Form)actionForm;
			dto.setProcessInfoDef(form);
			dto = igprm01BL.findAllProcessInfoDef(dto);
			IGPRM03011VO vo = new IGPRM03011VO();
			vo.setAddDefaultApproveDispatcher(dto.getAddDefaultApproveDispatcher());
			vo.setAddDefaultApprover(dto.getAddDefaultApprover());
			vo.setProcessInfoDefList(dto.getProcessInfoDefList());
			Map<String,String> typeMap = new HashMap<String,String>();
			typeMap.put("t", "text");
			typeMap.put("o", "option");
			vo.setTypeMap(typeMap);
			saveToken(req);
			req.setAttribute("vo", vo);
		}
		
		return mapping.findForward("DISP");
	}
	
}
