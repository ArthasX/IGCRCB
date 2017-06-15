package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM18BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM18DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0808Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM18011VO;

/**
 * 概述: 手动采集 创建记录：2014/1/3 修改记录：
 * @author Rg
 */
public class IGCIM0808Action extends BaseAction {

	private final String _STOP = "stop";
	private final String _START = "start";
	private final String _SEARCH = "search";
	private final String forward = "DISP";
	private final String _ACTION = "editAction";
	private final String _IGCIM18BL = "igcim18BL";

	static Log log = LogFactory.getLog(IGCIM0808Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		
		IGCIM18DTO dto = new IGCIM18DTO();
		IGCIM18011VO vo = new IGCIM18011VO();
		IGCIM18BL ctrBL= (IGCIM18BL) getBean(_IGCIM18BL);
		IGCIM0808Form form =(IGCIM0808Form)actionForm;
		String editAction = req.getParameter(_ACTION);
		dto.setIgcim0808Form(form);
		
		if(editAction != null && _START.equals(editAction)){
			dto = ctrBL.startServer(dto);
			form.setServerstatus("0");
			dto.setIgcim0808Form(form);
		}else if(editAction != null && _STOP.equals(editAction)){
			dto = ctrBL.stopServer(dto);
			form.setServerstatus("0");
			dto.setIgcim0808Form(form);
		}else if(editAction != null && _SEARCH.equals(editAction)){
			dto = ctrBL.searchServer(dto);
		}else{
			dto = ctrBL.getCIHQServerList(dto);
		}

		vo.setHqServerTBList(dto.getHqServerTBList());
		super.<IGCIM18011VO>setVO(req, vo);
		return mapping.findForward(forward);
	}

}