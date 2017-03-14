/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;


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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0408Form;

/**
 * 资产下拉数据选择画面Action处理
 *
 */

public class IGCIM0408Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0408Action.class);
	
	/**
	 * <p>
	 * Description:选择数据ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0408Form form = (IGCIM0408Form)actionForm;
		//获取BL接口实例
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		//实例化DTO
		IGCIM04DTO dto = new IGCIM04DTO();
		if( "DISP".equals(mapping.getParameter())){
			//资产下拉数据登记显示处理
			log.debug("========资产下拉数据登记处理显示开始========");
			req.setAttribute("IGCIM0408Form", new IGCIM0408Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","取值范围登记基本信息"));
			log.debug("========资产下拉数据登记处理显示终了========");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========资产下拉数据登记处理开始========");
			dto.setConfigurationcodedetail(form);
			dto.setIgcim0408Form(form);
			dto =ctlBL.insertConfigurationCodeDetailAction(dto);
			
			log.debug("========类型基本信息变更初期显示处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}

}
