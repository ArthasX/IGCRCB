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

import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM24BL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;
import com.deliverik.infogovernor.asset.form.IGASM2402Form;
import com.deliverik.infogovernor.asset.vo.IGASM24021VO;

/**
 * �ĵ��༭����Action����
 *
 * @author
 */
public class IGASM2402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2402Action.class);
	
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
		IGASM2402Form form = (IGASM2402Form)actionForm;
		
		//BLȡ��
		IGASM24BL ctlBL = (IGASM24BL) getBean("igasm24BL");
		
		//DTO����
		IGASM24DTO dto = new IGASM24DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�ĵ��Ǽǻ��������ʾ����
			log.debug("========�ĵ��Ǽǻ��������ʾ����ʼ========");
			form = new IGASM2402Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setEsyscoding("999014");
			ctlBL.searchInitEntityInfo(dto);
			form.setEiorgsyscoding(DefineUtils.DEFAULT_ORGNO);
			form.setEiorgname(dto.getEiorgname());//Ĭ�϶�����������
			form.setEsyscoding("999014");//��Ʊ�ʲ������
			form.setEname(dto.getEname());//��Ʊ�ʲ�����
	        form.setEid(14);//��Ʊ�ʲ�����
	        
			dto.setIgasm2402Form(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM2402Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�ĵ�������Ϣ"));
			log.debug("========�ĵ��Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�ĵ��Ǽǻ�������ʾ����
			log.debug("========�ĵ��Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ĵ��Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//�ĵ��༭����
			if (form.getMode().equals("0")){
				//�ĵ��ǼǴ���
				log.debug("========�ĵ��ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm2402Form(form);
				
				//�ĵ���Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵��ĵ���Ϣ�趨��VO��
				IGASM24021VO vo = new IGASM24021VO(dto.getIgasm2402Form());
				
				super.<IGASM24021VO>setVO(req.getSession(), vo);
				
				log.debug("========�ĵ��ǼǴ�������========");
				
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
