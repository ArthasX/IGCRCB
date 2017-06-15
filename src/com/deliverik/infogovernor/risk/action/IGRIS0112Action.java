/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0112Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01121VO;

/**
 * 审计人查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0112Action.class);

	/**
	 * 审计人查询处理
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
		IGRIS0112Form form = (IGRIS0112Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		dto.setIgRIS0112Form(form);
		
		if ( "DISP".equals(mapping.getParameter())){
			//审计人查询处理
			log.debug("========审计人查询处理开始========");
			
			//审计人信息检索逻辑调用
			dto = ctlBL.searchRiskAuditDefResultVWAction(dto);
			
			//将审计人信息检索结果设定到VO中
			IGRIS01121VO vo = new IGRIS01121VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefResultVWInfoList(dto.getRiskAuditDefResultVWInfoList());
			
			super.<IGRIS01121VO>setVO(req, vo);
			
			log.debug("========审计人查询处理终了========");
		} else if ( "SAVE".equals(mapping.getParameter())){
			//审计人保存处理
			log.debug("========审计人保存处理开始========");
			
			//审计人保存逻辑调用
			dto = ctlBL.saveRiskAuditResultAction(dto);
			
			log.debug("========审计人保存处理终了========");
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
