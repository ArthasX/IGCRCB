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
import com.deliverik.infogovernor.asset.bl.IGASM19BL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;
import com.deliverik.infogovernor.asset.form.IGASM1905Form;
import com.deliverik.infogovernor.asset.vo.IGASM19051VO;

/**
 * 人员配置信息历史记录画面Action处理
 *
 */
public class IGASM1905Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1905Action.class);

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
		IGASM1905Form form = (IGASM1905Form)actionForm;
		//BL取得
		IGASM19BL ctlBL = (IGASM19BL) getBean("igasm19BL");
		//DTO生成
		IGASM19DTO dto = new IGASM19DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//人员配置信息历史记录画面初期显示处理
			log.debug("========人员配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1905");

			//DTO输入参数设定
			dto.setIgasm1905Form(form);
			
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//人员配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGASM1905Action(dto);
			
			//将人员配置信息历史记录检索结果设定到VO中
			IGASM19051VO vo = new IGASM19051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGASM19051VO>setVO(req.getSession(), vo);
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========人员配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//人员配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
