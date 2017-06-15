/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;
import com.deliverik.infogovernor.svc.vo.IGSVC01001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���м�¼����_��ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0100Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSVC0100Action.class);
	
	/**
	 * <p>
	 * Description: ���̼�¼action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSVC0100Form form = (IGSVC0100Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���̼�¼��ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========���̼�¼��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSVC01BL ctlBL = (IGSVC01BL) getBean("igsvc01BL");
		//ʵ����DTO
		IGSVC01DTO dto = new IGSVC01DTO();
		String forward = "DISP";
		//���̼�¼��ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========���̼�¼��ѯ����ʼ========");
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrtype())){
				forward = "INCIDENT";
			}else if(IGPROCESSType.PROBLEM_PRTYPE.equals(form.getPrtype())){
				forward = "PROBLEM";
			}
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSVC0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSVC0201");
			dto.setPrSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setPrSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.getProcessRecords(dto);
			//����VO
			IGSVC01001VO vo = new IGSVC01001VO(dto.getProcessList());
			
			super.<IGSVC01001VO>setVO(request, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========���̼�¼��ѯ��������========");
		}
		return mapping.findForward(forward);
	}

}
