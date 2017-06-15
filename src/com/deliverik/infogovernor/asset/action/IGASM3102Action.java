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
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3102Form;
import com.deliverik.infogovernor.asset.vo.IGASM31021VO;

/**
 * ����ָ��༭����Action����
 *
 * @author
 */
public class IGASM3102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3102Action.class);

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
		IGASM3102Form form = (IGASM3102Form)actionForm;
		
		//BLȡ��
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		//DTO����
		IGASM31DTO dto = new IGASM31DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//����ָ��Ǽǻ��������ʾ����
			log.debug("========����ָ��Ǽǻ��������ʾ����ʼ========");
			form = new IGASM3102Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			//��ȡ��ǰ�û�
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//�趨Ĭ�ϱ��û���Ϊ��¼��name
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			dto.setIgasm3102Form(form);
			
			//��ȡ���������б�ֵ*
			ctlBL.searchRiskPropertyActioin(dto);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM3102Form", form);
			
			//���Ǽ����˵ķ���ָ����Ϣ�趨��VO��
			IGASM31021VO vo = new IGASM31021VO(dto.getIgasm3102Form());
			//����ָ��--��ֵ����
			vo.setThresholdList(dto.getThresholdList());
			//����ָ��--ָ��ģ������
			vo.setTitList(dto.getTitList());
			//����ָ��--�Ƿ�ؼ�ָ������
			vo.setKeyIndexList(dto.getKeyIndexList());
			//���յ� ���Լ���
			vo.setSoc0109List(dto.getSoc0109List());
			
			super.<IGASM31021VO>setVO(req.getSession(), vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","����ָ�������Ϣ"));
			
			saveToken(req);
			log.debug("========����ָ��Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
			
		} else if("REDISP".equals(mapping.getParameter())){
			//����ָ��Ǽǻ�������ʾ����
			log.debug("========����ָ��Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ָ��Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//����ָ��༭����
			if (form.getMode().equals("0")){
				//����ָ��ǼǴ���
				log.debug("========����ָ��ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[9]);
				
				//DTO��������趨
				dto.setIgasm3102Form(form);
				//�����ظ��ύ
				if (isTokenValid(req, true)) {
					//����ָ����Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				//���Ǽ����˵ķ���ָ����Ϣ�趨��VO��
				IGASM31021VO vo = new IGASM31021VO(dto.getIgasm3102Form());
				//����ָ��--��ֵ����
				vo.setThresholdList(dto.getThresholdList());
				//����ָ��--ָ��ģ������
				vo.setTitList(dto.getTitList());
				//����ָ��--�Ƿ�ؼ�ָ������
				vo.setKeyIndexList(dto.getKeyIndexList());
				//���յ� ���Լ���
				vo.setSoc0109List(dto.getSoc0109List());
				//���
				req.getSession().setAttribute("eilabel", dto.getIgasm3102Form().getEilabel());
				String eiiddd= dto.getEiid()+"";
				req.getSession().setAttribute("eiiddd",eiiddd);
				
				super.<IGASM31021VO>setVO(req.getSession(), vo);
				
				log.debug("========����ָ��ǼǴ�������========");
				
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
