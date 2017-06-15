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
import com.deliverik.infogovernor.asset.form.IGASM0111Form;
import com.deliverik.infogovernor.asset.vo.IGASM01111VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGASM0111Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0111Action.class);
	
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
		IGASM0111Form form = (IGASM0111Form)actionForm;
		//ʵ����DTO
		IGASM01DTO dto = new IGASM01DTO();
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		
		//����BL��ѯ
		if("DISP".equals(mapping.getParameter())){
			saveToken(req);
			dto.setIgasm0111Form(form);
			dto = ctlBL.getCfgCodeDetailByCategory(dto);
			IGASM01111VO vo = new IGASM01111VO();
			vo.setConfigurationCodeDetail(dto.getConfigurationcodedetail());
			saveToken(req);
			super.<IGASM01111VO>setVO(req, vo);
		} else if ("INSERT".equals(mapping.getParameter())){
			dto.setIgasm0111Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertCfgCodeDetailAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
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
