/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BLImpl;
import com.deliverik.infogovernor.scheduling.bl.IGSCH03BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0301Form;
import com.deliverik.infogovernor.scheduling.vo.IGSCH03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务策略_企业定时任务ACTION
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSCH0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSCH0301Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		IGSCH0301Form form = (IGSCH0301Form)actionForm;
		IGSCH03BL sch03BL = (IGSCH03BL) getBean("IGSCH03BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			String beginDate = form.getDate();
			IGSCH03DTO dto = new IGSCH03DTO();
			dto = sch03BL.findRole(dto);
			IGSCH03011VO vo = new IGSCH03011VO();
			List<LabelValueBean> roleList = new ArrayList<LabelValueBean>();
			roleList.add(new LabelValueBean("",""));
			List<Role> list = dto.getRolelist();
			for(Role role : list){
				roleList.add(new LabelValueBean(role.getRolename(), role.getRoleid().toString()));
			}
			request.setAttribute("roleList", roleList);
			vo.setBeginDate(beginDate);
			dto = sch03BL.getProcessDefinitions(dto);
			vo.setPdList(dto.getPdList());
			super.<IGSCH03011VO>setVO(request, vo);
			addMessage(request, new ActionMessage("IGCO10000.I001","指派任务调度信息"));
			return mapping.findForward("DISP");
		}else if("INSERT".equals(mapping.getParameter())){
			IGSCH03DTO dto = new IGSCH03DTO();
			String qjtype = form.getQjtype();
			form.setQjcrtuser(user.getUserid());
			form.setQjcrtusername(user.getUsername());
			String qjcrttime = form.getQjcrttime().trim();
			if("S".equalsIgnoreCase(qjtype)){
				dto.setQuartzJobs(form);
				dto.setIgsch0301Form(form);
				String periodType = form.getPeriodType();
				String CustomDate = form.getCustomDate();
				String exeHour = form.getQjhour();
				String exeMinute = form.getQjminute();
				String cronExpression =  creatCronExp(periodType,CustomDate,exeHour,exeMinute,qjcrttime);
				form.setQjtricron(cronExpression);
				try {
					sch03BL.saveQuartzJobs(dto);
				} catch (BLException e) {
					if(e.getErrors().get(0).getKey().equals("SchedulerException")){
						addMessage(request, new ActionMessage("IGSCH0302.I003","正确的短信提醒结束日期"));
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
			} else {
				String periodType = form.getPeriodType();
				String CustomDate = form.getCustomDate();
				String exeHour = form.getQjhour();
				String exeMinute = form.getQjminute();
				String cronExpression =  creatCronExp(periodType,CustomDate,exeHour,exeMinute,qjcrttime);
				form.setQjtricron(cronExpression);
				String startDate = form.getQjcrttime();
				IGSCH02BLImpl sch02BL = new IGSCH02BLImpl();
				String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
				form.setQjperiodinfo(periodInfo);
				request.getSession().setAttribute("IGSCH0301Form", form);
				return new ActionForward(form.getPtsavepg());
			}
		}
		return null;
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