/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM01BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM01DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0102Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM01021VO;

/**
 * Server Xml上传历史查询处理
 * @author Xudong Wang 
 * 2013.07.31
 */
public class IGALM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0102Action.class);

	/**
	 * Server Xml上传历史查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0102Form form = (IGALM0102Form)actionForm;
		
		//BL取得
		IGALM01BL ctlBL = (IGALM01BL) getBean("igalm01BL");
		//DTO生成
		IGALM01DTO dto = new IGALM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Server Xml上传历史查询画面初期显示处理开始========");
			log.debug("========Server Xml上传历史查询画面初期显示处理终了========");
		}
		//Server Xml上传历史查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========Server Xml上传历史查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
			}
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGALM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ( "SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
				if ( form== null){
					form = new IGALM0102Form();
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
					form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGALM0102");
			//检索条件设置
			dto.setCrm05SearchCond(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchALM0102Action(dto);
			//构造VO
			IGALM01021VO vo = new IGALM01021VO();
			vo.setIgalm0102List(dto.getIgalm0102List());
			super.<IGALM01021VO>setVO(request, vo);
			log.debug("========Server Xml上传历史查询处理终了========");
		}
		if("IMPORT".equals(mapping.getParameter())){
			log.debug("========性能指标模板上传处理开始========");
			dto.setIgalm0102Form(form);
			dto = ctlBL.importPerfTemplateAction(dto);
			log.debug("========性能指标模板上传处理终了========");
		} 
		
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========性能指标模板删除开始========");
			dto.setIgalm0102Form(form);
			dto = ctlBL.deleteALM0102Action(dto);
			log.debug("========性能指标模板删除终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
		
	}
}
