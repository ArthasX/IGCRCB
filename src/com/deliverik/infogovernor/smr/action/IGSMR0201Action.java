/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.action;

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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR02BL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.vo.IGSMR02011VO;

/**
 * ����������Action����
 *
 */
public class IGSMR0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0101Action.class);

	/**
	 * ���������Ӵ���
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
		IGSMR0201Form form = (IGSMR0201Form)actionForm;
		
		//BLȡ��
		IGSMR02BL ctlBL = (IGSMR02BL) getBean("igSMR02BL");
		
		//DTO����
		IGSMR02DTO dto = new IGSMR02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�걨�������������ʾ����
			log.debug("========����������ҳ���ʼ����ʾ����ʼ========");
			dto.setIgSMR0201Form(form);
			ctlBL.searchApproveSuggestion(dto);
			if(dto.getApproveSuggestionInfo() != null){
				form.setId(dto.getApproveSuggestionInfo().getId());
				form.setSuggestion(dto.getApproveSuggestionInfo().getSuggestion());
			}
			
			//��װVO
			IGSMR02011VO vo = new IGSMR02011VO();
			vo.setIg500Info(dto.getIg500Info());
			vo.setPidname(dto.getPidname());
			super.<IGSMR02011VO>setVO(request, vo);
			log.debug("========��������Ӽ�ҳ���ʼ����ʾ�������========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//���������������
			log.debug("========���������������ʼ========");
			
			//DTO��������趨
			dto.setIgSMR0201Form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.saveApproveSuggestion(dto);//�����������
			
			//����ɹ���ʶ
			request.setAttribute("flag", "1");
			
			//�Ƿ��������������
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				request.setAttribute("content", "1");
			}
			
			log.debug("========������������������========");
			
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
