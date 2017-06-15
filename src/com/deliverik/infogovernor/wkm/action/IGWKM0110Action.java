/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wkm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0110Form;
import com.deliverik.infogovernor.wkm.vo.IGWKM01101VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程通用查询action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGWKM0110Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGWKM0110Action.class);
		//BL取得
		IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
		//实例化dto
		IGWKM01DTO dto = new IGWKM01DTO();
		//form取得
		IGWKM0110Form form = (IGWKM0110Form) actionForm;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========流程查询操作开始===========");
			log.debug("==========流程查询操作结束===========");
		}
		//流程查询操作
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){

			//获取分页Bean
			getPaginDTO(request,"IGWKM0110");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGWKM0110Form) request.getSession().getAttribute("IGWKM0110Form");
				if ( form == null ) {
					form = new IGWKM0110Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGWKM0110Form) request.getSession().getAttribute("IGWKM0110Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGWKM0110");
			//排序标识取得
			String orderVal = request.getParameter("orderVal");		
			//翻页时保存排序标识
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}

			//设定排序方式
			if(StringUtils.isNotEmpty(form.getOrder())){
				if(StringUtils.isNotEmpty(orderVal)){
					if(orderVal.equals(form.getOrder())){
						if("DESC".equals(form.getSing())){
							form.setSing("ASC");
						}else{
							form.setSing("DESC");
						}
					}else{
						form.setSing("ASC");
					}
				}
			}else {//排序标识为空时默认按时间排序
				form.setOrder("propentime");
				form.setSing("DESC");
			}
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgwkm0110Form(form);
			//调用BL查询
			dto = ctlBL.searchProcessRecordAction(dto);
			IGWKM01101VO vo = new IGWKM01101VO();
			vo.setProcessList(dto.getProcessList());
			super.<IGWKM01101VO>setVO(request, vo);
		
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
