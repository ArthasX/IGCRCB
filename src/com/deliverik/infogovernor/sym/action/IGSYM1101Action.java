/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

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
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1101Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_���ݷ����б���Action����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1101Action.class);

	/**
	 * ���ݷ����б���Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGSYM1101Form form = (IGSYM1101Form)actionForm;
		//BLȡ��
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO����
		IGSYM11DTO dto = new IGSYM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���ݷ����б��������ʾ����
			log.debug("========���ݷ����б��������ʾ����ʼ========");
			
			getPaginDTO(req,"IGSYM1101");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSYM1101");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGSYM1101Action(dto);
			
			IGSYM11011VO vo = new IGSYM11011VO(dto.getCodeCategoryInfoList());
			
			saveToken(req);	
			
			super.<IGSYM11011VO>setVO(req, vo);
			
			log.debug("========���ݷ����б��������ʾ��������========");
		}else if("INSERTDISP".equals(mapping.getParameter())){
			log.debug("========���ݷ���Ǽǻ��������ʾ����ʼ========");
			saveToken(req);	
			log.debug("========���ݷ���Ǽǻ��������ʾ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========���ݷ���ǼǴ���ʼ========");
			dto.setIgsym1101Form(form);

			if (isTokenValid(req, true)){
				//����BL����
				dto = ctlBL.saveIGSYM1107Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========���ݷ���ǼǴ�������========");
		}else if ("DEL".equals(mapping.getParameter())){
			//���ݷ���ɾ������
			log.debug("========���ݷ���ɾ������ʼ========");

			//DTO��������趨
			dto.setIgsym1101Form(form);
			
			if (isTokenValid(req, true)){
				//���ݷ���ɾ���߼�����
				ctlBL.deleteIGSYM1101Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========���ݷ���ɾ����������========");
		}else if ("DELETE".equals(mapping.getParameter())){
			//���ݷ���ɾ������
			log.debug("========���ݷ���ɾ������ʼ========");
			
			//IGSYM1101Form form = (IGSYM1101Form)actionForm;

			//DTO��������趨
			//dto.setIgsym1001Form(form);
			
			//���ݷ���ɾ���߼�����
			//ctlBL.deleteCodeCategoryAction(dto);
			
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
