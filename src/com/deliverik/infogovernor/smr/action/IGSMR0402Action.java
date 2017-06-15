/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import java.util.ArrayList;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.pdf.xmlbl.IGPDF01BL;
import com.deliverik.infogovernor.smr.bl.IGSMR04BL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.vo.IGSMR04021VO;

/**
 * ����:�걨���� 
 * �����������걨���� 
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public class IGSMR0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0402Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0402Form form = (IGSMR0402Form)actionForm;

		//BLȡ��
		IGSMR04BL ctlBL = (IGSMR04BL) getBean("igSMR04BL");
		
		//������BLȡ��
		IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
				
		//DTO����
		IGSMR04DTO dto = new IGSMR04DTO();
		
		String forward = "DISP";

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�걨��ϸ�б���ʼ========");
			dto.setInstanceID(form.getInstanceID());
			dto = ctlBL.initIGSMR0402Action(dto);
			//ʵ����VO
			IGSMR04021VO vo = new IGSMR04021VO();
			vo.setLst_Report(dto.getLst_Report());
			super.<IGSMR04021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�걨��ϸ�б������========");
		}
		if("DISPONSE".equals(mapping.getParameter())){
			log.debug("========�걨��������ʼ========");
			if (isTokenValid(request, true)){				
				dto.setIgsmr0402Form(form);
				dto = ctlBL.managerIGSMR0402Action(dto);
				forward = "DISPONSE";
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�걨��������ʼ========");
		}
		if("EXPORT".equals(mapping.getParameter())){
            log.debug("========�걨����������ʼ========");
            Integer[] prids = form.getPrids();
            String[] prpdids = form.getPrpdids();
            List<String> fileNames = new ArrayList<String>();
            // ����pdf�����ļ�
            for (int i = 0; i < prids.length; i++) {
                String fileName = igPDF01BL.createPdf(prpdids[i], prids[i]);
                fileNames.add(fileName);
            }
            // ������ر����ļ�
            igPDF01BL.toZipAndDownload(fileNames, response);
            forward = "DISPONSE";
            log.debug("========�걨�������������========");
        }
		
		//�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
		return mapping.findForward(forward);
	}

}
