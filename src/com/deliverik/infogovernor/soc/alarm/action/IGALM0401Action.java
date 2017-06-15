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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM04BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM04DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0401Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM04021VO;

/**
 * 告警详细查询画面查询处理
 * @author Xudong Wang 
 * 2013.08.01
 */
public class IGALM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0401Action.class);

	/**
	 * 告警详细查询画面处理
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
		IGALM0401Form form = (IGALM0401Form)actionForm;
		//BL取得
		IGALM04BL ctlBL = (IGALM04BL) getBean("igalm04BL");
		//DTO生成
		IGALM04DTO dto = new IGALM04DTO();
		//告警信息查询
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========告警信息查询画面显示处理开始========");
			form.reset(mapping, request);
			log.debug("========告警信息查询画面显示处理终了========");
			return mapping.findForward("DISP");
		}
		//告警信息查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========告警信息查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
			}
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGALM0401");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
				if ( form== null){
					form = new IGALM0401Form();
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
					form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			if("no".equals(request.getParameter("isquery")) || "false".equals(request.getParameter("isof"))){
				form.setPriority(null);
			}
			
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGALM0401");
			//检索条件设置
			dto.setIgalm0401Form(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			String count = ResourceUtility.getString("WARNING_MESSAGE_COUNT");
			
			pDto.setPageDispCount(Integer.parseInt(count));
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchCRM04Action(dto);	
			dto = ctlBL.getAlarmPriority(dto);
			dto = ctlBL.getRefreshRate(dto);
			
			Integer[] string = form.getPriority();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(Integer str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			
			//构造VO
			IGALM04021VO vo = new IGALM04021VO();
			vo.setIgalm0401List(dto.getCrm04infoList());
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			vo.setRefreshRate(dto.getRefreshRate());
			super.<IGALM04021VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("isquery"))){
				form.setIsquery("yes");
			}else{
				form.setIsquery("");
			}
			
			log.debug("========告警信息查询处理终了========");
		}
		//告警详细查询
		if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========告警详细查询画面显示处理开始========");
			//ctlBL.xxx();
			log.debug("========告警详细查询画面显示处理终了========");
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
