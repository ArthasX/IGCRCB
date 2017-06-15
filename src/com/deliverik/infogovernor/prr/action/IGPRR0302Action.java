/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:角色查询Action 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0302Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0302Action.class);
		//BL取得
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//实例化dto
		IGPRR03DTO dto = new IGPRR03DTO();
		//form对象取得
		IGPRR0302Form form = (IGPRR0302Form) actionForm;
		if("DISP".equals(mapping.getParameter())){
			log.debug("================角色查询操作开始===============");
			String roletype = request.getParameter("roletype");
			String roleids = request.getParameter("roleids");
			String roleidin = request.getParameter("roleidin");
			form.reset();
			if(StringUtils.isNotEmpty(roletype)){
				form.setDisabled("1");
				form.setRoletype(roletype);
			}else{
				form.setDisabled("0");
			}
			if(StringUtils.isNotEmpty(roleids)){
				form.setRoleids(roleids);
			}
			if(StringUtils.isNotEmpty(roleidin)){
				form.setRoleidin(roleidin);
			}
			log.debug("================角色查询操作结束===============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========角色查询操作开始==========");
			//获取分页Bean
			getPaginDTO(request,"IGPRR0302");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGPRR0302Form) request.getSession().getAttribute("IGPRR0302Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//允许页面查询的最大记录数量取得
			int maxCnt = getMaxDataCount("IGPRR0302");
			//允许页面查询的最大记录数量设定
			dto.setMaxSearchCount(maxCnt);
			//分页dto设定
			dto.setPagingDto(pDto);
			//form设定
			dto.setIgprr0302Form(form);
			//调用BL查询
			dto = ctlBL.searchRoleListAction(dto);
			//实例化vo
			IGPRR03021VO vo = new IGPRR03021VO();
			vo.setRoleList(dto.getRoleList());
			super.<IGPRR03021VO>setVO(request, vo);
			log.debug("===========角色查询操作结束==========");
		}
		if("ADD".equals(mapping.getParameter())){
			log.debug("============配置角色添加操作开始===========");
			//页面操作设定
			dto.setIgprr0302Form(form);
			dto = ctlBL.addIG001InfoAction(dto);
			response.getWriter().write("<script>window.opener.refresh();window.close();</script>");
			log.debug("============配置角色添加操作结束===========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
