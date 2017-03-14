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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0138Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0147Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01381VO;

/**
 * 配置信息历史记录画面Action处理
 *
 */
public class IGCIM0138Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0138Action.class);
	
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
		IGCIM0138Form form = (IGCIM0138Form)actionForm;
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//配置信息历史记录画面初期显示处理
			log.debug("========配置信息历史记录画面初期显示处理开始========");
			IGCIM0147Form cim0147Fom=new IGCIM0147Form();
			cim0147Fom.setEiid(form.getEiid());
			cim0147Fom.setCiversion(form.getCiversion());
			cim0147Fom.setCismallversion(form.getCismallversion());
			//DTO输入参数设定
			dto.setIgcim0147Form(cim0147Fom);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGCIM0147Action(dto);
			
			
			//将配置信息历史记录检索结果设定到VO中
			IGCIM01381VO vo = new IGCIM01381VO(dto.getSoc0124Info(),
					dto.getSoc0107InfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCIM01381VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if ("BACK".equals(mapping.getParameter())) {
			//配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}

}
