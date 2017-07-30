/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.drm.bl.IGDRM18BL;
import com.deliverik.infogovernor.drm.dto.IGDRM18DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM18011VO;

/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description:Ԥ��ͳ��
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
public class IGDRM1801Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��־����ȡ�� 
		Log log = LogFactory.getLog(IGDRM1801Action.class);
		//BLȡ��
		IGDRM18BL ctlBL = (IGDRM18BL) getBean("igdrm18BL");
		//ʵ����DTO
		IGDRM18DTO dto = new IGDRM18DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============Ԥ��ͳ�Ʋ�ѯ��ʼ==================");
			dto = ctlBL.getPlanRate(dto);
			//ʵ����vo
			IGDRM18011VO vo = new IGDRM18011VO();
			vo.setPlanRateList(dto.getPlanRateList());
			super.setVO(request, vo);
			log.debug("===============Ԥ��ͳ�Ʋ�ѯ����==================");
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