/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM15BL;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1508Form;
import com.deliverik.infogovernor.sym.vo.IGSYM15061VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_���ݷ����б���Action����
 * </p>
 * 
 * @version 1.0
 */

public class IGSYM1506Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1506Action.class);

	/**
	 * ���ݷ����б���Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGSYM1508Form form = (IGSYM1508Form)actionForm;
		//BLȡ��
		IGSYM15BL ctlBL = (IGSYM15BL) getBean("igsym15BL");
		
		//DTO����
		IGSYM15DTO dto = new IGSYM15DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���ݷ����б��������ʾ����
			log.debug("========���ݷ����б��������ʾ����ʼ========");
			
			getPaginDTO(req,"IGSYM1507");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSYM1506");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGSYM1506Action(dto);
			
			IGSYM15061VO vo = new IGSYM15061VO(dto.getCodeCategoryDefInfoList());
			
			super.<IGSYM15061VO>setVO(req, vo);
			
			log.debug("========���ݷ����б��������ʾ��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
