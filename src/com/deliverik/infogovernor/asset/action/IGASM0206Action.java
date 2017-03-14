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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0206Form;
import com.deliverik.infogovernor.asset.vo.IGASM02061VO;

/**
 * �������ϵ������Action����
 *
 */
public class IGASM0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0206Action.class);

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
		IGASM0206Form form = (IGASM0206Form)actionForm;
		
		//BLȡ��
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO����
		IGASM02DTO dto = new IGASM02DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�������ϵ�����������ʾ����
			log.debug("========�������ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM0206Form) req.getSession().getAttribute("IGASM0206Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0206");

			//DTO��������趨
			dto.setIgasm0206Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�������ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM0206Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM02061VO vo = new IGASM02061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGASM02061VO>setVO(req.getSession(), vo);
			
			log.debug("========�������ϵ�����������ʾ��������========");
			
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
			//�������ϵɾ������
			log.debug("========�������ϵɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//�������ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========�������ϵɾ����������========");
			
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
