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
import com.deliverik.infogovernor.asset.form.IGASM0313Form;
import com.deliverik.infogovernor.asset.vo.IGASM03131VO;

/**
 * 设备上缴画面Action处理
 *
 */
public class IGASM0313Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0313Action.class);

	/**
	 * 设备上缴
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM0313Form form = (IGASM0313Form)actionForm;
		
		//BL取得
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO生成
		IGASM03DTO dto = new IGASM03DTO();
		if (!"PAY".equals(mapping.getParameter())) {
			if(req.getParameter("eiid")!=null){
				form.setEiid(Integer.valueOf(req.getParameter("eiid")));
			}
			if(req.getParameter("eiiorgid")!=null){
				form.setEiiorgid(req.getParameter("eiiorgid"));
				dto.setOrgid(req.getParameter("eiiorgid"));
			}
			if(req.getParameter("eiversion")!=null){
				form.setEiversion(String.valueOf(req.getParameter("eiversion")));
				dto.setEiversion(String.valueOf(req.getParameter("eiversion")));
			}
		}
		if( "DISP".equals(mapping.getParameter())){
			dto.setIgasm0313Form(form);
			if("S".equals(req.getParameter("type"))){
				ctlBL.searchEntityPayByEiidAction(dto);
				
				//将待上缴设备信息设定到VO中
				IGASM03131VO vo = new IGASM03131VO();
				vo.setOrgname(dto.getOrgname());
				vo.setRecivename(dto.getRecivename());
				super.<IGASM03131VO>setVO(req, vo);
			}
			saveToken(req);
		} else if( "INSERT".equals(mapping.getParameter())){
			log.debug("========设备上缴处理开始========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setIgasm0313Form(form);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			if(isTokenValid(req,true)){
				ctlBL.entityPayAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			req.getSession().removeAttribute("ADSelectEntity");
			req.getSession().removeAttribute("ADSelectedEntity");
			log.debug("========设备上缴处理终了========");
		} else if ("PAY".equals(mapping.getParameter())){
			
				log.debug("========设备批量上缴处理开始========");
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setIgasm0313Form(form);
				dto.setUserid(user.getUserid());
				dto.setUsername(user.getUsername());
				if(isTokenValid(req,true)){
					//资产ID集合
					Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
					if(set != null && set.size() > 0) {
						//DTO输入参数设定
						dto.setBatchEntityItem(set.toArray(new String[0]));
					} else {
						dto.setBatchEntityItem(new String[]{});
					}
					ctlBL.entityBatchPayAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				req.getSession().removeAttribute("ADSelectEntity");
				req.getSession().removeAttribute("ADSelectedEntity");
				log.debug("========设备批量上缴处理终了========");
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
