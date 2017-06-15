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
import com.deliverik.infogovernor.risk.form.IGRIS0117Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01171VO;

/**
 * 审计报告查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0117Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0117Action.class);

	/**
	 * 审计报告查询处理
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
		IGRIS0117Form form = (IGRIS0117Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//获取审计编号下拉列表
		ctlBL.searchRiskAuditInsLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		
		if( "DISP".equals(mapping.getParameter())){
			//审计报告查询画面初期显示处理
			log.debug("========审计报告查询画面初期显示处理开始========");
			log.debug("========审计报告查询画面初期显示处理终了========");
		} else if ( "SEARCH".equals(mapping.getParameter())){
			//审计报告查询处理
			log.debug("========审计报告查询处理开始========");
			
			dto.setIgRIS0117Form(form);
			
			//审计报告信息检索逻辑调用
			dto = ctlBL.searchRiskAuditReportAction(dto);
			
			//将审计报告信息检索结果设定到VO中
			IGRIS01171VO vo = new IGRIS01171VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefResultVWInfoList(dto.getRiskAuditDefResultVWInfoList());
			vo.setRadrisklevelList(dto.getRadrisklevelList());
			vo.setRadfrequencyList(dto.getRadfrequencyList());
			vo.setRadmodeList(dto.getRadmodeList());
			vo.setRadtypeList(dto.getRadtypeList());
			vo.setRarplanscoreList(dto.getRarplanscoreList());
			vo.setRarexecscoreList(dto.getRarexecscoreList());
			vo.setRaroverallscoreList(dto.getRaroverallscoreList());
			vo.setRiskAuditIns(dto.getRiskAuditIns());
			//vo.setChildCountMap(dto.getChildCountMap());
			
			super.<IGRIS01171VO>setVO(req, vo);
			
			log.debug("========审计报告查询处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		String forwardName = "DISP";
		String report = req.getParameter("report");
		if(null != report && "1".equals(report)){
			forwardName = "REPORT";
		}
	
		return mapping.findForward(forwardName);
	}
}
