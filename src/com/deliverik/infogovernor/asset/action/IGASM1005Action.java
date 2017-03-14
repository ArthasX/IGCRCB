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
import com.deliverik.infogovernor.asset.form.IGASM1005Form;
import com.deliverik.infogovernor.asset.vo.IGASM10051VO;

/**
 * 配置项配置信息历史记录画面Action处理
 *
 */
public class IGASM1005Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1005Action.class);

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
		IGASM1005Form form = (IGASM1005Form)actionForm;
		
		//BL取得
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		//DTO生成
		IGASM10DTO dto = new IGASM10DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//配置项配置信息历史记录画面初期显示处理
			log.debug("========配置项配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1005");

			//DTO输入参数设定
			dto.setIgasm1005Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置项配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGASM1005Action(dto);
			
			//将配置项配置信息历史记录检索结果设定到VO中
			IGASM10051VO vo = new IGASM10051VO(dto.getSocEntityItemVWInfo(),
					dto.getConfigItemMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(true);
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getSocConfigItemVersionTime());
			
			super.<IGASM10051VO>setVO(req.getSession(), vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			
			log.debug("========配置项配置信息历史记录画面初期显示处理终了========");
			String operType=req.getParameter("operType");
			if("tongji".equals(operType)){
				return mapping.findForward("TONGJIDISP");
			}else
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//配置项配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
