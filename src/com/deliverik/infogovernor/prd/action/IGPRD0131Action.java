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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0131Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01311VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 机构范围选择action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0131Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0131Action.class);
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//实例化dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//form取得
		IGPRD0131Form form = (IGPRD0131Form) actionForm;
		dto.setPdid(form.getPdid());
		String forward = "DISP";
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============流程机构范围选择页面初始化操作开始==============");
			//页面信息设定
			dto.setIgprd0131Form(form);
			//调用BL查询
			dto = ctlBL.getProcessOrgDefAction(dto);
			//查询流程是否被占用
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//实例化vo
			IGPRD01311VO vo = new IGPRD01311VO();
			vo.setOrgTreeMap(dto.getOrgTreeMap());
			vo.setPordList(dto.getPordList());
			super.<IGPRD01311VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory())&&"1".equals(form.getViewhistory())){
				forward = "VIEWHISTORY";
			}
			log.debug("=============流程机构范围选择页面初始化操作结束==============");
		}
		//操作
		if("INSERT".equals(mapping.getParameter())){
			if(isTokenValid(request,true)){
				//页面信息设定
				dto.setIgprd0131Form(form);
				//删除操作
				if("0".equals(form.getModel())){
					dto = ctlBL.removeProcessOrg(dto);
				//新增操作
				}else{
					dto = ctlBL.addProcessOrg(dto);
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
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
