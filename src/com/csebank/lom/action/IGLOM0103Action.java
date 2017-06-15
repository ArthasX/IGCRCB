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
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0103Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM01031VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * �Ӵ���������Action
 * 
 */
public class IGLOM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0103Action.class);

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
		IGLOM0103Form form = (IGLOM0103Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		// �����˵�
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//�Ӵ����������ѯ���������ʾ����
			log.debug("========�Ӵ����������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ����������ѯ���������ʾ��������========");

			saveToken(req);
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//�Ӵ����������ѯ��������ʾ����
			log.debug("========�Ӵ����������ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ����������ѯ��������ʾ��������========");
			
			forward = "DISP";
			
			
		}	else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========�Ӵ���������״̬ͣ��/���ô���ʼ========");
			//DTO��������趨
			dto.setIglom0103Form(form);
			
			

			if (isTokenValid(req, true)) {

				ctlBL.changeRecptionAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			
			log.debug("========�Ӵ���������״̬ͣ��/���ô�������========");
			
			forward = "CHANGE";
			
		}	else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========�Ӵ���������ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteRid(form.getDeleteRid());
			

			if (isTokenValid(req, true)) {

				ctlBL.deleteRecptionAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========�Ӵ���������ɾ����������========");
			
			forward = "DELETE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//�Ӵ����������ѯ����
			log.debug("========�Ӵ����������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0103");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0103Form) req.getSession().getAttribute("IGLOM0103Form");
				if ( form == null ) {
					form = new IGLOM0103Form();
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
					form = (IGLOM0103Form) req.getSession().getAttribute("IGLOM0103Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0103");
			
			//DTO��������趨
			dto.setRecptionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�Ӵ�����������Ϣ�����߼�����
			dto = ctlBL.searchRecptionAction(dto);
			
			saveToken(req);
			
			//���Ӵ�����������Ϣ��������趨��VO��
			IGLOM01031VO vo = new IGLOM01031VO();
			vo.setRecptionList(dto.getRecptionList());
			vo.setRecptionAmountList(dto.getRecptionAmountList());
			
			super.<IGLOM01031VO>setVO(req, vo);
			
			log.debug("========�Ӵ����������ѯ��������========");
			
			forward = "DISP";
		}else if( "STDISP".equals(mapping.getParameter())){
			
			//�Ӵ����������ѯ���������ʾ����(ʳ�ó���ѡ��Ӵ�����ʱ����)
			log.debug("========�Ӵ����������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ����������ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		}else if( "STSEARCH".equals(mapping.getParameter())||"STSEARCH1".equals(mapping.getParameter())){
			//�Ӵ����������ѯ����(ʳ�ó���ѡ��Ӵ�����ʱ����)
			log.debug("========�Ӵ����������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0103");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0103Form) req.getSession().getAttribute("IGLOM0103Form");
				if ( form == null ) {
					form = new IGLOM0103Form();
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
					form = (IGLOM0103Form) req.getSession().getAttribute("IGLOM0103Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0103");
			
			//DTO��������趨
			form.setRstatus_q(IGLOMCONSTANTS.REC_STATUS_ENABLE);//��ѯ�����еĽӴ�����
			
			dto.setRecptionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�Ӵ�����������Ϣ�����߼�����
			dto = ctlBL.searchRecptionAction(dto);
			
			
			//���Ӵ�����������Ϣ��������趨��VO��
			IGLOM01031VO vo = new IGLOM01031VO();
			vo.setRecptionList(dto.getRecptionList());
			super.<IGLOM01031VO>setVO(req, vo);
			
			log.debug("========�Ӵ����������ѯ��������========");
			
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
