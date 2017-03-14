/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ��Դ����<br/> 
 * ��������: ��Դ������ѯ��Ŀ�б�Action<br/> 
 * ������¼: 2014/02/14<br/> 
 * �޸ļ�¼:<br/>
 */
public class IGVIR0304Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0304Action.class);

    /**
     * ��ʾ����
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
        IGVIR0304Form form = (IGVIR0304Form)actionForm;
    	
        // BLȡ��
        IGVIR03BL ctlBL = (IGVIR03BL) getBean("igvir03BL");
        
        // DTO����
        IGVIR03DTO dto = new IGVIR03DTO();

        if ("DISP".equals(mapping.getParameter())) {
            log.debug("========���������ʾ��ʼ========");
            dto = ctlBL.searchProjectList(dto);
            IGVIR03041VO vo = new IGVIR03041VO();
            vo.setVim02List(dto.getVim02List());
            super.<IGVIR03041VO>setVO(req, vo);
            log.debug("========���������ʾ����========");
        }
        return mapping.findForward("DISP");
    }
}
