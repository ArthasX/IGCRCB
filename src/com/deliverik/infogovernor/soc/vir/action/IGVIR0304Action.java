/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR03BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR03DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0304Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR03041VO;

/**
 * 概述: 资源调整<br/> 
 * 功能描述: 资源调整查询项目列表Action<br/> 
 * 创建记录: 2014/02/14<br/> 
 * 修改记录:<br/>
 */
public class IGVIR0304Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0304Action.class);

    /**
     * 显示处理
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
        IGVIR0304Form form = (IGVIR0304Form)actionForm;
    	
        // BL取得
        IGVIR03BL ctlBL = (IGVIR03BL) getBean("igvir03BL");
        
        // DTO生成
        IGVIR03DTO dto = new IGVIR03DTO();

        if ("DISP".equals(mapping.getParameter())) {
            log.debug("========部署进度显示开始========");
            dto = ctlBL.searchProjectList(dto);
            IGVIR03041VO vo = new IGVIR03041VO();
            vo.setVim02List(dto.getVim02List());
            super.<IGVIR03041VO>setVO(req, vo);
            log.debug("========部署进度显示结束========");
        }
        return mapping.findForward("DISP");
    }
}
