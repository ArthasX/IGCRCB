/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.action;


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
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0106Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;

/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: 日常运维计划修改ACTION
 * </p>
 * 
 */

public class IGMTP0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMTP0108Action.class);

	/**
	 * <p>
	 * Description: 查询ACTION
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		IGMTP0107Form form = (IGMTP0107Form)actionForm;
		
		IGMTP0106Form igmtp0106Form = (IGMTP0106Form)request.getSession().getAttribute("IGMTP0106Form");
		// 获取BL接口实例
		IGMTP01BL ctrlBL = (IGMTP01BL) getBean("igmtp01BL");
		
		// 实例化DTO
		IGMTP01DTO dto = new IGMTP01DTO();

		log.debug("========日常运维计划修改处理开始========");
		if ("MODIFY".equals(mapping.getParameter())){
			dto.setQjid(igmtp0106Form.getQjid());
			String periodType = igmtp0106Form.getPeriodType();
			String exeHour = igmtp0106Form.getQjhour();
			String exeMinute = igmtp0106Form.getQjminute();
			String startDate = igmtp0106Form.getQjcrttime();
			String qjtricron = ctrlBL.creatCronExp(periodType, exeHour, exeMinute, startDate);
			String periodInfo = ctrlBL.getPeriodInfo(periodType, exeHour, exeMinute, startDate);
			igmtp0106Form.setQjperiodinfo(periodInfo);
			igmtp0106Form.setQjtricron(qjtricron);
			dto.setIgmtp0106Form(igmtp0106Form);
			dto.setIgmtp0107Form(form);
			
			//取得日历画面选择的日期集合
			List<String> selectList = (List<String>)request.getSession().getAttribute("selectList");
			dto.setSelectList(selectList);
			try {
				dto = ctrlBL.updateQuartzJobs(dto);
			} catch (BLException e) {
				if(e.getErrors().get(0).getKey().equals("SchedulerException")){
					return mapping.findForward("ERROR");
				}
				log.debug(e.getMessage());
			}
			
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
			
		}
		log.debug("========日常运维计划修改处理结束========");
		return mapping.findForward("DISP");
	}
}
