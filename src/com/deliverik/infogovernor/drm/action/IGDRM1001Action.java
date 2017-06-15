package com.deliverik.infogovernor.drm.action;

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


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
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1001Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM10012VO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_������ϸ��Ϣ����Action����
 * </p>
 * 
 * @author zyl
 */
public class IGDRM1001Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM1001Action.class);

    /**
     * ������ϸ��Ϣ����Action����
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //FORMȡ��
        IGDRM1001Form form = (IGDRM1001Form)actionForm;
        //BLȡ��
       IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");

        //DTO����
        IGDRM10DTO dto = new IGDRM10DTO();
        
        String forward = "DISP";
        
        if( "DISP".equals(mapping.getParameter())){
            if("1".equals(req.getParameter("back"))){
                if(!"1".equals(form.getClevel())){
                    form.setCcid(form.getPccid());
                }
                form.setCid(form.getPcid());
            }else if("2".equals(req.getParameter("back"))){
                form.setClevel("1");
            }else if("3".equals(req.getParameter("back"))){
                if(!"1".equals(form.getClevel())){
                    form.setCid(form.getPcid());
                }
            }
            //������ϸ��Ϣ��ѯ���������ʾ����
            log.debug("========������ϸ��Ϣ��ѯ���������ʾ����ʼ========");
            
            //DTO��������趨
            dto.setIgdrm1001Form(form);
            //������ϸ��Ϣ���������ʾ�����߼�����
            dto = ctlBL.initIGDRM1001Action(dto);
            //��������ϸ��Ϣ��������趨��VO��
            IGDRM10011VO vo = new IGDRM10011VO(dto.getCodeCategoryDefInfo(),
                    dto.getCodeDetailDefList(),dto.getCodeDetailDef());
            
            super.<IGDRM10011VO>setVO(req.getSession(), vo);
            
            super.<IGDRM10012VO>setVO(req.getSession(),  new IGDRM10012VO(dto.getCodeCategoryDefInfo(),
                    dto.getCodeDetailDef()));

            log.debug("========������ϸ��Ϣ���������ʾ��������========");
        }
        
        if ("DELETE".equals(mapping.getParameter())){
            //������ϸɾ������
            log.debug("========������ϸɾ������ʼ========");
            //DTO��������趨
            dto.setIgdrm1001Form(form);
            //��������ɾ�������߼�����
            ctlBL.deleteCodeDetailDefAction(dto);
            
            form.setCid(null);
            
            log.debug("========������ϸɾ����������========");
        }
        if ("REALDELETE".equals(mapping.getParameter())){
            //������ϸɾ������
            log.debug("========��������ɾ������ʼ========");
            //DTO��������趨
            dto.setIgdrm1001Form(form);
            
            //��������ɾ�������߼�����
            ctlBL.realdeleteCodeDetailDefAction(dto);
            
            form.setCid(null);
            
            log.debug("========��������ɾ����������========");
        }
        if ("BACK".equals(mapping.getParameter())){
            if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
                
                if("1".equals(form.getClevel())){
                    //���ش���
                    forward = "BACK1";
                }else{
                    
                    //DTO��������趨
                	 dto.setIgdrm1001Form(form);
                    
                    //������ϸ��Ϣ���������ʾ�����߼�����
                    dto = ctlBL.initIGDRM1001BackAction(dto);
                    
                    //��������ϸ��Ϣ��������趨��VO��
                    IGDRM10011VO vo = new IGDRM10011VO(dto.getCodeCategoryDefInfo(),
                            dto.getCodeDetailDefList(),dto.getCodeDetailDef());
                    
                    super.<IGDRM10011VO>setVO(req, vo);
                    
                    super.<IGDRM10012VO>setVO(req.getSession(),  new IGDRM10012VO(dto.getCodeCategoryDefInfo(),
                            dto.getCodeDetailDef()));
                    //���ش���
                    forward = "BACK";
                }
            }

        }
        
        //�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
        }
        //���˴���
        String orgFlag = req.getParameter("orgFlag");
        req.setAttribute("orgFlag", orgFlag);
        return mapping.findForward(forward);
    }
}
