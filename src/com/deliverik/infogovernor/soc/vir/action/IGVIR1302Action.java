/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR13BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1302Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������޸�Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1302Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1302Action.class);
		//BLȡ��
		IGVIR13BL ctlBL = (IGVIR13BL) getBean("igvir13BL");
		//ʵ����dto
		IGVIR13DTO dto = new IGVIR13DTO();
		//formȡ��
		IGVIR1302Form form = (IGVIR1302Form) actionForm;
		//dto�����趨
		dto.setIgvir1302Form(form);
		//ҳ���ʼ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============�����Ϣ�༭ҳ���ʼ��������ʼ==============");
			dto = ctlBL.initVmInfoAction(dto);
			saveToken(request);
			log.debug("==============�����Ϣ�༭ҳ���ʼ����������==============");
		}
		//�༭����
		if("EDIT".equals(mapping.getParameter())){
			log.debug("===========�����Ϣ�༭������ʼ=============");
			if(isTokenValid(request, true)){
				dto = ctlBL.editVmInfoAction(dto);
				dto.addMessage(new ActionMessage("IGVIR1302.I001"));
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========�����Ϣ�༭��������=============");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
