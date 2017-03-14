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
import com.deliverik.infogovernor.prd.form.IGPRD0173Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01731VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程表格类表单预览Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0173Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0173Action.class);
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//实例化dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//form取得
		IGPRD0173Form form = (IGPRD0173Form) actionForm;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========自定义流程表格类表单预览操作开始===========");
			//dto参数设定
			dto.setIgprd0173Form(form);
			//调用BL查询相关数据
			dto = ctlBL.searchColumnInfoAction(dto);
			//实例化vo
			IGPRD01731VO vo = new IGPRD01731VO();
			vo.setPidInfo(dto.getPidInfo());
			super.<IGPRD01731VO>setVO(request, vo);
			request.getSession().setAttribute("AD_columnInfoMap", dto.getColumnInfoMap());
			log.debug("===========自定义流程表格类表单预览操作结束===========");
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
