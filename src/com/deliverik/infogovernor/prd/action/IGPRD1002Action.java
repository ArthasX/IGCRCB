/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.prd.bl.IGPRD10BL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶���Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD1002Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD1002Action.class);
		//BLȡ��
		IGPRD10BL ctlBL = (IGPRD10BL) getBean("igprd10BL");
		//ʵ����dto
		IGPRD10DTO dto = new IGPRD10DTO();
		//dto�����趨
		dto.setForm(actionForm);

		response.setCharacterEncoding("utf-8");
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("============���̶���ҳ���ʼ��������ʼ=============");
			dto = ctlBL.initProcessDefinitionAction(dto);
			log.debug("============���̶���ҳ���ʼ����������=============");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===========���̶�����Ϣ���Ĳ���============");
			try {
				dto = ctlBL.changeProcessDefinitionAction(dto);
				response.getWriter().write("{\"msg\":\"success\"}");
			} catch (Exception e) {
				response.getWriter().write("{\"msg\":\"���泡���������\",\"err\":\"" + e.getMessage() + "\"}");
			}
			log.debug("===========���̶�����Ϣ���Ľ���============");
		}
		if("GETBUTTON".equals(mapping.getParameter())){
			log.debug("==========�ڵ㰴ť��Ϣȡ�ò�����ʼ==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.searchProcessStepButtonAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========�ڵ㰴ť��Ϣȡ�ò�������==========");
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
