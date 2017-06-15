/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.form.IGCOM0215Form;
import com.deliverik.infogovernor.vo.IGCOM02151VO;

/**
 * ͳ�Ʒ���-�����б�����Action����
 *
 */
public class IGCOM0215Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0215Action.class);
	
	/**
	 * ͳ�Ʒ���-�����б�����Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		//Session���
		clearSessionFormData(req);
		
		//FORMȡ��
		IGCOM0215Form form = (IGCOM0215Form)actionForm;
		
		//BLȡ��
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO����
		IGCOM02DTO dto = new IGCOM02DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			//Session���
			clearSessionFormData(req);
			
			
			dto.setReportFileDefinitionSearchCond(form);
			
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�����������ѯ����
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			IGCOM02151VO vo = new IGCOM02151VO(dto.getReportFileDefinitionList(), dto.getCompleteNodeName());
			
			super.<IGCOM02151VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
		}
		
		
		return mapping.findForward("DISP");
		
	}

}
