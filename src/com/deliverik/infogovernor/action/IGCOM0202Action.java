package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.form.IGCOM0202Form;

/**
 * �˵�Action����
 *
 */
public class IGCOM0202Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCOM0202Action.class);

    /**
     * �˵�Action����
     *
     * @param mapping 
     * @param actionForm 
     * @param req 
     * @param res 
     * @return 
     * @throws Exception 
     */
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
        //
        clearSessionFormData(req);
        log.debug("========�˵�����ʼ ========");

        IGCOM0202Form form = (IGCOM0202Form) actionForm;

        setLinkID(req, form.getLinkID());
        
        String actname = req.getParameter("actname");//�˵�IDȡ��
        
        //��ȡ�˵�Ȩ��
        UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
        
        //���ø����˵�
        if(StringUtils.isNotEmpty(actname)&& perm != null) {
            String actsortid = perm.getActsortid(actname);//��ȡָ���˵�ID��ACTSORTID
            //110923Begin
                setSessionAttribute(req, "igactionid", actsortid);
            //110923End
            if(StringUtils.isNotEmpty(actsortid)){
                if(actsortid.length() == 2) {//���һ���˵�ʱ����ն����˵�session����
                    setSessionAttribute(req, "firstactid", actsortid);
                    setSessionAttribute(req, "secondactid", null);
                } else {//������������˵�
                    
                        setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
                        setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
                }
            }
        }else if(StringUtils.isNotEmpty(req.getParameter("firstactid"))){
            setSessionAttribute(req, "firstactid", req.getParameter("firstactid"));
            setSessionAttribute(req, "secondactid", null);
        }


        log.debug("========�˵���������========");
        return mapping.findForward(form.getLinkID());
    }
}
