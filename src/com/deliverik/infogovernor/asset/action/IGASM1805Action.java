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
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1805Form;
import com.deliverik.infogovernor.asset.vo.IGASM18051VO;

/**
 * ϵͳ������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM1805Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1805Action.class);

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
		IGASM1805Form form = (IGASM1805Form)actionForm;
		
		//BLȡ��
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO����
		IGASM18DTO dto = new IGASM18DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//ϵͳ������Ϣ��ʷ��¼���������ʾ����
			log.debug("========ϵͳ������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1805");

			//DTO��������趨
			dto.setIgasm1805Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//ϵͳ������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM1805Action(dto);
			
			//��ϵͳ������Ϣ��ʷ��¼��������趨��VO��
			IGASM18051VO vo = new IGASM18051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM18051VO>setVO(req.getSession(), vo);
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========ϵͳ������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//ϵͳ������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
