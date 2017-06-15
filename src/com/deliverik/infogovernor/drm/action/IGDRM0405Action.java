package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;

/**
 * 获取应急资源附件ciid Ajax_Action
 *
 */
public class IGDRM0405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0405Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGDRM04BL ctlBL =(IGDRM04BL)getBean("igdrm04BL");
		
		if( "GET".equals(mapping.getParameter())){
			Integer eiid =Integer.valueOf( req.getParameter("eiid"));
			Integer eiversion = Integer.valueOf( req.getParameter("eiversion"));
			IGDRM04DTO dto = new IGDRM04DTO();
			dto.setEiid(eiid);
			dto.setEiversion(eiversion);
			ctlBL.getArrId(dto);
			res.setCharacterEncoding("UTF-8");
			PrintWriter w = res.getWriter();
			w.print(dto.getCiid());
		}
		
		return null;
	}
}
