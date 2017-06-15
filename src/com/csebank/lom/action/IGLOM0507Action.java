/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.csebank.lom.form.IGLOM0507Form;
import com.csebank.lom.vo.IGLOM05071VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 食堂接待管理Action
 * 
 */
public class IGLOM0507Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0507Action.class);

	/**
	 * 食堂接待管理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGLOM0507Form form = (IGLOM0507Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		if ("DETAIL".equals(mapping.getParameter())){
			//接待统计明细查询
			form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			try{
				c.setTime(sdf.parse(form.getEedate()+"/01"));
			}catch(ParseException e){
				return mapping.findForward("DISP");
			}
			
			c.add(c.MONTH, 1);
			c.add(c.DAY_OF_MONTH, -1);
			form.setEetime_from(form.getEedate()+"/01");
			form.setEetime_to(sdf.format(c.getTime()));
			log.debug("========接待统计明细查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO输入参数设定
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//食堂接待统计明细信息检索逻辑调用
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//将食堂接待统计明细信息检索结果设定到VO中
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			
			log.debug("========接待统计明细查询处理终了========");
			
			forward = "DISP";
		}else if( "DISP".equals(mapping.getParameter())){
			
			//食堂接待管理查询画面初期显示处理
			log.debug("========食堂接待管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========食堂接待管理查询画面初期显示处理终了========");
			
			forward = "DISP";
			
		} 	/*
			else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========食堂接待管理删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteRid(form.getDeleteRid());
			
			ctlBL.deleteRecptionAction(dto);
			
			log.debug("========接待工作管理删除处理终了========");
			
			forward = "DELETE";
			
		} */else if( "REPORT".equals(mapping.getParameter())){
			form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			try{
				c.setTime(sdf.parse(form.getEedate()+"/01"));
			}catch(ParseException e){
				return mapping.findForward("DISP");
			}
			
			c.add(c.MONTH, 1);
			c.add(c.DAY_OF_MONTH, -1);
			form.setEetime_from(form.getEedate()+"/01");
			form.setEetime_to(sdf.format(c.getTime()));
			log.debug("========接待统计明细查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO输入参数设定
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//食堂接待统计明细信息检索逻辑调用
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//将食堂接待统计明细信息检索结果设定到VO中
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			req.setAttribute("form", form);
			req.setAttribute("IGLOM05071VO", vo);
			log.debug("========接待统计明细查询处理终了========");
			return mapping.findForward("REPORT");

		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//食堂接待管理查询处理
			log.debug("========食堂接待管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
				if ( form == null ) {
					form = new IGLOM0507Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}  else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO输入参数设定
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//食堂接待管理信息检索逻辑调用
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//将食堂接待管理信息检索结果设定到VO中
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			
			log.debug("========食堂接待管理查询处理终了========");
			
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
