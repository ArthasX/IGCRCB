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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2702Form;
import com.deliverik.infogovernor.asset.vo.IGASM27021VO;

/**
 * ���յ�༭����Action����
 *
 * @author
 */
public class IGASM2702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2702Action.class);

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
		IGASM2702Form form = (IGASM2702Form)actionForm;
		
		//BLȡ��
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		
		//DTO����
		IGASM27DTO dto = new IGASM27DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���յ�Ǽǻ��������ʾ����
			log.debug("========���յ�Ǽǻ��������ʾ����ʼ========");
			form = new IGASM2702Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			//��ȡ��ǰ�û�
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//��������
			form.setEiinsdate(date);
			//�趨Ĭ�ϱ��û�IDΪ��¼��ID
			form.setEiuserid(user.getUserid());
			//�趨Ĭ�ϱ��û���Ϊ��¼��name
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			
			dto.setIgasm2702Form(form);
			//��ȡ���������б�ֵ*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//��ѯ���
			dto = ctlBL.searchEntityItemLableAction(dto);
			//�趨token
			saveToken(req);
			
			req.setAttribute("IGASM2702Form", form);
			IGASM27021VO vo = new IGASM27021VO(dto.getIgasm2702Form());
			//���� ���صȼ�����
			vo.setGradeList(dto.getGradeList());
			//���� ���𼯺�
			vo.setLevelList(dto.getLevelList());
			//���� �����Լ���
			vo.setPossibleList(dto.getPossibleList());
			//����  ��־����
			vo.setSignList(dto.getSignList());
			//���յ� ���Լ���
			vo.setSoc0109List(dto.getSoc0109List());
			super.<IGASM27021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���յ������Ϣ"));
			log.debug("========���յ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���յ�Ǽǻ�������ʾ����
			log.debug("========���յ�Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���յ�Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//���յ�༭����
			if (form.getMode().equals("0")){
				//���յ�ǼǴ���
				log.debug("========���յ�ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[6]);
				
				//DTO��������趨
				dto.setIgasm2702Form(form);
				
				if (isTokenValid(req, true)) {
					//���յ���Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemAction(dto);
					//���Ǽ����˵ķ��յ���Ϣ�趨��VO��
					IGASM27021VO vo = new IGASM27021VO(dto.getIgasm2702Form());
					//���
					req.getSession().setAttribute("eilabel", dto.getIgasm2702Form().getEilabel());
					//���յ�ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGASM27021VO>setVO(req.getSession(), vo);
				} else {
					addMessage(req, new ActionMessage("IGCO10000.I001"));

				}
				
				
				
				
				log.debug("========���յ�ǼǴ�������========");
				
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
