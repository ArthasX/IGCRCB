/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1405Form;
import com.deliverik.infogovernor.sym.vo.IGSYM14051VO;

/**
 * ����汾�б���Action����
 *
 */
public class IGSYM1405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1405Action.class);

	/**
	 * Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSYM1405Form form = (IGSYM1405Form)actionForm;
		
		//BLȡ��
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO����
		IGSYM14DTO dto = new IGSYM14DTO();
		
		//��ת
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//����汾�б��������ʾ����
			log.debug("========����汾�б��������ʾ����ʼ========");
			
			dto.setReportFileVersionSearchCond(form);
			
			ctlBL.searchReportFileVersionAction(dto);
			
			//�趨VO
			IGSYM14051VO vo = new IGSYM14051VO(dto.getReportFileDefinition(), dto.getReportFileVersionList());
			
			super.<IGSYM14051VO>setVO(req, vo);
			
			log.debug("========����汾�б��������ʾ��������========");
			
		} else if( "ASSIGN".equals(mapping.getParameter())){
			//����ָ���汾����
			log.debug("========����ָ���汾����ʼ========");
			
			dto.setRfvid(form.getRfvid());
			
			ctlBL.assignCurrentReportFileVersionAction(dto);
			
			log.debug("========����ָ���汾��������========");
			
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
