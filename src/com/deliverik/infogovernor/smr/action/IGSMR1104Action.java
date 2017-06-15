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
import com.deliverik.infogovernor.smr.bl.IGSMR11BL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
import com.deliverik.infogovernor.smr.form.IGSMR1103Form;
import com.deliverik.infogovernor.smr.vo.IGSMR11031VO;

/**
 * ����:�������� 
 * ������������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR1104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR1104Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR1103Form form = (IGSMR1103Form)actionForm;
						
		//BLȡ��
		IGSMR11BL ctlBL = (IGSMR11BL) getBean("igSMR11BL");
						
		//������BLȡ��
        IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
        
		//DTO����
		IGSMR11DTO dto = new IGSMR11DTO();
				
		String forward = "DISP";

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�걨��ϸ�б���ʼ========");
			dto.setInstanceID(form.getInstanceID());
			dto = ctlBL.initIGSMR1104Action(dto);
			//ʵ����VO
			IGSMR11031VO vo = new IGSMR11031VO();
			vo.setLst_Report(dto.getLst_Report());
			super.<IGSMR11031VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�걨��ϸ�б������========");
		}
		if("DISPONSE".equals(mapping.getParameter())){
			log.debug("========�걨��������ʼ========");
			if (isTokenValid(request, true)){				
				dto.setIgSMR1103Form(form);
				dto = ctlBL.managerIGSMR1104Action(dto);
				forward = "DISPONSE";
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�걨��������ʼ========");
		}
		if("EXPORT".equals(mapping.getParameter())){
            log.debug("========��������������ʼ========");
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
            log.debug("========�����������������========");
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
