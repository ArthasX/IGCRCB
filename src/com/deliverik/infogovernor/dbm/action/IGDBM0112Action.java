/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM03BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;

/**
 * 处长首页dashborad
 * @version 1.0
 */

public class IGDBM0112Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDBM0110Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM03BL ctlBL = (IGDBM03BL) getBean("igDBM03BL");
		IGDBM03DTO dto = new IGDBM03DTO();
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========处长首页初期显示处理开始========");
			
			//流程主题本月事件数量取得处理
			ctlBL.getCurrentMouthEventCount(dto);
			
			//流程主题本月问题数量取得处理
			ctlBL.getCurrentMouthProblemCount(dto);
			
			//流程主题首页各中心工作数量取得处理
			ctlBL.getAllTypeWorkCount(dto);
			
			//生成流程主题首页年度事件数量及平均解决时间xml
			ctlBL.setEventAvgCost(dto);
			req.setAttribute("lfy1", dto.getResultXML());

			//生成流程主题首页年度变更数量及平均解决率xml
			ctlBL.setproChangeAvgSuccess(dto);
			req.setAttribute("lfy3", dto.getResultXML());
			
			//生成流程主题首页变更计划日历xml
			ctlBL.setChangePlan(dto);
			
			req.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			req.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getAllTypeWorkCount().split(",");
			req.setAttribute("workcount", workResult[0]);
			req.setAttribute("worktype", workResult[1]);
			
			req.setAttribute("jsptype", req.getParameter("type"));
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
