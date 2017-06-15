package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0328Form;
import com.deliverik.infogovernor.vo.IGCOM03281VO;

/**
 * 配置详细信息画面Action处理
 *
 */
public class IGCOM0328Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0328Action.class);

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
		IGCOM0328Form form = (IGCOM0328Form)actionForm;
		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		if( "DISP".equals(mapping.getParameter())){
			//配置详细信息画面初期显示处理
			log.debug("========配置详细信息画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCOM0303");

			//DTO输入参数设定
			dto.setIgcom0328Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//配置详细信息画面初期显示逻辑调用
			dto = ctlBL.initIGCOM0328Action(dto);
		
			//将设备配置信息检索结果设定到VO中
			IGCOM03281VO vo = new IGCOM03281VO(dto.getSoc0124Info(),
					dto.getSoc0129InfoVWMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCOM03281VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","资产配置信息"));
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			log.debug("========配置详细信息画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward(null);
	}
}
