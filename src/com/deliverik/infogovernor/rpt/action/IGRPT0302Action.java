/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.rpt.bl.IGRPT03BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT03DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0302Form;

/**
 * ����: ����ͳ�Ʋ���Action
 * ������¼:����ȫ 2012/07/03
 * �޸ļ�¼: 
 */
public class IGRPT0302Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0302Action.class);
	protected MessageResources syresources = MessageResources.getMessageResources("SystemConfigResources");
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BLȡ��
		IGRPT03BL ctlBL = (IGRPT03BL) getBean("igrpt03BL");
		IGRPT0302Form form=(IGRPT0302Form) actionForm;
		//DTO����
		IGRPT03DTO dto = new IGRPT03DTO();
//		User user = (User) req.getSession().getAttribute(
//				SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			String objType=req.getParameter("objType");
			String mode=req.getParameter("mode");
			String objName=req.getParameter("objName");
			String eiid=req.getParameter("eiid");
			form.setObjType(objType);
			form.setEiid(eiid);
			form.setMode(mode);
			form.setObjName(objName);
			dto.setIgrpt0302Form(form);
			dto=ctlBL.initHostSearch(dto);
		}
		if("SEARCH".equals(mapping.getParameter())){
			dto.setIgrpt0302Form(form);
			ctlBL.capacityBirtForm(dto);
		}
		if("SERVICEDISP".equals(mapping.getParameter())){
			
		}
		if("SERVICE".equals(mapping.getParameter())){
			String temName=form.getTemplateName();
			form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+temName+"/1/"+temName+".rptdesign");
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
