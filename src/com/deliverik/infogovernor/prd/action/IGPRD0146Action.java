/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0146Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01461VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ������ʾ�п�ȶ���Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0146Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0146Action.class);
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//ʵ����dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//formȡ��
		IGPRD0146Form form = (IGPRD0146Form) actionForm;
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============���̲�ѯ������ʾ�п�ȶ���ҳ���ʼ��������ʼ==============");
			dto = ctlBL.initProcessQueryShowColumnAction(dto);
			//ʵ����vo
			IGPRD01461VO vo = new IGPRD01461VO();
			vo.setQueryShowColumnList(dto.getQueryShowColumnList());
			super.setVO(request, vo);
			// saveToken(request);
			log.debug("===============���̲�ѯ������ʾ�п�ȶ���ҳ���ʼ����������==============");
		}
		//���Ŀ�Ȳ���
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===============���̲�ѯ������ʾ�п�ȶ��������ʼ================");
			dto = ctlBL.editProcessQueryShowColumnWidthAction(dto);
			log.debug("===============���̲�ѯ������ʾ�п�ȶ����������================");
			return new ActionForward("/IGPRD0146_Disp.do?pdid=" + form.getPdid(), true);
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