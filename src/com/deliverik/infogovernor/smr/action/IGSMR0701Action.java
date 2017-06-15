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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR07BL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0701Form;
import com.deliverik.infogovernor.smr.vo.IGSMR04021VO;
import com.deliverik.infogovernor.smr.vo.IGSMR07011VO;

/**
 * �걨����Action����
 *
 */
public class IGSMR0701Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSMR0701Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSMR0701Form form = (IGSMR0701Form)actionForm;
		
		//BLȡ��
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
		
		//DTO����
		IGSMR07DTO dto = new IGSMR07DTO();
		
		IGSMR07011VO vo = new IGSMR07011VO();
		
		//DTO��������趨
		dto.setIgSMR0701Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//�걨�������������ʾ����
			log.debug("========�����ڱ�����ҳ����ʾ����ʼ========");
			//��ʼ����ò����ڱ����б�
			ctlBL.initSMR0701Action(dto);

			vo.setIg380List(dto.getIg380List());
			
			saveToken(req);
			
			super.<IGSMR07011VO>setVO(req, vo);
			log.debug("========�����ڱ�����ҳ����ʾ�������========");
		} else if( "INSERT".equals(mapping.getParameter())){
			//�걨��������
			log.debug("========�����ڱ�������ʼ========");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR0701Action(dto);//�����ڱ�����
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========�걨���������========");
			
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
