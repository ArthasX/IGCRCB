/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02061VO;

/**
 * 概述: 错误日志查询画面Action处理
 * 功能描述: 错误日志查询画面Action处理
 * 创建记录: 2011/06/09
 * 修改记录: 
 */
public class IGMNT0206Action extends BaseAction{
	static Log log=LogFactory.getLog(IGMNT0206Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGMNT0206Form form = (IGMNT0206Form)actionForm;
		//获取BL接口实例
		IGMNT02BL ctlBL = (IGMNT02BL)getBean("igmnt02BL");
		//实例化DTO
		IGMNT02DTO dto=new IGMNT02DTO();
		//国际化设置
		dto.setLocale(this.getLocale(request));
		//错误日志页面初始化显示
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========错误日志查询画面初期显示处理开始========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			dto = ctlBL.getAlarmSeverity(dto);
			dto = ctlBL.getCiList(dto);
			request.getSession().setAttribute("alarmSeverityList", dto.getAlarmSeverityList());
			request.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			request.getSession().setAttribute("ciList", dto.getCiList());
			saveToken(request);
			log.debug("========错误日志查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		//错误日志查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========错误日志查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
			}
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGMNT0206");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
				if ( form== null){
					form = new IGMNT0206Form();
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
					form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGMNT0206");
			//检索条件设置
			dto.setSoc0305SearchCond(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			pDto.setPageDispCount(20);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchSOC0305Action(dto);
			//构造VO
			IGMNT02061VO vo = new IGMNT02061VO();
			vo.setSoc0307List(dto.getSoc0307List());
			super.<IGMNT02061VO>setVO(request, vo);
			log.debug("========错误日志查询处理终了========");
		}
		//处理状态变更
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========处理状态变更开始========");
			dto.setIds(form.getIds());
			ctlBL.updateSOC0305(dto);
			log.debug("========处理状态变更结束=======");
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
