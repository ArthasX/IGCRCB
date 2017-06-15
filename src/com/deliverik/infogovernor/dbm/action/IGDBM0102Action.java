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
import com.deliverik.infogovernor.dbm.bl.IGDBM02BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;

/**
 * 概          述:  处长首页DashBoard 处理Action
 * 功能描述： 1.事件问题变更数量
 *           2.本月事件及本月问题数量
 *           3.监控面板
 *           4.年度事件数量及平均解决问题趋势
 *           5.年度问题数量及解决率
 *           6.年度变更数量及成功率
 *           7.柱图
 *           8.备注日历
 * 创建记录：宋海洋 2010/10/26
 * 修改记录：n/a
 */
public class IGDBM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0102Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM02BL ctlBL = (IGDBM02BL) getBean("igDBM02BL");
		IGDBM02DTO dto = new IGDBM02DTO();
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//流程定义登记画面初期显示处理
			log.debug("========流程定义登记画面初期显示处理开始========");
			
			//处长首页本月事件数量取得处理
			ctlBL.getCurrentMouthEventCount(dto);
			
			//处长首页本月问题数量取得处理
			ctlBL.getCurrentMouthProblemCount(dto);
			
			//处长首页各中心工作数量取得处理
			ctlBL.getWorkCount(dto);
			
			//生成处长首页年度事件数量及平均解决时间xml
			dto = ctlBL.setEventAvgCost(dto);
			
			req.setAttribute("lfy1", dto.getResultXML());
			
			//生成处长首页年度问题数量及平均解决率xml
			dto = ctlBL.setproProblemAvgSolute(dto);
			req.setAttribute("lfy2", dto.getResultXML());
			
			//生成处长首页年度问题数量及平均解决率xml
			dto = ctlBL.setproChangeAvgSuccess(dto);
			req.setAttribute("lfy3", dto.getResultXML());
			//生成处长首页变更计划日历xml
			ctlBL.setChangePlan(dto);
			
			//生成处长首页变更计划日历xml
			//dto.setValueOfDate("20101114|true");
			//ctlBL.setChangePlan(dto);
			
			//生成处长首页变更计划日历xml
			//dto.setValueOfDate("20101108|false");
			//ctlBL.setChangePlan(dto);
			req.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			req.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getWorkCount().split(",");
			req.setAttribute("workcount", workResult[0]);
			req.setAttribute("workCenter", workResult[1]);
			
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========流程定义登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
