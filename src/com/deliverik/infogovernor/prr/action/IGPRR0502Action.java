/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR05BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0502Form;
import com.deliverik.infogovernor.prr.vo.IGPRR05021VO;

/**
 * ����: �������Ա�б��ѯAction
 * ��������: �������Ա�б��ѯAction
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
public class IGPRR0502Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0502Action.class);
	
	/**
	 * �������Ա�б��ѯ����
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRR0502Form form = (IGPRR0502Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRR05BL ctlBL = (IGPRR05BL) getBean("igPRR05BL");
		IGPRR05DTO dto = new IGPRR05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�������Ա�б��ѯ����ʼ========");
			dto.setPgrid(form.getPgrid());
			//����BL��ѯ
			dto = ctlBL.searchProcessAction(dto);
			//����VO
			IGPRR05021VO vo = new IGPRR05021VO();
			vo.setLst_IG500Info(dto.getLst_IG500Info());
			super.<IGPRR05021VO>setVO(request, vo);
			log.debug("========�������Ա�б��ѯ��������========");
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
