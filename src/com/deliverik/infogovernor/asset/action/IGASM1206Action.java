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
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1206Form;
import com.deliverik.infogovernor.asset.vo.IGASM12061VO;

/**
 * �����ϵ������Action����
 *
 */
public class IGASM1206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1206Action.class);

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
		IGASM1206Form form = (IGASM1206Form)actionForm;
		
		//BLȡ��
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO����
		IGASM12DTO dto = new IGASM12DTO();
		
		//������ת�趨
		String forword = null;
		
		if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
			//�����ϵ�����������ʾ����
			log.debug("========�����ϵ�����������ʾ����ʼ========");
			if ("REDISP".equals(mapping.getParameter())){
				form = (IGASM1206Form) req.getSession().getAttribute("IGASM1206Form");
			}

			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1206");

			//DTO��������趨
			dto.setIgasm1206Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//�����ϵ�����������ʾ�߼�����
			dto = ctlBL.initIGASM1206Action(dto);
			
			//�����͹�ϵ������Ϣ��������趨��VO��
			IGASM12061VO vo = new IGASM12061VO(dto.getEntityItemVWInfo(),
					dto.getParEntityItemRelationList(),
					dto.getCldEntityItemRelationList());
			
			super.<IGASM12061VO>setVO(req.getSession(), vo);
			
			log.debug("========�����ϵ�����������ʾ��������========");
			
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
			//�����ϵɾ������
			log.debug("========�����ϵɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItemRelation(form.getDeleteEirid());
			
			//�����ϵɾ���߼�����
			ctlBL.deleteEntityItemRelationAction(dto);
			
			log.debug("========�����ϵɾ����������========");
			
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
