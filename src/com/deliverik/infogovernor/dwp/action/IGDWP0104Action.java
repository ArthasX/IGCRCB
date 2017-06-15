/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.action;

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
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.vo.IGDWP01041VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ѡ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0104Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDWP0104Action.class);
		//BLȡ��
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============����ѡ��ҳ���ʼ��������ʼ==============");
			dto = ctlBL.searchProcessDefinitions(dto);
			//ʵ����vo
			IGDWP01041VO vo = new IGDWP01041VO();
			vo.setProcessDefinitionMap(dto.getProcessDefinitionMap());
			super.setVO(request, vo);
			log.debug("==============����ѡ��ҳ���ʼ����������==============");
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
