/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_新增修改ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0102Action.class);
	
	/**
	 * <p>
	 * Description: 机构action处理
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
		//实例化FORM
		IGSYM0102Form form = (IGSYM0102Form)actionForm;
		//获取BL接口实例
		IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
		//实例化DTO
		IGSYM01DTO dto = new IGSYM01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========机构新增画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I001","机构基本信息"));
//			dto = ctlBL.searchOrganizationAll(dto);
//			List<Organization> list = dto.getOrganizationList();
//			List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
//			organizationList.add(new LabelValueBean("请选择", ""));
//			for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
//				Organization organization = iter.next();
//				organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
//			}
//			request.setAttribute("organizationList", organizationList);
			saveToken(request);
			log.debug("========机构新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		String forward = "DISP";
		//机构新增
		if( "INSERT".equals(mapping.getParameter())){
			if(form.getOrgpar()!=null&&!form.getOrgpar().equals("")){
				if(!(form.getOrgpar().equals("0002")||form.getOrgpar().equals("0001"))){
					if(form.getOrgpar().length() > 4) {
						form.setOrgname(form.getOrgparname()+"-"+form.getOrgname());
					}
				}
			}
			if (form.getMode().equals("0")){
				log.debug("========机构新增处理开始========");
			
				dto.setIgsym0102Form(form);
				dto.setOrganization(form);
				if (isTokenValid(request, true)){
					//调用BL新增
					dto = ctlBL.insertOrganizationAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========机构新增处理终了========");
			} else {
				//信息变更
				log.debug("========机构变更处理开始========");
				//无上级机构时置空
				if("".equals(form.getOrgpar())){
					form.setOrgpar(null);
					form.setOrgparname(null);
				}
				
				dto.setOrganization(form);
				//调用BL变更
				dto = ctlBL.updateOrganizationAction(dto);
				forward = "DETAIL";
				log.debug("========机构变更处理终了========");
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========机构变更初期显示处理开始========");
			dto.setIgsym0102Form(form);
			//无上级机构时置空
			if("".equals(form.getOrgpar())){
				form.setOrgpar(null);
				form.setOrgparname(null);
			}
			dto = ctlBL.initIGSYM0102Action(dto);
			List<Organization> list = dto.getOrganizationList();
			List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
			organizationList.add(new LabelValueBean("请选择", ""));
			for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
				Organization organization = iter.next();
				if(organization.getOrgid().equals(form.getOrgid())){
					continue;//本级机构不能作为上级机构
				}
				organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
			}
			request.setAttribute("organizationList", organizationList);
			log.debug("========机构变更初期显示处理终了========");
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
