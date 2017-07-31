/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0201Form;
import com.deliverik.infogovernor.sym.vo.IGSYM02011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_��ѯɾ��ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0201Action.class);
	
	/**
	 * <p>
	 * Description: �û�action����
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
		IGSYM0201Form form = (IGSYM0201Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//ʵ����DTO
		IGSYM02DTO dto = new IGSYM02DTO();
//		dto = ctlBL.searchOrganizationAll(dto);
//		List<Organization> list = dto.getOrganizationList();
//		List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
//		organizationList.add(new LabelValueBean("", ""));
//		for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
//			Organization organization = iter.next();
//			organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
//		}
//		request.setAttribute("organizationList", organizationList);
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û���ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//�û���ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0201");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0201Form) request.getSession().getAttribute("IGSYM0201Form");
				
				if ( form== null){
					form = new IGSYM0201Form();
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
					form = (IGSYM0201Form) request.getSession().getAttribute("IGSYM0201Form");
					if(request.getParameter("orgStr")!=null && !(request.getParameter("orgStr").equals(""))){
						System.out.println(request.getParameter("orgStr"));
						form.setOrgidstr(request.getParameter("orgStr"));
					}
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0201");
			
			dto.setUserSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserAction(dto);
			//����VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			
			super.<IGSYM02011VO>setVO(request, vo);
			
			log.debug("========�û���ѯ��������========");
		}else if("OPEN".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0201");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0201Form) request.getSession().getAttribute("IGSYM0201Form");
				
				if ( form== null){
					form = new IGSYM0201Form();
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
					form = (IGSYM0201Form) request.getSession().getAttribute("IGSYM0201Form");
//					if(request.getParameter("orgStr")!=null && !(request.getParameter("orgStr").equals(""))){
//						System.out.println(request.getParameter("orgStr"));
//						form.setOrgidstr(request.getParameter("orgStr"));
//					}
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0201");
			
			UserSearchCondImpl cond = new UserSearchCondImpl();
//			BeanUtils.copyProperties(cond, form);
			//����ѯ����Сдת���ɴ�д
			cond.setUsername_q(form.getUsername_q());
			if(StringUtils.isNotEmpty(form.getOrgidstr())){
				if("0002001017".equals(form.getOrgidstr())){
					
					cond.setOrgid_like(form.getOrgidstr());
				}else{
					
					cond.setOrgid(form.getOrgidstr());
				}
			}else{
				cond.setOrgid_like("0002001017");
			}
			
			dto.setUserSearchCond(cond);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserAction(dto);
			//����VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			
			super.<IGSYM02011VO>setVO(request, vo);
			
			log.debug("========�û���ѯ��������========");
		}
		//ɾ��/����
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========�û�ɾ��/�����ʼ========");
			dto.setUserid(form.getChangeUserid());
			ctlBL.changeUserFlagAction(dto);
			log.debug("========�û�ɾ��/���������========");
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
