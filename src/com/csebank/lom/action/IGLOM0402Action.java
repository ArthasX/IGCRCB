/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0402Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM04021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 发票工作管理Action
 * 
 */
public class IGLOM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0103Action.class);

	/**
	 * 处理
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
		IGLOM0402Form form = (IGLOM0402Form)actionForm;		
		//获取BL接口实例
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		//实例化DTO
		IGLOM04DTO dto = new IGLOM04DTO();
		String forward = "";
		//发票类型		
		req.setAttribute("invoice_itype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ITYPE));
		//付款状态
		req.setAttribute("invoice_istatus", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ISTATUS));
		//付款方式
		req.setAttribute("invoice_ipaymenttype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_IPAYMENTTYPE));
		
		if( "DISP_SEARCH".equals(mapping.getParameter())){
			
			//发票管理查询画面初期显示处理
			log.debug("========发票管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========发票管理查询画面初期显示处理终了========");
			
			forward = "DISP";
			
		}	
		//发票查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========发票查询处理开始========");
			//获取分页Bean
			getPaginDTO(req,"IGLOM0402");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0402Form) req.getSession().getAttribute("IGLOM0402Form");
				if ( form== null){
					form = new IGLOM0402Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0402Form) req.getSession().getAttribute("IGLOM0402Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGLOM0402");
			
			dto.setInvoiceInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchInvoiceAction(dto);
			//构造VO
			IGLOM04021VO vo = new IGLOM04021VO(null);
			vo.setInvoiceList(dto.getInvoiceList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========用户查询处理终了========");
			forward = "SEARCH_END";
		}
		//删除
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========通知删除处理开始========");
			dto.setDeleteNid(form.getIid());
			ctlBL.deleteNoticeAction(dto);
			log.debug("========通知删除处理终了========");
			forward="DELETE_END";
		}
//		List<ActionMessage> messageList = dto.getMessageList();
//		
//		if( messageList != null && messageList.size() > 0 ) {
//			for (ActionMessage message : messageList) {	
//				addMessage(request, message);
//			}
//		}
		return mapping.findForward(forward);
	}

}
