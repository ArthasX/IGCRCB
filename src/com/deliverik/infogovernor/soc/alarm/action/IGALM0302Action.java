/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM03BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0302Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM03021VO;

/**
 * 监控对象与告警规则配置
 * @author wangxing
 * 2013.08.02
 */
public class IGALM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0302Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0302Form form = (IGALM0302Form)actionForm;
		
		//BL取得
		IGALM03BL ctlBL = (IGALM03BL) getBean("igalm03BL");
		//DTO生成
		IGALM03DTO dto = new IGALM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========监控对象配置画面初期显示处理开始========");
			form.reset(mapping, request);
			dto.setIgalm0302Form(form);
			dto = ctlBL.getRuleTemps(dto);
			dto = ctlBL.getCRM09Info(dto);
			
			String flag = request.getParameter("flag");
			
			IGALM03021VO vo = new IGALM03021VO();
			vo.setRuleTemps(dto.getRuleTemps());
			vo.setRuleTempsNeed(dto.getRuleTempsNeed());
			vo.setCrm09Info(dto.getCrm09Info());
			vo.setFlag(flag);
			super.<IGALM03021VO>setVO(request, vo);
			
			log.debug("========监控对象查询配置画面初期显示处理终了========");
		}else if("Insert".equals(mapping.getParameter())){
			log.debug("========监控对象配置处理开始========");
			dto.setIgalm0302Form(form);
			dto = ctlBL.insertRuleTemps(dto);
			
			if("yes".equals(form.getFlag())){
				return mapping.findForward("DISP1");
			}
			log.debug("========监控对象配置处理终了========");
		}
	
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
	}
}
