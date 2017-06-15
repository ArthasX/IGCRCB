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
import com.deliverik.infogovernor.sym.form.IGSYM1903Form;
/**
 * ����:��Ϣ���ڱ��Action
 * ������������Ϣ���ڱ��
 * ������¼����� 2011/10/18
 * �޸ļ�¼��LuJiayuan Ǩ�ƹ��ܽ�������IGSYM1703Action���ΪIGSYM1903Action 2013/01/30
 */
public class IGSYM1903Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * ��Ϣ���ڱ������
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
		
		IGSYM1903Form igsym1903Form=(IGSYM1903Form) actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		dto.setIgsym1903Form(igsym1903Form);
		//��Ϣʱ���޸Ļ����ʼ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��Ϣʱ���޸Ļ����ʼ����ʼ===============");
			dto = igsym19BL.searchProcessWorkTimeTemplateByPK(dto);
			log.debug("==============��Ϣʱ���޸Ļ����ʼ������===============");
		}
		//��Ϣʱ����
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============��Ϣʱ���޸Ŀ�ʼ===============");
			igsym19BL.updateProcessWorkTimeTemplateAction(dto);
			log.debug("==============��Ϣʱ���޸Ľ���===============");
			String pwtDate = igsym1903Form.getPwtDate();
			String year = pwtDate.substring(0, 4);
			String month = pwtDate.substring(5, 7);
			return new ActionForward("/IGSYM1901_ReDisp.do?year="+year+"&month="+(Integer.valueOf(month)-1));
		}
		return mapping.findForward("DISP");
	}

}
