/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0509Form;
import com.csebank.lom.vo.IGLOM05091VO;
import com.deliverik.framework.base.BaseAction;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_���ŽӴ�ͳ�ƹ���_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0509Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0508Action.class);
	
	/**
	 * <p>
	 * Description:���ŽӴ�ͳ�Ʋ�ѯACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author wuzhenqiu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGLOM0509Form form = (IGLOM0509Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ���������ʾ����ʼ========");

			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//ʵ����DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ����ʼ========");
			
			dto.setDeptEentertainmentSearchCond(form);
			dto.setIglom0509Form(form);
			//����BL��ѯ
			dto = ctlBL.searchDeptEentertainmentAction(dto);
			if(dto.getDeptEentertainmentList().size()==1){
				dto.getDeptEentertainmentList().clear();
			}
			//����VO
			IGLOM05091VO vo = new IGLOM05091VO();
			vo.setDeptEentertainmentList(dto.getDeptEentertainmentList());
			
			super.<IGLOM05091VO>setVO(request, vo);
			
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ��������========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ����ʼ========");
			
			dto.setDeptEentertainmentSearchCond(form);
			dto.setIglom0509Form(form);
			//����BL��ѯ
			dto = ctlBL.searchDeptEentertainmentAction(dto);
			if(dto.getDeptEentertainmentList().size()==1){
				dto.getDeptEentertainmentList().clear();
			}
			//����VO
			IGLOM05091VO vo = new IGLOM05091VO();
			vo.setDeptEentertainmentList(dto.getDeptEentertainmentList());
			
			super.<IGLOM05091VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05091VO", vo);
			
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ��������========");
			return mapping.findForward("REPORT");

		}/*
		else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========���ŽӴ�ͳ����ϸ��ѯ����ʼ========");
			
			//����BL��ѯ
			dto = ctlBL.searchEentertainmentAction(dto);
			
			//����VO
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(request, vo);
			
			log.debug("========���ŽӴ�ͳ����ϸ��ѯ��������========");
		}
		*/
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
