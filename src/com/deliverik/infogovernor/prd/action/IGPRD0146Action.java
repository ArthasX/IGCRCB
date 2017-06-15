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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0146Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01461VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询定义显示列宽度定义Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0146Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0146Action.class);
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//实例化dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//form取得
		IGPRD0146Form form = (IGPRD0146Form) actionForm;
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============流程查询定义显示列宽度定义页面初始化操作开始==============");
			dto = ctlBL.initProcessQueryShowColumnAction(dto);
			//实例化vo
			IGPRD01461VO vo = new IGPRD01461VO();
			vo.setQueryShowColumnList(dto.getQueryShowColumnList());
			super.setVO(request, vo);
			// saveToken(request);
			log.debug("===============流程查询定义显示列宽度定义页面初始化操作结束==============");
		}
		//更改宽度操作
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===============流程查询定义显示列宽度定义操作开始================");
			dto = ctlBL.editProcessQueryShowColumnWidthAction(dto);
			log.debug("===============流程查询定义显示列宽度定义操作结束================");
			return new ActionForward("/IGPRD0146_Disp.do?pdid=" + form.getPdid(), true);
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