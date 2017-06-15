/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.action;


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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR08BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0802Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR08021VO;

/**
 * ����: ������Դͳ��
 * ��������: ������Դͳ��
 * ������¼: 2014/02/12
 * �޸ļ�¼: 
 */
public class IGVIR0802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0802Action.class);

	/**
	 * ���ð�����ϵ��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGVIR0802Form form = (IGVIR0802Form)actionForm;
		//BLȡ��
		IGVIR08BL ctlBL = (IGVIR08BL) getBean("igvir08BL");
		
		//DTO����
		IGVIR08DTO dto = new IGVIR08DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========������Դͳ����ʾ��ʼ========");
			User loginUser = (User) req.getSession().getAttribute("LOGIN_USER");
			dto.setLoginUser(loginUser);
			dto.setIgVIR0802Form(form);
//			ctlBL.searchVim03ByUser(dto);
			ctlBL.searchVim03(dto);
			IGVIR08021VO vo = new IGVIR08021VO();
			vo.setOneVim03List(dto.getOneVim03List());
//			vo.setOneVim03uList(dto.getOneVim03uList());
//			vo.setUser(dto.getUser());
			super.<IGVIR08021VO>setVO(req, vo);
			log.debug("========������Դͳ����ʾ����========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
