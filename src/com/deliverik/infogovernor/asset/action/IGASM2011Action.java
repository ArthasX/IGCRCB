/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2011Form;
import com.deliverik.infogovernor.asset.vo.IGASM20111VO;

/**
 * 概述: 导入对象版本查询画面Action处理
 * 功能描述: 导入对象版本查询画面Action处理
 * 创建记录: 2011/05/05
 * 修改记录: 
 */
public class IGASM2011Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2003Action.class);
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM2011Form form = (IGASM2011Form)actionForm;
		
		//BL取得
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			//导入对象历史版本查询处理
			log.debug("========导入对象历史版本查询开始========");
			
			//DTO输入参数设定
			dto.setImpeiname(form.getImpeiname());
			
			dto.setImpversion(form.getImpversion());
			
			//导入对象历史版本查询逻辑调用
			dto=ctlBL.searchImportVersionIGASM2010Action(dto);
			
			//将应用配置信息历史记录检索结果设定到VO中
			IGASM20111VO vo = new IGASM20111VO(dto.getImportVersionInfoList(),dto.getImportVersionInfo());
			
			super.<IGASM20111VO>setVO(req.getSession(), vo);
			log.debug("========导入对象历史版本查询处理终了========");
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
