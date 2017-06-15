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
import com.deliverik.infogovernor.fxk.bl.IGFXK03BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0302Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռƻ��޸�Action
 * </p>
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
public class IGFXK0302Action  extends BaseAction{
    /**��־����*/
    private static Log log = LogFactory.getLog(IGFXK0302Action.class);
    
	@Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("=======================�����޸�=======================");
        
        IGFXK0302Form form = (IGFXK0302Form)actionForm;
        
        IGFXK03DTO dto=new IGFXK03DTO();
        //��ȡBL�ӿ�ʵ��
        IGFXK03BL ctrlBL = (IGFXK03BL) getBean("igFXK03BL");
        //��תҳ��
        String forward = "DISP"; 
        
        dto=ctrlBL.searchUserLabelValueBean(dto);
        request.setAttribute("userLabelLst", dto.getPeo_LabelValueBean());
        //��ʼ��ҳ��
        if("DISP".equals(mapping.getParameter())){
            dto.setForm0302(form);
            dto=ctrlBL.searchFXK0302FormAction(dto);
            if("1".equals(form.getMode())){
                String par=dto.getForm0302().getRiskpeople();
                //�Ը������ַ������н�ȡ
                if(par!=null&&!"".equals(par)){
                    try{
                        par=par.split("_")[2];
                    }catch( Exception e){
                    }
                }
                form.setRiskpeople(par);
                forward="SEE";
            }else{
            	form.setRiskpeople(dto.getForm0302().getRiskpeople());
            }
            
        }
        //�޸�
        if("EDIT".equals(mapping.getParameter())){
            //��ҳ��DTOȡ��
            dto.setForm0302(form);
            dto=ctrlBL.editFXK0302FormAction(dto);
            
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
