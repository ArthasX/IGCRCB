/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description: 报表预览Action处理
 * @Author
 * @History 
 * @Version
 */
public class IGSYM1406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1406Action.class);
	
	/** BIRT报表文件路径 */
	protected String reporturl = "";//ResourceUtility.getString("BIRT_REPORT_FILE_ROOT_PATH");

	/**
	 * 事件处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========报表预览处理开始 ========");

		IGSYM14BL symBL = (IGSYM14BL) getBean("igSYM14BL");
		IGSYM14DTO dto = new IGSYM14DTO();
		IGSYM1406Form form = (IGSYM1406Form) actionForm;
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		reporturl = ctlBL.getCodeValue(CodeDefinition.BIRT, "", "", CodeDefinition.BIRT_URL);
		
		//构造BIRT访问URL
		form.setUrl(reporturl + form.getRfdfilename() + "/" + form.getRfdversion() + "/" + form.getRfdfilename() + ".rptdesign");

		dto.setRfdid(form.getRfdid());
		
		dto = symBL.getReportTitle(dto);
		
		IGSYM1402Form form1 = dto.getIgSYM1402Form();
		
		form.setTitle(form1.getRfdtitle());
		
		log.debug("========报表预览处理终了========");
		return mapping.findForward("DISP");
	}
}
