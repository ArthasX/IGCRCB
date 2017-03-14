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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0412Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04121VO;

/**
 * ����汾�б���Action����
 *
 */
public class IGSYM0412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM0412Action.class);

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
		IGSYM0412Form form = (IGSYM0412Form)actionForm;
		
		//BLȡ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//DTO����
		IGSYM04DTO dto = new IGSYM04DTO();
		
		//��ת
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//����汾�б��������ʾ����
			log.debug("========����汾�б��������ʾ����ʼ========");
			
			dto.setReportFileVersionSearchCond(form);
			
			ctlBL.searchReportFileVersionAction(dto);
			
			//�趨VO
			IGSYM04121VO vo = new IGSYM04121VO(dto.getReportFileDefinition(), dto.getReportFileVersionList());
			
			super.<IGSYM04121VO>setVO(req, vo);
			
			log.debug("========����汾�б��������ʾ��������========");
			
		} else if( "ASSIGN".equals(mapping.getParameter())){
			//����ָ���汾����
//			log.debug("========����ָ���汾����ʼ========");
//			
//			dto.setRfvid(form.getRfvid());
//			
//			ctlBL.assignCurrentReportFileVersionAction(dto);
//			
//			log.debug("========����ָ���汾��������========");
			
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
