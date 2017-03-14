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
import com.deliverik.infogovernor.dbm.bl.IGDBM09BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * 概          述:  系统可用率分析DashBoard 处理Action
 * 功能描述：  1.当前实际可用率         
 *			2.实际可用率全年累计        
 *			3.可用率年度趋势         
 *			4.工作及时解决率趋势
 * 创建记录：李旭峙    2010/12/01
 * 修改记录：n/a
 */

public class IGDBM0109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0109Action.class);
	final String currentActualAvailability = "AD_PN1RETURN"; /*当前实际可用率*/
	final String yearActualAvailability= "AD_PN2RETURN";/*实际可用率全年累计*/
	final String availabilityYearTrends= "AD_PN3RETURN";/*可用率年度趋势*/
	final String workTimelySolutionlyTrends= "AD_PN4RETURN";/*工作及时解决率趋势*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM09BL ctlBL = (IGDBM09BL) getBean("igDBM09BL");
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========系统可用率分析画面初期显示处理开始========");
			
			IGDBM09DTO dto = new IGDBM09DTO();
			dto.setSelectSystemId("link1");//默认选择第一个系统ID
			
			dto = ctlBL.getCurrentActualAvailability(dto);
    		req.getSession().setAttribute(currentActualAvailability, dto.getCurrentActualAvailability());   //设置当前实际可用率
    		dto = ctlBL.getYearActualAvailability(dto);
    		req.getSession().setAttribute(yearActualAvailability, dto.getYearActualAvailability()); //设置实际可用率全年累计
    		dto = ctlBL.getAvailabilityYearTrends(dto);
    		req.getSession().setAttribute(availabilityYearTrends, dto.getAvailabilityYearTrends()); //设置可用率年度趋势
    		dto = ctlBL.getWorkTimelySolutionlyTrends(dto);
    		req.getSession().setAttribute(workTimelySolutionlyTrends, dto.getWorkTimelySolutionlyTrends()); //设置工作及时解决率趋势
			log.debug("========系统可用率分析话画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
