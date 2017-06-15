package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM05031Form;
import com.deliverik.infogovernor.drm.form.IGDRM0503Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05031VO;
import com.deliverik.infogovernor.drm.vo.IGDRM05032VO;

/**
 * 专项预案配置信息历史记录画面Action处理
 *
 */
public class IGDRM0503Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0503Action.class);

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

		//BL取得
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//专项预案配置信息历史记录画面初期显示处理
			log.debug("========专项预案配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0503");
			IGDRM0503Form form = (IGDRM0503Form)actionForm;

			//DTO输入参数设定
			dto.setIgdrm0503Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//专项预案配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGDRM0503Action(dto);
			
			//将专项预案配置信息历史记录检索结果设定到VO中
			IGDRM05031VO vo = new IGDRM05031VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.isFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			//历史信息导航显示,AssetsName=1代表专项预案2代表场景
			form.setAssetsName("1");
			super.<IGDRM05031VO>setVO(req.getSession(), vo);
			log.debug("========专项预案配置信息历史记录画面初期显示处理终了========");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//专项预案配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		if( "VERSION".equals(mapping.getParameter())){
			//配置信息历史记录画面初期显示处理
			log.debug("========配置信息历史记录画面初期显示处理开始========");
			IGDRM0503Form form = (IGDRM0503Form)actionForm;

			//DTO输入参数设定
			dto.setIgdrm0503Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.ClickVersionShow(dto);
			
			//将配置信息历史记录检索结果设定到VO中
			IGDRM05031VO vo = new IGDRM05031VO(dto.getEntityItemVWInfo(), dto.getConfigItemMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.isFlag());
			super.<IGDRM05031VO>setVO(req, vo);
			log.debug("========配置信息历史记录画面初期显示处理终了========");
		}
		if( "SEARCH".equals(mapping.getParameter())){
			//资产配置项信息版本比较画面初期显示处理
			log.debug("========资产配置项信息版本比较画面初期显示处理开始========");
			IGDRM05031Form form1 = (IGDRM05031Form)actionForm;
			//DTO输入参数设定
			dto.setIgdrm05031Form(form1);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//资产配置项信息版本比较画面初期显示逻辑调用
			dto = ctlBL.versionCompare(dto);
			
			//将资产配置项信息版本比较检索结果设定到VO中
			IGDRM05032VO vo = new IGDRM05032VO(dto.getEntityItemVW(), dto.getEntityItemConfigurations());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.isFlag());
			super.<IGDRM05032VO>setVO(req, vo);
			
			log.debug("========资产配置项信息版本比较画面初期显示处理终了========");
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
