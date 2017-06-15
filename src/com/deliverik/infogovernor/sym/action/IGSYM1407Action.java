/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.action;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1407Form;

/**
 * ����: birtViewer2.5Action
 * ��������: birtViewer2.5Action
 * ������¼: 2012/05/28
 * �޸ļ�¼: 
 */
public class IGSYM1407Action extends BaseAction{

	static Log log=LogFactory.getLog(IGSYM1407Action.class);
	protected MessageResources resources = MessageResources.getMessageResources("SystemConfigResources");
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//��ȡForm bean
		IGSYM1407Form Form=(IGSYM1407Form)actionForm;
		//�����ļ�·��Ĭ��C:/SOCFile/IG/IGReports/ 
		Form.setRfdTitle(URLDecoder.decode(Form.getRfdTitle(),"UTF-8"));
		String Birt_File_Path=resources.getMessage("BIRT_REPORT_PATH");
		log.debug("=====================birt��ʾ��ʼ=====================");
		if (StringUtils.isEmpty(Form.getReportname())) {			
			Form.setReportname("SystemTransferred/1/SystemTransferred.rptdesign");
		}else if(!Form.getReportname().equals("undefined")){			
			//�����ļ��������� 
			String File_Name=Form.getReportname()+"/1/"+Form.getReportname()+".rptdesign";
			String File_NameOne=Form.getReportname()+"_table/1/"+Form.getReportname()+"_table.rptdesign";
			//�ϳ�·��
			String realfileOne=Birt_File_Path+File_NameOne;
			Form.setReportpathTable(realfileOne);
			
			String realfile=Birt_File_Path+File_Name;
			Form.setReportpath(realfile);
		}
		
		Form.setDateFrom("2011-06-29");
		Form.setDateTo("2011-06-30");
		
		if(StringUtils.isEmpty(Form.getDataid())){//��ֵ����Ĭ������			
			Form.setDataid("000292600901");
		}
		if (StringUtils.isEmpty(Form.getTimetype())) {
			Form.setTimetype("hour");
		}
		
		
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		IGSYM14DTO dto = new IGSYM14DTO();
		dto.setIgsym1407Form(Form);
		dto = ctlBL.getObjectName(dto);
		req.setAttribute("objectNameList", dto.getObjectNameList());
		
		log.debug("=====================birt��ʾ����=====================");
		return mapping.findForward("Disp");
	}

}
