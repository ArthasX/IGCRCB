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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM10BL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1001Form;
import com.deliverik.infogovernor.sym.vo.IGSYM10011VO;

/**
 * ���ݷ����б���Action����
 *
 */
public class IGSYM1001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1001Action.class);

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
		IGSYM1001Form form = (IGSYM1001Form)actionForm;
		
		//BLȡ��
		IGSYM10BL ctlBL = (IGSYM10BL) getBean("igsym10BL");
		
		//DTO����
		IGSYM10DTO dto = new IGSYM10DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���ݷ����б��������ʾ����
			log.debug("========���ݷ����б��������ʾ����ʼ========");
			
			getPaginDTO(req,"IGSYM1001");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSYM1001");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGSYM1001Action(dto);
			
			IGSYM10011VO vo = new IGSYM10011VO(dto.getCodeCategoryList());
			
			super.<IGSYM10011VO>setVO(req, vo);
			
			log.debug("========���ݷ����б��������ʾ��������========");
		}

		if ("DELETE".equals(mapping.getParameter())){
			//���ݷ���ɾ������
			log.debug("========���ݷ���ɾ������ʼ========");
			
			//DTO��������趨
			dto.setIgsym1001Form(form);
			
			//���ݷ���ɾ���߼�����
			ctlBL.deleteCodeCategoryAction(dto);
			
			log.debug("========���ݷ���ɾ����������========");
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
