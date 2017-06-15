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
 * 菜单Action处理
 *
 */
public class IGCOM0202Action extends BaseAction {

    static Log log = LogFactory.getLog(IGCOM0202Action.class);

    /**
     * 菜单Action处理
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
        log.debug("========菜单处理开始 ========");

        IGCOM0202Form form = (IGCOM0202Form) actionForm;

        setLinkID(req, form.getLinkID());
        
        String actname = req.getParameter("actname");//菜单ID取得
        
        //获取菜单权限
        UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
        
        //设置高亮菜单
        if(StringUtils.isNotEmpty(actname)&& perm != null) {
            String actsortid = perm.getActsortid(actname);//获取指定菜单ID的ACTSORTID
            //110923Begin
                setSessionAttribute(req, "igactionid", actsortid);
            //110923End
            if(StringUtils.isNotEmpty(actsortid)){
                if(actsortid.length() == 2) {//点击一级菜单时需清空二级菜单session变量
                    setSessionAttribute(req, "firstactid", actsortid);
                    setSessionAttribute(req, "secondactid", null);
                } else {//点击二，三级菜单
                    
                        setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
                        setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
                }
            }
        }else if(StringUtils.isNotEmpty(req.getParameter("firstactid"))){
            setSessionAttribute(req, "firstactid", req.getParameter("firstactid"));
            setSessionAttribute(req, "secondactid", null);
        }


        log.debug("========菜单处理终了========");
        return mapping.findForward(form.getLinkID());
    }
}
