package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0156Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01551VO;

/**
 * ��ѯָ��
 *
 */
public class IGCIM0156Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0156Action.class);
	
	/**
	 * �¼�����
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
		IGCIM0156Form form = (IGCIM0156Form)actionForm;
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ѯָ�괦��ʼ========");
			
			dto.setEiid(form.getEiid());
			ctlBL.getResid(dto);
			if(StringUtils.isNotEmpty(dto.getResid())){
				form.setResource_id(Integer.parseInt(dto.getResid()));
				dto.setIgcim0155Form(form);
				
				//��ȡ����
				dto = ctlBL.initIGCIM0155Action(dto);
				
				IGCIM01551VO vo = new IGCIM01551VO();
				super.<IGCIM01551VO>setVO(req, vo);
			}
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			
			log.debug("========��ѯָ�괦��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}

}
