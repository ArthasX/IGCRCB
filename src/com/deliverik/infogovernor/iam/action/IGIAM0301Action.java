/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.vo.IGIAM03011VO;

/**
 * 概述: 审计报告管理新增action
 * 功能描述：审计报告管理新增action
 * 创建人：惠涌智
 * 创建记录： 2012-8-8
 * 修改记录：
 */
public class IGIAM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0301Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取form
		IGIAM0301Form form = (IGIAM0301Form)actionForm;
		//获取业务逻辑BL
		IGIAM03BL iam03BL = (IGIAM03BL)getBean("igiam03bl");
		//声明DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		//获取当前登录用户
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========审计报告查询处理开始========");
			//分页用DTO取得
			getPaginDTO(request, "IGIAM0301");	
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//由详细画面，编辑画面返回查询画面时的再检索处理
			if ("SEARCH1".equals(mapping.getParameter())){
				form.setApprojectname("");
				form.setApreporttype("");
			//进行初次查询处理
			} else {
				//判断form是否为空
				if (form == null) {
					//form为空时，初始化form
					form = new IGIAM0301Form();
				} else {
					//进行分页处理
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0301");
			//将查询结果的结果数封装到dto中
			igiam03DTO.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			igiam03DTO.setPagingDto(pDto);
			igiam03DTO.setIgiam0301Form(form);
			//查询结果
			igiam03DTO = iam03BL.searchIAM03DTOAction(igiam03DTO);
			//将查询结果放到VO中
			IGIAM03011VO vo = new IGIAM03011VO();
			vo.setAuditProjectInfoList(igiam03DTO.getAuditProjectInfoList());
			//放回VO
			super.<IGIAM03011VO>setVO(request, vo);
			log.debug("========审计报告查询处理结束========");
		}
		return mapping.findForward("DISP");
	}
	
}
