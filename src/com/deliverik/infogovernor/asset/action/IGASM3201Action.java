package com.deliverik.infogovernor.asset.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.asset.bl.IGASM32BL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3201Form;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.asset.vo.IGASM32011VO;

/**
 * 文档编辑画面Action处理
 *
 * @author
 */
public class IGASM3201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3201Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM3201Form form = (IGASM3201Form)actionForm;
		
		//BL取得
		IGASM32BL ctlBL = (IGASM32BL) getBean("IGASM32BL");
		
		//DTO生成
		IGASM32DTO dto = new IGASM32DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========风险事件查询画面初期显示处理开始========");
			forward = "DISP";
			log.debug("========风险事件查询画面初期显示处理结束========");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM3201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//文档查询处理
			log.debug("========文档查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM3201Form) req.getSession().getAttribute("IGASM3201Form");
				if ( form== null){
					form = new IGASM3201Form();
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
					form = (IGASM3201Form) req.getSession().getAttribute("IGASM3201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM3201");
			
			//查询最新版本
			form.setEiversion("0");
			
			//DTO输入参数设定
			dto.setIgasm3201Form(form);
			copyArgu(dto);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//文档检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将文档信息检索结果设定到VO中
			IGASM32011VO vo = new IGASM32011VO(dto.getRiskcaseVWList());
			super.<IGASM32011VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			forward = "SUCCESS";
		}else if("SHOW".equals(mapping.getParameter())){
			dto.setEiid(Integer.parseInt(req.getParameter("eiid")));
			PrintWriter out = null;
			try {
				dto = ctlBL.searchRiskPolicyAction(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getRiskPolicy())){
					out.print(dto.getRiskPolicy());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}
	
	private void copyArgu(IGASM32DTO dto){
		RiskcaseVWSearchCondImpl cond= new RiskcaseVWSearchCondImpl();
		IGASM3201Form form = dto.getIgasm3201Form();
		cond.setEiid(form.getEiid());
		cond.setVersion(form.getEiversion());
		cond.setFccategory(form.getFccategory());
		cond.setFcname(form.getFcname());
		cond.setFcorigin(form.getFcorigin());
		cond.setFcpolicy(form.getFcpolicy());
		cond.setRiskcatchtime_from(form.getRiskcatchtime_from());
		cond.setRiskcatchtime_to(form.getRiskcatchtime_to());
		cond.setRiskid(form.getRiskid());
		cond.setRiskreviewresult(form.getRiskreviewresult());
		cond.setEISTATUS(form.getEistatus());
		dto.setRiskcaseVWSearchCond(cond);
	}
}
