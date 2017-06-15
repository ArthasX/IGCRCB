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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0129Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01341VO;

/**
 * Ӧ�ò�ѯ����Action���� IGCIM0113Action
 *
 */
public class IGCIM0129Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0129Action.class);

	/**
	 * FS��ϵ����
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
		IGCIM0129Form form = (IGCIM0129Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		
		if ("DISP".equals(mapping.getParameter())){
			//FS��ϵ��ʾ
			log.debug("========FS��ϵ��ʾ��ʼ========");

			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgasm0813Form(form);
			
			dto = ctlBL.searchFSRelationListAction(dto);	//FS��ѡ�б�
			
			//FS��ϵ��ʾVO
			IGCIM01341VO vo = new IGCIM01341VO();
			vo.setEntityItemList(dto.getEntityItemList());		//FS��ѡ�б�
			vo.setEntityItemedList(dto.getEntityItemedList());		//FS�Ѿ�ѡ�б�
			super.<IGCIM01341VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========FS��ϵ��ʾ����========");
		}else if ("INSERT".equals(mapping.getParameter())){
			log.debug("========FS��ϵ��ӿ�ʼ========");
			dto.setIgasm0813Form(form);
			dto = ctlBL.insertFSRelationAction(dto);
			addMessage(req, new ActionMessage("IGCIM0114.I002"));
			log.debug("========FS��ϵ�������========");
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========FS��ϵɾ����ʼ========");
			dto.setIgasm0813Form(form);
			dto = ctlBL.deleteFSRelationAction(dto);
			addMessage(req, new ActionMessage("IGCIM0114.I001"));
			log.debug("========FS��ϵɾ������========");
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
