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
import com.deliverik.infogovernor.drm.form.IGDRM0416Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04121VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04161VO;

/**
 * 类型详细信息画面Action处理
 *
 */
public class IGDRM0416Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0416Action.class);

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
		IGDRM0416Form form = (IGDRM0416Form)actionForm;
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//类型配置信息查询画面初期显示处理
			log.debug("========类型配置信息查询画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0416");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//类型配置信息查询画面初期显示处理逻辑调用
			dto = ctlBL.initIGDRM0416Action(dto);
			
			//将类型配置信息检索结果设定到VO中
			IGDRM04161VO vo = new IGDRM04161VO(dto.getConfigurationMap());
			
			super.<IGDRM04161VO>setVO(req, vo);

			IGDRM04121VO vo1 = new IGDRM04121VO(dto.getEntity());
			
			super.<IGDRM04121VO>setVO(req.getSession(),vo1);
			
			log.debug("========类型配置信息查询画面初期显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//类型配置删除处理
			log.debug("========类型配置删除处理开始========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//返回处理
				return mapping.findForward("BACK");
			}

			//DTO输入参数设定
			dto.setDeleteConfiguration(form.getDeleteCid());
			
			//类型配置删除处理逻辑调用
			ctlBL.deleteConfigurationAction(dto);
			
			log.debug("========类型配置删除处理终了========");
		}
		
		//修改分类属性状态 1启用 2停用
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========资产分类属性状态变化处理开始========");

			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("cid")!=null){
				dto.setCid(req.getParameter("cid"));
			}
			if(req.getParameter("cstatus")!=null){
				dto.setCstatus(req.getParameter("cstatus"));
			}

			ctlBL.changeConfigStatus(dto);
			
			log.debug("========资产分类属性状态变化处理终了========");
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
