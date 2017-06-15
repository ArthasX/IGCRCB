/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM06BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * 概          述:  事件流程综合分析DashBoard 处理Action
 * 功能描述：  1.月事件类型数量及占比查询
 *           2.事件平均解决时间趋势查询
 *           3.事件数量趋势
 *           4.事件及时解决率趋势
 * 创建记录：赵俊    2010/11/30
 * 修改记录：n/a
 */

public class IGDBM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*事件数量占比*/
	final String incidentLineForAvg= "AD_PN2RETURN";/*事件平均解决时间返回值*/
	final String incidentLineForCount= "AD_PN3RETURN";/*事件数量趋势返回值*/
	final String incidentLineForSolve= "AD_PN4RETURN";/*事件及时解决率返回值*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM06BL ctlBL = (IGDBM06BL) getBean("igDBM06BL");
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========事件流程综合分析画面初期显示处理开始========");
			Calendar  c=new  GregorianCalendar();//新建日期对象  
			int  year=c.get(Calendar.YEAR);//获取年份  
			int  month=c.get(Calendar.MONTH);//获取月份  

			IGDBM06DTO dto = new IGDBM06DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("业务故障");
			dto.setPn3Value("业务故障");
			dto.setPn4Value("业务故障");
			dto = ctlBL.getProcessIncidentAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //设置事件数量占比值
    		req.getSession().setAttribute(incidentLineForAvg, dto.getIncidentLineForAvg()); //设置事件平均解决时间返回值
    		req.getSession().setAttribute(incidentLineForCount, dto.getIncidentLineForCount()); //设置事件数量趋势返回值
    		req.getSession().setAttribute(incidentLineForSolve, dto.getIncidentLineForSolve()); //设置事件及时解决率返回值
			log.debug("========事件流程综合分析话画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
