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
import com.deliverik.infogovernor.sdl.bl.IGSDL03BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0301Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL03011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼��ѯɾ��ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0301Action.class);
	
	/**
	 * <p>
	 * Description:��׼��ѯɾ��ACTION����
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
		IGSDL0301Form form = (IGSDL0301Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��׼��ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��׼��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL03BL ctlBL = (IGSDL03BL) getBean("igSDL03BL");
		//ʵ����DTO
		IGSDL03DTO dto = new IGSDL03DTO();
		//��׼��ѯ
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��׼��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSDL0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSDL0301Form) request.getSession().getAttribute("IGSDL0301Form");
				if ( form == null ) {
					form = new IGSDL0301Form();
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
					form = (IGSDL0301Form) request.getSession().getAttribute("IGSDL0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("IGSDL0301");
			
			dto.setSdlDefineInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchSdlDefineInfoAction(dto);
			
			//����VO
			IGSDL03011VO vo = new IGSDL03011VO(dto.getSdlDefineInfoList());
			
			super.<IGSDL03011VO>setVO(request, vo);
			
			log.debug("========��׼��ѯ��������========");
		}
		//ɾ��
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========��׼ɾ������ʼ========");
			dto.setDeleteSdlDefineInfoid(form.getDeleteSdlDefineInfoid());
			ctlBL.deleteSdlDefineInfoAction(dto);
			log.debug("========��׼ɾ����������========");
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
