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
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1402Form;
import com.deliverik.infogovernor.asset.vo.IGASM14021VO;

/**
 * �����¼�༭����Action����
 *
 * @author
 */
public class IGASM1402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1402Action.class);

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
		IGASM1402Form form = (IGASM1402Form)actionForm;
		
		//BLȡ��
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO����
		IGASM14DTO dto = new IGASM14DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�����¼�Ǽǻ��������ʾ����
			log.debug("========�����¼�Ǽǻ��������ʾ������ʼ========");
			form = new IGASM1402Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);		
			
			dto.setIgasm1402Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM1402Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�����¼������Ϣ"));
			log.debug("========�����¼�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�����¼�Ǽǻ�������ʾ����
			log.debug("========�����¼�Ǽǻ�������ʾ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�����¼�Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//�����¼�༭����
			if (form.getMode().equals("0")){
				//�����¼�ǼǴ���
				log.debug("========�����¼�ǼǴ�����ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm1402Form(form);
				
				//�����¼��Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵ķ����¼��Ϣ�趨��VO��
				IGASM14021VO vo = new IGASM14021VO(dto.getIgasm1402Form());
				
				super.<IGASM14021VO>setVO(req.getSession(), vo);
				
				log.debug("========�����¼�ǼǴ�������========");
				
				forward = "DISP";

			}
		}
		
		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}