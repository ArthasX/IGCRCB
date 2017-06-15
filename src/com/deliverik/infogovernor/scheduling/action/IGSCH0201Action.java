/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BLImpl;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;
import com.deliverik.infogovernor.scheduling.vo.IGSCH02011VO;

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

public class IGSCH0201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSCH0201Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		IGSCH0201Form form = (IGSCH0201Form)actionForm;
		IGSCH02BL sch02BL = (IGSCH02BL) getBean("IGSCH02BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			String beginDate = form.getDate();
			String type = form.getType();
			IGSCH02011VO vo = new IGSCH02011VO();
			vo.setBeginDate(beginDate);
			vo.setType(type);
			vo.setUser(user);
			IGSCH02DTO dto = new IGSCH02DTO(); 
			dto = sch02BL.getProcessDefinitions(dto);
			vo.setPdList(dto.getPdList());
			super.<IGSCH02011VO>setVO(request, vo);
			saveToken(request);
			addMessage(request, new ActionMessage("IGCO10000.I001","个人任务调度信息"));
		}else if("INSERT".equals(mapping.getParameter())){
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
			String taskType = form.getType();
			if("WP".equalsIgnoreCase(taskType)){
				dto.setQuartzJobs(form);
				String cronExpression =  creatCronExp(periodType,CustomDate,exeHour,exeMinute,qjcrttime);
				form.setQjtricron(cronExpression);
				try {
					if (isTokenValid(request, true)){
						sch02BL.saveQuartzJobs(dto);
					}else{
						addMessage(request, new ActionMessage("IGCO00000.E007"));
						return mapping.findForward("/error1");
					}
				} catch (BLException e) {
					if(e.getErrors().get(0).getKey().equals("SchedulerException")){
						addMessage(request, new ActionMessage("IGSCH0202.I003","正确的短信提醒结束日期"));
						return mapping.findForward("ERROR");
					}
					log.debug(e.getMessage());
				}
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(request, message);
					}
				}
				return mapping.findForward("SUCCESS");
			} else if("WE".equalsIgnoreCase(taskType)){
				String cronExpression =  creatCronExp(periodType,CustomDate,exeHour,exeMinute,qjcrttime);
				form.setQjtricron(cronExpression);
				String startDate = form.getQjcrttime();
				String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
				form.setQjperiodinfo(periodInfo);
				request.setAttribute("IGSCH0201Form", form);
				saveToken(request);
				return mapping.findForward("SMS_DISP");
			}
		}
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