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
import com.deliverik.infogovernor.dbm.bl.IGDBM08BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;

/**
 * 概          述:  工作流程综合分析DashBoard 处理Action
 * 功能描述：  1.月工作类型数量及占比查询
 *           2.工作平均解决时间趋势查询
 *           3.工作数量趋势
 *           4.工作及时解决率趋势
 * 创建记录：赵俊    2010/11/30
 * 修改记录：n/a
 */

public class IGDBM0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*工作数量占比*/
	final String workLineForAvg= "AD_PN2RETURN";/*工作平均解决时间返回值*/
	final String workLineForCount= "AD_PN3RETURN";/*工作数量趋势返回值*/
	final String workLineForSolve= "AD_PN4RETURN";/*工作及时解决率返回值*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM08BL ctlBL = (IGDBM08BL) getBean("igDBM08BL");
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========工作流程综合分析画面初期显示处理开始========");
			Calendar  c=new  GregorianCalendar();//新建日期对象  
			int  year=c.get(Calendar.YEAR);//获取年份  
			int  month=c.get(Calendar.MONTH);//获取月份  

			IGDBM08DTO dto = new IGDBM08DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("设备工作");
			dto.setPn3Value("设备工作");
			dto.setPn4Value("设备工作");
			dto = ctlBL.getProcessWorkAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //设置工作数量占比值
    		req.getSession().setAttribute(workLineForAvg, dto.getWorkLineForAvg()); //设置工作平均解决时间返回值
    		req.getSession().setAttribute(workLineForCount, dto.getWorkLineForCount()); //设置工作数量趋势返回值
    		req.getSession().setAttribute(workLineForSolve, dto.getWorkLineForSolve()); //设置工作及时解决率返回值
			log.debug("========工作流程综合分析话画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
