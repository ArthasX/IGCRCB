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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM12BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1203Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM12031VO;

/**
 * ������Ϣ��ʷ��¼����Action����
 *
 */
public class IGCIM1203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1203Action.class);
	
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
		IGCIM1203Form form = (IGCIM1203Form)actionForm;
		//BLȡ��
		IGCIM12BL ctlBL = (IGCIM12BL) getBean("igcim12BL");
		//DTO����
		IGCIM12DTO dto = new IGCIM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcim1203form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGCIM1203Action(dto);
			
			
			//��������Ϣ��ʷ��¼��������趨��VO��
			IGCIM12031VO vo = new IGCIM12031VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			vo.setConfigItemVWInfoMap(dto.getSoc0129InfoVWMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCIM12031VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
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
