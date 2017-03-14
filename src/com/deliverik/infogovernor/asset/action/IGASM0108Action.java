/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.asset.action;


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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0108Form;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGASM0108Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0108Action.class);
	
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
		IGASM0108Form form = (IGASM0108Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		//ʵ����DTO
		IGASM01DTO dto = new IGASM01DTO();
		if( "DISP".equals(mapping.getParameter())){
			//�ʲ��������ݵǼ���ʾ����
			log.debug("========�ʲ��������ݵǼǴ�����ʾ��ʼ========");
			req.setAttribute("IGASM0108Form", new IGASM0108Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","ȡֵ��Χ�Ǽǻ�����Ϣ"));
			log.debug("========�ʲ��������ݵǼǴ�����ʾ����========");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========�ʲ��������ݵǼǴ�����ʼ========");
			dto.setConfigurationcodedetail(form);
			dto.setIgasm0108Form(form);
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