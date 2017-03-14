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
import com.deliverik.infogovernor.dbm.bl.IGDBM04BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;

/**
 * 概          述:  基础设施DashBoard 处理Action
 * 功能描述： 1.四大主机使用率
 *           2.四大主机当日利用率趋势
 *           3.四大主机数据库与中间件使用率
 *           4.核心存储当月利用率趋势
 *           5.相关事件与相关问题数
 * 创建记录：李旭峙 2010/10/26
 * 修改记录：n/a
 */
public class IGDBM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);

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
		IGDBM04BL ctlBL = (IGDBM04BL) getBean("igDBM04BL");
		IGDBM04DTO dto = new IGDBM04DTO();
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			
			log.debug("========基础设施话画面初期显示处理开始========");
			//当日核心系统主机CPU/内存利用率xml
			ctlBL.setKernelUseAvg(dto);
			//当日前置系统主机CPU/内存利用率xml
			ctlBL.setPrefixUseAvg(dto);
			//当日中间业务主机CPU/内存利用率xml
			ctlBL.setMiddleOperationUseAvg(dto);
			//生成当日网银主机CPU/内存利用率xml
			ctlBL.setNetbankUseAvg(dto);
			
			//双色线
			dto = ctlBL.getDoubleColorLine(dto);
			req.setAttribute("dcl", dto.getResultXML());
			
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========基础设施话画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
