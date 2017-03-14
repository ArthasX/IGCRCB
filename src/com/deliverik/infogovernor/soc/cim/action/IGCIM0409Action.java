/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;


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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0409Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04091VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGCIM0409Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0409Action.class);
	
	/**
	 * <p>
	 * Description:ѡ������ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//��ȡBL�ӿ�ʵ��
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		//ʵ����DTO
		IGCIM04DTO dto = new IGCIM04DTO();
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		//����BL��ѯ
		
		if ("CHANGE_NAME".equals(mapping.getParameter())){
			IGCIM0409Form form = (IGCIM0409Form)actionForm;
			dto.setIgcim0409Form(form);
		}
		dto = ctlBL.searchConfigurationCodeDetail(dto);
		//����VO
		IGCIM04091VO vo = new IGCIM04091VO(dto.getConfigurationCodeDetailList());
		super.<IGCIM04091VO>setVO(req, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return mapping.findForward("DISP");
	}

}
