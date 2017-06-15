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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD10BL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;
import com.deliverik.infogovernor.prd.form.IGPRD1001Form;
import com.deliverik.infogovernor.prd.vo.IGPRD10011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD1001Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD1001Action.class);
		//BL取得
		IGPRD10BL ctlBL = (IGPRD10BL) getBean("igprd10BL");
		//form取得
		IGPRD1001Form form = (IGPRD1001Form) actionForm;
		//实例化dto
		IGPRD10DTO dto = new IGPRD10DTO();
		//dto参数设定
		dto.setForm(actionForm);
		//流程定义查询操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============流程定义查询操作开始=================");
			if(form.getPtid() == null || form.getPtid() == 0){
				form.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID);
			}
			//分页用DTO取得
			getPaginDTO(request,"IGPRD1001");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRD1001Form) request.getSession().getAttribute("IGPRD1001Form");
				if ( form == null ) {
					form = new IGPRD1001Form();
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
					form = (IGPRD1001Form) request.getSession().getAttribute("IGPRD1001Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0101");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//流程定义信息检索逻辑调用
			dto = ctlBL.searchLastProcessDefinitionAction(dto);
			//实例化vo
			IGPRD10011VO vo = new IGPRD10011VO();
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			super.setVO(request, vo);
			log.debug("===============流程定义查询操作结束=================");
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
