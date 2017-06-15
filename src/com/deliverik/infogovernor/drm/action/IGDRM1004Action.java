/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

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
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1004Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_������Ϣ�༭����Action����
 * </p>
 * 
 * @author zyl
 */

public class IGDRM1004Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1004Action.class);

	/**
	 * ������Ϣ�༭����Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM1004Form form = (IGDRM1004Form)actionForm;
		
		//BLȡ��
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		
		//DTO����
		IGDRM10DTO dto = new IGDRM10DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ�Ǽǻ��������ʾ����
			log.debug("========������Ϣ�Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGDRM1004Form", form);
			form.setCid(null);
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			saveToken(req);
			log.debug("========������Ϣ�Ǽǻ��������ʾ��������========");
			forward="DISP";
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//������Ϣ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//�������͵Ǽǻ���
					return mapping.findForward("BACK1");
				} else if (form.getRoute().equals("1")){
					//����������ϸ ����
					return mapping.findForward("BACK2");
				}
			}
			if (form.getMode().equals("0")){
				//������Ϣ�ǼǴ���
				log.debug("========������Ϣ�ǼǴ���ʼ========");

				//DTO��������趨
				dto.setIgdrm1004Form(form);
				
				if (isTokenValid(req, true)){
					//������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertCodeDetailDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========������Ϣ�ǼǴ�������========");
				
				if (form.getRoute().equals("0")){
					forward = "DISP";
				} else if (form.getRoute().equals("1")){
					forward = "DETAIL";
				}

			} else {
				//������Ϣ�������
				log.debug("========������Ϣ�������ʼ========");

				//DTO��������趨
				dto.setIgdrm1004Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateCodeDetailDefAction(dto);
				log.debug("========������Ϣ�����������========");
				if("1".equals(form.getClevel())){
					forward = "BACK3";
				}else{
					forward = "BACK2";
				}
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//������Ϣ�༭������ڴ���
			log.debug("========������Ϣ�༭������ڴ���ʼ========");

			//DTO��������趨
			dto.setIgdrm1004Form(form);
			
			//������Ϣ�༭������ڴ����߼�����
			dto = ctlBL.initIGDRM1004Action(dto);
			
			log.debug("========������Ϣ�����������========");

			forward = "DISP";
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
        //���˴���
        String orgFlag = req.getParameter("orgFlag");
        req.setAttribute("orgFlag", orgFlag);
		return mapping.findForward(forward);
	}
}
