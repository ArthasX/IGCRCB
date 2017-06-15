package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1512Form;

/**
 * ��ѵ�ƻ�Action����
 */
public class IGDRM1503Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM1503Action.class);

    /**
     * ��ѵ�ƻ�Action����
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {

        //ʵ����FORM
    	IGDRM1512Form form = (IGDRM1512Form)actionForm;

        //�жϵ�½��ʽ
        @SuppressWarnings("unused")
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

//        IGSVC17DTO dto = new IGSVC17DTO();
//        dto.setIgSVC1703Form(form);
//		IGSVC17BL bl = (IGSVC17BL)this.getBean("igSVC17BL");

		// ��ȡBL�ӿ�ʵ��
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// ʵ����DTO
		IGDRM15DTO dto = new IGDRM15DTO();  
		// ��ȡform
		dto.setIgdrm1512Form(form);	
		
        String forward = "DISP";
        if ("INIT_ADD".equals(mapping.getParameter())) {
        	 // ����ҳ���ʼ��
        	log.debug("===============��ѵ��¼����������ʼ==================");
			form.setUpTptime(IGStringUtils.getCurrentDateTime());
			
			saveToken(request);
			log.debug("===============��ѵ��¼������������==================");

		}else if ("ADD".equals(mapping.getParameter())) { 
			// ����
        	if(isTokenValid(request, true)) {
        		ctlBL.createTrainingPlan(dto);
        		forward = "/IGDRM1511_ToEdit.do?tpid=" + form.getUpTpid();
			}
		}
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            } 
        } 
        if("DISP".equals(forward)){
        	return mapping.findForward(forward);
        }else{
        	return new ActionForward(forward);
        }
    } 
}
