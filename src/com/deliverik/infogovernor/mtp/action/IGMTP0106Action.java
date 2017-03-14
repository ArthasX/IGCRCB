/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0106Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;

/**
 *	日常运维任务修改功能Action
 */

public class IGMTP0106Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGMTP0106Action.class);

	/**
	 * 处理逻辑
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//初始化
		IGMTP0106Form form = (IGMTP0106Form)actionForm;
		IGMTP01BL ctrlBL = (IGMTP01BL) getBean("igmtp01BL");
		IGMTP01DTO dto = new IGMTP01DTO();
	
		//取得参数
		String periodType = form.getPeriodType();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String qjcrttime = form.getQjcrttime().trim();
		String qjendtime = form.getQjendtime().trim();
		String startDate = form.getQjcrttime().trim();
		
		//取得执行周期表达式
		String cronExpression =  ctrlBL.creatCronExp(periodType,exeHour,exeMinute,qjcrttime);
		form.setQjtricron(cronExpression);
		
		//取得执行周期表达式说明信息
		String periodInfo = ctrlBL.getPeriodInfo(periodType, exeHour, exeMinute,startDate);
		form.setQjperiodinfo(periodInfo);
		
		dto.setIgmtp0106Form(form);
		//设置运维计划主键ID
		dto.setQjid(form.getQjid());
		
		//初始化日历修改页面需要的信息
		dto = ctrlBL.initIGMTP0107(dto,cronExpression);
		
		IGMTP01061VO vo = new IGMTP01061VO();
		vo.setStartDate(qjcrttime);
		vo.setEndDate(qjendtime);
		vo.setDateList(dto.getDateList());
		
		form.setDotime(dto.getDateList().get(0)+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
		
		//将运维计划登记信息保存到session中
		request.getSession().setAttribute("IGMTP0106Form", form);
		saveToken(request);
		super.<IGMTP01061VO>setVO(request, vo);
		return mapping.findForward("DISP");

	}
	
	

}