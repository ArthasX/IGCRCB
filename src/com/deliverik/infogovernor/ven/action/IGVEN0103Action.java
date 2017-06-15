package com.deliverik.infogovernor.ven.action;

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
import com.deliverik.infogovernor.crc.vo.IGCRC04031VO;
import com.deliverik.infogovernor.ven.bl.IGVEN01BL;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0103Form;

/**
 * ���ռ������ѯ����Action����
 *
 */
public class IGVEN0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0103Action.class);

	/**
	 * ���ռ������ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGVEN0103Form form = (IGVEN0103Form)actionForm;
		
		//BLȡ��
		IGVEN01BL ctlBL = (IGVEN01BL) getBean("igven01BL");
		
		//DTO����
		IGVEN01DTO dto = new IGVEN01DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if("BATCH".equals(mapping.getParameter())){
			
			log.debug("========��鹤��ָ������������ʼ========");
			dto.setIgVEN0103Form(form);
			dto.setUser(user);
			
			dto = ctlBL.batchFlowAction(dto);
			log.debug("========��鹤��ָ����������������========");
			return mapping.findForward("ASSIGN");
		}else if("BATCH_DISP".equals(mapping.getParameter())){
			log.debug("===========��鹤��ָ������ҳ���ʼ��������ʼ===============");
			dto.setIgVEN0103Form(form);
			dto.setUser(user);
			dto = ctlBL.initIGRIS0402Action(dto);
			//ʵ����vo
			IGCRC04031VO vo = new IGCRC04031VO();
			vo.setAssignInfo(dto.getAssignInfo());
			vo.setPrids(dto.getIgVEN0103Form().getPrids());
			req.getSession().setAttribute("prids", dto.getIgVEN0103Form().getPrids());
			req.setAttribute("prids", dto.getIgVEN0103Form().getPrids());
			super.<IGCRC04031VO>setVO(req, vo);
			saveToken(req);
			log.debug("===========��鹤��ָ����������ҳ���ʼ����������===============");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
