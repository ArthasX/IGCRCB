package com.deliverik.infogovernor.sya.action;

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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sya.bl.IGSYA01BL;
import com.deliverik.infogovernor.sya.dto.IGSYA01DTO;
import com.deliverik.infogovernor.sya.form.IGSYA0102Form;

/**
 *  �ƶ�Action����
 *
 */
public class IGSYA0102Action extends BaseAction {

    static Log log = LogFactory.getLog(IGSYA0102Action.class);

    /**
     *  �ƶ�Action����
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
    	IGSYA0102Form form = (IGSYA0102Form)actionForm;
        //�жϵ�½��ʽ
        User nowUser = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        IGSYA01DTO dto= new IGSYA01DTO();
        dto.setIgSYA0102Form(form);
        dto.setUser(nowUser);
        IGSYA01BL bl= (IGSYA01BL)this.getBean("igSYA01BL");
        String forward = "DISP";
        if( "DISP".equals(mapping.getParameter())){
            saveToken(request);
        }
        //����
        if( "INSERT".equals(mapping.getParameter())){
            
            if(form.getMode().equals("0")){
            	if(isTokenValid(request, true)){
                	dto.setAttachFile(form);//����form
                    bl.regist(dto);
                }else{
                    addMessage(request, new ActionMessage("IGCO00000.E007"));
                    return mapping.findForward("/error1");
                }
                addMessage(request, new ActionMessage("IGCO10000.I010","�ƶ���Ϣ�Ǽ�"));
            } else {
				//��Ϣ���
				log.debug("========�ƶȱ������ʼ========");
				dto.setIgSYA0102Form(form);
				dto.setAttachFile(form);//����form
				
				//����BL���
				dto = bl.update(dto);
				 addMessage(request, new ActionMessage("IGCO10000.I010","�ƶ���Ϣ���"));
				log.debug("========�ƶȱ����������========");
//				return mapping.findForward("DETAIL");
			}
        }
      //���ҳ���ʼ��
  		if ("EDIT".equals(mapping.getParameter())){
  			log.debug("========�ƶȱ��������ʾ����ʼ========");
  			dto.setIgSYA0102Form(form);
  			dto = bl.init(dto);
  			
  			AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
  			if (form.getAttkey()!=null &&!form.getAttkey().equals("")) {
  				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getAttkey());
  				form.setAttachmentList(attachmentList);
  			}
  			
  			List<ActionMessage> messageList = dto.getMessageList();
  			if( messageList != null && messageList.size() > 0 ) {
  				for (ActionMessage message : messageList) {	
  					addMessage(request, message);
  				}
  			}
  			log.debug("========�ƶȱ��������ʾ��������========");
  			return mapping.findForward("DISP");
  		}
  		if ("DETAIL".equals(mapping.getParameter())){
  			log.debug("========�ƶȱ��������ʾ����ʼ========");
  			dto.setIgSYA0102Form(form);
  			dto = bl.init(dto);
  			
  			AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
  			if (form.getAttkey()!=null &&!form.getAttkey().equals("")) {
  				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getAttkey());
  				form.setAttachmentList(attachmentList);
  			}
  			
  			List<ActionMessage> messageList = dto.getMessageList();
  			if( messageList != null && messageList.size() > 0 ) {
  				for (ActionMessage message : messageList) {	
  					addMessage(request, message);
  				}
  			}
  			log.debug("========�ƶȱ��������ʾ��������========");
  			return mapping.findForward("DISP");
  		}
  		/* //ɾ��
        if ("DELETE".equals(mapping.getParameter())){
            log.debug("========�ƶ�ɾ������ʼ========");
            if(StringUtils.isNotEmpty(request.getParameter("paid"))){
                form = new IGSYA0102Form();
                form.setInid(Integer.valueOf(request.getParameter("inid")));
                dto.setIgSYA0102Form(form);
                dto = bl.deleteTrain(dto);
            }
            log.debug("========�ƶ�ɾ����������========");
        }*/
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
        return mapping.findForward(forward);
    }
}
