/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import java.util.ArrayList;
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
import com.deliverik.infogovernor.pdf.xmlbl.IGPDF01BL;
import com.deliverik.infogovernor.smr.bl.IGSMR04BL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.vo.IGSMR04021VO;

/**
 * 概述:年报审批 
 * 功能描述：年报审批 
 * 创建记录： 2013-07-25
 * 修改记录：
 */
public class IGSMR0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0402Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0402Form form = (IGSMR0402Form)actionForm;

		//BL取得
		IGSMR04BL ctlBL = (IGSMR04BL) getBean("igSMR04BL");
		
		//报表导出BL取得
		IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
				
		//DTO生成
		IGSMR04DTO dto = new IGSMR04DTO();
		
		String forward = "DISP";

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			log.debug("========年报明细列表处理开始========");
			dto.setInstanceID(form.getInstanceID());
			dto = ctlBL.initIGSMR0402Action(dto);
			//实例化VO
			IGSMR04021VO vo = new IGSMR04021VO();
			vo.setLst_Report(dto.getLst_Report());
			super.<IGSMR04021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========年报明细列表处理结束========");
		}
		if("DISPONSE".equals(mapping.getParameter())){
			log.debug("========年报审批处理开始========");
			if (isTokenValid(request, true)){				
				dto.setIgsmr0402Form(form);
				dto = ctlBL.managerIGSMR0402Action(dto);
				forward = "DISPONSE";
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========年报审批处理开始========");
		}
		if("EXPORT".equals(mapping.getParameter())){
            log.debug("========年报报表导出处理开始========");
            Integer[] prids = form.getPrids();
            String[] prpdids = form.getPrpdids();
            List<String> fileNames = new ArrayList<String>();
            // 导出pdf报表文件
            for (int i = 0; i < prids.length; i++) {
                String fileName = igPDF01BL.createPdf(prpdids[i], prids[i]);
                fileNames.add(fileName);
            }
            // 打包下载报表文件
            igPDF01BL.toZipAndDownload(fileNames, response);
            forward = "DISPONSE";
            log.debug("========年报报表导出处理结束========");
        }
		
		//逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
		return mapping.findForward(forward);
	}

}
