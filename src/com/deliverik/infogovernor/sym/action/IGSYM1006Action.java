package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM10BL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1006Form;
import com.deliverik.infogovernor.sym.vo.IGSYM10061VO;

/**
 * 数据详细信息画面Action处理
 *
 */
public class IGSYM1006Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1006Action.class);

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
		IGSYM1006Form form = (IGSYM1006Form)actionForm;
		
		//BL取得
		IGSYM10BL ctlBL = (IGSYM10BL) getBean("igsym10BL");
		
		//DTO生成
		IGSYM10DTO dto = new IGSYM10DTO();

		if( "DISP".equals(mapping.getParameter())){
			//数据详细信息查询画面初期显示处理
			log.debug("========数据详细信息查询画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgsym1006Form(form);
			
			//数据详细信息画面初期显示处理逻辑调用
			dto = ctlBL.initIGSYM1006Action(dto);
			
			//将数据详细信息检索结果设定到VO中
			IGSYM10061VO vo = new IGSYM10061VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetailList());
			vo.setFlag(dto.getFlag());
			super.<IGSYM10061VO>setVO(req, vo);

			log.debug("========数据详细信息画面初期显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//数据详细删除处理
			log.debug("========数据详细删除处理开始========");
			//DTO输入参数设定
			dto.setIgsym1006Form(form);
			
			//数据配置删除处理逻辑调用
			ctlBL.deleteCodeDetailAction(dto);
			
			log.debug("========数据详细删除处理终了========");
		}
		
		if ("BACK".equals(mapping.getParameter())){
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//返回处理
				return mapping.findForward("BACK");
			}

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
