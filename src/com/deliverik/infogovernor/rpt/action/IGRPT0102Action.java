/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.rpt.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.bl.IGRPT01BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT01DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0102Form;
import com.deliverik.infogovernor.rpt.vo.IGRPT01021VO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 统计分析-报表列表画面用Action处理
 *
 */
public class IGRPT0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRPT0102Action.class);
	
	
	
	/**
	 * 统计分析-报表列表画面用Action处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		//FORM取得
		IGRPT0102Form form = (IGRPT0102Form)actionForm;
		
		//BL取得
		IGRPT01BL ctlBL = (IGRPT01BL) getBean("igRPT01BL");
		
		//DTO生成
		IGRPT01DTO dto = new IGRPT01DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			//Session清除
			clearSessionFormData(req);
			
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//报表分类树查询处理
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			IGRPT01021VO vo = new IGRPT01021VO(dto.getReportFileDefinitionList(), dto.getCompleteNodeName());
			
			super.<IGRPT01021VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
		}
		
		else if ("CUSTOMR".equals(mapping.getParameter())) {
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//报表分类树查询处理
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			//查询订制报表
			dto = ctlBL.searchReportByCustom(dto);
			//过滤已订制报表
			List<ReportFileDefinition> rfdList = dto
					.getReportFileDefinitionList();
			List<ReportFileDefinition> srfdList = dto
					.getSelectedReportFileDefinitionList();
			if (rfdList != null && rfdList.size() > 0) {
				for (ReportFileDefinition srfd : srfdList) {
					for (ReportFileDefinition rfd : rfdList) {
						if (srfd.getRfdid().equals(rfd.getRfdid())) {
							rfdList.remove(rfd);
							break;
						}
					}

				}
			}
			
			
			IGRPT01021VO vo = new IGRPT01021VO(rfdList, dto.getCompleteNodeName());
			vo.setSelectedReportFileDefinitionList(srfdList);
			
			super.<IGRPT01021VO>setVO(req, vo);
			
		}
		
		else if ("INSERT".equals(mapping.getParameter())) {
			
			dto.setIgRPT0102Form(form);
			
			
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.insertCustomReport(dto);
			
			addMessage(req, new ActionMessage("IGCO10000.I004","报表订制"));
			
		}
		else if ("DELETE".equals(mapping.getParameter())) {
			
			dto.setIgRPT0102Form(form);
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.deleteCustomReport(dto);
			
			addMessage(req, new ActionMessage("IGCO10000.I006","报表订制"));
			
		}
		else if ("ORDER".equals(mapping.getParameter())) {
			
			dto.setIgRPT0102Form(form);
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.orderCustomReport(dto);
			
			
		}
		
		else if ("FLEX".equals(mapping.getParameter())) {
			
			
		}
		
		return mapping.findForward("DISP");
		
	}

}
