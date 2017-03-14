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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR08BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0804Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR08041VO;

/**
 * ����: ������Դͳ��
 * ��������: ������Դͳ��
 * ������¼: 2014/02/12
 * �޸ļ�¼: 
 */
public class IGVIR0804Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0804Action.class);

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
		
		IGVIR0804Form form = (IGVIR0804Form)actionForm;
		//BLȡ��
		IGVIR08BL ctlBL = (IGVIR08BL) getBean("igvir08BL");
		
		//DTO����
		IGVIR08DTO dto = new IGVIR08DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========������Դͳ����ʾ��ʼ========");
			dto.setIgVIR0804Form(form);
			ctlBL.searchVim03ByOrg(dto);
			IGVIR08041VO vo = new IGVIR08041VO();
			vo.setOneVim03oList(dto.getOneVim03oList());
//			vo.setOrgbean(dto.getOrgbean());
			super.<IGVIR08041VO>setVO(req, vo);
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
