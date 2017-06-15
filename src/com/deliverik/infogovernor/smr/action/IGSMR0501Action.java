/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR05BL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.vo.IGSMR05011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 历史数据分组信息form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR0501Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGSMR0501Action.class);
		//BL取得
		IGSMR05BL ctlBL = (IGSMR05BL) getBean("igSMR05BL");
		//实例化dto
		IGSMR05DTO dto = new IGSMR05DTO();
		//form取得
		IGSMR0501Form form = (IGSMR0501Form) actionForm;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========分组信息取得页面初始化操作开始===========");
			dto.setIgsmr0501Form(form);
			dto = ctlBL.searchRegulatoryHistoryListAction(dto);
			IGSMR05011VO vo = new IGSMR05011VO();
			vo.setReportHistoryVWInfoList(dto.getReportHistoryVWInfoList());
			super.<IGSMR05011VO>setVO(request, vo);
			log.debug("===========分组信息取得页面初始化操作结束===========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		return mapping.findForward("DISP");
	}

}
