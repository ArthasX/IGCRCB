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
import com.deliverik.infogovernor.dbm.bl.IGDBM05BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;

/**
 * 概          述:  问题流程综合分析DashBoard 处理Action
 * 功能描述：  1.月问题类型数量及占比查询
 *           2.问题平均解决时间趋势查询
 *           3.问题数量趋势
 *           4.问题及时解决率趋势
 * 创建记录：赵俊    2010/11/26
 * 修改记录：n/a
 */

public class IGDBM0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*问题数量占比*/
	final String problemLineForAvg= "AD_PN2RETURN";/*问题平均解决时间返回值*/
	final String problemLineForCount= "AD_PN3RETURN";/*问题数量趋势返回值*/
	final String problemLineForSolve= "AD_PN4RETURN";/*问题及时解决率返回值*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM05BL ctlBL = (IGDBM05BL) getBean("igDBM05BL");
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========问题流程综合分析画面初期显示处理开始========");
			Calendar  c=new  GregorianCalendar();//新建日期对象  
			int  year=c.get(Calendar.YEAR);//获取年份  
			int  month=c.get(Calendar.MONTH);//获取月份  

			IGDBM05DTO dto = new IGDBM05DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("设备问题");
			dto.setPn3Value("设备问题");
			dto.setPn4Value("设备问题");
			dto = ctlBL.getProcessProblemAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //设置问题数量占比值
    		req.getSession().setAttribute(problemLineForAvg, dto.getProblemLineForAvg()); //设置问题平均解决时间返回值
    		req.getSession().setAttribute(problemLineForCount, dto.getProblemLineForCount()); //设置问题数量趋势返回值
    		req.getSession().setAttribute(problemLineForSolve, dto.getProblemLineForSolve()); //设置问题及时解决率返回值
			log.debug("========问题流程综合分析话画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
