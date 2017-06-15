/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
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
import com.deliverik.infogovernor.drm.bl.IGDRM17BL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM17031VO;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼��Աѡ�񵯳���
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1703Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��־����ȡ�� 
		Log log = LogFactory.getLog(IGDRM1703Action.class);
		//BLȡ��
		IGDRM17BL ctlBL = (IGDRM17BL) getBean("igdrm17BL");
		//ʵ����DTO
		IGDRM17DTO dto = new IGDRM17DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============��ѵ��¼��ѯ��Ա��ʼ==================");
			dto = ctlBL.searchUserRoleAction(dto);
			//ʵ����vo
			IGDRM17031VO vo = new IGDRM17031VO();
			vo.setUserRoleInfoMap(dto.getUserRoleInfoMap());
			super.setVO(request, vo);
			log.debug("===============��ѵ��¼��ѯ��Ա����==================");
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
