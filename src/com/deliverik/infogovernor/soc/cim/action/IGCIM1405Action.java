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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM14BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM14DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1405Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM14051VO;

/**
 * ��Ա������Ϣ��ʷ��¼����Action����
 *
 */
public class IGCIM1405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1405Action.class);

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
		IGCIM1405Form form = (IGCIM1405Form)actionForm;
		//BLȡ��
		IGCIM14BL ctlBL = (IGCIM14BL) getBean("igcim14BL");
		//DTO����
		IGCIM14DTO dto = new IGCIM14DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��Ա������Ϣ��ʷ��¼���������ʾ����
			log.debug("========��Ա������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM1405");

			//DTO��������趨
			dto.setIgcim1405Form(form);
			
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��Ա������Ϣ��ʷ��¼���������ʾ�߼�����
//			dto = ctlBL.initIGCIM1405Action(dto);
			
			//����Ա������Ϣ��ʷ��¼��������趨��VO��
			IGCIM14051VO vo = new IGCIM14051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGCIM14051VO>setVO(req.getSession(), vo);
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
