package com.deliverik.infogovernor.syslog.action;

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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.syslog.bl.IGLOG002BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0022Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0022VO;
/**
 * 
 * 告警规则模板添加ACTION
 *
 * @作者 王省
 *
 * 创建：2013-4-8
 * 修改：2013-8-19
 */
public class IGLOG0022Action extends BaseAction{
	static Log log = LogFactory.getLog(IGLOG0022Action.class);

	/**
	 * 告警规则模板添加
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化DTO
		IGLOG0021DTO dto = new IGLOG0021DTO();
		
		//实例化form表单
		IGLOG0022Form form = (IGLOG0022Form) actionForm;
		
		//实例化ctrolBL
		IGLOG002BL ctlBL = (IGLOG002BL) getBean("iglog002BL");
		
		//告警规则模板页面初始化
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========告警规则模板页面初始化开始========");
			//是否显示返回按钮
			String couldReturn = request.getParameter("couldReturn");
			IGLOG0022VO vo = new IGLOG0022VO();
			vo.setCouldReturn(couldReturn);
			super.<IGLOG0022VO>setVO(request, vo);
			log.debug("========告警规则模板页面初始化结束========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			log.debug("========告警规则模板录入开始========");
			
			//将录入form放入载体dto中
			dto.setIgLog0022Form(form);
			
			//录入告警规则
			dto = ctlBL.insertDeviceAndRules(dto);
			
			log.debug("========告警规则模板录入结束========");
		}
		
		if("DISP_FAST".equals(mapping.getParameter())){
			log.debug("========快速录入告警规则模板页面初始化开始========");
			dto.setIgLog0022Form(form);
			dto = ctlBL.getDeviceByIp(dto);
			IGLOG0022VO vo = new IGLOG0022VO();
			vo.setMss00001TB(dto.getMss00001TB());
			vo.setPriority(form.getPriority());
			if(form.getAlarmmsgs() != null)
				vo.setAlarmmsg(form.getAlarmmsgs()[0]);
			super.<IGLOG0022VO>setVO(request, vo);
			log.debug("========快速录入告警规则模板页面初始化结束========");
		}
		
		if("INSERT_FAST".equals(mapping.getParameter())){
			log.debug("========快速录入告警规则开始========");
			dto.setIgLog0022Form(form);
			dto = ctlBL.fastConfigAlarmRule(dto);
			log.debug("========快速录入告警规则结束========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
