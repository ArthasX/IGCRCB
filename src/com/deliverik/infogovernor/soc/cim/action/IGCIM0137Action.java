package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0137Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01371VO;


public class IGCIM0137Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0137Action.class);

	/**
	 * 
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
		IGCIM0137Form form = (IGCIM0137Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========���ð�����ϵ��ʾ��ʼ========");
			
			dto.setIgcim0137Form(form);
			
			dto=ctlBL.initIGAIM0137Action(dto);
			IGCIM01371VO vo = new IGCIM01371VO();
			vo.setInitTreeStr(dto.getInitTreeStr());
			vo.setInitNodeID(dto.getInitNodeID());
			super.<IGCIM01371VO>setVO(req, vo);
			
			log.debug("========���ð�����ϵ��ʾ����========");
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
