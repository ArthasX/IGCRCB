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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.bl.IGDBM01BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * 概          述:  行长首页DashBoard 处理Action
 * 功能描述： 1.各地分行款项及涨幅
 *           2.监控面板
 *           3.银联、ATM、POS成功率仪表盘
 *           4.银联、ATM、POS成功率柱图
 *           5.当前工作统计
 *           6.变更计划查询
 *           7.IT运营趋势
 * 创建记录：李旭峙 2010/10/26
 * 修改记录：n/a
 */
public class IGDBM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0101Action.class);

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
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BL取得
		IGDBM01BL ctlBL = (IGDBM01BL) getBean("igDBM01BL");
		
		//DTO生成
		IGDBM01DTO dto = new IGDBM01DTO();
		dto.setUser(user);
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//行长首页画面初期显示处理
			log.debug("========流程定义登记画面初期显示处理开始========");
			
			dto = ctlBL.setITChart(dto);
			
			req.setAttribute("chart", dto.getResultXML());
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========流程定义登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
