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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM10BL;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;
import com.deliverik.infogovernor.asset.form.IGASM1004Form;
import com.deliverik.infogovernor.asset.vo.IGASM10041VO;

/**
 * 配置项配置信息详细画面Action处理
 *
 */
public class IGASM1004Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1004Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1004Form form = (IGASM1004Form)actionForm;
		
		//BL取得
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		
		//DTO生成
		IGASM10DTO dto = new IGASM10DTO();
		String operType=req.getParameter("operType");
		if( "DISP".equals(mapping.getParameter())){
			//配置项配置信息登记画面初期显示处理
			log.debug("========配置项配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1004");

			//DTO输入参数设定
			dto.setIgasm1004Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置项配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM1004Action(dto);
			
			//将配置项配置信息检索结果设定到VO中
			IGASM10041VO vo = new IGASM10041VO();
			
			vo.setSocConfigItemVWInfoMap(dto.getSocConfigItemVWInfoMap());
			vo.setSocEntityItemVWInfo(dto.getSocEntityItemVWInfo());
			super.<IGASM10041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","配置项配置信息"));
			log.debug("========配置项配置信息登记画面初期显示处理终了========");
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			if(operType!=null){
				if(operType.equals("wb")){
					return mapping.findForward("WBDISP");
				}
			}
			return mapping.findForward("DISP");
		} 

		if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
			//配置项配置信息编辑画面按下返回按钮时的返回处理
			//返回配置项查询画面
			return mapping.findForward("BACK1");
		}

		return mapping.findForward("null");
	}
}
