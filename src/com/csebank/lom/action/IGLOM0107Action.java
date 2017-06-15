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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM01031VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 模块：后勤管理-接待管理-外出就餐管理
 * 说明：点击外出就餐登记以及从左侧树中点击外出就餐管理action
 * @author 唐晓娜
 *
 */
public class IGLOM0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0103Action.class);

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
		IGLOM0107Form form = (IGLOM0107Form)actionForm;
		
		//BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		// 下拉菜单
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		
		String forward = "";
		
		if( "view-init".equals(mapping.getParameter())){
			
			//接待工作管理查询画面初期显示处理
			log.debug("========外出就餐管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========外出就餐管理查询画面初期显示处理终了========");

			saveToken(req);
			forward = "view-init";
			
			
		} 
		//else if("REDISP".equals(mapping.getParameter())){
//			
//			//接待工作管理查询画面再显示处理
//			log.debug("========接待工作管理查询画面再显示处理开始========");
//			addMessage(req, new ActionMessage("IGCO10000.I003"));
//			log.debug("========接待工作管理查询画面再显示处理终了========");
//			
//			forward = "DISP";
//			
//			
//		}	
		//改变外出就餐工作状态
		else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========外出就餐管理状态停用/启用处理开始========");
			//DTO输入参数设定
			dto.setIglom0107Form(form);
			
			

			if (isTokenValid(req, true)) {

				ctlBL.changeDealAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			//清空form中的rstatus状态，避免返回时候按照当前保留状态展现内容
			form.setRstatus("");
			log.debug("========外出就餐作管理状态停用/启用处理终了========");
			
			forward = "CHANGE";
			
		}	
		else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========外出就餐信息删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteRid(form.getDeleteRid());
			

			if (isTokenValid(req, true)) {

				ctlBL.deleteDealAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========外出就餐信息删除处理结束========");
			
			forward = "DELETE";
			
		} 
		//点击查询外出就餐工作管理信息，search1是删除之后重新返回页面刷新处理
		else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//接待工作管理查询处理
			log.debug("========接待工作管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0107");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0107Form) req.getSession().getAttribute("IGLOM0107Form");
				if ( form == null ) {
					form = new IGLOM0107Form();
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
					form = (IGLOM0107Form) req.getSession().getAttribute("IGLOM0107Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0107");
			
			//DTO输入参数设定
			dto.setDealSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//接待工作管理信息检索逻辑调用
			dto = ctlBL.searchDealInfo(dto);
			
			saveToken(req);
			
			//将接待工作管理信息检索结果设定到VO中
			IGLOM01031VO vo = new IGLOM01031VO();
			vo.setDealList(dto.getDealList());
			vo.setDealAmountList(dto.getDealAmountList());
			//List list=dto.getDealList();
			//System.out.print(dto.getDealList());
			super.<IGLOM01031VO>setVO(req, vo);
			
			
			log.debug("========接待工作管理查询处理终了========");
			
			forward = "DISP";
		}
		//else if( "STDISP".equals(mapping.getParameter())){
//			
//			//接待工作管理查询画面初期显示处理(食堂出库选择接待工作时调用)
//			log.debug("========接待工作管理查询画面初期显示处理开始========");
//			addMessage(req, new ActionMessage("IGCO10000.I003"));
//			log.debug("========接待工作管理查询画面初期显示处理终了========");
//			
//			forward = "DISP";
//			
//			

		
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
