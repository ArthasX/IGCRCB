/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0515Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05151VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_单一物品库存统计管理_统计查询ACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0515Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0515Action.class);
	
	/**
	 * <p>
	 * Description:物品库存月汇总统计查询ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author wuzhenqiu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGLOM0515Form form = (IGLOM0515Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========单一物品库存统计查询画面初期显示处理开始========");
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========单一物品库存总统计查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//实例化DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========单一物品库存月汇总统计查询处理开始========");
			getPaginDTO(request,"IGLOM0515");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			dto.setSingleGoodsStockSearchCond(form);
			dto.setIglom0515Form(form);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchSingleGoodsStockAction(dto);
			
			//构造VO
			IGLOM05151VO vo = new IGLOM05151VO();
			vo.setSingleGoodsStockList(dto.getSingleGoodsStockList());
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			super.<IGLOM05151VO>setVO(request, vo);
			
			log.debug("========单一物品库存月汇总统计查询处理终了========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========单一物品库存月汇总统计查询处理开始========");
			form.setEdate("report");
			dto.setSingleGoodsStockSearchCond(form);
			dto.setIglom0515Form(form);
			//调用BL查询
			dto = ctlBL.searchSingleGoodsStockAction(dto);
			
			//构造VO
			IGLOM05151VO vo = new IGLOM05151VO();
			vo.setSingleGoodsStockList(dto.getSingleGoodsStockList());
			super.<IGLOM05151VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05151VO", vo);
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			request.setAttribute("goods", form.getGoods());
			form.setEdate("");
			log.debug("========单一物品库存统计明细查询处理终了========");
			return mapping.findForward("REPORT");
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
