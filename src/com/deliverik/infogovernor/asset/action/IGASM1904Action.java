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
import com.deliverik.infogovernor.asset.bl.IGASM19BL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;
import com.deliverik.infogovernor.asset.form.IGASM1904Form;
import com.deliverik.infogovernor.asset.vo.IGASM19041VO;

/**
 * 人员配置信息详细画面Action处理
 *
 */
public class IGASM1904Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1904Action.class);

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
		IGASM1904Form form = (IGASM1904Form)actionForm;
		
		//BL取得
		IGASM19BL ctlBL = (IGASM19BL) getBean("igasm19BL");
		
		//DTO生成
		IGASM19DTO dto = new IGASM19DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//人员配置信息登记画面初期显示处理
			log.debug("========人员配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1904");

			//DTO输入参数设定
			dto.setIgasm1904Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//人员配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM1904Action(dto);
			
			//将人员配置信息检索结果设定到VO中
			IGASM19041VO vo = new IGASM19041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGASM19041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","人员配置信息"));
			saveToken(req);
			log.debug("========人员配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//人员配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//人员配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回人员查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回人员登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========人员配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm1904Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========人员配置信息编辑处理终了========");
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
