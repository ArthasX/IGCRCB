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
import com.deliverik.infogovernor.smr.bl.IGSMR07BL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0704Form;
import com.deliverik.infogovernor.smr.vo.IGSMR07041VO;

/**
 * ����:�����ڱ������� 
 * ���������������ڱ������� 
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public class IGSMR0704Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0704Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0704Form form = (IGSMR0704Form)actionForm;
				
		//BLȡ��
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
				
	    //������BLȡ��
        IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
        
		//DTO����
		IGSMR07DTO dto = new IGSMR07DTO();
		
		String forward = "DISP";

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�����ڱ�����ϸ�б���ʼ========");
			dto.setInstanceID(form.getInstanceID());
			dto = ctlBL.initIGSMR0704Action(dto);
			//ʵ����VO
			IGSMR07041VO vo = new IGSMR07041VO();
			vo.setLst_Report(dto.getLst_Report());
			super.<IGSMR07041VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�����ڱ�����ϸ�б������========");
		}
		if("DISPONSE".equals(mapping.getParameter())){
			log.debug("========�����ڱ�����������ʼ========");
			if (isTokenValid(request, true)){				
				dto.setIgSMR0704Form(form);
				dto = ctlBL.managerIGSMR0704Action(dto);
				forward = "DISPONSE";
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�����ڱ�����������ʼ========");
		}
		if("EXPORT".equals(mapping.getParameter())){
            log.debug("========�����ڱ���������ʼ========");
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
            log.debug("========�����ڱ������������========");
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
