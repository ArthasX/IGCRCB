package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;

/**
 * 应急资产配置信息详细画面Action处理
 *
 */
public class IGDRM0404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0404Action.class);

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
		IGDRM0404Form form = (IGDRM0404Form)actionForm;
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		req.setAttribute("backPage", req.getParameter("backPage"));
		
		if( "DISP".equals(mapping.getParameter())){
			//应急资产配置信息登记画面初期显示处理
			log.debug("========应急资产配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
//			int maxCnt = getMaxDataCount("IGASM0504");
//
//			//DTO输入参数设定
//			dto.setIgdrm0404Form(form);
//			
//			dto.setMaxSearchCount(maxCnt);
//			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
//			
//			dto.setUser(user);
//			
//			//应急资产配置信息登记画面初期显示逻辑调用
//			dto = ctlBL.initIGDRM0404Action(dto);
//			
//			//将应急资产配置信息检索结果设定到VO中
//			IGDRM04041VO vo = new IGDRM04041VO(dto.getEntityItemVW(),
//					dto.getConfigItemVWInfoMap());
//			//返回查看资产配置信息权限标识
//			vo.setFlag(dto.isFlag());
//			vo.setEiorgname(dto.getEiorgname());
//			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
//			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
//			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
//				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
//				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
//			}
//			super.<IGDRM04041VO>setVO(req.getSession(), vo);
//			
//			addMessage(req, new ActionMessage("IGCO10000.I001","应急资产属性信息"));
//			saveToken(req);
//			log.debug("========应急资产配置信息登记画面初期显示处理终了========");
//			forward = "DISP";
//		} else if( "EDIT".equals(mapping.getParameter())){
//			//应急资产配置信息编辑
//			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
//				//应急资产配置信息编辑画面按下返回按钮时的返回处理
//				if (form.getRoute().equals("0")){
//					//返回应急资产查询画面
//					return mapping.findForward("BACK1");
//				} else {
//					//返回应急资产登记画面
//					return mapping.findForward("BACK2");
//				}
//			}
//
//			log.debug("========应急资产配置信息编辑处理开始========");
//
//			//DTO输入参数设定
//			dto.setIgdrm0404Form(form);
//			if (isTokenValid(req, true)){
//				//类型配置信息编辑逻辑调用
//				dto = ctlBL.editEntityItemAction(dto);
//			}else{
//				addMessage(req, new ActionMessage("IGCO00000.E007"));
//				return mapping.findForward("/error1");
//			}

			log.debug("========应急资产配置信息编辑处理终了========");
			forward = "DISP";
		}else if("GETLABEL".equals(mapping.getParameter())){
			dto.setEsyscoding(req.getParameter("esyscoding"));
			ctlBL.getLabel(dto);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(dto.getEilabel());
			return null;
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
