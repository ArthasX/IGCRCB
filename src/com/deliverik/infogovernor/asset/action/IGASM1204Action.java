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
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1204Form;
import com.deliverik.infogovernor.asset.vo.IGASM12041VO;

/**
 * 机柜配置信息详细画面Action处理
 *
 */
public class IGASM1204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1204Action.class);

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
		IGASM1204Form form = (IGASM1204Form)actionForm;
		
		//BL取得
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO生成
		IGASM12DTO dto = new IGASM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机柜配置信息登记画面初期显示处理
			log.debug("========机柜配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1204");

			//DTO输入参数设定
			dto.setIgasm1204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//机柜配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM1204Action(dto);
			
			//将机柜配置信息检索结果设定到VO中
			IGASM12041VO vo = new IGASM12041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoList());
			
			super.<IGASM12041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","机柜配置信息"));
			log.debug("========机柜配置信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//机柜配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//机柜配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回机柜查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回机柜登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========机柜配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm1204Form(form);
			
			//类型配置信息编辑逻辑调用
			dto = ctlBL.editEntityItemAction(dto);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}

			log.debug("========机柜配置信息编辑处理终了========");
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("null");
	}
}
