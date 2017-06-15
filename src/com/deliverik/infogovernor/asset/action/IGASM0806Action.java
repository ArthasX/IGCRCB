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
import com.deliverik.infogovernor.asset.form.IGASM0806Form;
import com.deliverik.infogovernor.asset.vo.IGASM08061VO;

/**
 * Ӧ�ù�ϵ������Action����
 *
 */
public class IGASM0806Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0806Action.class);

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
		IGASM0806Form form = (IGASM0806Form)actionForm;
		
		//BLȡ��
		IGASM08BL ctlBL = (IGASM08BL) getBean("igasm08BL");
		
		//DTO����
		IGASM08DTO dto = new IGASM08DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�����������ʾ����
			log.debug("========Ӧ�ù�ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM0806Form) req.getSession().getAttribute("IGASM0806Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0806");

			//DTO��������趨
			dto.setIgasm0806Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//Ӧ�ù�ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM0806Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM08061VO vo = new IGASM08061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM08061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========Ӧ�ù�ϵ�����������ʾ��������========");
			
			forword = "DISP";
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			if (req.getParameter("btn_back")!=null) {
				//���ذ�ť����ʱ�ķ��ش���
				forword = "BACK";
			}
			if (req.getParameter("btn_add")!=null) {
				//���Ӱ�ť����ʱ�Ĵ���
				forword = "ADD";
			}
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//Ӧ�ù�ϵɾ������
			log.debug("========Ӧ�ù�ϵɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//Ӧ�ù�ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========Ӧ�ù�ϵɾ����������========");
			
			forword = "DISP";
		}

		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forword);
	}
}
