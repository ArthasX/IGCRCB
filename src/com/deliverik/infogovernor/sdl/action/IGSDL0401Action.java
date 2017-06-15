/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.infogovernor.sdl.bl.IGSDL04BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0401Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL04011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��Ϣ��ѯɾ��ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0401Action.class);
	
	/**
	 * <p>
	 * Description:��Ϣ��ѯɾ��ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSDL0401Form form = (IGSDL0401Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��Ϣ��ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ϣ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL04BL ctlBL = (IGSDL04BL) getBean("igSDL04BL");
		//ʵ����DTO
		IGSDL04DTO dto = new IGSDL04DTO();
		//��Ϣ��ѯ
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ϣ��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSDL0401");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSDL0401Form) request.getSession().getAttribute("IGSDL0401Form");
				if ( form == null ) {
					form = new IGSDL0401Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSDL0401Form) request.getSession().getAttribute("IGSDL0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("IGSDL0401");
			
			dto.setSdlInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchSdlInfoAction(dto);
			
			//����VO
			IGSDL04011VO vo = new IGSDL04011VO(dto.getSdlInfoList());
			
			super.<IGSDL04011VO>setVO(request, vo);
			
			log.debug("========��Ϣ��ѯ��������========");
		}
		//ɾ��
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========��Ϣɾ������ʼ========");
			dto.setDeleteSdlInfoid(form.getDeleteSdlInfoid());
			ctlBL.deleteSdlInfoAction(dto);
			log.debug("========��Ϣɾ����������========");
		}
		//��ϸ��Ϣ
		if ("DETAIL".equals(mapping.getParameter())){
			log.debug("========��Ϣ��ϸ��Ϣ����ʼ========");
			dto.setSiid(form.getSiid());
			dto = ctlBL.searchSdlInfoDetailAction(dto);
			IGSDL04011VO vo = new IGSDL04011VO();
			vo.setSdlInfo(dto.getSdlInfo());
			vo.setAttachmentList(dto.getAttachmentList());
			super.<IGSDL04011VO>setVO(request, vo);
			log.debug("========��Ϣ��ϸ��Ϣ��������========");
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
