/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.action;

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
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;

/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: �ճ���ά�ƻ�����Ǽ�ACTION
 * </p>
 * 
 */

public class IGMTP0103Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGMTP0103Action.class);

	/**
	 * �����߼�
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		
		IGMTP0101Form form = (IGMTP0101Form)actionForm;
		IGMTP01BL igmtp01BL = (IGMTP01BL) getBean("igmtp01BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if("DISP".equals(mapping.getParameter())){
			//Session���
			clearSessionFormData(request);
			String beginDate = form.getDate();
			IGMTP01011VO vo = new IGMTP01011VO();
			vo.setBeginDate(beginDate);
			vo.setUser(user);
			IGMTP01DTO dto = new IGMTP01DTO(); 
			dto = igmtp01BL.getProcessDefinitions(dto);
			vo.setPdList(dto.getPdList());
			super.<IGMTP01011VO>setVO(request, vo);
			addMessage(request, new ActionMessage("IGCO10000.I001","������Ϣ"));
		}
		return mapping.findForward("DISP");
	}
	
}