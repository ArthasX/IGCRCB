/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.prj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0107Form;
import com.deliverik.infogovernor.prj.vo.IGPRJ0107VO;


public class IGPRJ0107Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRJ0107Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		//ʵ����FORM
		IGPRJ0107Form form = (IGPRJ0107Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRJ01BL prjBL = (IGPRJ01BL) getBean("igprj01BL");
		//ʵ����DTO
		IGPRJ01DTO dto = new IGPRJ01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setIgprj0107Form(form);
		dto.setUserId(user.getUserid());
		IGPRJ0107VO vo = new IGPRJ0107VO();
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========�����˲�ѯ����ʼ========");
			//����BL��ѯ
			try {
				dto = prjBL.getParticipant(dto);
			} catch (BLException e) {
			}
			//����VO
			vo.setParticipantList(dto.getParticipantList());
			vo.setRoleMap(dto.getRoleMap());
			super.<IGPRJ0107VO>setVO(request, vo);
			log.debug("========�����˲�ѯ��������========");
		}
		//������
		if ("PARTICIPANT".equals(mapping.getParameter())){
			log.debug("========�����˴���ʼ========");
			if("0".equals(form.getMode())){//ɾ����ɫ
				try {
					dto = prjBL.removeParticipant(dto);
				} catch (BLException e) {
					request.setAttribute("pid", form.getPid());
					return mapping.findForward("DELETE_ERROR");
				}
			}else{//��ӽ�ɫ
				try {
					dto = prjBL.addParticipant(dto);
				} catch (BLException e) {
					request.setAttribute("pid", form.getPid());
					return mapping.findForward("ADD_ERROR");
				}
			}
			request.setAttribute("pid", form.getPid());
			log.debug("========�����˴�������========");
		}
		return mapping.findForward("DISP");
	}
	
}
