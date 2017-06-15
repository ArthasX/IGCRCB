package com.deliverik.infogovernor.asset.action;

import java.util.List;
import java.util.Set;

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
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0311Form;
import com.deliverik.infogovernor.asset.vo.IGASM03111VO;

/**
 * 设备下发画面Action处理
 * 
 */
public class IGASM0311Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0311Action.class);

	/**
	 * 设备报废
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGASM0311Form form = (IGASM0311Form) actionForm;
		// BL取得
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		// DTO生成
		IGASM03DTO dto = new IGASM03DTO();
		if (req.getParameter("eiid") != null) {
			form.setEiid(Integer.valueOf(req.getParameter("eiid")));
		}
		if (req.getParameter("eiversion") != null) {
			form.setEiversion(req.getParameter("eiversion"));
		}

		if ("DISP".equals(mapping.getParameter())) {
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIgasm0311Form(form);
			dto = ctlBL.searchPreScrapEntityItemAction(dto);
			IGASM03111VO vo = new IGASM03111VO(dto.getEntityItemVWInfo(), dto.getFlag());
			super.<IGASM03111VO> setVO(req, vo);
		} else if ("INSERT".equals(mapping.getParameter())) {
			User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setIgasm0311Form(form);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			ctlBL.entityPreScrapAction(dto);
			req.getSession().removeAttribute("ADSelectEntity");
			req.getSession().removeAttribute("ADSelectedEntity");
			log.debug("========设备查询画面初期显示处理终了========");
		} else if ("BATCHDISP".equals(mapping.getParameter())) {
			User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setIgasm0311Form(form);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());			
			log.debug("========设备查询画面初期显示处理终了========");
		} else if("INSERT_BATCH".equals(mapping.getParameter())){
			User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setIgasm0311Form(form);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
			if(set != null && set.size() > 0) {
				//DTO输入参数设定
				dto.setBatchEntityItem(set.toArray(new String[0]));
			} else {
				dto.setBatchEntityItem(new String[]{});
			}
			ctlBL.entityPreScrapBatchAction(dto);
			req.getSession().removeAttribute("ADSelectEntity");
			req.getSession().removeAttribute("ADSelectedEntity");
			log.debug("========设备查询画面初期显示处理终了========");
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
