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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0408Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04081VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_���ݽ�ɫ���Ͳ�ѯ�û�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
 
public class IGSYM0408Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0408Action.class);
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//ʵ����FORM
		IGSYM0408Form form = (IGSYM0408Form)actionForm;
		if(form!=null){
			Integer roleid = form.getRoleida();
			Integer count = form.getFromCount();
			String username = form.getUsername();
			String orgida = form.getOrgida();
			String orgname = form.getOrgname();
			String roletype = form.getRoletype();
			request.getSession().setAttribute("IGSYM0408Form", null);
			form = new IGSYM0408Form();
			form.setRoleida(roleid);
			form.setFromCount(count);
			form.setUsername(username);
			form.setOrgida(orgida);
			form.setOrgname(orgname);
			form.setRoletype(roletype);
			request.getSession().setAttribute("IGSYM0408Form", form);
			
		}
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û���ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0408");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
			int maxCnt = getMaxDataCount("IGSYM0408");
			
			dto.setUserInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserByRoleType(dto);
			//����VO
			IGSYM04081VO vo = new IGSYM04081VO(dto.getUserList());	
			super.<IGSYM04081VO>setVO(request, vo);
			log.debug("========�û���ѯ��������========");
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
