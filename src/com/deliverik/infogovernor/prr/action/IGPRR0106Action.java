/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0106Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01061VO;

/**
 * @Description: �鿴����־Action
 * @Author  
 * @History 2010-9-17     �½� 
 * @Version V1.0
 */
public class IGPRR0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0106Action.class);

	/**
	 * ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========�鿴����־����ʼ========");
		//FORMȡ��
		IGPRR0106Form form = (IGPRR0106Form)actionForm;
		
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		
		//DTO����
		IGPRR01DTO dto = new IGPRR01DTO();

		if("DISP".equals(mapping.getParameter())){
			//����־��ѯ
			dto.setRlid(form.getRlid());
			
			dto = ctlBL.getVarRecordLogs(dto);
			dto.setPrid(dto.getVarLogList().get(0).getPrid());
			Map<String,List<Attachment>> map =ctlBL.getProcessInfo(dto.getVarLogList().get(0).getPrid());

			
			//VO����
			IGPRR01061VO vo = new IGPRR01061VO();
			vo.setVarLogList(dto.getVarLogList());
			vo.setAttachmentMap(map);
			super.<IGPRR01061VO>setVO(req, vo);

		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		log.debug("========�鿴����־��������========");
		return mapping.findForward(forward);
	}
	
	

}
