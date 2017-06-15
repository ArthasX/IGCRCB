/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description: �ʲ���ϵѡ��
 * @History 2013-12-27     �½�
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
        
        // BLȡ��
        IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
        //ʵ����DTO
        IGCIM01DTO dto = new IGCIM01DTO();
        
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        dto.setUser(user);
        if ("EXPORT".equals(mapping.getParameter())) {
            log.debug("========�ʲ��Զ��屨��������ʼ========");
            String eiid = req.getParameter("eiid");
            dto.setEiid(eiid);
            dto = ctlBL.exportReport(dto);
            
            IGCIM1102ExcelDTO excelDto = new IGCIM1102ExcelDTO();
            IGCIM1102ExcelBL excelBL = (IGCIM1102ExcelBL) getBean("igcim1102excelBL");
            //�ļ�����
            excelDto.setReportTitle(dto.getReportTitle()+".xls");
            //��ͷ��Ϣ
            excelDto.setTitleListMap(dto.getTitleListMap());
            //������Ϣ
            excelDto.setContentListMap(dto.getContentListMap());
			excelDto.setFileid("CIM1102");
			excelDto.setResponse(res);
			excelBL.initExcel(excelDto);
            log.debug("========�ʲ��Զ��屨�����������========");
            return null;
        }
        // �߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
        return mapping.findForward("DISP");
    }
}
