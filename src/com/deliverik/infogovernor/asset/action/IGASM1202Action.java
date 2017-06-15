package com.deliverik.infogovernor.asset.action;

import java.util.Date;
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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1202Form;
import com.deliverik.infogovernor.asset.vo.IGASM12021VO;

/**
 * ����༭����Action����
 *
 * @author
 */
public class IGASM1202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1202Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM1202Form form = (IGASM1202Form)actionForm;
		
		//BLȡ��
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO����
		IGASM12DTO dto = new IGASM12DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//����Ǽǻ��������ʾ����
			log.debug("========����Ǽǻ��������ʾ����ʼ========");
			form = new IGASM1202Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			req.setAttribute("IGASM1202Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���������Ϣ"));
			log.debug("========����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//����Ǽǻ�������ʾ����
			log.debug("========����Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//����༭����
			if (form.getMode().equals("0")){
				//����ǼǴ���
				log.debug("========����ǼǴ���ʼ========");

				//DTO��������趨
				dto.setIgasm1202Form(form);
				
				//������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵Ļ�����Ϣ�趨��VO��
				IGASM12021VO vo = new IGASM12021VO(dto.getIgasm1202Form());
				
				super.<IGASM12021VO>setVO(req.getSession(), vo);
				
				log.debug("========����ǼǴ�������========");
				
				forward = "DISP";

			}
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
