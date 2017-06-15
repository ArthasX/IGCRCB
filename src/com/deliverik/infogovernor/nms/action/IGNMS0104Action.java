/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.nms.bl.IGNMS01BL;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.event.IGNMS0101Pushlet;
import com.deliverik.infogovernor.nms.form.IGNMS0104Form;

/**
 * 概述: 设备发现推送
 * 功能描述: 设备发现推送
 * 创建记录: 2013/12/30 Fubin
 * 修改记录:
 */
public class IGNMS0104Action extends BaseAction {
	static Log log = LogFactory.getLog(IGNMS0104Action.class);
	
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    IGNMS0104Form form = (IGNMS0104Form)actionForm;
        IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
        IGNMS01DTO dto = new IGNMS01DTO();
        
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("=========== 设备发现推送开始 ==========");
			Map<String, String> pushMap = new HashMap<String, String>();
			String doClose = form.getDoClose();
			String gversion = form.getGversion();
			if(StringUtils.isEmpty(doClose)||(!"1".equals(doClose))){
				doClose = "0";
				String pushXML = form.getPushXML();
		        pushMap.put("pushXML", pushXML);
			}
	        pushMap.put("doClose", doClose);
	        pushMap.put("gversion", gversion);
			IGNMS0101Pushlet.pushData(pushMap);
			
			log.debug("=========== 设备发现推送终了 ==========");
			return null;
		} else if ("GETIMGURL".equals(mapping.getParameter())) {
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                dto = ctlBL.getImgUrl(dto);
                out.print(dto.getImgUrlXml());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
			return null;
		} else if ("GETDEVTYPE".equals(mapping.getParameter())) {
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                dto = ctlBL.getDevType(dto);
                out.print(dto.getDevTypeXml());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
			return null;
		}
		
		return mapping.findForward("DISP");
	}

}
