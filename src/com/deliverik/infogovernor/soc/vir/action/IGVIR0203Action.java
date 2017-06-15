/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ��Դ����<br/> 
 * ��������: ���������ʾAction<br/> 
 * ������¼: 2014/02/14<br/> 
 * �޸ļ�¼:<br/>
 */
public class IGVIR0203Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0203Action.class);

    /**
     * ���������ʾ����
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
    	//ʵ����FORM
    	IGVIR0203Form form = (IGVIR0203Form)actionForm;
    	
        // BLȡ��
        FlowSearchBL flowSearchBL = (FlowSearchBL)getBean("flowSearchBL");
        IGVIR02BL ctlBL = (IGVIR02BL) getBean("igvir02BL");
        
        // DTO����
        IGVIR02DTO dto = new IGVIR02DTO();

        if ("DISP".equals(mapping.getParameter())) {
            log.debug("========���������ʾ��ʼ========");
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
            log.debug("========���������ʾ����========");
        }else if("GETPROGRESS".equals(mapping.getParameter())){
        	log.debug("========������Ȼ�ȡ��ʼ========");
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
            log.debug("========������Ȼ�ȡ����========");
			return null;
        }
        
        return mapping.findForward("DISP");
    }
}
