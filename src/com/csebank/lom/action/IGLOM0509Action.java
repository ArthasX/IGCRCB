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
import com.csebank.lom.form.IGLOM0509Form;
import com.csebank.lom.vo.IGLOM05091VO;
import com.deliverik.framework.base.BaseAction;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_部门接待统计管理_统计查询ACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0509Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0508Action.class);
	
	/**
	 * <p>
	 * Description:部门接待统计查询ACTION处理
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
		IGLOM0509Form form = (IGLOM0509Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========部门接待统计查询画面初期显示处理开始========");

			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========部门接待统计查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//实例化DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========部门接待统计查询处理开始========");
			
			dto.setDeptEentertainmentSearchCond(form);
			dto.setIglom0509Form(form);
			//调用BL查询
			dto = ctlBL.searchDeptEentertainmentAction(dto);
			if(dto.getDeptEentertainmentList().size()==1){
				dto.getDeptEentertainmentList().clear();
			}
			//构造VO
			IGLOM05091VO vo = new IGLOM05091VO();
			vo.setDeptEentertainmentList(dto.getDeptEentertainmentList());
			
			super.<IGLOM05091VO>setVO(request, vo);
			
			log.debug("========部门接待统计查询处理终了========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========部门接待统计查询处理开始========");
			
			dto.setDeptEentertainmentSearchCond(form);
			dto.setIglom0509Form(form);
			//调用BL查询
			dto = ctlBL.searchDeptEentertainmentAction(dto);
			if(dto.getDeptEentertainmentList().size()==1){
				dto.getDeptEentertainmentList().clear();
			}
			//构造VO
			IGLOM05091VO vo = new IGLOM05091VO();
			vo.setDeptEentertainmentList(dto.getDeptEentertainmentList());
			
			super.<IGLOM05091VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05091VO", vo);
			
			log.debug("========部门接待统计查询处理终了========");
			return mapping.findForward("REPORT");

		}/*
		else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========部门接待统计明细查询处理开始========");
			
			//调用BL查询
			dto = ctlBL.searchEentertainmentAction(dto);
			
			//构造VO
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(request, vo);
			
			log.debug("========部门接待统计明细查询处理终了========");
		}
		*/
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
