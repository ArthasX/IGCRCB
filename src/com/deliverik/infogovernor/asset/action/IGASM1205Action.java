package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1205Form;
import com.deliverik.infogovernor.asset.vo.IGASM12051VO;

/**
 * 机柜配置信息历史记录画面Action处理
 *
 */
public class IGASM1205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1205Action.class);

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
		IGASM1205Form form = (IGASM1205Form)actionForm;
		
		//BL取得
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO生成
		IGASM12DTO dto = new IGASM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机柜配置信息历史记录画面初期显示处理
			log.debug("========机柜配置信息历史记录画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1205");

			//DTO输入参数设定
			dto.setIgasm1205Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//机柜配置信息历史记录画面初期显示逻辑调用
			dto = ctlBL.initIGASM1205Action(dto);
			
			//将机柜配置信息历史记录检索结果设定到VO中
			IGASM12051VO vo = new IGASM12051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			
			super.<IGASM12051VO>setVO(req.getSession(), vo);
			
			log.debug("========机柜配置信息历史记录画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//机柜配置信息历史记录画面返回按钮按下时的返回处理
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
