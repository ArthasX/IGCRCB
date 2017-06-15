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
import com.deliverik.infogovernor.iam.bl.IGIAM05BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

/**
 * @Description: ���Ͳ�ѯ����Action����
 * @Author 
 * @History 20131011     �½�
 * @Version V1.0
 */
public class IGIAM0502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0502Action.class);

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
		IGIAM05BL ctlBL = (IGIAM05BL) getBean("igiam05BL");
		
		//DTO����
		IGIAM01DTO dto = new IGIAM01DTO();
		
		dto.setPtid(req.getParameter("ptid"));
		
		String pdid[] = req.getParameter("pdid").split(";");
		dto.setPdid(pdid);
		
		ctlBL.searchProcessDef(dto);
		
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
