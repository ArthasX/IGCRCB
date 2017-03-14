/** 北京递蓝科软件技术有限公司版权所有，保留所有权利。*/

package com.deliverik.infogovernor.aim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.aim.form.IGAIM0150Form;
import com.deliverik.infogovernor.aim.vo.IGAIM01501VO;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;

/**
 * @Busstopo map
 * @version 1.0
 */

public class IGAIM0150Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAIM0150Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGAIM0150Form form = (IGAIM0150Form)actionForm;
		//画面跳转设定
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查看业务系统性能初期显示处理开始========");
			//String eiid = req.getParameter("eiid");
			IGCOM01BL igcom01BL = (IGCOM01BL)getBean("IGCOM01BL");
			
			IGCOM01DTO dto = new IGCOM01DTO();
			dto.setIgaim0150Form(form);
			
			dto = igcom01BL.searchHQAlertListDetailVWActionByIP(dto); // hq告警
			
			IGAIM01501VO vo = new IGAIM01501VO();
			
			if("1".equals(form.getOracleFlag())){
				dto = igcom01BL.searchOracleAlertAction(dto); // Oracle告警
				vo.setLst_CRM06Info(dto.getLst_CRM06Info()); // Oracle告警
			}
			
			super.<IGAIM01501VO> setVO(req, vo);
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
