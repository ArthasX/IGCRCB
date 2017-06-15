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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0301Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程组定义简略显示Action
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0301Action extends BaseAction{
	static Log log = LogFactory.getLog(IGPRD0301Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//BL取得
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//实例化dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//form取得
		IGPRD0301Form form = (IGPRD0301Form) actionForm;
		//dto参数设定
		//页面初始化操作
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========流程组定义查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGPRD0301");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
				if ( form == null ) {
					form = new IGPRD0301Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
//					form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0301");
			
			
			dto.setIgprd0301Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			

			//流程定义信息检索逻辑调用
			dto = ctlBL.searchProcessGroupDefinition(dto);
			
			//将流程定义信息检索结果设定到VO中
			IGPRD03011VO vo = new IGPRD03011VO(dto.getProcessGroupDefinitionList());
			
			super.<IGPRD03011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========流程组定义查询处理终了========");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("================开始改变流程状态================");
			dto.setIgprd0301Form(form);
			
			if (isTokenValid(req, true)){
				//流程组状态修改
				ctlBL.changeStatus(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("===============改变流程状态结束==========");
		}
		if("UPGRADE".equals(mapping.getParameter())){
			log.debug("==========流程组升版开始============");
			
			dto.setIgprd0301Form(form);
			
			
			log.debug("==========流程组升版结束============");
		}
		if("LANUCH".equals(mapping.getParameter())){
			log.debug("==========流程组发起开始============");
			
			dto.setIgprd0301Form(form);

			dto.setUser((User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER));
			if (isTokenValid(req, true)){
				//流程组发起
				ctlBL.LaunchAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("==========流程组发起结束============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}