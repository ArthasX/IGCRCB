/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.cic.bl.IGCIC02BL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0201Form;
import com.deliverik.infogovernor.cic.vo.IGCIC02011VO;
import com.deliverik.infogovernor.sym.vo.IGSYM01011VO;

/**
 * @Description: �Ա�ִ����� ҵ�� Action����
 * @Author
 * @History 2014-04-23 �½�
 */
public class IGCIC0201Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCIC0201Action.class);

    /**
     * ����
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

        IGCIC0201Form form = (IGCIC0201Form) actionForm;

        IGCIC02BL ctlBL = (IGCIC02BL) getBean("igcic02BL");

        IGCIC02DTO dto = new IGCIC02DTO();

        if ("DISP".equals(mapping.getParameter())) {

        } else if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())) {
            log.debug("============= �ȶ�ִ�������ʼ��ʼ =============");

            // ��ȡ��ҳBean
            getPaginDTO(request, "IGSYM0101");
            PagingDTO pDto = (PagingDTO) request.getAttribute("PagingDTO");

            if ("SEARCH1".equals(mapping.getParameter())) {
                
                // ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGCIC0201Form) request.getSession().getAttribute("IGCIC0201Form");
                
                if (form == null) {
                    
                    form = new IGCIC0201Form();
                    
                } else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
                
            } else {
                
                if (request.getParameter("PAGING") == null) {
                    
                    pDto.setFromCount(0);
                    
                    form = (IGCIC0201Form) request.getSession().getAttribute("IGCIC0201Form");
                    if (form != null) {
                        form.setFromCount(0);
                    }
                }
            }

            // ����¼��ȡ��
            int maxCnt = getMaxDataCount("IGSYM0101");

            dto.setIgcic0201Form(form);
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);

            dto = ctlBL.searchCompareProcessAction(dto);
            
            IGCIC02011VO vo = new IGCIC02011VO();
            vo.setCompareprocessList(dto.getCompareprocessList());
            super.<IGCIC02011VO>setVO(request, vo);
            
            log.debug("============= �ȶ�ִ�������ʼ���� =============");
        } else if ("EXECUTE".equals(mapping.getParameter())) {
            log.debug("=============== ִ�бȶ����� ==============");
            
            dto = ctlBL.executeCompareTask(dto);
            
            log.debug("=============== ִ�бȶ����� ==============");
        } else if ("INSERT".equals(mapping.getParameter())) {

        } else if ("DELETE".equals(mapping.getParameter())) {

        }

        // �߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();

        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(request, message);
            }

        }

        return mapping.findForward("DISP");
    }
}
