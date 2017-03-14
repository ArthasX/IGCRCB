/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.sym.form.IGSYM0305Form;
import com.deliverik.infogovernor.sym.vo.IGSYM03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_查询删除ACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGSYM0305Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0305Action.class);
	
	/**
	 * <p>
	 * Description: 角色action处理
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
		//实例化FORM
		IGSYM0305Form form = (IGSYM0305Form)actionForm;
//		if(form!=null){
//			//String roleid = form.getRoleid();
//			Integer count = form.getFromCount();
//			//String roletype = form.getRoletype();
//			//String rolename_q = form.getRolename_q();
//			request.getSession().setAttribute("IGSYM0305Form", null);
//			form = new IGSYM0305Form();
//			//form.setRoleid(roleid);
//			form.setFromCount(count);
//			//form.setRoletype(roletype);
//			//form.setRolename_q(rolename_q);
//			request.getSession().setAttribute("IGSYM0305Form", form);
//			
//		}\
		if(request.getParameter("flag")!=null){
			String ciiop=(String) request.getParameter("flag");
			request.getSession().setAttribute("flag",ciiop);
		}
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========角色查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========角色查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSYM03BL ctlBL = (IGSYM03BL) getBean("igsym03BL");
		//实例化DTO
		IGSYM03DTO dto = new IGSYM03DTO();
		//角色查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========角色查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0305Form) request.getSession().getAttribute("IGSYM0305Form");
				if ( form== null){
					form = new IGSYM0305Form();
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
					form = (IGSYM0305Form) request.getSession().getAttribute("IGSYM0305Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0305");
			
			dto.setRoleSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRoleAction(dto);
			
			request.setAttribute("nameMap", dto.getCompletenameMap());
			request.setAttribute("assetnameMap", dto.getCompleteassetnameMap());
			//构造VO
			IGSYM03011VO vo = new IGSYM03011VO(dto.getRoleList());
			
			super.<IGSYM03011VO>setVO(request, vo);
			
			log.debug("========角色查询处理终了========");
		}
		if( "RDISP".equals(mapping.getParameter())){
			log.debug("========角色查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========角色查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "RSEARCH".equals(mapping.getParameter())||"RSEARCH1".equals(mapping.getParameter())){
			log.debug("========角色查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("RSEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0305Form) request.getSession().getAttribute("IGSYM0305Form");
				if ( form== null){
					form = new IGSYM0305Form();
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
					form = (IGSYM0305Form) request.getSession().getAttribute("IGSYM0305Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0305");
			
			form.setRoles_BP_EX(new String[]{"IGBP19","IGBP24","IGBP25","IGBP26","IGBP27","IGBP28"});
			
			dto.setRoleSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRoleAction(dto);
			
			request.setAttribute("nameMap", dto.getCompletenameMap());
			request.setAttribute("assetnameMap", dto.getCompleteassetnameMap());
			//构造VO
			IGSYM03011VO vo = new IGSYM03011VO(dto.getRoleList());
			
			super.<IGSYM03011VO>setVO(request, vo);
			
			log.debug("========角色查询处理终了========");
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
