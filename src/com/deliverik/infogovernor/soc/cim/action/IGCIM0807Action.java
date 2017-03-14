package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM13DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0807Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM13012VO;

/**
 * 概述: 定时采集 创建记录：2013/7/3 修改记录：
 */
public class IGCIM0807Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0807Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		IGCIM0807Form form=(IGCIM0807Form)actionForm;
		
		IGCIM13DTO dto = new IGCIM13DTO();
		
		IGCIM13BL ctrBL= (IGCIM13BL) getBean("igcim13BL");
		
		IGCIM13012VO vo = new IGCIM13012VO();
		
		getPaginDTO(req,"IGCIM0807");
		
		PagingDTO pDto;
		
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
		
		String forward = "DISP";
		
		int maxCnt = getMaxDataCount("IGCIM0807");
		
		if("Search".equals(mapping.getParameter())){
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGCIM0807Form) req.getSession().getAttribute("IGCIM0807Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			String uuid= req.getParameter("uuid");
			String disp = req.getParameter("disp");
			String servername = req.getParameter("servername");
			if("true".equals(disp)){
				req.getSession().setAttribute("uuid", uuid);
				req.getSession().setAttribute("servername", servername);
				req.setAttribute("disp", "true");
			}else req.setAttribute("disp", "false");
			if(StringUtils.isEmpty(uuid)) uuid = (String)req.getSession().getAttribute("uuid");
			
			dto.setUuid(uuid);
			dto.setIgcim0807Form(form);
			dto = ctrBL.getHistoryTaskListByType(dto);
			vo.setHistoryList(dto.getHistoryList());
			super.<IGCIM13012VO>setVO(req, vo);
			
		}
		return mapping.findForward(forward);
	}
}
