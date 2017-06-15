/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BLImpl;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务策略ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class EnterpriseTaskAction extends BaseAction {
	
	static Log log = LogFactory.getLog(EnterpriseTaskAction.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		
		IGSCH0201Form form = (IGSCH0201Form)actionForm;
		IGSCH02BL sch02BL = (IGSCH02BL) getBean("IGSCH02BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		form.setQjcrtuser(user.getUserid());
		form.setQjcrtusername(user.getUsername());
		form.setQjimpluser(user.getUserid());
		form.setQjimplusername(user.getUsername());
		IGSCH02DTO dto = new IGSCH02DTO();
		dto.setIgsch0201Form(form);
		String periodType = form.getPeriodType();
		String CustomDate = form.getCustomDate();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String qjcrttime = form.getQjcrttime().trim();
		
		String cronExpression =  creatCronExp(periodType,CustomDate,exeHour,exeMinute,qjcrttime);
		form.setQjtricron(cronExpression);
		String startDate = form.getQjcrttime();
		String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
		form.setQjperiodinfo(periodInfo);
		request.getSession().setAttribute("IGSCH0201Form", form);
		saveToken(request);
		
		return mapping.findForward("DISP");
	}
	
	private String creatCronExp(String periodType, String CustomDate,
			String exeHour, String exeMinute, String qjcrttime){
		String retCronExp = null;
		//秒 分 时 日 月 周
		if ("week".equals(periodType)) {
			IGSCH02BLImpl sch02BL = new IGSCH02BLImpl();
			String week = sch02BL.getWeekOfDate(qjcrttime, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + week;
		} else if ("month".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " * ?";
		} else if ("once".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			String month = qjcrttime.split("/")[1];
			String year = qjcrttime.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		} else if ("day".equals(periodType)){
			
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		} else if ("quarter".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + "/3 ?";
		}
		log.debug(retCronExp);
		return retCronExp;
	}

}