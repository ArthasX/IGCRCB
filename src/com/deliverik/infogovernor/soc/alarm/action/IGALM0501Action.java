/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM07BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0501Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM05011VO;


public class IGALM0501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0102Action.class);

	/**
	 * 性能查询页面
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
		IGALM0501Form form = (IGALM0501Form)actionForm;
		String collecttime="";
		//获取当天的日期转换成字符串
		//BL取得
		IGALM07BL ctlBL = (IGALM07BL) getBean("igalm07BL");
		//DTO生成
		IGALM07DTO dto = new IGALM07DTO();
	   
		if( "DISP".equals(mapping.getParameter())){
			if ("DISP".equals(mapping.getParameter())){
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
			}
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGALM0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ( "DISP".equals(mapping.getParameter())){
				
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
				if ( form== null){
					form = new IGALM0501Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			collecttime= sdf.format(date);
			form.setCollecttime(collecttime);
			form.setNowCollecttime(collecttime);
			//如果查询日期等于今天  查CR02表 找到最新的表名查实时表   否则查历史表

			form.setTablename(ctlBL.searchTable(form));
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGALM0501");
			//检索条件设置
			dto.setCrm10SearchCond(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchALM0501VWAction(dto);
			//构造VO
			IGALM05011VO vo = new IGALM05011VO();
			vo.setIgalm0501VWList(dto.getIgalm0501VWList());
			super.<IGALM05011VO>setVO(request, vo);
		}
		//Server Xml上传历史查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
			}
			//获取分页Bean（传递数据的dto）
			getPaginDTO(request,"IGALM0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//判断是否由详细画面，编辑画面返回查询画面
			if ( "SEARCH1".equals(mapping.getParameter())){
				
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
				if ( form== null){
					form = new IGALM0501Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} 
			else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGALM0501Form) request.getSession().getAttribute("IGALM0501Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			collecttime= sdf.format(date);
			form.setCollecttime(collecttime);
			form.setNowCollecttime(collecttime);
			//如果查询日期等于今天  查CRM02表 找到最新的表名查实时表   否则查历史表
			boolean Isflag=true;
			if(!form.getGet_EndTime().isEmpty()&&Isflag){
				if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&form.getGet_StartTime().isEmpty()){
					form.setTablename(ctlBL.searchTable(form));
				}
				else if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&!form.getGet_StartTime().isEmpty())
				   {
					if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime))
					{
						form.setTablename(ctlBL.searchTable(form));
					}
					else
					{
						form.setTablename("crm10");
					}
					
				    }
				else
				{
					form.setTablename("crm10");
				}
				Isflag=false;
				
		    }
			
			else if (!form.getGet_StartTime().isEmpty()&&Isflag){
				if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&form.getGet_EndTime().isEmpty()){
					form.setTablename(ctlBL.searchTable(form));
					}
				  else if(form.getGet_StartTime().substring(0, 10).replace("/", "").trim().equals(collecttime)&&!form.getGet_EndTime().isEmpty())
				  {
					if(form.getGet_EndTime().substring(0, 10).replace("/", "").trim().equals(collecttime))
					{
						form.setTablename(ctlBL.searchTable(form));
					}
					else
					{
						form.setTablename("crm10");
					}
				  }
				
				else{
						form.setTablename("crm10");
						}
				}
			else{
					form.setTablename("crm10");
					}		
			
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGALM0501");
			//检索条件设置
			form.setSymType(String.valueOf(form.getServertype()));
			dto.setCrm10SearchCond(form);
			//查询的最大记录数设置
			dto.setMaxSearchCount(maxCnt);
			//分页Bean设置
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchALM0501VWAction(dto);
			//构造VO
			IGALM05011VO vo = new IGALM05011VO();
			vo.setIgalm0501VWList(dto.getIgalm0501VWList());
			super.<IGALM05011VO>setVO(request, vo);
			
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
