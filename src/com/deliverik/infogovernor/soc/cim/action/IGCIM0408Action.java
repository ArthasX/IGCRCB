/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0408Form;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGCIM0408Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0408Action.class);
	
	/**
	 * <p>
	 * Description:ѡ������ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0408Form form = (IGCIM0408Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		//ʵ����DTO
		IGCIM04DTO dto = new IGCIM04DTO();
		if( "DISP".equals(mapping.getParameter())){
			//�ʲ��������ݵǼ���ʾ����
			log.debug("========�ʲ��������ݵǼǴ�����ʾ��ʼ========");
			req.setAttribute("IGCIM0408Form", new IGCIM0408Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","ȡֵ��Χ�Ǽǻ�����Ϣ"));
			log.debug("========�ʲ��������ݵǼǴ�����ʾ����========");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========�ʲ��������ݵǼǴ���ʼ========");
			dto.setConfigurationcodedetail(form);
			dto.setIgcim0408Form(form);
			dto =ctlBL.insertConfigurationCodeDetailAction(dto);
			
			log.debug("========���ͻ�����Ϣ���������ʾ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}

}
