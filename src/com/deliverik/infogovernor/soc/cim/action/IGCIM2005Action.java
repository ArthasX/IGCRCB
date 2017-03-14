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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2005Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM20051VO;

/**
 * Ӧ�ù�ϵ������Action����
 *
 */
public class IGCIM2005Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2005Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM2005Form form = (IGCIM2005Form)actionForm;
		
		//BLȡ��
		IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
		
		//DTO����
		IGCIM20DTO dto = new IGCIM20DTO();
		dto.setLocale(this.getLocale(req));
		//������ת�趨
		String forword = null;
		req.setAttribute("backurl", req.getParameter("backurl"));
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�����������ʾ����
			log.debug("========Ӧ�ù�ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGCIM2005Form) req.getSession().getAttribute("IGCIM2005Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM2005");

			//DTO��������趨
			dto.setIgcim2005Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//Ӧ�ù�ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGCIM2005Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGCIM20051VO vo = new IGCIM20051VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationMap(),
					dto.getCldEntityItemRelationMap(),
					dto.getParCount(),
					dto.getCldCount());
			vo.setParEntityRelationMap(dto.getParEntityRelationMap());
			vo.setCldEntityRelationMap(dto.getCldEntityRelationMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGCIM20051VO>setVO(req.getSession(), vo);
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
			ctlBL.deleteEntityItemRelationActionApp(dto);
			
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
