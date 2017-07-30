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
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1406Form;
import com.deliverik.infogovernor.asset.vo.IGASM14061VO;

/**
 * �����¼��ϵ��������Action����
 *
 */
public class IGASM1406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1406Action.class);

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
		IGASM1406Form form = (IGASM1406Form)actionForm;
		
		//BLȡ��
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO����
		IGASM14DTO dto = new IGASM14DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�����¼��ϵ�������������ʾ����
			log.debug("========�����¼��ϵ�������������ʾ������ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM1406Form) req.getSession().getAttribute("IGASM1406Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1406");

			//DTO��������趨
			dto.setIgasm1406Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�����¼��ϵ�������������ʾ�߼�����
			dto = ctlBL.initIGASM1406Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM14061VO vo = new IGASM14061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGASM14061VO>setVO(req.getSession(), vo);
			
			log.debug("========�����¼��ϵ�������������ʾ��������========");
			
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
			//�����¼��ϵɾ������
			log.debug("========�����¼��ϵɾ��������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//�����¼��ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========�����¼��ϵɾ����������========");
			
			forword = "DISP";
		}

		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forword);
	}
}