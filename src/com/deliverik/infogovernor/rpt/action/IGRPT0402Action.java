/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.rpt.bl.IGRPT04BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0402Form;

/**
 * 概述: 报表统计参数Action
 * 创建记录:杨龙全 2012/10/29
 * 修改记录: 
 */
public class IGRPT0402Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0402Action.class);
	
	protected MessageResources syresources = MessageResources.getMessageResources("SystemConfigResources");
    
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
	    
	    //BL取得
		IGRPT04BL ctlBL = (IGRPT04BL) getBean("igrpt04BL");
		
		IGRPT0402Form form=(IGRPT0402Form) actionForm;
		
		//DTO生成
		IGRPT04DTO dto = new IGRPT04DTO();
		
		dto.setIgrpt0402Form(form);
		
		if("DISP".equals(mapping.getParameter())){
		    
		    String temName = form.getTemplateName();
		    
		    // 定制报表处理则另需取得报表模板名称
		    if ("0".equals(form.getIsFlag())) {
		        //报表模板查询cid设定
		        dto.setTemName(temName);
		        //报表参数信息表查询主键设定
		        dto.setRfdid(form.getRfdid());
		        //报表定义参数信息取得
		        dto = ctlBL.getCustomConfigurationInfo(dto);
		        //设定定制报表的报表模板名称
		        temName = dto.getTemName();
		        //定制报表参数设定
                form.setTemplateName(temName);
                form.setPdid(dto.getPdid());
                form.setPsdcode(dto.getPsdcode());
                form.setPidid(dto.getPidid());
                form.setPidvalue(dto.getPidvalue());
                form.setTitle(dto.getTitle());
		    }
			
			//判断流程类型
			if(StringUtils.isNotEmpty(form.getRfdpictype())){
				if("0".equals(form.getRfdpictype())){
					//表格
					temName=temName+"_table";
				}else if("1".equals(form.getRfdpictype())){
					//柱形
					temName=temName+"_bar";
				}else if("2".equals(form.getRfdpictype())){
					//饼图
					temName=temName+"_pie";
				}else if("3".equals(form.getRfdpictype())){
					//线图
					temName=temName+"_line";
				}
			}
			if (StringUtils.isEmpty(dto.getTreeFormLevel2())) {
			    form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+form.getTemplateName()+"/1/"+temName+".rptdesign");
			} else {
			    form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+form.getTemplateName()+"/2/"+temName+".rptdesign");
			}
		}
		
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
