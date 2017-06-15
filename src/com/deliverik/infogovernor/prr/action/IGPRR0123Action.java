/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0123Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01231VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̱���־�鿴Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0123Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0123Action.class);
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//ʵ������dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//form����ȡ��
		IGPRR0123Form form = (IGPRR0123Form) actionForm;
		//dto�����趨
		dto.setUser(user);
		dto.setPrid(form.getPrid());
		//��ѯ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("================����־��ѯ������ʼ=================");
			dto = ctlBL.searchProcessInfoLog(dto);
			//ʵ����vo
			IGPRR01231VO vo = new IGPRR01231VO();
			vo.setVarLogList(dto.getVarLogList());
			super.<IGPRR01231VO>setVO(request, vo);
			log.debug("================����־��ѯ��������=================");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
