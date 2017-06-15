package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1114Form;
import com.deliverik.infogovernor.asset.vo.IGASM11141VO;

/**
 * 机柜平面图画面Action处理
 *
 */
public class IGASM1114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1114Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1114Form form = (IGASM1114Form)actionForm;

		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机柜平面图画面初期显示处理
			log.debug("========机柜平面图画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm1114Form(form);
			
			//机柜检索逻辑调用
			dto = ctlBL.initIGASM1114Action(dto);
			
			//将机柜信息检索结果设定到VO中
			IGASM11141VO vo = new IGASM11141VO(dto.getComputerContainerVWInfo(),
					dto.getComputerDeviceVWInfoList());
			
			super.<IGASM11141VO>setVO(req, vo);
			
			log.debug("========机柜平面图画面初期显示处理终了========");
		} else if ("DISP_FX".equals(mapping.getParameter())){
			if("1".equals(form.getJitype())){
				req.setAttribute("jitype", "14");
			}else{
				req.setAttribute("jitype", form.getJitype());
			}
		}

		if( "MOVE".equals(mapping.getParameter())){
			//设备移除处理
			log.debug("========设备移除处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm1114Form(form);
			
			//设备移除逻辑调用
			dto = ctlBL.moveoutComputerDeviceAction(dto);
			
			log.debug("========设备移除处理终了========");
		}

		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
