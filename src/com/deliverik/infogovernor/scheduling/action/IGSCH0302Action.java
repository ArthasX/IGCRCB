/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BLType;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH03BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0301Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0302Form;
import com.deliverik.infogovernor.scheduling.vo.IGSCH03021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务策略ACTION
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSCH0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSCH0302Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		IGSCH0302Form form = (IGSCH0302Form)actionForm;
		IGSCH03BL sch03BL = (IGSCH03BL) getBean("IGSCH03BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			IGSCH03DTO dto = (IGSCH03DTO)request.getAttribute("IGSCH03DTO");
			IGSCH0301Form igsch0301Form = dto.getIgsch0301Form();
			IGSCH02BL sch02BL = (IGSCH02BL) getBean("IGSCH02BL");
			String periodType = igsch0301Form.getPeriodType();
			String CustomDate = igsch0301Form.getCustomDate();
			String exeHour = igsch0301Form.getQjhour();
			String exeMinute = igsch0301Form.getQjminute();
			String startDate = igsch0301Form.getQjcrttime();
			String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
			igsch0301Form.setQjperiodinfo(periodInfo);
			
			IGSCH03021VO vo = new IGSCH03021VO();
			
			List<LabelValueBean> roleList = new ArrayList<LabelValueBean>();
			if(roleList.isEmpty()){
				roleList.add(new LabelValueBean("", ""));
			}
			request.getSession().setAttribute("ADroleList", roleList);
			
			if(StringUtils.isNotEmpty(igsch0301Form.getQprpdid())){
				dto.setPdid(igsch0301Form.getQprpdid());
				dto = sch03BL.getProcessInfoDefs(dto);
				if(dto.getPidList()!=null){
					form.setPivarvalue(new String[dto.getPidList().size()]);
				}
			}
			vo.setProcessInfoDefList(dto.getPidList());
			
			vo.setIgsch0301Form(igsch0301Form);
			super.<IGSCH03021VO>setVO(request.getSession(), vo);
			addMessage(request, new ActionMessage("IGCO10000.I001","指派任务基本信息"));
		}else if("INSERT".equals(mapping.getParameter())){
			IGSCH03DTO dto = new IGSCH03DTO();
			form.setQprstatus(IGSCH01BLType.PROCESS_STATUS_WAITING_IMPLEMENT);
			form.setQprtype(IGSCH01BLType.PROCESS_ENTERPRISE_TYPE);
			form.setQprpdname(IGSCH01BLType.PROCESS_ENTERPRISE_NAME);
			
			form.setQpruserid(user.getUserid());
			form.setQprusername(user.getUsername());
			form.setQprorgid(user.getOrgid());
			form.setQprorgname(user.getOrgname());
			dto.setIgsch0302Form(form);
			
			dto.setQuartzProcessRecord(form);
			dto.setQuartzJobs(form);
			try {
				sch03BL.saveQuartzWorkAction(dto);
			} catch (BLException e) {
				if(e.getErrors().get(0).getKey().equals("SchedulerException")){
					addMessage(request, new ActionMessage("IGSCH0302.I004","正确的指派任务结束日期"));
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