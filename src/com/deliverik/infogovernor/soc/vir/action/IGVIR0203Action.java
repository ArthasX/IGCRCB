/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.infogovernor.soc.vir.IGVIRCONSTANTS;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR02BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0203Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR02031VO;
import com.google.gson.Gson;

/**
 * 概述: 资源申请<br/> 
 * 功能描述: 部署进度显示Action<br/> 
 * 创建记录: 2014/02/14<br/> 
 * 修改记录:<br/>
 */
public class IGVIR0203Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0203Action.class);

    /**
     * 部署进度显示处理
     * 
     * @param mapping
     *            ActionMapping
     * @param actionForm
     *            ActionForm
     * @param req
     *            HttpServletRequest
     * @param res
     *            HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
            HttpServletResponse res) throws Exception {
    	//实例化FORM
    	IGVIR0203Form form = (IGVIR0203Form)actionForm;
    	
        // BL取得
        FlowSearchBL flowSearchBL = (FlowSearchBL)getBean("flowSearchBL");
        IGVIR02BL ctlBL = (IGVIR02BL) getBean("igvir02BL");
        
        // DTO生成
        IGVIR02DTO dto = new IGVIR02DTO();

        if ("DISP".equals(mapping.getParameter())) {
            log.debug("========部署进度显示开始========");
//            req.setAttribute("prid", form.getPrid());
            if(StringUtils.isNotEmpty(form.getPrid())){
            	int prid = Integer.parseInt(form.getPrid());
                String pid = flowSearchBL.searchPublicProcessInfo(prid,IGVIRCONSTANTS.APPLY_FORM_PROJECT);
                dto.setPid(pid);
                dto = ctlBL.getApplyVMList(dto);
                IGVIR02031VO vo = new IGVIR02031VO();
                vo.setVim03List(dto.getVim03List());
                vo.setPid(pid);
                super.<IGVIR02031VO>setVO(req, vo);
            }
            log.debug("========部署进度显示结束========");
        }else if("GETPROGRESS".equals(mapping.getParameter())){
        	log.debug("========部署进度获取开始========");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
	        	String pid = req.getParameter("pid");
	        	dto.setPid(pid);
	            dto = ctlBL.getApplyVMList(dto);
	            Gson gson = new Gson();
				gson.toJson(dto.getVim03List(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========部署进度获取终了========");
			return null;
        }
        
        return mapping.findForward("DISP");
    }
}
