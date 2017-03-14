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
import com.deliverik.infogovernor.prr.bl.IGPRR04BL;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;
import com.deliverik.infogovernor.prr.vo.IGPRR04011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���Ŀ¼��ʾaction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0401Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0401Action.class);
		//BLȡ��
		IGPRR04BL ctlBL = (IGPRR04BL) getBean("igprr04BL");
		//ʵ����dto
		IGPRR04DTO dto = new IGPRR04DTO();
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("========����Ŀ¼ҳ���ʼ��������ʼ========");
			//����Bl��������
			dto = ctlBL.initServiceCatelogAction(dto);
			//ʵ����vo
			IGPRR04011VO vo = new IGPRR04011VO();
			vo.setServiceCatalogMap(dto.getServiceCatalogMap());
			vo.setServiceCatalogFirstClassify(dto.getServiceCatalogFirstClassify());
			super.<IGPRR04011VO>setVO(request, vo);
			log.debug("========����Ŀ¼ҳ���ʼ����������========");
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
