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
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM01031VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ģ�飺���ڹ���-�Ӵ�����-����Ͳ͹���
 * ˵�����������Ͳ͵Ǽ��Լ���������е������Ͳ͹���action
 * @author ������
 *
 */
public class IGLOM0107Action extends BaseAction {

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
		IGLOM0107Form form = (IGLOM0107Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		// �����˵�
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		
		String forward = "";
		
		if( "view-init".equals(mapping.getParameter())){
			
			//�Ӵ����������ѯ���������ʾ����
			log.debug("========����Ͳ͹����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����Ͳ͹����ѯ���������ʾ��������========");

			saveToken(req);
			forward = "view-init";
			
			
		} 
		//else if("REDISP".equals(mapping.getParameter())){
//			
//			//�Ӵ����������ѯ��������ʾ����
//			log.debug("========�Ӵ����������ѯ��������ʾ����ʼ========");
//			addMessage(req, new ActionMessage("IGCO10000.I003"));
//			log.debug("========�Ӵ����������ѯ��������ʾ��������========");
//			
//			forward = "DISP";
//			
//			
//		}	
		//�ı�����Ͳ͹���״̬
		else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========����Ͳ͹���״̬ͣ��/���ô���ʼ========");
			//DTO��������趨
			dto.setIglom0107Form(form);
			
			

			if (isTokenValid(req, true)) {

				ctlBL.changeDealAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			//���form�е�rstatus״̬�����ⷵ��ʱ���յ�ǰ����״̬չ������
			form.setRstatus("");
			log.debug("========����Ͳ�������״̬ͣ��/���ô�������========");
			
			forward = "CHANGE";
			
		}	
		else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========����Ͳ���Ϣɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteRid(form.getDeleteRid());
			

			if (isTokenValid(req, true)) {

				ctlBL.deleteDealAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========����Ͳ���Ϣɾ���������========");
			
			forward = "DELETE";
			
		} 
		//�����ѯ����Ͳ͹���������Ϣ��search1��ɾ��֮�����·���ҳ��ˢ�´���
		else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//�Ӵ����������ѯ����
			log.debug("========�Ӵ����������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0107");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0107Form) req.getSession().getAttribute("IGLOM0107Form");
				if ( form == null ) {
					form = new IGLOM0107Form();
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
					form = (IGLOM0107Form) req.getSession().getAttribute("IGLOM0107Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0107");
			
			//DTO��������趨
			dto.setDealSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�Ӵ�����������Ϣ�����߼�����
			dto = ctlBL.searchDealInfo(dto);
			
			saveToken(req);
			
			//���Ӵ�����������Ϣ��������趨��VO��
			IGLOM01031VO vo = new IGLOM01031VO();
			vo.setDealList(dto.getDealList());
			vo.setDealAmountList(dto.getDealAmountList());
			//List list=dto.getDealList();
			//System.out.print(dto.getDealList());
			super.<IGLOM01031VO>setVO(req, vo);
			
			
			log.debug("========�Ӵ����������ѯ��������========");
			
			forward = "DISP";
		}
		//else if( "STDISP".equals(mapping.getParameter())){
//			
//			//�Ӵ����������ѯ���������ʾ����(ʳ�ó���ѡ��Ӵ�����ʱ����)
//			log.debug("========�Ӵ����������ѯ���������ʾ����ʼ========");
//			addMessage(req, new ActionMessage("IGCO10000.I003"));
//			log.debug("========�Ӵ����������ѯ���������ʾ��������========");
//			
//			forward = "DISP";
//			
//			

		
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
