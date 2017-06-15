/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0110Form;
import com.deliverik.infogovernor.asset.vo.IGASM01101VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGASM0110Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0110Action.class);
	
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
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		IGASM0110Form form = (IGASM0110Form)actionForm;
		//ʵ����DTO
		IGASM01DTO dto = new IGASM01DTO();
		dto.setIgasm0110Form(form);
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		
		//����BL��ѯ
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			dto.setFlag("status");
		}else if("CHANGE_VALUE".equals(mapping.getParameter())){
			dto.setFlag("changeValue");
		}
		dto = ctlBL.searchCfgCodeDetailByCategory(dto);
		//����VO
		IGASM01101VO vo = new IGASM01101VO(dto.getConfigurationCodeDetailList());
		super.<IGASM01101VO>setVO(req, vo);
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
