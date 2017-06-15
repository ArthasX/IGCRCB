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

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0409Form;
import com.csebank.lom.vo.IGLOM04021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 *  发票部门统计明细Action
 * 
 */
public class IGLOM0409Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0409Action.class);

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
		
		String forward="";
		//实例化FORM
		IGLOM0409Form form = (IGLOM0409Form)actionForm;
		
		//BL取得
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		
		//DTO生成
		IGLOM04DTO dto = new IGLOM04DTO();
	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========发票部门统计详细信息查询处理开始========");
			//获取分页Bean
			getPaginDTO(req,"IGLOM0409");

			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");

			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOM0409Form) req.getSession().getAttribute("IGLOM0409Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0409");
			
			dto.setInvoiceInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchInvoiceAction(dto);
			//构造VO
			IGLOM04021VO vo = new IGLOM04021VO(null);
			vo.setInvoiceList(dto.getInvoiceList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========发票部门统计详细信息查询处理查询处理终了========");
			forward = "DISP";
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
