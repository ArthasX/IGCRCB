/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0801Form;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * ����: HQ�Զ���¼
 * ������¼��2013/5/31
 * �޸ļ�¼��
 */
public class IGCIM0801Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0801Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//������ת�趨
		String forward = "DISP";
		
		//Get Form
		IGCIM0801Form form=(IGCIM0801Form)actionForm;

		//ע��ֵ
		//ע��ֵ
		log.info("========�Զ���¼HQ���������ʾ����ʼ========");
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		form.setUrl("http://"+codeListUtils.getCodeValue("160", null, null, "1")+":"+codeListUtils.getCodeValue("160", null, null, "2"));
		form.setJ_username(codeListUtils.getCodeValue("160", null, null, "3"));
		form.setJ_password(StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4")));
		log.info("========�Զ���¼HQ���������ʾ��������========");
		
		return mapping.findForward(forward);
	}
}
