/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0134Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01341VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:参与者支持机构选择action 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0134Action extends BaseAction{
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0134Action.class);
		//bl取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//实例化dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//form取得
		IGPRD0134Form form = (IGPRD0134Form) actionForm;
		dto.setPdid(form.getPdid());
		String forward = "DISP";
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========参与者支持机构选择页面初始化操作开始============");
			//form设定
			dto.setIgprd0134Form(form);
			//查询参与者信息
			dto = ctlBL.getProcessParticipantsByOrg(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//实例化vo
			IGPRD01341VO vo = new IGPRD01341VO();
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setProcessParticipantDefList(dto.getProcessParticipantDefList());
			vo.setOrgList(dto.getLst_orgdef());
			super.<IGPRD01341VO>setVO(request, vo);
			//如果是并行节点
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				forward = "DISP2";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory())&&"1".equals(form.getViewhistory())){
				forward += "HISTORY";
			}
			log.debug("===========参与者支持机构选择页面初始化操作结束============");
		}
		
		//参与人配置操作
		if("INSERT".equals(mapping.getParameter())){
			log.debug("===========参与人配置开始============");
			if(isTokenValid(request,true)){
				//页面信息设定
				dto.setIgprd0134Form(form);
				//删除参与人
				if("0".equals(form.getMode())){
					ctlBL.removeProcessParticipantsByOrg(dto);
				}else{//添加参与人
					ctlBL.addProcessParticipantsByOrg(dto);
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========参与人配置结束============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
