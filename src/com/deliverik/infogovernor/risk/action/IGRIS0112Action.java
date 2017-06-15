/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����˲�ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0112Action.class);

	/**
	 * ����˲�ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGRIS0112Form form = (IGRIS0112Form)actionForm;
		
		//BLȡ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO����
		IGRIS01DTO dto = new IGRIS01DTO();
		
		dto.setIgRIS0112Form(form);
		
		if ( "DISP".equals(mapping.getParameter())){
			//����˲�ѯ����
			log.debug("========����˲�ѯ����ʼ========");
			
			//�������Ϣ�����߼�����
			dto = ctlBL.searchRiskAuditDefResultVWAction(dto);
			
			//���������Ϣ��������趨��VO��
			IGRIS01121VO vo = new IGRIS01121VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefResultVWInfoList(dto.getRiskAuditDefResultVWInfoList());
			
			super.<IGRIS01121VO>setVO(req, vo);
			
			log.debug("========����˲�ѯ��������========");
		} else if ( "SAVE".equals(mapping.getParameter())){
			//����˱��洦��
			log.debug("========����˱��洦��ʼ========");
			
			//����˱����߼�����
			dto = ctlBL.saveRiskAuditResultAction(dto);
			
			log.debug("========����˱��洦������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
