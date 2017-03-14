/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ա��ѯaction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0303Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0303Action.class);
		//BLȡ��
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//ʵ����dto
		IGPRR03DTO dto = new IGPRR03DTO();
		//formȡ��
		IGPRR0303Form form = (IGPRR0303Form) actionForm;
		//dto�����趨
		dto.setIgprr0303Form(form);
		log.debug("==========��Ա��ѯҳ���ʼ��������ʼ==========");
		String roletype = request.getParameter("roletype");
		String pidid = request.getParameter("pidid");
		form.reset();
		if(StringUtils.isNotEmpty(roletype)){
			form.setRoletype(roletype);
		}
		if(StringUtils.isNotEmpty(pidid)){
			form.setPidid(pidid);
		}
		dto = ctlBL.searchRoleidNotInAction(dto);
		//ҳ���ʼ������
		/*if("DISP".equals(mapping.getParameter())){
			log.debug("==========��Ա��ѯҳ���ʼ��������ʼ==========");
			String roletype = request.getParameter("roletype");
			String pidid = request.getParameter("pidid");
			form.reset();
			if(StringUtils.isNotEmpty(roletype)){
				form.setRoletype(roletype);
			}
			if(StringUtils.isNotEmpty(pidid)){
				form.setPidid(pidid);
			}
			dto = ctlBL.searchRoleidNotInAction(dto);
			log.debug("==========��Ա��ѯҳ���ʼ����������==========");
		}*/
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("============��Ա��ѯ������ʼ============");
			//����BL��ѯ�û���Ϣ
			dto = ctlBL.searchUserRoleAction(dto);
			//ʵ����vo
			IGPRR03031VO vo = new IGPRR03031VO();
			vo.setUserRoleInfoMap(dto.getUserRoleInfoMap());
			super.<IGPRR03031VO>setVO(request, vo);
			log.debug("============��Ա��ѯ��������============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
