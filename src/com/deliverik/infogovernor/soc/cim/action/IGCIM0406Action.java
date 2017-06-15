package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0406Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04021VO;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04061VO;

/**
 * 类型详细信息画面Action处理
 *
 */
public class IGCIM0406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0406Action.class);

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
		IGCIM0406Form form = (IGCIM0406Form)actionForm;
		
		//BL取得
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO生成
		IGCIM04DTO dto = new IGCIM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//类型配置信息查询画面初期显示处理
			log.debug("========类型配置信息查询画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0406");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//类型配置信息查询画面初期显示处理逻辑调用
			dto = ctlBL.initIGCIM0406Action(dto);
			
			//将类型配置信息检索结果设定到VO中
			IGCIM04061VO vo = new IGCIM04061VO(dto.getConfigurationMap());
			
			super.<IGCIM04061VO>setVO(req, vo);

			IGCIM04021VO vo1 = new IGCIM04021VO(dto.getEntity());
			vo1.setStartFlag(dto.getStartFlag());
			vo1.setStopFlag(dto.getStopFlag());
			
			super.<IGCIM04021VO>setVO(req.getSession(),vo1);
			
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
		
		//修改模型属性状态 1启用 2停用
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========资产模型属性状态变化处理开始========");

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
			
			log.debug("========资产模型属性状态变化处理终了========");
		}
		if("CHANGE_ENTITY_STATUS".equals(mapping.getParameter())){

			log.debug("========资产模型状态变化处理开始========");
			if(req.getParameter("eid")!=null){
				dto.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				dto.setEstatus(req.getParameter("estatus"));
			}
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========资产模型状态变化处理终了========");
		
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
