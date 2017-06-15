package com.deliverik.infogovernor.sya.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sya.bl.IGSYA01BL;
import com.deliverik.infogovernor.sya.dto.IGSYA01DTO;
import com.deliverik.infogovernor.sya.form.IGSYA0101Form;
import com.deliverik.infogovernor.sya.vo.IGSYA0101VO;

/**
 * �ƶȲ�ѯAction����
 *
 */
public class IGSYA0101Action extends BaseAction {

    static Log log = LogFactory.getLog(IGSYA0101Action.class);

    /**
     * �ƶ�Action����
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
        //ʵ����FORM
        IGSYA0101Form form = (IGSYA0101Form)actionForm;
        //�жϵ�½��ʽ
        User nowUser = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        IGSYA01DTO dto= new IGSYA01DTO();
        dto.setIgSYA0101Form(form);
        IGSYA01BL bl= (IGSYA01BL)this.getBean("igSYA01BL");
        String forward = "DISP";
        if( "DISP".equals(mapping.getParameter())){
            return mapping.findForward("DISP");
        }   
        //�û���ѯ
        if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
            log.debug("========�ƶȲ�ѯ����ʼ========");
            //��ȡ��ҳBean
            getPaginDTO(request,"IGSYA0101");

            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            
            if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGSYA0101Form) request.getSession().getAttribute("IGSYA0101Form");
                if ( form== null){
                    form = new IGSYA0101Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {
                if (request.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
                    form = new IGSYA0101Form();
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                }
            }
            
            int maxCnt = getMaxDataCount("IGSYA0101");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            dto.setUser(nowUser);
            //����BL��ѯ
            dto = bl.search(dto);
            //����VO
            IGSYA0101VO vo = new IGSYA0101VO();
            vo.setInstitutionList(dto.getInstitutionList());
            super.<IGSYA0101VO>setVO(request, vo);
            log.debug("========�ƶȲ�ѯ��������========");
        }
        //��������
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========�ƶȸ������ش���ʼ========");
			String exattkey = request.getParameter("exattkey");
			String attId=request.getParameter("attid");	
			String type="sya";
			request.setAttribute("type", type);
			request.setAttribute("attId", attId);
	
			log.debug("========�ƶȸ������ش������========");
			return mapping.findForward("LOADFILE");
		}
        List<ActionMessage> messageList = dto.getMessageList();
        
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(request, message);
            }
        }
        return mapping.findForward("DISP");
    }
}
