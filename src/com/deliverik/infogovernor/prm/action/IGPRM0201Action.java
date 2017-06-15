/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0202Form;
import com.deliverik.infogovernor.prm.vo.IGPRM02011VO;

public class IGPRM0201Action extends BaseAction {

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
		
		IGPRM0202Form form = (IGPRM0202Form)actionForm;
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			dto.setProcessDefinition(form);
			igprm01BL.changePDStatus(dto);
		} else {
			getPaginDTO(req,"IGPRM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGPRM0201");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// 调用BL查询
			dto = igprm01BL.findAllProcessDefinition(dto);
			IGPRM02011VO vo = new IGPRM02011VO();
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			vo.setProcessTemplateList(dto.getProcessTemplateList());
			req.setAttribute("vo", vo);
		}
		
		return mapping.findForward("DISP");
	}
	
}
