package com.deliverik.infogovernor.syslog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.syslog.bl.IGLOG004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;
import com.deliverik.infogovernor.syslog.vo.IGLOG0043VO;
/**
 * 
 * 规则条件模板录入Action
 *
 * @作者 zhaoyong
 *
 * 2013-4-2
 */
public class IGLOG0043Action extends BaseAction{
	static Log log = LogFactory.getLog(IGLOG0043Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//实例化DTO
		IGLOG0041DTO dto = new IGLOG0041DTO();
		
		//实例化form表单
		IGLOG0042Form form = (IGLOG0042Form) actionForm;
		
		//实例化ctrolBL
		IGLOG004BL ctlBL = (IGLOG004BL) getBean("iglog004BL");
		
		//模板录入页面初始化
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========规则条件模板录入页面初始化开始========");
			
			dto = ctlBL.getAlarmPriority(dto);
			String couldReturn = request.getParameter("couldReturn");
			
			IGLOG0041VO vo = new IGLOG0041VO();
			vo.setCouldReturn(couldReturn);
			vo.setAlarmPriorities(dto.getAlarmPriorities());
			super.<IGLOG0041VO>setVO(request,vo);
			
			log.debug("========规则条件模板录入页面初始化结束========");
		}
		
		//是模板录入
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========规则条件模板录入开始========");
			
			//将form放入到dto中
			dto.setIgLog0042Form(form);
			
			//调用ctlBL录入规则条件
			dto = ctlBL.insertMss0004(dto);
			
			//成功信息
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			
			log.debug("========规则条件模板录入结束========");
		}
		
		//模板修改页面初始化
		if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========规则条件模板修改页面初始化开始========");
			
			//将form放入到载体dto中
			dto.setIgLog0042Form(form);
			
			//调用ctlBL查询当前规则条件
			dto = ctlBL.getMss0004(dto);
			
			dto = ctlBL.getAlarmPriority(dto);
			
			dto = ctlBL.getDeviceListString(dto);
			
			//实例化载体vo
			IGLOG0043VO vo = new IGLOG0043VO();
			
			vo.setMss00004TB(dto.getMss00004TB());
			
			vo.setMss00003InfoList(dto.getMss00003InfoList());
			
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			
			vo.setAlarmPriorities(dto.getAlarmPriorities());
			
			vo.setDeviceListString(dto.getDeviceListString());
			
			super.<IGLOG0043VO>setVO(request,vo);
			
			log.debug("========规则条件模板修改页面初始化结束========");
		}
		
		//模板修改
		if( "EDIT".equals(mapping.getParameter())){
			log.debug("========规则条件模板修改开始========");
			
			//将form放入到载体dto中
			dto.setIgLog0042Form(form);
			
			//调用ctlBL修改规则条件模板
			dto=ctlBL.updateMss0004(dto);
			
			//成功信息
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			
			log.debug("========规则条件模板修改结束========");
			
		}
		
		
		return mapping.findForward("DISP");
	}

}
