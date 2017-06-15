/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR05BL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0502Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �˵����ʾAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR0502Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSMR0502Action.class);
		//BLȡ��
		IGSMR05BL ctlBL = (IGSMR05BL) getBean("igSMR05BL");
		//ʵ����dto
		IGSMR05DTO dto = new IGSMR05DTO();
		//formȡ��
		IGSMR0502Form form = (IGSMR0502Form) actionForm;
		//dto�����趨
		dto.setIgsmr0502Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========�˵��ҳ���ʼ��������ʼ============");
			//dto�����趨
			dto = ctlBL.searchReportDescAction(dto);
			log.debug("===========�˵��ҳ���ʼ����������============");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		return mapping.findForward("DISP");
	}

}
