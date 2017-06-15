package com.deliverik.infogovernor.fxk.action;

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
import com.deliverik.infogovernor.fxk.bl.IGFXK03BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0301Form;
import com.deliverik.infogovernor.fxk.vo.IGFXK03011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռƻ���ѯAction
 * </p>
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
public class IGFXK0301Action  extends BaseAction{
    /**��־����*/
    private static Log log = LogFactory.getLog(IGFXK0301Action.class);
    
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("=======================�������ѹ���ʼ=======================");
        
        IGFXK0301Form form = (IGFXK0301Form)actionForm;
        IGFXK03DTO dto=new IGFXK03DTO();
        dto.setForm(actionForm);
        //��ȡBL�ӿ�ʵ��
        IGFXK03BL ctrlBL = (IGFXK03BL) getBean("igFXK03BL");
        //��תҳ��
        String forward = "DISP"; 
        dto=ctrlBL.searchLableValueAction(dto);
        request.setAttribute("lvFXTYPEList", dto.getLst_LabelValueBean());
        dto=ctrlBL.searchUserLabelValueBean(dto);
        request.setAttribute("userLabelLst", dto.getPeo_LabelValueBean());
        
        //��ʼ��ҳ��
        if("DISP".equals(mapping.getParameter())){
            
        }
        //��ʼ��ҳ��
        if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
            //��ҳ��DTOȡ��
            getPaginDTO(request,"IGFXK0301");
            PagingDTO pDto;
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGFXK0301Form) request.getSession().getAttribute("IGFXK0301Form");
                if ( form == null ) {
                    form = new IGFXK0301Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } 
            int maxCnt = getMaxDataCount("IGFXK0301");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            
            //DTO��������趨
            dto.setMaxSearchCount(maxCnt);
            
            dto.setPagingDto(pDto);
            //����bl �������ݴ���
            dto=ctrlBL.searchRiskproAction(dto);
            //ʵ����vo
            IGFXK03011VO vo = new IGFXK03011VO();
            
            //���ݷ��ظ�ҳ��
            vo.setInfomap(dto.getInfomap());
            super.<IGFXK03011VO>setVO(request, vo);
            log.debug("=======������ʾ�����ѯ�������========");
            
        }
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
        return mapping.findForward(forward);

	}

	
}
