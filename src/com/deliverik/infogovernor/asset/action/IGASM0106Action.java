package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0106Form;
import com.deliverik.infogovernor.asset.vo.IGASM01021VO;
import com.deliverik.infogovernor.asset.vo.IGASM01061VO;

/**
 * 类型详细信息画面Action处理
 *
 */
public class IGASM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0106Action.class);

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
		IGASM0106Form form = (IGASM0106Form)actionForm;
		
		//BL取得
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO生成
		IGASM01DTO dto = new IGASM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//类型配置信息查询画面初期显示处理
			log.debug("========类型配置信息查询画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0106");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setConfigurationSearchCond(form);
			
			//类型配置信息查询画面初期显示处理逻辑调用
			dto = ctlBL.initIGASM0106Action(dto);
			
			//将类型配置信息检索结果设定到VO中
			IGASM01061VO vo = new IGASM01061VO(dto.getConfigurationMap());
			
			super.<IGASM01061VO>setVO(req, vo);

			IGASM01021VO vo1 = new IGASM01021VO(dto.getEntity());
			
			super.<IGASM01021VO>setVO(req.getSession(),vo1);
			
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
