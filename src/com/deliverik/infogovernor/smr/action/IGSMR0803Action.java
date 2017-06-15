/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08031VO;


/**
 * 概述:监控报表详细页 查询action
 * 功能描述：监控报表详细页 查询action
 * 创建人：李季
 * 创建记录： 2013/09/04
 * 修改记录：
 */
public class IGSMR0803Action extends BaseAction{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGSMR0803Action.class);
	
	/**
	 * 监控报表详细页  查询
	 * 
	 * */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//controlBL取得
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
		
		//实例化dto
		IGSMR08DTO dto = new IGSMR08DTO();
		
		//（查询）form取得
		IGSMR0803Form form = (IGSMR0803Form) actionForm;
		
		/*页面初始化*/
		if("DISP".equals(mapping.getParameter())){
			log.debug("==================页面初始化操作开始=====================");
			
			log.debug("==================页面初始化操作结束=====================");
		}
		
		/*查询操作*/
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==================查询操作开始=====================");
			
			//把form中的内容封装在dto
			dto.setIgsmr0803Form(form);
			
			//调用controlBL查询(把查询出的数据再次封装进dto中)
			dto = ctlBL.searchListForDetailAction(dto);
			
			//vo对象设定
			IGSMR08031VO vo = new IGSMR08031VO();
			
			//查询信息集合封装进vo中
			vo.setDetailMap(dto.getDetailMap());
			
			//判断根据人员或机构查询返回
			if(StringUtils.isNotEmpty(form.getUserid())){
				//人员查询
				vo.setFlag("2");
			}else{
				//机构查询
				vo.setFlag("1");
			}
			
			//把vo存在request中带到JSP中   
			super.<IGSMR08031VO>setVO(request, vo);
			
			log.debug("==================查询操作结束=====================");
		}
		
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}

