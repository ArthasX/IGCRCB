/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;


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

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0309Form;
import com.csebank.lom.vo.IGLOM0309VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;


public class IGLOM0309Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0309Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
		String forward="";
		IGLOM0309Form form = (IGLOM0309Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========预支月度统计初始化开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预支月度统计初始化开始终了========");
			forward="DISP";
		}	
		//统计部门查询
		if( "SEARCH".equals(mapping.getParameter())){
			//获取BL接口实例
			IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
			//实例化DTO
			IGLOM03DTO dto = new IGLOM03DTO();
			log.debug("========预支月度统计查询处理开始========");
			
            int maxCnt = getMaxDataCount("IGLOM0309");
			
            dto.setAdvancesummaryCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//调用BL查询
			dto = ctlBL.searchAdvancesummaryAction(dto);
			
			//构造VO
			IGLOM0309VO vo = new IGLOM0309VO();
			vo.setSummaryList(dto.getAdvanceSummarylList());
			super.<IGLOM0309VO>setVO(req, vo);
			
			log.debug("========预支月度统计查询处理终了========");
			forward="DISP";
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		}
		if(StringUtils.isNotEmpty(req.getParameter("report"))) {
			return mapping.findForward("REPORT");
		}
		return mapping.findForward(forward);
	}
	
}
