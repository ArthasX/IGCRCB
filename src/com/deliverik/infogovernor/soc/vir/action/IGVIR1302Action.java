/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR13BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1302Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机配置修改Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1302Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1302Action.class);
		//BL取得
		IGVIR13BL ctlBL = (IGVIR13BL) getBean("igvir13BL");
		//实例化dto
		IGVIR13DTO dto = new IGVIR13DTO();
		//form取得
		IGVIR1302Form form = (IGVIR1302Form) actionForm;
		//dto参数设定
		dto.setIgvir1302Form(form);
		//页面初始化
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============虚机信息编辑页面初始化操作开始==============");
			dto = ctlBL.initVmInfoAction(dto);
			saveToken(request);
			log.debug("==============虚机信息编辑页面初始化操作结束==============");
		}
		//编辑操作
		if("EDIT".equals(mapping.getParameter())){
			log.debug("===========虚机信息编辑操作开始=============");
			if(isTokenValid(request, true)){
				dto = ctlBL.editVmInfoAction(dto);
				dto.addMessage(new ActionMessage("IGVIR1302.I001"));
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========虚机信息编辑操作结束=============");
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
