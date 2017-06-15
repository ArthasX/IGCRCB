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
import com.csebank.lom.form.IGLOM0113Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM01131VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ���Ų��ŽӴ�����Action
 * 
 */
public class IGLOM0113Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0113Action.class);

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
		IGLOM0113Form form = (IGLOM0113Form)actionForm;
		
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
			
			//���ŽӴ�������ѯ���������ʾ����
			log.debug("========���ŽӴ�������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ŽӴ�������ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//���ŽӴ�������ѯ��������ʾ����
			log.debug("========���ŽӴ�������ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ŽӴ�������ѯ��������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���ŽӴ�������ѯ����
			log.debug("========���ŽӴ�������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0113");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0113Form) req.getSession().getAttribute("IGLOM0113Form");
				if ( form == null ) {
					form = new IGLOM0113Form();
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
					form = (IGLOM0113Form) req.getSession().getAttribute("IGLOM0113Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0113");
			
			//DTO��������趨
			dto.setRecptionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���ŽӴ�������Ϣ�����߼�����
			dto = ctlBL.searchRecptionCostAction(dto);
			
			
			//�����ŽӴ�������Ϣ��������趨��VO��
			IGLOM01131VO vo = new IGLOM01131VO();
			vo.setRecptionCostList(dto.getRecptionCostList());
			
			super.<IGLOM01131VO>setVO(req, vo);
			
			log.debug("========���ŽӴ�������ѯ��������========");
			
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
