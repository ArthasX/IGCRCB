/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.action;

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
import com.deliverik.infogovernor.cic.form.IGCIC0203Form;
import com.deliverik.infogovernor.cic.vo.IGCIC02021VO;
import com.deliverik.infogovernor.cic.vo.IGCIC02031VO;

/**
 * @Description: 对比执行情况 业务 Action处理
 * @Author
 * @History 2014-04-23 新建
 */
public class IGCIC0203Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCIC0203Action.class);

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

        IGCIC0203Form form = (IGCIC0203Form) actionForm;

        IGCIC02BL ctlBL = (IGCIC02BL) getBean("igcic02BL");

        IGCIC02DTO dto = new IGCIC02DTO();

        if ("DISP".equals(mapping.getParameter())) {
            
            dto.setIgcic0203Form(form);
            request.setAttribute("cpid", form.getCpid());
            
            ctlBL.searchObjectCompareresult(dto);
            
            IGCIC02031VO vo = new IGCIC02031VO();
            vo.setCic0203ShowMap(dto.getCic0203ShowMap());
            super.<IGCIC02031VO>setVO(request, vo);
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
