/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0401Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��Ȩ��ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0401Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫ��Ȩaction����
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
		IGSYM0401Form form = (IGSYM0401Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		dto = ctlBL.searchOrganizationAll(dto);
		List<Organization> list = dto.getOrganizationList();
		List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
		organizationList.add(new LabelValueBean("", ""));
		for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
			Organization organization = iter.next();
			organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
		}
		request.setAttribute("organizationList", organizationList);
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ɫ��Ȩ��ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ɫ��Ȩ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ɫ��Ȩ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��ɫ��Ȩ��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0401");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0401Form) request.getSession().getAttribute("IGSYM0401Form");
				if ( form== null){
					form = new IGSYM0401Form();
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
					form = (IGSYM0401Form) request.getSession().getAttribute("IGSYM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0401");
			
			dto.setUserSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserAction(dto);
			//����VO
			IGSYM04011VO vo = new IGSYM04011VO(dto.getUserList());
			
			super.<IGSYM04011VO>setVO(request, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========��ɫ��Ȩ��ѯ��������========");
		}
		return mapping.findForward("DISP");
	}

}
