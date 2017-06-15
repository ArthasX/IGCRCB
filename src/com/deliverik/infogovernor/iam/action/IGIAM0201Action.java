/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0201Form;
import com.deliverik.infogovernor.iam.vo.IGIAM02011VO;

/**
 * @author zhaomin
 *
 */
/**
 * 概述: 内置工作管理查询action
 * 功能描述：内置工作管理查询
 * 创建人：赵敏
 * 创建记录： 2012-7-26
 * 修改记录：
 */
public class IGIAM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0201Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取form
		IGIAM0201Form form = (IGIAM0201Form)actionForm;
		
		//获取bl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//获取dto
		IGIAM02DTO dto = new IGIAM02DTO();

		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========内审工作查询处理开始========");
			//分页用DTO取得
			getPaginDTO(request, "IGIAM0201");			
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//判断form是否为空
			if (form == null) {
				//form为空时，初始化form
				form = new IGIAM0201Form();
			} else {
				//进行分页处理
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(form.getFromCount());
				} else {
					form.setFromCount(pDto.getFromCount());
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0101");
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);
			dto.setIgiam0201form(form);
			//设置新增form对象
			dto = iajBL.searchIAMAction(dto);
			//初始化VO
			IGIAM02011VO vo = new IGIAM02011VO();
			//将查询结果封装到VO中
			vo.setInternalauditJobList(dto.getInternalauditJobList());
			//返回VO
			super.<IGIAM02011VO>setVO(request, vo);
			log.debug("========内审工作查询处理结束========");
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
