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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;
import com.deliverik.infogovernor.svc.vo.IGSVC01061VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨_ͨ�ò�ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0106Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSVC0106Action.class);
	
	/**
	 * <p>
	 * Description: ͨ��action����
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
		IGSVC0100Form form = (IGSVC0100Form)actionForm;
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//��ȡBL�ӿ�ʵ��
		IGSVC01BL ctlBL = (IGSVC01BL) getBean("igsvc01BL");
		//ʵ����DTO
		IGSVC01DTO dto = new IGSVC01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ���������ʾ����ʼ========");
			dto = ctlBL.getPrtypeList(dto);
			request.getSession().setAttribute("prtypeList", dto.getPrtypeList());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========ͨ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//ͨ�ò�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSVC0106");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGSVC0100Form) request.getSession().getAttribute("IGSVC0100Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSVC0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			form.setUserid_q(user.getUserid());
			form.setSing("DESC");
			form.setOrder(" prclosetime desc , propentime ");
			dto.setPrSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.getProcessRecordsForLook(dto);
			//����VO
			IGSVC01061VO vo = new IGSVC01061VO();
			vo.setProcessRecordList(dto.getProcessList());
			vo.setDetailPgMap(dto.getDetailPgMap());
			super.<IGSVC01061VO>setVO(request, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========ͨ�ò�ѯ��������========");
		}
		return mapping.findForward("DISP");
	}

}
