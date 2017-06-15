/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.cic.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.cic.bl.IGCIC02BL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0204Form;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;

public class IGCIC0204Action extends BaseAction{
	//��־����ȡ��
	Log log = LogFactory.getLog(IGCIC0204Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	    log.debug("===============�ļ����ݱȽϿ�ʼ===============");
	    IGCIC0204Form form = (IGCIC0204Form) actionForm;
	    IGCIC02BL ctlBL = (IGCIC02BL) getBean("igcic02BL");

        IGCIC02DTO dto = new IGCIC02DTO();
        dto.setIgcic0204Form(form);
        dto = ctlBL.getCompareObjectFilepath(dto);
        CompareresultInfo info = dto.getCompareresultInfo();

		request.setAttribute("a", FileUtils.readFileToString(new File(info.getSvalue()), "utf-8"));
		request.setAttribute("b", FileUtils.readFileToString(new File(info.getTvalue()), "utf-8"));
		
		log.debug("===============�ļ����ݱȽϽ���===============");

		return mapping.findForward("DISP");
	}

}
