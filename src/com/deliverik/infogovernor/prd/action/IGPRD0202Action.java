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
import com.deliverik.infogovernor.prd.bl.IGPRD02BL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0202Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义简略显示Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0202Action.class);
		//BL取得
		IGPRD02BL ctlBL = (IGPRD02BL) getBean("igprd02BL");
		//实例化dto
		IGPRD02DTO dto = new IGPRD02DTO();
		//form取得
		IGPRD0202Form form = (IGPRD0202Form) actionForm;
		//dto参数设定
		dto.setPdid(form.getPdid());
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============流程简略显示操作开始===============");
			dto = ctlBL.initProccessDefinitionInfoAction(dto);
			
			//实例化vo
			IGPRD02021VO vo = new IGPRD02021VO();
			vo.setFlowChartHeight(dto.getFlowChartHeight());
			vo.setFlowChartXML(dto.getFlowChartXML());
			vo.setVoList(dto.getVoList());
			super.<IGPRD02021VO>setVO(request, vo);
			log.debug("===============流程简略显示操作结束===============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}