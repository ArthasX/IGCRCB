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
import com.deliverik.infogovernor.asset.bl.IGASM15BL;
import com.deliverik.infogovernor.asset.dto.IGASM15DTO;
import com.deliverik.infogovernor.asset.form.IGASM1502Form;
import com.deliverik.infogovernor.asset.vo.IGASM15021VO;

/**
 * ��Ա�༭����Action����
 *
 * @author
 */
public class IGASM1502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1502Action.class);

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
		IGASM1502Form form = (IGASM1502Form)actionForm;
		
		//BLȡ��
		IGASM15BL ctlBL = (IGASM15BL) getBean("igasm15BL");
		
		//DTO����
		IGASM15DTO dto = new IGASM15DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//��Ա�Ǽǻ��������ʾ����
			log.debug("========��Ա�Ǽǻ��������ʾ����ʼ========");
			form = new IGASM1502Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			dto.setIgasm1502Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM1502Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","��Ա������Ϣ"));
			log.debug("========��Ա�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//��Ա�Ǽǻ�������ʾ����
			log.debug("========��Ա�Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ա�Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//��Ա�༭����
			if (form.getMode().equals("0")){
				//��Ա�ǼǴ���
				log.debug("========��Ա�ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm1502Form(form);
				
				//��Ա��Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵���Ա��Ϣ�趨��VO��
				IGASM15021VO vo = new IGASM15021VO(dto.getIgasm1502Form());
				
				super.<IGASM15021VO>setVO(req.getSession(), vo);
				
				log.debug("========��Ա�ǼǴ�������========");
				
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
