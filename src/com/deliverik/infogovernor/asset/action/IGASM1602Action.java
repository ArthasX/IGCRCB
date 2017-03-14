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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM16BL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;
import com.deliverik.infogovernor.asset.form.IGASM1602Form;
import com.deliverik.infogovernor.asset.vo.IGASM16021VO;

/**
 * ���ݱ༭����Action����
 *
 * @author
 */
public class IGASM1602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1602Action.class);

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
		IGASM1602Form form = (IGASM1602Form)actionForm;
		
		//BLȡ��
		IGASM16BL ctlBL = (IGASM16BL) getBean("igasm16BL");
		
		//DTO����
		IGASM16DTO dto = new IGASM16DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���ݵǼǻ��������ʾ����
			log.debug("========���ݵǼǻ��������ʾ����ʼ========");
			form = new IGASM1602Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			dto.setIgasm1602Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM1602Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���ݻ�����Ϣ"));
			log.debug("========���ݵǼǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���ݵǼǻ�������ʾ����
			log.debug("========���ݵǼǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ݵǼǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//���ݱ༭����
			if (form.getMode().equals("0")){
				//���ݵǼǴ���
				log.debug("========���ݵǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm1602Form(form);
				
				//������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGASM16021VO vo = new IGASM16021VO(dto.getIgasm1602Form());
				
				super.<IGASM16021VO>setVO(req.getSession(), vo);
				
				log.debug("========���ݵǼǴ�������========");
				
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
