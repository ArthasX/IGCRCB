package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM10BL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1006Form;
import com.deliverik.infogovernor.sym.vo.IGSYM10061VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGSYM1006Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1006Action.class);

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
		IGSYM1006Form form = (IGSYM1006Form)actionForm;
		
		//BLȡ��
		IGSYM10BL ctlBL = (IGSYM10BL) getBean("igsym10BL");
		
		//DTO����
		IGSYM10DTO dto = new IGSYM10DTO();

		if( "DISP".equals(mapping.getParameter())){
			//������ϸ��Ϣ��ѯ���������ʾ����
			log.debug("========������ϸ��Ϣ��ѯ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgsym1006Form(form);
			
			//������ϸ��Ϣ���������ʾ�����߼�����
			dto = ctlBL.initIGSYM1006Action(dto);
			
			//��������ϸ��Ϣ��������趨��VO��
			IGSYM10061VO vo = new IGSYM10061VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetailList());
			vo.setFlag(dto.getFlag());
			super.<IGSYM10061VO>setVO(req, vo);

			log.debug("========������ϸ��Ϣ���������ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//������ϸɾ������
			log.debug("========������ϸɾ������ʼ========");
			//DTO��������趨
			dto.setIgsym1006Form(form);
			
			//��������ɾ�������߼�����
			ctlBL.deleteCodeDetailAction(dto);
			
			log.debug("========������ϸɾ����������========");
		}
		
		if ("BACK".equals(mapping.getParameter())){
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���ش���
				return mapping.findForward("BACK");
			}

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
