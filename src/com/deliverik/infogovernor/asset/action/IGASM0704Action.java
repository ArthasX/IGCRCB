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
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0704Form;
import com.deliverik.infogovernor.asset.vo.IGASM07041VO;

/**
 * ����������Ϣ��ϸ����Action����
 *
 */
public class IGASM0704Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0704Action.class);

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
		IGASM0704Form form = (IGASM0704Form)actionForm;
		
		//BLȡ��
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO����
		IGASM07DTO dto = new IGASM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0704");

			//DTO��������趨
			dto.setIgasm0704Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//����������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM0704Action(dto);
			
			//������������Ϣ��������趨��VO��
			IGASM07041VO vo = new IGASM07041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoList());
			
			super.<IGASM07041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========����������Ϣ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//����������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//����������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//���ػ�����ѯ����
					return mapping.findForward("BACK1");
				} else {
					//���ػ����Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========����������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm0704Form(form);
			
			//����������Ϣ�༭�߼�����
			dto = ctlBL.editEntityItemAction(dto);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}

			log.debug("========����������Ϣ�༭��������========");
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("null");
	}
}
