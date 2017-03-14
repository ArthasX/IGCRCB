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
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2802Form;
import com.deliverik.infogovernor.asset.vo.IGASM28021VO;
import com.deliverik.infogovernor.asset.vo.IGASM28071VO;

/**
 * �����༭����Action����
 *
 * @author
 */
public class IGASM2802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2802Action.class);

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
		IGASM2802Form form = (IGASM2802Form)actionForm;
		
		//BLȡ��
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO����
		IGASM28DTO dto = new IGASM28DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�����Ǽǻ��������ʾ����
			log.debug("========�����Ǽǻ��������ʾ����ʼ========");
			form = new IGASM2802Form();
			//��ȡ��ǰ�û�
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//��form �����û�
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setIgasm2802Form(form);
			
			//��ȡ������Ƶ�� ����
			ctlBL.searchRiskPropertyActioin(dto);
			//��ȡ���
			dto = ctlBL.searchEntityItemLableAction(dto);
			
			req.setAttribute("IGASM2802Form", form);
			saveToken(req);
			IGASM28071VO vo = new IGASM28071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			vo.setSoc0109List(dto.getSoc0109List());
			super.setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========�����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�����Ǽǻ�������ʾ����
			log.debug("========�����Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�����Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//�����༭����
			if (form.getMode().equals("0")){
				//�����ǼǴ���
				log.debug("========�����ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[6]);
				
				
				//DTO��������趨
				dto.setIgasm2802Form(form);
				if (isTokenValid(req, true)) {
					
					//�������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemAction(dto);
					
					//���Ǽ����˵ļ������Ϣ�趨��VO��
					IGASM28021VO vo = new IGASM28021VO(dto.getIgasm2802Form());
					//���
					req.getSession().setAttribute("eilabel", dto.getIgasm2802Form().getEilabel());
					//�����ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGASM28021VO>setVO(req.getSession(), vo);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				
				log.debug("========�����ǼǴ�������========");
				
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
