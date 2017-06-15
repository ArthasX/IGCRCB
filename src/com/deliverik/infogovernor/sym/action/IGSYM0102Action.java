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
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0102Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_�����޸�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0102Action.class);
	
	/**
	 * <p>
	 * Description: ����action����
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
		IGSYM0102Form form = (IGSYM0102Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
		//ʵ����DTO
		IGSYM01DTO dto = new IGSYM01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�����������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001","����������Ϣ"));
//			dto = ctlBL.searchOrganizationAll(dto);
//			List<Organization> list = dto.getOrganizationList();
//			List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
//			organizationList.add(new LabelValueBean("��ѡ��", ""));
//			for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
//				Organization organization = iter.next();
//				organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
//			}
//			request.setAttribute("organizationList", organizationList);
			saveToken(request);
			log.debug("========�����������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		String forward = "DISP";
		//��������
		if( "INSERT".equals(mapping.getParameter())){
			if(form.getOrgpar()!=null&&!form.getOrgpar().equals("")){
				if(!(form.getOrgpar().equals("0002")||form.getOrgpar().equals("0001"))){
					if(form.getOrgpar().length() > 4) {
						form.setOrgname(form.getOrgparname()+"-"+form.getOrgname());
					}
				}
			}
			if (form.getMode().equals("0")){
				log.debug("========������������ʼ========");
			
				dto.setIgsym0102Form(form);
				dto.setOrganization(form);
				if (isTokenValid(request, true)){
					//����BL����
					dto = ctlBL.insertOrganizationAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========����������������========");
			} else {
				//��Ϣ���
				log.debug("========�����������ʼ========");
				//���ϼ�����ʱ�ÿ�
				if("".equals(form.getOrgpar())){
					form.setOrgpar(null);
					form.setOrgparname(null);
				}
				
				dto.setOrganization(form);
				//����BL���
				dto = ctlBL.updateOrganizationAction(dto);
				forward = "DETAIL";
				log.debug("========���������������========");
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========�������������ʾ����ʼ========");
			dto.setIgsym0102Form(form);
			//���ϼ�����ʱ�ÿ�
			if("".equals(form.getOrgpar())){
				form.setOrgpar(null);
				form.setOrgparname(null);
			}
			dto = ctlBL.initIGSYM0102Action(dto);
			List<Organization> list = dto.getOrganizationList();
			List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
			organizationList.add(new LabelValueBean("��ѡ��", ""));
			for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
				Organization organization = iter.next();
				if(organization.getOrgid().equals(form.getOrgid())){
					continue;//��������������Ϊ�ϼ�����
				}
				organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
			}
			request.setAttribute("organizationList", organizationList);
			log.debug("========�������������ʾ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
