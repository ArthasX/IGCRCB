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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM02BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM02031VO;

/**
 * 规则模板修改处理
 * @author zhangnan 
 * 2013.08.02
 */
public class IGALM0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0203Action.class);

	/**
	 * 规则模板修改处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0201Form form = (IGALM0201Form)actionForm;
		
		//BL取得
		IGALM02BL ctlBL = (IGALM02BL) getBean("igalm02BL");
		//DTO生成
		IGALM02DTO dto = new IGALM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========规则模板修改画面初期显示处理开始========");
			dto.setIgalm0201Form(form);
			dto = ctlBL.initRuleTemp(dto);
			//规则条件取得
			List<CRM07TB> crm07TBList = dto.getCrm07TBList();
			//监控指标取得
			List<LabelValueBean> monitorIndexList = dto.getMonitorIndexList();
			req.setAttribute("monitorIndexList", monitorIndexList);
			IGALM02031VO vo=new IGALM02031VO();
			vo.setCrm07TBList(crm07TBList);
			super.<IGALM02031VO>setVO(req, vo);
			log.debug("========规则模板修改画面初期显示处理终了========");
			
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========规则模板修改处理开始========");
			dto.setIgalm0201Form(form);
			dto = ctlBL.updateRuleTemp(dto);
			log.debug("========规则模板修改处理终了========");
		} 
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward("DISP");
		
	}
}
