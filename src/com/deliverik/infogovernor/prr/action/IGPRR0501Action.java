/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR05BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0501Form;
import com.deliverik.infogovernor.prr.vo.IGPRR05011VO;

/**
 * 概述: 流程组查询Action
 * 功能描述: 流程组查询Action
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
public class IGPRR0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0501Action.class);
	
	/**
	 * 流程组查询处理
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRR0501Form form = (IGPRR0501Form)actionForm;
		//获取BL接口实例
		IGPRR05BL ctlBL = (IGPRR05BL) getBean("igPRR05BL");
		IGPRR05DTO dto = new IGPRR05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========流程组查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========流程组查询画面初期显示处理终了========");
		}
		
		//工作查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========流程组查询处理开始========");
			
			//获取分页Bean
			getPaginDTO(request,"IGPRR0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRR0501Form) request.getSession().getAttribute("IGPRR0501Form");
				if ( form == null ) {
					form = new IGPRR0501Form();
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
						form = (IGPRR0501Form) request.getSession().getAttribute("IGPRR0501Form");
						if (form !=null) {
							form.setFromCount(0);
						}
					  }
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGPRR0501");
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
			}
			
			dto.setIg483SearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchGroupAction(dto);
			//构造VO
			IGPRR05011VO vo = new IGPRR05011VO();
			vo.setLst_IG483Info(dto.getLst_IG483Info());
			super.<IGPRR05011VO>setVO(request, vo);
			log.debug("========流程组查询处理终了========");
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
