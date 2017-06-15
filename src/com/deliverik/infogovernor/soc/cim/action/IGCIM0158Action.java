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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0158Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01581VO;

/**
 * �ʲ�������̲�ѯAction����
 *
 */
public class IGCIM0158Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0158Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0158Form form = (IGCIM0158Form)actionForm;
	
//		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
	
//		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ò�ѯ���������ʾ����
			log.debug("========Ӧ�ò�ѯ���������ʾ����ʼ========");
			String eiid = form.getEiid();
			dto.setEiid(eiid);
			if("0".equals(form.getType())){
				ctlBL.getProcessByEiid(dto);
			}else{
				ctlBL.getMaintainByEiid(dto);
			}
			IGCIM01581VO vo = new IGCIM01581VO();
			vo.setRes500VWList(dto.getRes500VWList());
			super.<IGCIM01581VO>setVO(req, vo);
			log.debug("========Ӧ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
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
