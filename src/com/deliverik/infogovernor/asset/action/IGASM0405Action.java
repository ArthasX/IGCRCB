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
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0405Form;
import com.deliverik.infogovernor.asset.vo.IGASM04051VO;

/**
 * ��ͬ������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM0405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0405Action.class);

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
		IGASM0405Form form = (IGASM0405Form)actionForm;
		
		//BLȡ��
		IGASM04BL ctlBL = (IGASM04BL) getBean("igasm04BL");
		//DTO����
		IGASM04DTO dto = new IGASM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��ͬ������Ϣ��ʷ��¼���������ʾ����
			log.debug("========��ͬ������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0405");

			//DTO��������趨
			dto.setIgasm0405Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��ͬ������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0405Action(dto);
			
			//����ͬ������Ϣ��ʷ��¼��������趨��VO��
			IGASM04051VO vo = new IGASM04051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM04051VO>setVO(req.getSession(), vo);
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========��ͬ������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//��ͬ������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
