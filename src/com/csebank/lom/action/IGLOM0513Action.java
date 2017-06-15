/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0513Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂出库明细Action
 * 作者：唐晓娜
 */
public class IGLOM0513Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0513Action.class);

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
		IGLOM0513Form form = (IGLOM0513Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		//下拉菜单
		req.setAttribute("gout_consume", LOMHelper.getItemsCodes(CodeUtils.GOUT_CONSUME));
		String forward = "";
		//初期显示跳转到可以查询的页面
		if( "DISP".equals(mapping.getParameter())){
			
			
			log.debug("========食堂物品消耗明细初始化处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========食堂物品消耗明细初始化处理开始========");
			
			forward = "DISP";
	
		
		}else if( "SEARCH".equals(mapping.getParameter())){
			
			log.debug("========食堂物品消耗明细查询处理开始========");
            getPaginDTO(req,"IGLOM0513");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
	
			form = (IGLOM0513Form) req.getSession().getAttribute("IGLOM0513Form");
			//from中的useType条件转换，如果useType=1代表普通消耗，useType=2招待消耗

			dto.setGoutDetailSearchCond(form);
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0513");
			
			//DTO输入参数设定
			dto.setGoutDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);			
		
			dto = ctlBL.searchGoutDetailInfo(dto)	;
			
			
			IGLOM05081VO vo = new IGLOM05081VO();
			vo.setGoutDetailInfoList(dto.getGoutDetailInfoList());
			
			super.<IGLOM05081VO>setVO(req, vo);
			
			log.debug("========食堂物品消耗明细查询处理开始========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
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
