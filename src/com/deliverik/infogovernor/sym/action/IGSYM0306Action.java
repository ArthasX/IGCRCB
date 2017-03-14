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
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0301Form;
import com.deliverik.infogovernor.sym.vo.IGSYM03011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_��ѯACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGSYM0306Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0306Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫaction����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSYM0301Form form = (IGSYM0301Form)actionForm;
		if(form==null){
			form = new IGSYM0301Form();
		}
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ɫ��ѯ���������ʾ����ʼ========");
			if(request.getParameter("pdid")!=null && !"".equals(request.getParameter("pdid"))){
				form.setPdid(request.getParameter("pdid"));
			}
			request.setAttribute("IGSYM0301Form", form);
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ɫ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSYM03BL ctlBL = (IGSYM03BL) getBean("igsym03BL");
		//ʵ����DTO
		IGSYM03DTO dto = new IGSYM03DTO();
		//��ɫ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��ɫ��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0301Form) request.getSession().getAttribute("IGSYM0301Form");
				if ( form== null){
					form = new IGSYM0301Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSYM0301Form) request.getSession().getAttribute("IGSYM0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0301");

			//���˵���IGBP���͵Ľ�ɫ
			//form.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
			
			//��ѯ��ɫ���ʹ���IGBP04�ļ�¼
			//form.setRoletype_gt(WorkFlowConstDefine.DISPATCH_ROLE_TYPE);
			
			
			
			dto.setRoleSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchRoleActionFor0306(dto);
			
			request.setAttribute("nameMap", dto.getCompletenameMap());
			request.setAttribute("assetnameMap", dto.getCompleteassetnameMap());
			//����VO
			IGSYM03011VO vo = new IGSYM03011VO(dto.getRoleList());
			
			super.<IGSYM03011VO>setVO(request, vo);
			
			log.debug("========��ɫ��ѯ��������========");
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
