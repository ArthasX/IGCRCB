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
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH03BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;
import com.deliverik.infogovernor.scheduling.vo.IGSCH02021VO;

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

public class IGSCH0203Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSCH0203Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		IGSCH02BL sch02BL = (IGSCH02BL) getBean("IGSCH02BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			IGSCH0201Form igsch0201Form = (IGSCH0201Form)request.getAttribute("IGSCH0201Form");
			String periodType = igsch0201Form.getPeriodType();
			String CustomDate = igsch0201Form.getCustomDate();
			String exeHour = igsch0201Form.getQjhour();
			String exeMinute = igsch0201Form.getQjminute();
			String startDate = igsch0201Form.getQjcrttime();
			String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
			igsch0201Form.setQjperiodinfo(periodInfo);
			
			List<LabelValueBean> allRoleList = new ArrayList<LabelValueBean>();
			allRoleList.add(new LabelValueBean("",""));
			IGSCH03BL sch03BL = (IGSCH03BL) getBean("IGSCH03BL");
			IGSCH03DTO igsch03dto = new IGSCH03DTO();
			igsch03dto = sch03BL.findRole(igsch03dto);
			List<Role> userRoleList = igsch03dto.getRolelist();
			for(Role role : userRoleList){
				allRoleList.add(new LabelValueBean(role.getRolename(), role.getRoleid().toString()));
			}
			request.setAttribute("allRoleList", allRoleList);
			saveToken(request);
			IGSCH02021VO vo = new IGSCH02021VO();
			vo.setIgsch0201Form(igsch0201Form);
			super.<IGSCH02021VO>setVO(request.getSession(), vo);
			addMessage(request, new ActionMessage("IGCO10000.I001","个人任务基本信息"));
		}else if("INSERT".equals(mapping.getParameter())){
			IGSCH0201Form igsch0201Form = (IGSCH0201Form)actionForm;
			IGSCH02DTO dto = new IGSCH02DTO();
			igsch0201Form.setQjcrtuser(user.getUserid());
			igsch0201Form.setQjcrtusername(user.getUsername());
			dto.setQuartzJobs(igsch0201Form);
			dto.setIgsch0201Form(igsch0201Form);
			try {
				if (isTokenValid(request, true)){
					sch02BL.saveQuartzJobs(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
			} catch (BLException e) {
				if(e.getErrors().get(0).getKey().equals("SchedulerException")){
					addMessage(request, new ActionMessage("IGSCH0202.I004","正确的个人任务结束日期"));
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
		}
		return mapping.findForward("DISP");
	}

}