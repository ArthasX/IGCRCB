package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0106Form;
import com.deliverik.infogovernor.asset.vo.IGASM01021VO;
import com.deliverik.infogovernor.asset.vo.IGASM01061VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGASM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0106Action.class);

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
		IGASM0106Form form = (IGASM0106Form)actionForm;
		
		//BLȡ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO����
		IGASM01DTO dto = new IGASM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ��ѯ���������ʾ����
			log.debug("========����������Ϣ��ѯ���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0106");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//����������Ϣ��ѯ���������ʾ�����߼�����
			dto = ctlBL.initIGASM0106Action(dto);
			
			//������������Ϣ��������趨��VO��
			IGASM01061VO vo = new IGASM01061VO(dto.getConfigurationMap());
			
			super.<IGASM01061VO>setVO(req, vo);

			IGASM01021VO vo1 = new IGASM01021VO(dto.getEntity());
			
			super.<IGASM01021VO>setVO(req.getSession(),vo1);
			
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
