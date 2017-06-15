/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更发起人附件处理Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0405Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCRC0405Action.class);
		//BL取得
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//实例化dto
		IGCRC04DTO dto = new IGCRC04DTO();
		if("GETATTACHMENT".equals(mapping.getParameter())){
			log.debug("================日志附件查理操作开始==================");
			//取得日志信息
			IGPRR01021VO vo = (IGPRR01021VO) request.getSession().getAttribute("IGPRR01021VO");
			if(vo != null){
				Map<String, List<IG036Info>> map = vo.getRecordLogMap();
				if(map != null && map.get(IGPRDCONSTANTS.RECORDLOG_TYPE_CL_NAME) != null){
					dto.setForm(actionForm);
					dto.setRecordList(map.get(IGPRDCONSTANTS.RECORDLOG_TYPE_CL_NAME));
					dto = ctlBL.getRecordLogAttachmentAction(dto);
					PrintWriter out = null;
					try {
						out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
						out.print(dto.getAjaxResult());
					} catch (Exception e) {
						out.print("");
						log.error("AjaxAction Exception", e);
					} finally {
						if (out != null)
							out.close();
					}
				}
			}
			log.debug("================日志附件查理操作结束==================");
		}
		return null;
	}

}