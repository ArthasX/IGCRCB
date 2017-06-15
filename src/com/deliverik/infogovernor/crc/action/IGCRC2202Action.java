/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.crc.bl.IGCRC22BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**	
 * 概述:变更总体钻取统计赋值Action处理
 * 功能描述： 
 * 创建记录：史凯龙    2014-8-15 下午1:54:45	
 * 修改记录：
 *          
 */	
public class IGCRC2202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2202Action.class);
	/**	
	 * 功能：事件处理
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 修改记录：
	 *          	
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================变更总体钻取统计赋值Action开始=============");
		// Form获得
		IGWKM0101Form form = (IGWKM0101Form) actionForm;
		//获取request中相关值
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		//获取类型syscoding
		String syscoding = request.getParameter("syscoding");
		//获取变更结果的标示
		String flag = request.getParameter("flag");
		StringBuffer date = new StringBuffer();
		StringBuffer datemin = new StringBuffer();
		
		String str = "";
		
		//设置时间查询条件
		if(year != null && !(month.equals("")) && month != null && !(month.equals(""))){
			date.append(year);
			date.append("/");
			date.append(month);
			date.append("/01");
			if( month.equals("12")){
				Integer demoyear = Integer.parseInt(year);
				demoyear = demoyear + 1;
				datemin.append(demoyear.toString());
				datemin.append("/01/01");
			}else{
				Integer demoMonth = Integer.parseInt(month);
				demoMonth = demoMonth + 1;
				month = demoMonth>9 ? demoMonth.toString():"0"+demoMonth.toString();
				datemin.append(year);
				datemin.append("/");
				datemin.append(month);
				datemin.append("/01");
			}
		}
		
		if ("DISP".equals(mapping.getParameter())) {
			//设置表单的相关信息
			String[] varnames = {"变更类型", "驳回次数", "是否影响业务", "业务影响范围"};
			String[] varvalues = new String[4];
			//设置表单的对应的值
			if(syscoding != null){
				varvalues[0] = syscoding;
			}
			if(flag.equals("1")){
				varvalues[1] = "0";				
			}
			form.setCustom("0");
			form.setPropentime(date.toString());
			form.setPrclosetime(datemin.toString());
			form.setPrstatus("C");
			form.setPrpdid("01084%");
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}else if("SEARCH".equals(mapping.getParameter())){
			//设置表单的相关信息
			String[] varnames = {"变更类型", "变更结果", "是否影响业务", "业务影响范围"};
			String[] varvalues = new String[4];
			//设置表单的对应值
			if(syscoding != null){
				varvalues[0] = syscoding;
			}
			//判断变更结果是成功还是失败
			if(flag.equals("1")){
				varvalues[1] = "成功";
			}else if(flag.equals("0")){
				varvalues[1] = "失败";
			}
			form.setCustom("0");
			form.setPrstatus("C");
			form.setPropentime(date.toString());
			form.setPrclosetime(datemin.toString());
			form.setPrpdid("01084%");
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}
		log.debug("================变更总体钻取统计赋值Action结束=============");
		return mapping.findForward("SEARCH");
		
	}
}
