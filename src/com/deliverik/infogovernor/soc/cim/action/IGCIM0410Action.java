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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0110Form;
import com.deliverik.infogovernor.asset.vo.IGASM01101VO;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0410Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04101VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGCIM0410Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0410Action.class);
	
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
		IGCIM0410Form form = (IGCIM0410Form)actionForm;
		//ʵ����DTO
		IGCIM04DTO dto = new IGCIM04DTO();
		dto.setIgcim0410Form(form);
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
		IGCIM04101VO vo = new IGCIM04101VO(dto.getConfigurationCodeDetailList());
		super.<IGCIM04101VO>setVO(req, vo);
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
