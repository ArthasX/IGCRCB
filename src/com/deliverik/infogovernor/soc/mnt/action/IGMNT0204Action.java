package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT03BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT03DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0204Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02041VO;

/**
 * 设备配置信息详细画面Action处理
 *
 */
public class IGMNT0204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMNT0204Action.class);

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
		IGMNT0204Form form = (IGMNT0204Form)actionForm;
		
		//BL取得
		IGMNT03BL ctlBL = (IGMNT03BL) getBean("igmnt03BL");
		
		//DTO生成
		IGMNT03DTO dto = new IGMNT03DTO();
		dto.setLocale(this.getLocale(req));
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//设备配置信息登记画面初期显示处理
			log.debug("========设备配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2504");
			
			//DTO输入参数设定
			dto.setIgmnt0204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//设备配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGMNT0204Action(dto);
			
			//将设备配置信息检索结果设定到VO中
			IGMNT02041VO vo = new IGMNT02041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGMNT02041VO>setVO(req.getSession(), vo);
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
			IGMNT0204Form finalform = new IGMNT0204Form();
			BeanUtils.copyProperties(finalform, form);
			req.getSession().setAttribute("ADfinalform", finalform);
			req.setAttribute("eiidValue", form.getEiid());
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
