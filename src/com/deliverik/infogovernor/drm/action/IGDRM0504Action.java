package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0504Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05041VO;

/**
 * 专项预案资产配置信息详细画面Action处理
 *
 */
public class IGDRM0504Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0504Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGDRM0504Form form = (IGDRM0504Form)actionForm;
		//BL取得
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		req.setAttribute("backPage", req.getParameter("backPage"));
		
		if( "DISP".equals(mapping.getParameter())){
			//专项预案资产配置信息登记画面初期显示处理
			log.debug("========专项预案资产配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0504");

			//DTO输入参数设定
			dto.setIgdrm0504Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//专项预案资产配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGDRM0504Action(dto);
			
			
			
			//将专项预案资产配置信息检索结果设定到VO中
			IGDRM05041VO vo = new IGDRM05041VO(dto.getEntityItemVW(),
					dto.getConfigItemVWInfoMap());
			//场景-关系资产map - List
			vo.setEntityItemList(dto.getEntityItemList());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.isFlag());
			vo.setEiorgname(dto.getEiorgname());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			
			super.<IGDRM05041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","专项预案资产属性信息"));
			saveToken(req);
			log.debug("========专项预案资产配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//专项预案资产配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//专项预案资产配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回专项预案资产查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回专项预案资产登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========专项预案资产配置信息编辑处理开始========");

			//DTO输入参数设定
			dto.setIgdrm0504Form(form);
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========专项预案资产配置信息编辑处理终了========");
			forward = "DISP";
		}else if("DETAIL".equals(mapping.getParameter())){
			dto.setPdid(req.getParameter("pdid"));
			dto = ctlBL.searchFlowDetail(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				out.print(dto.getOutPrintStr());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

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
