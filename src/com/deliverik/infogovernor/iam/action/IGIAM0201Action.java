/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0201Form;
import com.deliverik.infogovernor.iam.vo.IGIAM02011VO;

/**
 * @author zhaomin
 *
 */
/**
 * ����: ���ù��������ѯaction
 * �������������ù��������ѯ
 * �����ˣ�����
 * ������¼�� 2012-7-26
 * �޸ļ�¼��
 */
public class IGIAM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0201Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡform
		IGIAM0201Form form = (IGIAM0201Form)actionForm;
		
		//��ȡbl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//��ȡdto
		IGIAM02DTO dto = new IGIAM02DTO();

		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========��������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request, "IGIAM0201");			
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//�ж�form�Ƿ�Ϊ��
			if (form == null) {
				//formΪ��ʱ����ʼ��form
				form = new IGIAM0201Form();
			} else {
				//���з�ҳ����
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(form.getFromCount());
				} else {
					form.setFromCount(pDto.getFromCount());
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIAM0101");
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);
			dto.setIgiam0201form(form);
			//��������form����
			dto = iajBL.searchIAMAction(dto);
			//��ʼ��VO
			IGIAM02011VO vo = new IGIAM02011VO();
			//����ѯ�����װ��VO��
			vo.setInternalauditJobList(dto.getInternalauditJobList());
			//����VO
			super.<IGIAM02011VO>setVO(request, vo);
			log.debug("========��������ѯ�������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
