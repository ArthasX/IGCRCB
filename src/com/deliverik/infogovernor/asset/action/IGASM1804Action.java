package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1804Form;
import com.deliverik.infogovernor.asset.vo.IGASM18041VO;

/**
 * 系统配置信息详细画面Action处理
 *
 */
public class IGASM1804Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1804Action.class);

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
		IGASM1804Form form = (IGASM1804Form)actionForm;
		
		//BL取得
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO生成
		IGASM18DTO dto = new IGASM18DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//系统配置信息登记画面初期显示处理
			log.debug("========系统配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1804");

			//DTO输入参数设定
			dto.setIgasm1804Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//系统配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM1804Action(dto);
			
			//将系统配置信息检索结果设定到VO中
			IGASM18041VO vo = new IGASM18041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM18041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","系统属性信息"));
			saveToken(req);
			log.debug("========系统配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		}  if( "EDIT".equals(mapping.getParameter())){
			//系统配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//系统配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回系统查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回系统登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========系统配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm1804Form(form);
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========系统配置信息编辑处理终了========");
			forward = "DISP";
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward(forward);
	}
}
