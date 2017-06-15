/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM19BL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1902Form;
/**
 * ����:��Ϣ����ģ��Ǽ�Action
 * ������������Ϣ����ģ��Ǽ�
 * ������¼����� 2011/10/18
 * �޸ļ�¼��LuJiayuan Ǩ�ƹ��ܽ�������IGSYM1702Action���ΪIGSYM1902Action 2013/01/30
 */
public class IGSYM1902Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * ��Ϣ����ģ��ǼǴ���
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGSYM1902Form igsym1902Form=(IGSYM1902Form) actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		dto.setIgsym1902Form(igsym1902Form);
		//��Ϣʱ��Ǽ�
		if("INSERT".equals(mapping.getParameter())){
			log.debug("==============��Ϣʱ��Ǽǿ�ʼ===============");
			dto = igsym19BL.insertProcessWorkTimeTemplateAction(dto);
			log.debug("==============��Ϣʱ��Ǽǽ���===============");
			Integer year = igsym1902Form.getYear();
			return new ActionForward("/IGSYM1901_ReDisp.do?year="+year+"&month="+0);
		}
		//��Ϣʱ��Ǽǻ����ʼ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��Ϣʱ��Ǽǻ����ʼ����ʼ===============");
			log.debug("==============��Ϣʱ��Ǽǻ����ʼ������===============");
		}
		
		return mapping.findForward("DISP");
	}

}
