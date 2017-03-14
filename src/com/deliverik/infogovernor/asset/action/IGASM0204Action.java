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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.vo.IGASM02041VO;

/**
 * 配置项配置信息详细画面Action处理
 *
 */
public class IGASM0204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0204Action.class);

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
		IGASM0204Form form = (IGASM0204Form)actionForm;
		
		//BL取得
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO生成
		IGASM02DTO dto = new IGASM02DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//配置项配置信息登记画面初期显示处理
			log.debug("========配置项配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0204");

			//DTO输入参数设定
			dto.setIgasm0204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置项配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM0204Action(dto);
			
			//将配置项配置信息检索结果设定到VO中
			IGASM02041VO vo = new IGASM02041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGASM02041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","配置项配置信息"));
			log.debug("========配置项配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//配置项配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//配置项配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回配置项查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回配置项登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========配置项配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm0204Form(form);
			
			//类型配置信息编辑逻辑调用
			dto = ctlBL.editEntityItemAction(dto);
			

			log.debug("========配置项配置信息编辑处理终了========");
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
