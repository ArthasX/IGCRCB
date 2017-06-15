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
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1114Form;
import com.deliverik.infogovernor.asset.vo.IGASM11141VO;

/**
 * ����ƽ��ͼ����Action����
 *
 */
public class IGASM1114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1114Action.class);

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
		IGASM1114Form form = (IGASM1114Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����ƽ��ͼ���������ʾ����
			log.debug("========����ƽ��ͼ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1114Form(form);
			
			//��������߼�����
			dto = ctlBL.initIGASM1114Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11141VO vo = new IGASM11141VO(dto.getComputerContainerVWInfo(),
					dto.getComputerDeviceVWInfoList());
			
			super.<IGASM11141VO>setVO(req, vo);
			
			log.debug("========����ƽ��ͼ���������ʾ��������========");
		} else if ("DISP_FX".equals(mapping.getParameter())){
			if("1".equals(form.getJitype())){
				req.setAttribute("jitype", "14");
			}else{
				req.setAttribute("jitype", form.getJitype());
			}
		}

		if( "MOVE".equals(mapping.getParameter())){
			//�豸�Ƴ�����
			log.debug("========�豸�Ƴ�����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1114Form(form);
			
			//�豸�Ƴ��߼�����
			dto = ctlBL.moveoutComputerDeviceAction(dto);
			
			log.debug("========�豸�Ƴ���������========");
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
