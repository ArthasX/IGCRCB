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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.infogovernor.prr.bl.IGPRR06BL;
import com.deliverik.infogovernor.prr.dto.IGPRR06DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0601Form;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCondImpl;
import com.deliverik.infogovernor.prr.vo.IGPRR06011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0601Action extends BaseAction{

	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0601Action.class);
		//BL取得
		IGPRR06BL ctlBL = (IGPRR06BL) getBean("igPRR06BL");
		//实例化dto
		IGPRR06DTO dto = new IGPRR06DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//dto参数设定
		dto.setForm(actionForm);
		//form取得
		IGPRR0601Form form = (IGPRR0601Form) actionForm;
		dto.setPdid(form.getPdid());
			//获取流程查询页路径
		dto = ctlBL.searchForwardJsp(dto);
		
		
		//取得流程定义ID
		if(null!=form.getPdid()&&form.getPdid().length() < 7){
			dto = ctlBL.searchProcessDefinitionIdAction(dto);
			form.setPdid(dto.getPdid());
		}
		//获取页面显示头
		if(request.getSession().getAttribute("AD_ProcessQueryTitle") == null){
			dto = ctlBL.searchProcessQueryTitleAction(dto);
			request.getSession().setAttribute("AD_ProcessQueryTitle", dto.getProcessQueryShowColumnList());
			request.getSession().setAttribute("AD_ProcessQuery", dto.getProcessQueryList());
			request.getSession().setAttribute("AD_STATUS_DEFINITION", dto.getPsdList());
		}
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============流程通用查询页面初始化操作开始================");
			
			log.debug("===============流程通用查询页面初始化操作结束================");
		}
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("==============流程通用查询操作开始===============");
			//获取分页Bean
			getPaginDTO(request,"IGPRR0601");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRR0601Form) request.getSession().getAttribute("IGPRR0601Form");
				if (form == null) {
					form = new IGPRR0601Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGPRR0601Form) request.getSession().getAttribute("IGPRR0601Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			//实例化查询条件
			ProcessSearchCondImpl cond = new ProcessSearchCondImpl();
			this.copyProperties(cond, actionForm);
			//取得显示列
			List<IG110Info> showColumnList = (List<IG110Info>) request.getSession().getAttribute("AD_ProcessQueryTitle");
			//取得查询条件
			List<IG111Info> queryList = (List<IG111Info>) request.getSession().getAttribute("AD_ProcessQuery");
			cond.setQueryList(queryList);
			cond.setShowColumnList(showColumnList);
			dto.setProcessSearchCond(cond);
			int maxCnt = getMaxDataCount("IGWKM0601");
			dto.setPagingDto(pDto);
			dto.setMaxSearchCount(maxCnt);
			dto = ctlBL.searchProcessRecordAction(dto);
			//实例化vo
			IGPRR06011VO vo = new IGPRR06011VO();
			vo.setResult(dto.getResult());
			super.setVO(request, vo);
			log.debug("==============流程通用查询操作结束===============");
		}
		//导出操作
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("===============通用查询导出操作开始=================");
			dto.setResponse(response);
			//实例化查询条件
			ProcessSearchCondImpl cond = new ProcessSearchCondImpl();
			this.copyProperties(cond, actionForm);
			//取得显示列
			List<IG110Info> showColumnList = (List<IG110Info>) request.getSession().getAttribute("AD_ProcessQueryTitle");
			//取得查询条件
			List<IG111Info> queryList = (List<IG111Info>) request.getSession().getAttribute("AD_ProcessQuery");
			cond.setQueryList(queryList);
			cond.setShowColumnList(showColumnList);
			dto.setProcessSearchCond(cond);
			dto = ctlBL.exportProcessRecordAction(dto);
			log.debug("===============通用查询导出操作结束=================");
			return null;
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		//跳转到定制JSP
		if(StringUtils.isNotEmpty(dto.getForwardJsp())){
			return new ActionForward(dto.getForwardJsp());
		} else {
			return mapping.findForward("DISP");
		}
	}

}