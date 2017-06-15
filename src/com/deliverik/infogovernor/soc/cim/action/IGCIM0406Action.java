package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0406Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04021VO;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04061VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGCIM0406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0406Action.class);

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
		IGCIM0406Form form = (IGCIM0406Form)actionForm;
		
		//BLȡ��
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO����
		IGCIM04DTO dto = new IGCIM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ��ѯ���������ʾ����
			log.debug("========����������Ϣ��ѯ���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0406");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//����������Ϣ��ѯ���������ʾ�����߼�����
			dto = ctlBL.initIGCIM0406Action(dto);
			
			//������������Ϣ��������趨��VO��
			IGCIM04061VO vo = new IGCIM04061VO(dto.getConfigurationMap());
			
			super.<IGCIM04061VO>setVO(req, vo);

			IGCIM04021VO vo1 = new IGCIM04021VO(dto.getEntity());
			vo1.setStartFlag(dto.getStartFlag());
			vo1.setStopFlag(dto.getStopFlag());
			
			super.<IGCIM04021VO>setVO(req.getSession(),vo1);
			
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
		
		//�޸�ģ������״̬ 1���� 2ͣ��
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�ʲ�ģ������״̬�仯����ʼ========");

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
			
			log.debug("========�ʲ�ģ������״̬�仯��������========");
		}
		if("CHANGE_ENTITY_STATUS".equals(mapping.getParameter())){

			log.debug("========�ʲ�ģ��״̬�仯����ʼ========");
			if(req.getParameter("eid")!=null){
				dto.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				dto.setEstatus(req.getParameter("estatus"));
			}
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========�ʲ�ģ��״̬�仯��������========");
		
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
