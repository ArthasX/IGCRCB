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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM03BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0301Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM03011VO;

/**
 * 监控对象配置
 * @author wangxing
 * 2013.08.01
 */
public class IGALM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0301Action.class);
	

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0301Form form = (IGALM0301Form)actionForm;
		
		//BL取得
		IGALM03BL ctlBL = (IGALM03BL) getBean("igalm03BL");
		//DTO生成
		IGALM03DTO dto = new IGALM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========监控对象查询画面初期显示处理开始========");
			log.debug("========监控对象查询画面初期显示处理终了========");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========监控对象视图查询处理开始========");
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGALM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ( "SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0301Form) request.getSession().getAttribute("IGALM0301Form");
				if ( form== null){
					form = new IGALM0301Form();
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
					form = (IGALM0301Form) request.getSession().getAttribute("IGALM0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			String flag =request.getParameter("flag");
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGALM0102");
			//检索条件设置
			dto.setIgalm0301Form(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchIGALM03Action(dto);
			//构造VO
			IGALM03011VO vo = new IGALM03011VO();
			vo.setCrm06InfoList(dto.getCrm06InfoList());
			vo.setFlag(flag);
			super.<IGALM03011VO>setVO(request, vo);
			log.debug("========监控对象视图查询处理终了========");
		}else if("ChangeStatus".equals(mapping.getParameter())){
			log.debug("========监控对象状态修改处理开始========");
			dto.setIgalm0301Form(form);
			dto = ctlBL.changeStatus(dto);
			log.debug("========监控对象状态修改处理结束========");
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
