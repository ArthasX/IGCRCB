/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.infogovernor.rpt.bl.IGRPT04BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0401Form;
import com.deliverik.infogovernor.rpt.vo.IGRPT04011VO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 概述: 报表统计Action
 * 创建记录:张楠 2012/10/26
 */
public class IGRPT0401Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0401Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BL取得
		IGRPT04BL ctlBL = (IGRPT04BL) getBean("igrpt04BL");
		//DTO生成
		IGRPT04DTO dto = new IGRPT04DTO();
		
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		IGRPT0401Form form=(IGRPT0401Form) actionForm;
		if(form!=null){
			if(form.getRclRfdTitle()!=null){
				form.setRclRfdTitle(URLDecoder.decode(form.getRclRfdTitle(),"UTF-8"));
			}
		}
		if("DISP".equals(mapping.getParameter())){
			dto=ctlBL.initReport(dto);
		}
		IGRPT04011VO vo=new IGRPT04011VO();
		vo.setParCodeDetailList(dto.getParCodeDetailList());
		vo.setCldCodeDetailList(dto.getCldCodeDetailList());
		List<ReportFileDefinition> rfdList = dto.getRfdList();
		vo.setRfdList(rfdList);
		
		if(dto.getParCodeDetailList()!=null&&dto.getParCodeDetailList().size()>0){
			req.setAttribute("numIndex", dto.getParCodeDetailList().size());
		}else{
			req.setAttribute("numIndex", "0");
		}
		
		Map<String, String> rfdtypeMap=new HashMap<String, String>();
		for (ReportFileDefinition reportFileDefinition : rfdList) {
			String rfdtype = reportFileDefinition.getRfdtype();
			rfdtypeMap.put(rfdtype, rfdtype);
		}
		vo.setRfdtypeMap(rfdtypeMap);
		super.<IGRPT04011VO>setVO(req, vo);
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
