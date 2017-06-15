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
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0704Form;
import com.deliverik.infogovernor.asset.vo.IGASM07041VO;

/**
 * 机房配置信息详细画面Action处理
 *
 */
public class IGASM0704Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0704Action.class);

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
		IGASM0704Form form = (IGASM0704Form)actionForm;
		
		//BL取得
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO生成
		IGASM07DTO dto = new IGASM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机房配置信息登记画面初期显示处理
			log.debug("========机房配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0704");

			//DTO输入参数设定
			dto.setIgasm0704Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//机房配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM0704Action(dto);
			
			//将机房配置信息检索结果设定到VO中
			IGASM07041VO vo = new IGASM07041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoList());
			
			super.<IGASM07041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","机房配置信息"));
			log.debug("========机房配置信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//机房配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//机房配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回机房查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回机房登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========机房配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm0704Form(form);
			
			//类型配置信息编辑逻辑调用
			dto = ctlBL.editEntityItemAction(dto);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}

			log.debug("========机房配置信息编辑处理终了========");
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("null");
	}
}
