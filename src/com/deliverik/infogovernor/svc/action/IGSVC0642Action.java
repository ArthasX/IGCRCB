/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0642Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06421VO;
import com.deliverik.infogovernor.xls.svc.bl.IGSVC0642ExcelBL;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC0642ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程数量统计Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0642Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGSVC0642Action.class);
		//BL取得
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//实例化dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//form取得
		IGSVC0642Form form = (IGSVC0642Form) actionForm;
		//dto参数设定
		dto.setIgsvc0642Form(form);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============流程数量统计页面初始化操作开始=============");
			log.debug("=============流程数量统计页面初始化操作结束=============");
		}
		//统计操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==============流程数量统计数据查询操作开始=============");
			dto = ctlBL.searchProcessRecordCountAction(dto);
			IGSVC06421VO vo = dto.getIgsvc06421VO();
			super.<IGSVC06421VO>setVO(request, vo);
			log.debug("==============流程数量统计数据查询操作结束=============");
		}
		//到处操作
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("============流程数量统计导出操作开始============");
			dto = ctlBL.searchProcessRecordCountAction(dto);
			IGSVC06421VO vo = dto.getIgsvc06421VO();
			IGSVC0642ExcelDTO excelDTO = new IGSVC0642ExcelDTO();
			this.copyProperties(excelDTO, vo);
			excelDTO.setResponse(response);
			excelDTO.setFileid("SVC0642");
			IGSVC0642ExcelBL excelBL = (IGSVC0642ExcelBL) getBean("igsvc0642ExcelBL");
			excelBL.initExcel(excelDTO);
			log.debug("============流程数量统计导出操作结束============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
