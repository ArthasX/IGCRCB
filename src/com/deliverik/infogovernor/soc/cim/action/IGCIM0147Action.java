package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0147Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01471VO;

/**
 * ������Ϣ��ʷ��¼����Action����
 *
 */
public class IGCIM0147Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0147Action.class);
	
	/**
	 * �¼�����
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
		IGCIM0147Form form = (IGCIM0147Form)actionForm;
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������Ϣ��ʷ��¼���������ʾ������ʼ========");
			
			//DTO��������趨
			dto.setIgcim0147Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGCIM0147Action(dto);
			
			
			//��������Ϣ��ʷ��¼��������趨��VO��
			IGCIM01471VO vo = new IGCIM01471VO(dto.getSoc0124Info(),
					dto.getSoc0107InfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCIM01471VO>setVO(req, vo);
			
			//�߼����������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if ("BACK".equals(mapping.getParameter())) {
			//������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}

}