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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BLType;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;

/**
 *	日常运维任务(指派工作)Action
 */

public class IGMTP0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGMTP0101Action.class);

	/**
	 * 处理逻辑
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//初始化
		IGMTP0101Form form = (IGMTP0101Form)actionForm;
		IGMTP01BL ctrlBL = (IGMTP01BL) getBean("igmtp01BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGMTP01DTO dto = new IGMTP01DTO();
		
		//设置运维计划登记人信息
		form.setQjcrtuser(user.getUserid());
		form.setQjcrtusername(user.getUsername());
		form.setQjimpluser(user.getUserid());
		form.setQjimplusername(user.getUsername());
		
		//dto.setIgmtp0101Form(form);
		
		//取得参数
		String periodType = form.getPeriodType();
		//String CustomDate = form.getCustomDate();
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
		
		form.setWorkType(IGMTP01BLType.PROCESS_ENTERPRISE_TYPE);
		dto.setIgmtp0101Form(form);
		//当周期类型不是仅执行一次时，初始化日历画面需要的信息
		if(!"once".equals(periodType)){
			//初始化日历页面需要的信息
			dto = ctrlBL.initIGMTP0104(dto,cronExpression);
			
			IGMTP01011VO vo = new IGMTP01011VO();
			vo.setStartDate(qjcrttime);
			vo.setEndDate(qjendtime);
			vo.setDateList(dto.getDateList());
			
			form.setDotime(dto.getDateList().get(0)+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
			
			//将运维计划登记信息保存到session中
			request.getSession().setAttribute("IGMTP0101Form", form);
			saveToken(request);
			super.<IGMTP01011VO>setVO(request, vo);
			return mapping.findForward("DISP");
		}else{
			//将运维计划登记信息保存到session中
			form.setDotime(qjcrttime+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
			request.getSession().setAttribute("IGMTP0101Form", form);
			saveToken(request);
			
			return mapping.findForward("ONCE");
		}

	}
	
	

}