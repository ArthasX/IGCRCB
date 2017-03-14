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
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1204Form;
import com.deliverik.infogovernor.asset.vo.IGASM12041VO;

/**
 * ����������Ϣ��ϸ����Action����
 *
 */
public class IGASM1204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1204Action.class);

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
		IGASM1204Form form = (IGASM1204Form)actionForm;
		
		//BLȡ��
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO����
		IGASM12DTO dto = new IGASM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1204");

			//DTO��������趨
			dto.setIgasm1204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//����������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM1204Action(dto);
			
			//������������Ϣ��������趨��VO��
			IGASM12041VO vo = new IGASM12041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoList());
			
			super.<IGASM12041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========����������Ϣ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//����������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//����������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//���ػ����ѯ����
					return mapping.findForward("BACK1");
				} else {
					//���ػ���Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========����������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm1204Form(form);
			
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
