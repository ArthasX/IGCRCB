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
import com.deliverik.infogovernor.dbm.bl.IGDBM01BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * 概          述:  流程主题DashBoard 处理Action
 * 功能描述： 1.事件问题变更数量
 *           2.本月事件及本月问题数量
 *           3.故障统计
 *           4.年度事件数量及平均解决问题趋势
 *           5.年度问题数量及解决率
 *           6.年度变更数量及成功率
 *           7.柱图
 *           8.备注日历
 *           以上全部删除了。
 *           
 * 创建记录：宋海洋 2010/10/26
 * 修改记录：Xudong Wang 2012/11/22
 */
public class IGDBM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0103Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM01BL ctlBL = (IGDBM01BL) getBean("igDBM01BL");
		IGDBM01DTO dto = new IGDBM01DTO();
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//流程定义登记画面初期显示处理
			log.debug("========行长首页画面初期显示处理开始========");
			dto=ctlBL.setITChart(dto);
			req.setAttribute("IICHART", dto.getResultXML());
//			
			log.debug("========行长首页画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
