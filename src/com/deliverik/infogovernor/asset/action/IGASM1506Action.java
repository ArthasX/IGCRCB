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
import com.deliverik.infogovernor.asset.bl.IGASM15BL;
import com.deliverik.infogovernor.asset.dto.IGASM15DTO;
import com.deliverik.infogovernor.asset.form.IGASM1506Form;
import com.deliverik.infogovernor.asset.vo.IGASM15061VO;

/**
 * ��Ա��ϵ��������Action����
 *
 */
public class IGASM1506Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1506Action.class);

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
		IGASM1506Form form = (IGASM1506Form)actionForm;
		
		//BLȡ��
		IGASM15BL ctlBL = (IGASM15BL) getBean("igasm15BL");
		
		//DTO����
		IGASM15DTO dto = new IGASM15DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//��Ա��ϵ�������������ʾ����
			log.debug("========��Ա��ϵ�������������ʾ������ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM1506Form) req.getSession().getAttribute("IGASM1506Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1506");

			//DTO��������趨
			dto.setIgasm1506Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��Ա��ϵ�������������ʾ�߼�����
			dto = ctlBL.initIGASM1506Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM15061VO vo = new IGASM15061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM15061VO>setVO(req.getSession(), vo);
			saveToken(req);
			
			log.debug("========��Ա��ϵ�������������ʾ��������========");
			
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
			//��Ա��ϵɾ������
			log.debug("========��Ա��ϵɾ��������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//��Ա��ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========��Ա��ϵɾ����������========");
			
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