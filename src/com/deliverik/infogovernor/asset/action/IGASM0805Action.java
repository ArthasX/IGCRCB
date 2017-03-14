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
import com.deliverik.infogovernor.asset.bl.IGASM08BL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;
import com.deliverik.infogovernor.asset.form.IGASM0805Form;
import com.deliverik.infogovernor.asset.vo.IGASM08051VO;

/**
 * Ӧ��������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM0805Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0805Action.class);

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
		IGASM0805Form form = (IGASM0805Form)actionForm;
		
		//BLȡ��
		IGASM08BL ctlBL = (IGASM08BL) getBean("igasm08BL");
		
		//DTO����
		IGASM08DTO dto = new IGASM08DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ��������Ϣ��ʷ��¼���������ʾ����
			log.debug("========Ӧ��������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0805");

			//DTO��������趨
			dto.setIgasm0805Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//Ӧ��������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0805Action(dto);
			
			//��Ӧ��������Ϣ��ʷ��¼��������趨��VO��
			IGASM08051VO vo = new IGASM08051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());

			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM08051VO>setVO(req.getSession(), vo);
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========Ӧ��������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//Ӧ��������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
