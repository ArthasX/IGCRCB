/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ͳ�Ʒ���-�����б�����Action����
 *
 */
public class IGRPT0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRPT0102Action.class);
	
	
	
	/**
	 * ͳ�Ʒ���-�����б�����Action����
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

		//FORMȡ��
		IGRPT0102Form form = (IGRPT0102Form)actionForm;
		
		//BLȡ��
		IGRPT01BL ctlBL = (IGRPT01BL) getBean("igRPT01BL");
		
		//DTO����
		IGRPT01DTO dto = new IGRPT01DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			//Session���
			clearSessionFormData(req);
			
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�����������ѯ����
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			IGRPT01021VO vo = new IGRPT01021VO(dto.getReportFileDefinitionList(), dto.getCompleteNodeName());
			
			super.<IGRPT01021VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
		}
		
		else if ("CUSTOMR".equals(mapping.getParameter())) {
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�����������ѯ����
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			//��ѯ���Ʊ���
			dto = ctlBL.searchReportByCustom(dto);
			//�����Ѷ��Ʊ���
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
			
			
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.insertCustomReport(dto);
			
			addMessage(req, new ActionMessage("IGCO10000.I004","������"));
			
		}
		else if ("DELETE".equals(mapping.getParameter())) {
			
			dto.setIgRPT0102Form(form);
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.deleteCustomReport(dto);
			
			addMessage(req, new ActionMessage("IGCO10000.I006","������"));
			
		}
		else if ("ORDER".equals(mapping.getParameter())) {
			
			dto.setIgRPT0102Form(form);
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.orderCustomReport(dto);
			
			
		}
		
		else if ("FLEX".equals(mapping.getParameter())) {
			
			
		}
		
		return mapping.findForward("DISP");
		
	}

}
