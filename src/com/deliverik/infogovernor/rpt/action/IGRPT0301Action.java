/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

import java.net.URLDecoder;
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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.bl.IGRPT03BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT03DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0301Form;
import com.deliverik.infogovernor.rpt.vo.IGRPT03011VO;

/**
 * 概述: 报表统计Action
 * 创建记录:杨龙全 2012/07/03
 * 修改记录: 
 */
public class IGRPT0301Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0301Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BL取得
		Calendar c1=Calendar.getInstance();
		IGRPT03BL ctlBL = (IGRPT03BL) getBean("igrpt03BL");
		//DTO生成
		IGRPT03DTO dto = new IGRPT03DTO();
		
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		IGRPT0301Form form=(IGRPT0301Form) actionForm;
		if(form!=null){
			if(form.getRclRfdTitle()!=null){
				form.setRclRfdTitle(URLDecoder.decode(form.getRclRfdTitle(),"UTF-8"));
			}
		}
		if("DISP".equals(mapping.getParameter())){
			dto=ctlBL.initReport(dto);
		}
		IGRPT03011VO igrpt03011vo=new IGRPT03011VO();
		igrpt03011vo.setBcVWList(dto.getBcVWList());
		igrpt03011vo.setHcVWList(dto.getHcVWList());
		igrpt03011vo.setScList(dto.getScList());
		igrpt03011vo.setCatagoryCodeDeatilList(dto.getCatagoryCodeDeatilList());
		igrpt03011vo.setObjCodeDeatilList(dto.getObjCodeDeatilList());
		igrpt03011vo.setReportFileDefinitionList(dto.getReportFileDefinitionList());
		super.<IGRPT03011VO>setVO(req, igrpt03011vo);
		Calendar c2=Calendar.getInstance();
		System.out.println("=================="+(c2.getTimeInMillis()-c1.getTimeInMillis())+"=======================");
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
