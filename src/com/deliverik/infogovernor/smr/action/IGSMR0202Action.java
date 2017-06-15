/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR02BL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.vo.IGSMR02021VO;

/**
 * ���������ѯAction����
 *
 */
public class IGSMR0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0101Action.class);

	/**
	 * ���������ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0202Form form = (IGSMR0202Form)actionForm;
		
		//BLȡ��
		IGSMR02BL ctlBL = (IGSMR02BL) getBean("igSMR02BL");
		
		//DTO����
		IGSMR02DTO dto = new IGSMR02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�걨�������������ʾ����
			log.debug("========���������ѯҳ���ʼ����ʾ����ʼ========");
			dto.setIgSMR0202Form(form);
			ctlBL.searchApproveSuggestionAllByPidid(dto);
			
			//��װVO
			IGSMR02021VO vo = new IGSMR02021VO();
			vo.setIg500Info(dto.getIg500Info());
			vo.setLstApproveSuggestionInfo(dto.getLstApproveSuggestionInfo());
			super.<IGSMR02021VO>setVO(request, vo);
			log.debug("========���������ѯҳ���ʼ����ʾ�������========");
			
		} 
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
