/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.action;

import java.io.PrintWriter;
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
import com.deliverik.infogovernor.cic.bl.IGCIC02BL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0205Form;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.vo.IGCIC02051VO;
import com.google.gson.Gson;

/**
 * @Description: 对比执行情况 业务 Action处理
 * @Author
 * @History 2014-04-23 新建
 */
public class IGCIC0205Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCIC0205Action.class);

    /**
     * 处理
     * 
     * @param mapping
     * @param actionForm
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res)
            throws Exception {

        IGCIC0205Form form = (IGCIC0205Form) actionForm;

        IGCIC02BL ctlBL = (IGCIC02BL) getBean("igcic02BL");

        IGCIC02DTO dto = new IGCIC02DTO();

        if ("DISP".equals(mapping.getParameter())) {
            
            dto.setIgcic0205Form(form);
            request.setAttribute("cpid", form.getCpid());
            
            ctlBL.getTreeView(dto);
            
            Gson gson = new Gson();
            
            IGCIC02051VO vo = new IGCIC02051VO(gson.toJson(dto.getTreeMap()));
            vo.setSoc0124InfoJson(gson.toJson(dto.getSoc0124Info()));
            vo.setSourceMap(dto.getSourceMap());
            vo.setTargetMap(dto.getTargetMap());
            super.<IGCIC02051VO>setVO(request, vo);
        } 
        else if("DETAIL".equals(mapping.getParameter())){
        	List<CompareresultVWInfo> resultList = ctlBL.getDetailByEentity(request.getParameter("eid"), Integer.valueOf(request.getParameter("cpid")));
        	Gson gson = new Gson();
        	res.setCharacterEncoding("utf-8");
        	
        	PrintWriter pw =  res.getWriter();
        	
        	pw.write(gson.toJson(resultList));
        	return null;
        }

        // 逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();

        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(request, message);
            }

        }

        return mapping.findForward("DISP");
    }
}
