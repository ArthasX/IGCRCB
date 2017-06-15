/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.action;

import java.util.Calendar;
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
import com.deliverik.infogovernor.sta.form.IGSTA0103Form;
import com.deliverik.infogovernor.sta.vo.IGSTA01031VO;

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

public class IGSTA0103Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSTA0103Action.class);
	
	/**
	 * <p>
	 * Description: ��ͬͳ��action����
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
		IGSTA0103Form form = (IGSTA0103Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSTA01BL ctlBL = (IGSTA01BL) getBean("igsta01BL");
		IGSTA01DTO dto = new IGSTA01DTO();
		//��ѯ��ͬģ��
		ctlBL.getContractLabel(dto);
		request.setAttribute("contractLabel", dto.getContractType());
		
		//ʵ����DTO
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ͬͳ�Ʋ�ѯ���������ʾ����ʼ========");
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			form.setCurYear(String.valueOf(year));
			log.debug("========��ͬͳ�Ʋ�ѯ���������ʾ��������========");
		}
		//�����ѯ
		else if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========��ͬͳ�Ʋ�ѯ����ʼ========");
			dto.setIgsta0103Form(form);
			
			//����BL��ѯ
			dto = ctlBL.searchContractAmountAction(dto);
			//����VO
			IGSTA01031VO vo = new IGSTA01031VO();
			vo.setContracts(dto.getContracts());
			super.<IGSTA01031VO>setVO(request, vo);
			log.debug("========��ͬͳ�Ʋ�ѯ��������========");
		}
		else if("FETCH".equals(mapping.getParameter())){
		    log.debug("========��ͬͳ����ȡ��ѯ����ʼ========");
		    
		    //��ҳ��DTOȡ��
            getPaginDTO(request,"IGSTA0103");
            
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
          
            if (request.getParameter("PAGING") == null) {
                pDto.setFromCount(0);
                form = (IGSTA0103Form) request.getSession().getAttribute("IGSTA0103Form");
                if (form !=null) {
                    form.setFromCount(0);
                }
            }
            dto.setIgsta0103Form(form);
            dto.setPagingDto(pDto);
            
		    //����BL��ѯ
		    dto = ctlBL.searchEntityItemAction(dto);
		    //����VO
		    IGSTA01031VO vo = new IGSTA01031VO();
		    vo.setEntityItemCompactVWInfoList(dto.getEntityItemCompactVWInfoList());
		    super.<IGSTA01031VO>setVO(request, vo);
		    log.debug("========��ͬͳ����ȡ��ѯ��������========");
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
