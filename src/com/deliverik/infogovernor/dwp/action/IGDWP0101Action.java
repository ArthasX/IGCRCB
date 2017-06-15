/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0101Form;
import com.deliverik.infogovernor.dwp.vo.IGDWP01011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0101Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDWP0101Action.class);
		//BL取得
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//实例化dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//form取得
		IGDWP0101Form form = (IGDWP0101Form) actionForm;
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setForm(form);
		dto.setUser(user);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("================日常工作计划查询页面初始化操作开始=================");
			log.debug("================日常工作计划查询页面初始化操作结束=================");
		}
		
		//日常工作计划查询操作
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//获取分页Bean
			getPaginDTO(request,"IGDWP0101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDWP0101Form) request.getSession().getAttribute("IGDWP0101Form");
				if ( form == null ) {
					form = new IGDWP0101Form();
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
					form = (IGDWP0101Form) request.getSession().getAttribute("IGDWP0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			if("Y".equals(form.getSingle())){
				form.setPuserid(user.getUserid());
			}else{
				form.setPuserid(null);
			}
			int maxCnt = getMaxDataCount("IGDWP0101");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchDayWorkPlanAction(dto);
			//实例化vo
			IGDWP01011VO vo = new IGDWP01011VO();
			vo.setDayWorkPlanList(dto.getDayWorkPlanList());
			super.<IGDWP01011VO>setVO(request, vo);
			saveToken(request);
		}
		//任务删除操作
		if("DELETE".equals(mapping.getParameter())){
			log.debug("================日常工作计划删除操作开始=================");
			if (isTokenValid(request, true)){
				dto = ctlBL.deleteDayWorkPlanAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("================日常工作计划删除操作结束=================");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
