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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0416Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04121VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04161VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGDRM0416Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0416Action.class);

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
		IGDRM0416Form form = (IGDRM0416Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ��ѯ���������ʾ����
			log.debug("========����������Ϣ��ѯ���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0416");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//����������Ϣ��ѯ���������ʾ�����߼�����
			dto = ctlBL.initIGDRM0416Action(dto);
			
			//������������Ϣ��������趨��VO��
			IGDRM04161VO vo = new IGDRM04161VO(dto.getConfigurationMap());
			
			super.<IGDRM04161VO>setVO(req, vo);

			IGDRM04121VO vo1 = new IGDRM04121VO(dto.getEntity());
			
			super.<IGDRM04121VO>setVO(req.getSession(),vo1);
			
			log.debug("========����������Ϣ��ѯ���������ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//��������ɾ������
			log.debug("========��������ɾ������ʼ========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���ش���
				return mapping.findForward("BACK");
			}

			//DTO��������趨
			dto.setDeleteConfiguration(form.getDeleteCid());
			
			//��������ɾ�������߼�����
			ctlBL.deleteConfigurationAction(dto);
			
			log.debug("========��������ɾ����������========");
		}
		
		//�޸ķ�������״̬ 1���� 2ͣ��
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�ʲ���������״̬�仯����ʼ========");

			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("cid")!=null){
				dto.setCid(req.getParameter("cid"));
			}
			if(req.getParameter("cstatus")!=null){
				dto.setCstatus(req.getParameter("cstatus"));
			}

			ctlBL.changeConfigStatus(dto);
			
			log.debug("========�ʲ���������״̬�仯��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
