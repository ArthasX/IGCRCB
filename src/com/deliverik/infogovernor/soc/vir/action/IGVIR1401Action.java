/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR14BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1401Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR14011VO;
import com.deliverik.infogovernor.xls.soc.vir.bl.IGVIR1401ExcelBL;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1401ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源申请统计Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1401Action.class);
		//BL取得
		IGVIR14BL ctlBL = (IGVIR14BL) getBean("igvir14BL");
		//实例化dto
		IGVIR14DTO dto = new IGVIR14DTO();
		//form取得
		IGVIR1401Form form = (IGVIR1401Form) actionForm;
		//dto参数设定
		dto.setIgvir1401Form(form);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============资源申请统计页面初始化操作开始================");
			log.debug("===============资源申请统计页面初始化操作结束================");
		}
		//统计数据查询
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=================资源申请统计统计数据查询操作开始================");
			dto = ctlBL.searchVMApplyStatisticsDataAction(dto);
			//实例化vo
			IGVIR14011VO vo = new IGVIR14011VO();
			vo.setVmApplyStatisticsDataMap(dto.getVmApplyStatisticsDataMap());
			super.<IGVIR14011VO>setVO(request, vo);
			log.debug("=================资源申请统计统计数据查询操作结束================");
		}
		//导出操作
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("==============资源申请统计导出操作开始================");
			dto = ctlBL.searchVMApplyStatisticsDataAction(dto);
			IGVIR1401ExcelDTO excelDto = new IGVIR1401ExcelDTO();
			excelDto.setVmApplyStatisticsDataMap(dto.getVmApplyStatisticsDataMap());
			excelDto.setResponse(response);
			excelDto.setFileid("VIR1401");
			IGVIR1401ExcelBL excelBL = (IGVIR1401ExcelBL) getBean("igvir1401ExcelBL");
			excelBL.initExcel(excelDto);
			log.debug("==============资源申请统计导出操作结束================");
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
