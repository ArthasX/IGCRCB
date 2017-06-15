package com.deliverik.infogovernor.asset.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1111Form;
import com.deliverik.infogovernor.asset.vo.IGASM11111VO;
import com.deliverik.infogovernor.asset.vo.IGASM11201VO;

/**
 * �����б���Action����
 *
 */
public class IGASM1124Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1124Action.class);

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

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		//������ת����
		String forward = null;
		
		dto = ctlBL.getSynchronizationAlarmSystem(dto);

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
