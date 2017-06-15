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
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;
import com.deliverik.infogovernor.sym.form.IGSYM1406Form;

/**
 * @Description: ����Ԥ��Action����
 * @Author
 * @History 
 * @Version
 */
public class IGSYM1406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1406Action.class);
	
	/** BIRT�����ļ�·�� */
	protected String reporturl = "";//ResourceUtility.getString("BIRT_REPORT_FILE_ROOT_PATH");

	/**
	 * �¼�����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========����Ԥ������ʼ ========");

		IGSYM14BL symBL = (IGSYM14BL) getBean("igSYM14BL");
		IGSYM14DTO dto = new IGSYM14DTO();
		IGSYM1406Form form = (IGSYM1406Form) actionForm;
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		reporturl = ctlBL.getCodeValue(CodeDefinition.BIRT, "", "", CodeDefinition.BIRT_URL);
		
		//����BIRT����URL
		form.setUrl(reporturl + form.getRfdfilename() + "/" + form.getRfdversion() + "/" + form.getRfdfilename() + ".rptdesign");

		dto.setRfdid(form.getRfdid());
		
		dto = symBL.getReportTitle(dto);
		
		IGSYM1402Form form1 = dto.getIgSYM1402Form();
		
		form.setTitle(form1.getRfdtitle());
		
		log.debug("========����Ԥ����������========");
		return mapping.findForward("DISP");
	}
}
