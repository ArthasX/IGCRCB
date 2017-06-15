/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.action;

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
import com.deliverik.infogovernor.sta.bl.IGSTA01BL;
import com.deliverik.infogovernor.sta.dto.IGSTA01DTO;
import com.deliverik.infogovernor.sta.form.IGSTA0105Form;
import com.deliverik.infogovernor.sta.vo.IGSTA01051VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������Ĺ���_��ѯACTION
 * </p>
 * 
 * @author 
 * @version 1.0
 */

public class IGSTA0105Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSTA0105Action.class);
	
	/**
	 * <p>
	 * Description: ��Ŀͳ��action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author huiyongzhi
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSTA0105Form form = (IGSTA0105Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSTA01BL ctlBL = (IGSTA01BL) getBean("igsta01BL");
		IGSTA01DTO dto = new IGSTA01DTO();
		
		//ʵ����DTO
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��Ŀͳ�Ʋ�ѯ���������ʾ����ʼ========");
			log.debug("========��Ŀͳ�Ʋ�ѯ���������ʾ��������========");
		}
		//�����ѯ
		else if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ŀͳ�Ʋ�ѯ����ʼ========");
			dto.setIgsta0105Form(form);
			 //��ҳ��DTOȡ��
            getPaginDTO(request,"IGSTA0105");
            
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
          
            if (request.getParameter("PAGING") == null) {
                pDto.setFromCount(0);
                form = (IGSTA0105Form) request.getSession().getAttribute("IGSTA0105Form");
                if (form !=null) {
                    form.setFromCount(0);
                }
            }
            dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchPrjRecAction(dto);
			//����VO
			IGSTA01051VO vo = new IGSTA01051VO();
			vo.setProjectInfo(dto.getProjectInfo());
			super.<IGSTA01051VO>setVO(request, vo);
			log.debug("========��Ŀͳ�Ʋ�ѯ��������========");
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
