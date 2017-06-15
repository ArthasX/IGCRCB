/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
import com.deliverik.infogovernor.iam.bl.IGIAM05BL;
import com.deliverik.infogovernor.iam.dto.IGIAM05DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0503Form;
import com.deliverik.infogovernor.iam.vo.IGIAM050301VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�����Ŀ��������ѯ_��ѯACTION
 * </p>
 * 
 * @author zhaomin
 * @version 1.0
 */

public class IGIAM0503Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGIAM0503Action.class);
	
	/**
	 * <p>
	 * Description: �����Ŀ��������ѯaction����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author zhaomin
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGIAM0503Form form = (IGIAM0503Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGIAM05BL ctlBL = (IGIAM05BL) getBean("igiam05BL");

		//ʵ����DTO
		IGIAM05DTO dto = new IGIAM05DTO();
		//�����ѯ
		if( "SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�����Ŀ��������ѯ����ʼ========");
			getPaginDTO(request, "IGIAM0503");	
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGIAM0503Form) request.getSession().getAttribute("IGIAM0503Form");
                if ( form == null ) {
                    form = new IGIAM0503Form();
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
                    form = (IGIAM0503Form) request.getSession().getAttribute("IGIAM0503Form");
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                 }
            }
			
			
			int maxCnt = getMaxDataCount("IGIAM0503");
			form.setFromCount(0);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgiam0503Form(form);
			//����BL��ѯ
			dto = ctlBL.getProcessRecords(dto);
			//����VO
			IGIAM050301VO vo = new IGIAM050301VO(dto.getProcessInfos());
			super.<IGIAM050301VO>setVO(request, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========�����Ŀ��������ѯ��������========");
		} 
		return mapping.findForward("DISP");
	}
}
