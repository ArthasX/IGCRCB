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
import com.deliverik.infogovernor.asset.bl.IGASM24BL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;
import com.deliverik.infogovernor.asset.form.IGASM2406Form;
import com.deliverik.infogovernor.asset.vo.IGASM24061VO;

/**
 * �ĵ���ϵ������Action����
 *
 */
public class IGASM2406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2406Action.class);

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
		IGASM2406Form form = (IGASM2406Form)actionForm;
		
		//BLȡ��
		IGASM24BL ctlBL = (IGASM24BL) getBean("igasm24BL");
		
		//DTO����
		IGASM24DTO dto = new IGASM24DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�ĵ���ϵ�����������ʾ����
			log.debug("========�ĵ���ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM2406Form) req.getSession().getAttribute("IGASM2406Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2406");

			//DTO��������趨
			dto.setIgasm2406Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�ĵ���ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM2406Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM24061VO vo = new IGASM24061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM24061VO>setVO(req.getSession(), vo);
			saveToken(req);
			log.debug("========�ĵ���ϵ�����������ʾ��������========");
			
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
			//�ĵ���ϵɾ������
			log.debug("========�ĵ���ϵɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//�ĵ���ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========�ĵ���ϵɾ����������========");
			
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
