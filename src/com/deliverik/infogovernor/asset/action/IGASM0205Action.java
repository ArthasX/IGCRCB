package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0205Form;
import com.deliverik.infogovernor.asset.vo.IGASM02051VO;

/**
 * ������������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM0205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0205Action.class);

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
		IGASM0205Form form = (IGASM0205Form)actionForm;
		
		//BLȡ��
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO����
		IGASM02DTO dto = new IGASM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0205");

			//DTO��������趨
			dto.setIgasm0205Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0205Action(dto);
			
			//��������������Ϣ��ʷ��¼��������趨��VO��
			IGASM02051VO vo = new IGASM02051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM02051VO>setVO(req.getSession(), vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========������������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//������������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
