/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0114Form;
import com.csebank.lom.vo.IGLOM01131VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * �Ӵ����˲�ѯAction
 * 
 */
public class IGLOM0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0114Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGLOM0114Form form = (IGLOM0114Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//�Ӵ����˲�ѯ���������ʾ����
			log.debug("========�Ӵ����˲�ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ����˲�ѯ���������ʾ��������========");
			
			forward = "DISP";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//�Ӵ����˲�ѯ����
			log.debug("========�Ӵ����˲�ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0114");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//��ʳ����Ϣ���棬�����Ϣ���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0114Form) req.getSession().getAttribute("IGLOM0114Form");
				if ( form == null ) {
					form = new IGLOM0114Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0114Form) req.getSession().getAttribute("IGLOM0114Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0114");
			
			//DTO��������趨
			dto.setRecptionGuestInfoCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���ŽӴ�������Ϣ�����߼�����
			dto = ctlBL.searchRecptionByGusetAction(dto);
			
			
			//�����ŽӴ�������Ϣ��������趨��VO��
			IGLOM01131VO vo = new IGLOM01131VO();
			vo.setGuestRecptionList(dto.getGuestRecptionList());
			
			super.<IGLOM01131VO>setVO(req, vo);
			
			log.debug("========�Ӵ����˲�ѯ��������========");
			
			forward = "DISP";
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
