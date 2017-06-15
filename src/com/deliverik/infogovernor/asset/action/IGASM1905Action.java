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
import com.deliverik.infogovernor.asset.bl.IGASM19BL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;
import com.deliverik.infogovernor.asset.form.IGASM1905Form;
import com.deliverik.infogovernor.asset.vo.IGASM19051VO;

/**
 * ��Ա������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM1905Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1905Action.class);

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
		IGASM1905Form form = (IGASM1905Form)actionForm;
		//BLȡ��
		IGASM19BL ctlBL = (IGASM19BL) getBean("igasm19BL");
		//DTO����
		IGASM19DTO dto = new IGASM19DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��Ա������Ϣ��ʷ��¼���������ʾ����
			log.debug("========��Ա������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1905");

			//DTO��������趨
			dto.setIgasm1905Form(form);
			
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��Ա������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM1905Action(dto);
			
			//����Ա������Ϣ��ʷ��¼��������趨��VO��
			IGASM19051VO vo = new IGASM19051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM19051VO>setVO(req.getSession(), vo);
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========��Ա������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//��Ա������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
