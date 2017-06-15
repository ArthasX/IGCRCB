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
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2806Form;
import com.deliverik.infogovernor.asset.vo.IGASM28061VO;

/**
 * ������ϵ������Action����
 *
 */
public class IGASM2806Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2806Action.class);

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
		IGASM2806Form form = (IGASM2806Form)actionForm;
		
		//BLȡ��
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO����
		IGASM28DTO dto = new IGASM28DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//������ϵ�����������ʾ����
			log.debug("========������ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM2806Form) req.getSession().getAttribute("IGASM2806Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2806");

			//DTO��������趨
			dto.setIgasm2806Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM2806Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM28061VO vo = new IGASM28061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM28061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========������ϵ�����������ʾ��������========");
			
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
			//������ϵɾ������
			log.debug("========������ϵɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//������ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========������ϵɾ����������========");
			
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
