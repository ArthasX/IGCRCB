/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.xls.soc.cim.bl.IGCIM1102ExcelBL;
import com.deliverik.infogovernor.xls.soc.cim.dto.IGCIM1102ExcelDTO;

/**
 * @Description: 资产关系选择
 * @History 2013-12-27     新建
 */
public class IGCIM1102Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCIM1102Action.class);

    /**
     * 
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
            HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        // BL取得
        IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
        //实例化DTO
        IGCIM01DTO dto = new IGCIM01DTO();
        
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        dto.setUser(user);
        if ("EXPORT".equals(mapping.getParameter())) {
            log.debug("========资产自定义报表导出处理开始========");
            String eiid = req.getParameter("eiid");
            dto.setEiid(eiid);
            dto = ctlBL.exportReport(dto);
            
            IGCIM1102ExcelDTO excelDto = new IGCIM1102ExcelDTO();
            IGCIM1102ExcelBL excelBL = (IGCIM1102ExcelBL) getBean("igcim1102excelBL");
            //文件名称
            excelDto.setReportTitle(dto.getReportTitle()+".xls");
            //表头信息
            excelDto.setTitleListMap(dto.getTitleListMap());
            //内容信息
            excelDto.setContentListMap(dto.getContentListMap());
			excelDto.setFileid("CIM1102");
			excelDto.setResponse(res);
			excelBL.initExcel(excelDto);
            log.debug("========资产自定义报表导出处理结束========");
            return null;
        }
        // 逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
        return mapping.findForward("DISP");
    }
}
