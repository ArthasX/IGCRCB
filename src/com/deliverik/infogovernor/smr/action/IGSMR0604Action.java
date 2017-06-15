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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0603Form;
import com.deliverik.infogovernor.smr.vo.IGSMR06031VO;

/**
 * 概述:季报审批 
 * 功能描述：季报审批
 * 创建人：赵梓廷
 * 创建记录： 2013-08-08
 * 修改记录：
 */
public class IGSMR0604Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0604Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0603Form form = (IGSMR0603Form)actionForm;
						
		//BL取得
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
						
		//报表导出BL取得
        IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
        
		//DTO生成
		IGSMR06DTO dto = new IGSMR06DTO();
				
		String forward = "DISP";

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			log.debug("========年报明细列表处理开始========");
			dto.setInstanceID(form.getInstanceID());
			dto = ctlBL.initIGSMR0604Action(dto);
			//实例化VO
			IGSMR06031VO vo = new IGSMR06031VO();
			vo.setLst_Report(dto.getLst_Report());
			super.<IGSMR06031VO>setVO(request, vo);
			saveToken(request);
			log.debug("========年报明细列表处理结束========");
		}
		if("DISPONSE".equals(mapping.getParameter())){
			log.debug("========年报审批处理开始========");
			if (isTokenValid(request, true)){				
				dto.setIgSMR0603Form(form);
				dto = ctlBL.managerIGSMR0604Action(dto);
				forward = "DISPONSE";
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========年报审批处理开始========");
		}
		if("EXPORT".equals(mapping.getParameter())){
            log.debug("========季报报表导出处理开始========");
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
            log.debug("========季报报表导出处理结束========");
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
