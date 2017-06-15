/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR02BL;
import com.deliverik.infogovernor.prr.dto.IGPRR02DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0114Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01141VO;

/**
 * 概述:添加抄阅人action 
 * 功能描述：添加抄阅人
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
public class IGPRR0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0114Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGPRR0114Form form = (IGPRR0114Form)actionForm;		
		//BL取得
		IGPRR02BL ctlBL = (IGPRR02BL) getBean("igPRR02BL");	
		String forward = "DISP";
		//DTO生成
		IGPRR02DTO dto = new IGPRR02DTO();	
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH1".equals(mapping.getParameter())){
			log.debug("========抄阅人查询页面初始处理开始========");
			forward = "SEARCH1";
			log.debug("========抄阅人查询页面初始处理结束========");
			
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========查询抄阅人页面初始处理开始========");
			dto.setIgprr0114form(form);
			dto = ctlBL.getPeopleUnderRoleAction(dto);
			IGPRR01141VO vo = new IGPRR01141VO();
			vo.setMap_cru(dto.getMap_cru());
			super.<IGPRR01141VO>setVO(request, vo);
			log.debug("========查询抄阅人页面初始处理结束========");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========抄阅人查询页面处理开始========");
			//分页用DTO取得
			getPaginDTO(request,"IGPRR0114");
			PagingDTO pDto;			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRR0114");			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);			
			dto.setPagingDto(pDto);
			dto.setIgprr0114form(form);
			dto = ctlBL.getCopyReadInfoByCondAction(dto);
			IGPRR01141VO vo = new IGPRR01141VO();
			vo.setList(dto.getList());
			super.<IGPRR01141VO>setVO(request, vo);
			forward = "SEARCH";
			log.debug("========抄阅人查询页面处理结束========");
		}
		if("SAVE".equals(mapping.getParameter())){
			dto.setIgprr0114form(form);
			dto = ctlBL.saveCopyReadInfoByPkAction(dto);
			request.setAttribute("prserialnum",dto.getIg500().getPrserialnum() );// 工单号
			request.setAttribute("prid",dto.getIg500().getPrid());
			request.setAttribute("pts",dto.getIg500().getPrtype());
			forward = "SUCCESS";
		}
		if("UPDATE".equals(mapping.getParameter())){
			dto.setIgprr0114form(form);
			dto = ctlBL.updateIsLookAction(dto);
			request.setAttribute("prserialnum",dto.getIg500().getPrserialnum() );// 工单号
			request.setAttribute("prid",dto.getIg500().getPrid());
			request.setAttribute("pts",dto.getIg500().getPrtype());
			forward = "UPDATE";
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
