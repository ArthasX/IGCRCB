package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0602Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR06021VO;

/**
 * 虚拟化分析信息详细画面Action处理
 *
 */
public class IGVIR0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0602Action.class);

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
		IGVIR0602Form form = (IGVIR0602Form)actionForm;
		
		//BL取得
		IGVIR06BL ctlBL = (IGVIR06BL) getBean("igvir06BL");
		
		//DTO生成
		IGVIR06DTO dto = new IGVIR06DTO();
		dto.setLocale(this.getLocale(req));
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//虚拟化分析信息登记画面初期显示处理
			log.debug("========虚拟化分析信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0104");

			//DTO输入参数设定
			dto.setIgvir0602Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//虚拟化分析信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGVIR0602Action(dto);
			
			//将虚拟化分析信息检索结果设定到VO中
			IGVIR06021VO vo = new IGVIR06021VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//获取历史版本更新时间
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGVIR06021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","虚拟化分析信息"));
			saveToken(req);
			log.debug("========虚拟化分析信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//虚拟化分析信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//虚拟化分析信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回应用查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回应用登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========虚拟化分析信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgvir0602Form(form);
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemActionApp(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========虚拟化分析信息编辑处理终了========");
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
