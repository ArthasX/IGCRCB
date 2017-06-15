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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2705Form;
import com.deliverik.infogovernor.asset.vo.IGASM27051VO;

/**
 * 风险点配置信息历史记录画面Action处理
 *
 */
public class IGASM2705Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2705Action.class);

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
		IGASM2705Form form = (IGASM2705Form)actionForm;
		
		//BL取得
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		//DTO生成
		IGASM27DTO dto = new IGASM27DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//风险点配置信息历史记录画面初期显示处理
			log.debug("========风险点配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2705");

			//DTO输入参数设定
			dto.setIgasm2705Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//风险点配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGASM2705Action(dto);
			
			//将风险点配置信息历史记录检索结果设定到VO中
			IGASM27051VO vo = new IGASM27051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM27051VO>setVO(req.getSession(), vo);
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========风险点配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//风险点配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
