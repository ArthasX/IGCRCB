package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0705Form;
import com.deliverik.infogovernor.asset.vo.IGASM07051VO;

/**
 * 机房配置信息历史记录画面Action处理
 *
 */
public class IGASM0705Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0705Action.class);

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
		IGASM0705Form form = (IGASM0705Form)actionForm;
		
		//BL取得
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO生成
		IGASM07DTO dto = new IGASM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机房配置信息历史记录画面初期显示处理
			log.debug("========机房配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0705");

			//DTO输入参数设定
			dto.setIgasm0705Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//机房配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGASM0705Action(dto);
			
			//将机房配置信息历史记录检索结果设定到VO中
			IGASM07051VO vo = new IGASM07051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			
			super.<IGASM07051VO>setVO(req.getSession(), vo);
			
			log.debug("========机房配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//机房配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
