package com.deliverik.infogovernor.ram.action;

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
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;
import com.deliverik.infogovernor.ram.bl.IGRAM01BL;
import com.deliverik.infogovernor.ram.dto.IGRAM01DTO;

/**
 * @Description: �����������Ͳ�ѯ����Action����
 * @Author  tangzhen@deliverik.com
 * @History 20131011     �½�
 * @Version V1.0
 */
public class IGRAM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRAM0101Action.class);

	/**
	 * ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BLȡ��
		IGRAM01BL ctlBL = (IGRAM01BL) getBean("igram01BL");
		
		//DTO����
		IGRAM01DTO dto = new IGRAM01DTO();
		
		dto.setPtid(req.getParameter("ptid"));
		
		ctlBL.searchWD4typeProcessDef(dto);
		
		IGPRM00001VO vo = new IGPRM00001VO();
		
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());
		
		super.<IGPRM00001VO>setVO(req, vo);
		
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
