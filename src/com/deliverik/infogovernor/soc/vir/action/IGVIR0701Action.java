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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR07BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR07DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR07011VO;

/**
 * ����: vCenter��Ϣ��ѯ
 * ��������: vCenter��Ϣ��ѯAction
 * ������¼: 2014/02/12
 * �޸ļ�¼: 
 */
public class IGVIR0701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0701Action.class);

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
		
		//BLȡ��
		IGVIR07BL ctlBL = (IGVIR07BL) getBean("igvir07BL");
		
		//DTO����
		IGVIR07DTO dto = new IGVIR07DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========vCenter��Ϣ��ѯ��ʼ========");
			ctlBL.searchVIM01(dto);
			IGVIR07011VO vo = new IGVIR07011VO();
			vo.setVim01InfoList(dto.getVim01InfoList());
			super.<IGVIR07011VO>setVO(req.getSession(), vo);
			log.debug("========vCenter��Ϣ��ѯ����========");
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
