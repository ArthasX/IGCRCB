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
import com.deliverik.infogovernor.soc.vir.form.IGVIR1402Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR14021VO;
import com.deliverik.infogovernor.xls.soc.vir.bl.IGVIR1402ExcelBL;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1402ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源使用情况统计Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1402Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1402Action.class);
		//BL取得
		IGVIR14BL ctlBL = (IGVIR14BL) getBean("igvir14BL");
		//实例化dto
		IGVIR14DTO dto = new IGVIR14DTO();
		//form取得
		IGVIR1402Form form = (IGVIR1402Form) actionForm;
		//dto参数设定
		dto.setVcid(form.getVcid());
		dto.setHostname(form.getHostname());
		//查询连接信息
		dto = ctlBL.searchVCenterConnectionAction(dto);
		request.setAttribute("AD_vcnames", dto.getLabelValueBeanList());
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("============资源使用情况统计页面初始化操作开始===========");
			log.debug("============资源使用情况统计页面初始化操作结束===========");
		}
		//统计操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============资源使用情况统计数据查询操作开始=============");
			dto = ctlBL.searchHostInfosAction(dto);
			//实例化vo
			IGVIR14021VO vo = new IGVIR14021VO();
			vo.setHostMap(dto.getHostMap());
			super.setVO(request, vo);
			log.debug("=============资源使用情况统计数据查询操作结束=============");
		}
		//导出操作
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("============资源使用情况导出操作开始============");
			dto = ctlBL.searchHostInfosAction(dto);
			IGVIR1402ExcelDTO excelDto = new IGVIR1402ExcelDTO();
			excelDto.setHostMap(dto.getHostMap());
			excelDto.setResponse(response);
			excelDto.setFileid("VIR1402");
			IGVIR1402ExcelBL excelBL = (IGVIR1402ExcelBL) getBean("igvir1402ExcelBL");
			excelBL.initExcel(excelDto);
			log.debug("============资源使用情况导出操作结束============");
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
