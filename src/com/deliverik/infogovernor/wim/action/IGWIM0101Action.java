/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.action;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;
import com.deliverik.infogovernor.wim.vo.IGWIM01011VO;
import com.google.gson.Gson;

/**
 * @Description 工作项新增、修改Action
 * 
 * @date 2017年6月9日16:38:55
 * 
 * @author WangLiang
 *
 */
public class IGWIM0101Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//工作项管理Form取得
		IGWIM0101Form form = (IGWIM0101Form) actionForm;
		//BL取得
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO生成
		IGWIM01DTO dto = new IGWIM01DTO();
		//获取登录用户
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//登陆用户保存
		dto.setUser(user);
		//保存Form
		dto.setIgwim0101Form(form);
		
		if("DISP".equals(mapping.getParameter())){
			
			log.info("==========工作项定义初始化页面Action初始化开始==========");
			//调用BL初始化工作项信息
			dto = ctlBL.workDefinitionInitAction(dto);
			//调用BL查询用户是否是中心负责人或以上岗位
			dto = ctlBL.searchIsLeader(dto);
			//新增页面初始化设置发起人id
			form.setInitiatorId(user.getUserid());
			//新增页面初始化设置发起人名称
			form.setInitiatorName(user.getUsername());
			//保存用户是否为中心负责人以上岗位
			form.setIsLeader(dto.getIsLeader());
			//实例化工作项管理VO
			IGWIM01011VO vo = new IGWIM01011VO();
			//保存工作项定义信息
			vo.setWorkDefinitionInfo(dto.getWorkDefinitionInfo());
			//保存频率周星期集合 
			vo.setWeekList(dto.getWeekList());
			//保存频率月天数集合 
			vo.setMonthList(dto.getMonthList());
			//保存频率小时集合 
			vo.setHourList(dto.getHourList());
			//保存频率分集合 
			vo.setMinutesList(dto.getMinutesList());
			//将工作项管理Form保存至Request对象
			request.setAttribute("IGWIM0101Form", form);
			
			saveToken(request);
			super.<IGWIM01011VO>setVO(request, vo);
			
			log.info("==========工作项定义初始化页面Action初始化结束==========");
			
		}else if("INSERT".equals(mapping.getParameter())){
			
			log.info("==========工作项定义更新Action开始==========");
			
			if (isTokenValid(request, true)){
				if(form!=null && "0".equals(form.getMode())){
					//新增
					ctlBL.registerWorkDefinitionAction(dto);
				}else{
					//更新
					ctlBL.updateWorkDefinitionAction(dto);
				}
			}
			log.info("==========工作项定义更新Action结束==========");
			
		}else if("MODIFY".equals(mapping.getParameter())){
			
			log.info("==========工作项状态修改Action开始==========");
			
			//获取输出流
			PrintWriter out = null;
			
			//设置输出格式
			out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
			
			//调用BL更新工作项启、停用状态
			IGWIM01DTO msgDto = ctlBL.updateWorkDefinitionStatusAction(dto);
			
			//实例化Gson
			Gson gson = new Gson();
			
			//保存提示信息
			out.print(gson.toJson(msgDto.getMsg()));
			
			try {
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
				
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			
			log.info("==========工作项状态修改Action结束==========");
			
			return null;
			
		}else if("MANUALAJAX".equals(mapping.getParameter())){
			
			log.info("==========工作项实例手动发起Action处理开始==========");
			
			//获取输出流
			PrintWriter out = null;
			//设置输出格式
			out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
			
			try {
				
				//设置手动发起标识
				dto.setLaunchFlag("Y");
				//设置wdid
				dto.setWdid(Integer.parseInt(request.getParameter("wdid")));
				//调用BL手动发起工作项实例
				dto = ctlBL.registerWorkInstanceAction(dto);
				//实例化Gson
				Gson gson = new Gson();
				//保存提示信息
				out.print(gson.toJson(dto.getMsg()));
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
				
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			log.info("==========工作项实例手动发起Action处理结束==========");
			
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		
		return mapping.findForward("DISP");
	}

}
