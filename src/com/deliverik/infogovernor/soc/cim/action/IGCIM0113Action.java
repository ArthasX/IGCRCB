package com.deliverik.infogovernor.soc.cim.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01041VO;

/**
 * 设备配置信息详细画面Action处理
 *
 */
public class IGCIM0113Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0113Action.class);

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
		IGCIM0104Form form = (IGCIM0104Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//设备配置信息登记画面初期显示处理
			log.debug("========设备配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0104");
			
			//DTO输入参数设定
			dto.setIgasm0304Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//设备配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGCIM0104Action(dto);
			
			//将设备配置信息检索结果设定到VO中
			IGCIM01041VO vo = new IGCIM01041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGCIM01041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","设备配置信息"));
			log.debug("========设备配置信息登记画面初期显示处理终了========");
			saveToken(req);
			forward = "DISP";
			IGCIM0104Form finalform = new IGCIM0104Form();
			BeanUtils.copyProperties(finalform, form);
			req.getSession().setAttribute("ADfinalform", finalform);
			req.setAttribute("eiidValue", form.getEiid());
		} else if( "DISP_NOTOKEN".equals(mapping.getParameter())){
			//设备配置信息登记画面初期显示处理
			log.debug("========设备配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0104");

			//DTO输入参数设定
			dto.setIgasm0304Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//设备配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGCIM0104Action(dto);
			
			//将设备配置信息检索结果设定到VO中
			IGCIM01041VO vo = new IGCIM01041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGCIM01041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			req.setAttribute("eiidValue", form.getEiid());
			if(req.getSession().getAttribute("ADfinalform")!=null){
				BeanUtils.copyProperties(form, (IGCIM0104Form)req.getSession().getAttribute("ADfinalform"));
				req.getSession().removeAttribute("ADfinalform");
			}
			
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","设备配置信息"));
			log.debug("========设备配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//设备配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//设备配置信息编辑画面按下返回按钮时的返回处理
				if(req.getParameter("route")!=null){
					return mapping.findForward("BACK3");
				}
				if (form.getRoute().equals("0")){
					//返回设备查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回设备登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========设备配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgasm0304Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			req.setAttribute("eiidValue", form.getEiid());
			log.debug("========设备配置信息编辑处理终了========");
			forward = "DISP";
		}else if("XMLDISP".equals(mapping.getParameter())){
			log.debug("========保存配置信息XML页面初始化处理开始========");		
			saveToken(req);
			log.debug("========保存配置信息XML页面初始化处理终了========");
			return mapping.findForward("DISP");
		}else if("SAVEFIRST".equals(mapping.getParameter())){
			log.debug("========保存配置信息XML处理开始========");		
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

			if (isTokenValid(req, true)){
				ctlBL.insertIntoDBFromXMLFirst(form,user);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			addMessage(req, new ActionMessage("IGCIM0122.I001"));
			log.debug("========保存配置信息XML处理终了========");
			return mapping.findForward("DISP");
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
