/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD02BL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:用户查询action 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0201Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0201Action.class);
		//bl取得
		IGPRD02BL ctlBL = (IGPRD02BL) getBean("igprd02BL");
		//实例化dto
		IGPRD02DTO dto = new IGPRD02DTO();
		//form取得
		IGPRD0201Form form = (IGPRD0201Form) actionForm;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========用户查询页面初始化操作开始============");
			//清空form
			log.debug("===========用户查询页面初始化操作结束============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========用户查询操作开始=============");
			//获取分页Bean
			getPaginDTO(request,"IGPRD0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGPRD0201Form) request.getSession().getAttribute("IGPRD0201Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			//允许页面查询的最大记录数量取得
			int maxCnt = getMaxDataCount("IGPRD0201");
			//允许页面查询的最大记录数量设定
			dto.setMaxSearchCount(maxCnt);
			//分页dto设定
			dto.setPagingDto(pDto);
			//form设定
			dto.setIgprd0201Form(form);
			//调用BL查询用户集合
			dto = ctlBL.searchUserInfoList(dto);
			//实例化vo
			IGPRD02011VO vo = new IGPRD02011VO();
			vo.setUserroleList(dto.getUserroleList());
			super.<IGPRD02011VO>setVO(request, vo);
			log.debug("===========用户查询操作结束=============");
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

