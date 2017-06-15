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
import com.csebank.lom.form.IGLOM0521Form;
import com.csebank.lom.vo.IGLOM05071VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 模塊：后勤管理-食堂管理
 * 說明：食堂招待部门汇总查询明细Action
 * 作者：唐曉娜
 */
public class IGLOM0521Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0121Action.class);

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
		
		//FORM取得
		IGLOM0521Form form = (IGLOM0521Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
	    if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//部门接待工作查询处理
			log.debug("========食堂招待部门汇总明细查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0121");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0521Form) req.getSession().getAttribute("IGLOM0521Form");
				if ( form == null ) {
					form = new IGLOM0521Form();
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
					form = (IGLOM0521Form) req.getSession().getAttribute("IGLOM0521Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0521");
			
			//DTO输入参数设定
			dto.setEeSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//部门接待工作信息检索逻辑调用
			dto = ctlBL.searchEEOrgVWDetail(dto);
			
			
			//将部门接待工作信息检索结果设定到VO中
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			
			log.debug("========食堂招待部门汇总明细查询处理开始========");
			
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
