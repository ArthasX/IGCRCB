/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

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
import com.deliverik.infogovernor.drm.bl.IGDRM11BL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1101Form;
import com.deliverik.infogovernor.drm.vo.IGDRM11011VO;


/**
 * 签到Action
 * @author zyl
 * 
 * 2015年3月13日10:03:37
 */
public class IGDRM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1101Action.class);

	/**
	 * 
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
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//初始化form
		IGDRM1101Form form = (IGDRM1101Form)actionForm;
		//BL取得
		IGDRM11BL ctlBL = (IGDRM11BL) getBean("igdrm11BL");
		
		//DTO生成
		IGDRM11DTO dto = new IGDRM11DTO();
		dto.setUser(user);
		dto.setIgdrm1101Form(form);
		//画面跳转设定
		String forward = "DISP";
		//签到初始化
		if( "DISP".equals(mapping.getParameter())){
			log.debug("===========签到初始化页面显示处理开始===========");
		    dto=ctlBL.initIGDRM1101Action(dto);
		    //构造VO
			IGDRM11011VO vo = new IGDRM11011VO();
			vo.setSigninMap(dto.getSigninMap());
			super.<IGDRM11011VO>setVO(req, vo);
			log.debug("===========签到初始化页面显示处理开始===========");
		    return mapping.findForward(forward);
		}
		//演练实施
		if( "SIGNIN".equals(mapping.getParameter())){
			log.debug("================签到操作处理开始================");
			dto=ctlBL.updateIGDRM1101Action(dto);
			//构造VO
			IGDRM11011VO vo = new IGDRM11011VO();
			vo.setSigninMap(dto.getSigninMap());
			super.<IGDRM11011VO>setVO(req, vo);
			ctlBL.pushSigninableMessage(dto);
			log.debug("================签到操作处理结束================");
			return mapping.findForward(forward);
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
