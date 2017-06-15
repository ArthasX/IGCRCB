package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0304Form;
import com.deliverik.infogovernor.vo.IGCOM0304VO;

/**
 * ���ݲ�ѯHELP������Action����
 *
 */
public class IGCOM0304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0304Action.class);

	/**
	 * 
	 * �¼�����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCOM0304Form form = (IGCOM0304Form)actionForm;
		
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����HELP��ѯ���������ʾ����ʼ========");
			
			form = new IGCOM0304Form();
			
			req.getSession().setAttribute("IGCOM0304Form", form);
			
			ctlBL.initIGCOM0304Action(dto);
			
			req.getSession().setAttribute("ADCodeCategory", dto.getCodeCategorylList());
			
			log.debug("========����HELP��ѯ���������ʾ��������========");
		}

		log.debug("========����HELP��ѯ����ʼ========");

		//��ҳ��DTOȡ��
		getPaginDTO(req,"IGCOM0304");

		PagingDTO pDto;
		
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
//		pDto.setFromCount(form.getFromCount());
		//��ѯ��¼������ȡ��
		int maxCnt = getMaxDataCount("IGCOM0304");
		
		//DTO��������趨
		dto.setIgcom0304Form(form);
		
		dto.setMaxSearchCount(maxCnt);
		
		dto.setPagingDto(pDto);
		
		//�ʲ���Ϣ�����߼�����
		dto = ctlBL.searchCodeDetailAction(dto);
		
		//���ʲ���Ϣ��������趨��VO��
		IGCOM0304VO vo = new IGCOM0304VO(dto.getCodeDetailList());
		
		super.<IGCOM0304VO>setVO(req, vo);
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		log.debug("========����HELP��ѯ��������========");

		return mapping.findForward("DISP");
	}
}
