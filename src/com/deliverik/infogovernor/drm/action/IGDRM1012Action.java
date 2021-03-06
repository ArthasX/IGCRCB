package com.deliverik.infogovernor.drm.action;

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.sym.bl.IGSYM15BL;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.vo.IGSYM15021VO;
import com.deliverik.infogovernor.sym.vo.IGSYM15022VO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据详细信息画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class IGDRM1012Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM1012Action.class);

    /**
     * 数据详细信息画面Action处理
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
        //FORM取得
        IGSYM1502Form form = (IGSYM1502Form)actionForm;
        //BL取得
        IGSYM15BL ctlBL = (IGSYM15BL) getBean("igsym15BL");
        
        //DTO生成
        IGSYM15DTO dto = new IGSYM15DTO();
        
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
            //数据详细信息查询画面初期显示处理
            log.debug("========数据详细信息查询画面初期显示处理开始========");
            
            //DTO输入参数设定
            dto.setIgsym1502Form(form);
            
            //数据详细信息画面初期显示处理逻辑调用
            dto = ctlBL.initIGSYM1502Action(dto);

            //将数据详细信息检索结果设定到VO中
            IGSYM15021VO vo = new IGSYM15021VO(dto.getCodeCategoryDefInfo(),
                    dto.getCodeDetailDefList(),dto.getCodeDetailDef());
            
            super.<IGSYM15021VO>setVO(req.getSession(), vo);
            
            super.<IGSYM15022VO>setVO(req.getSession(),  new IGSYM15022VO(dto.getCodeCategoryDefInfo(),
                    dto.getCodeDetailDef()));

            log.debug("========数据详细信息画面初期显示处理终了========");
        }
        
        if ("DELETE".equals(mapping.getParameter())){
            //数据详细删除处理
            log.debug("========数据详细删除处理开始========");
            //DTO输入参数设定
            dto.setIgsym1502Form(form);
            
            //数据配置删除处理逻辑调用
            ctlBL.deleteCodeDetailDefAction(dto);
            
            form.setCid(null);
            
            log.debug("========数据详细删除处理终了========");
        }
        if ("REALDELETE".equals(mapping.getParameter())){
            //数据详细删除处理
            log.debug("========数据物理删除处理开始========");
            //DTO输入参数设定
            dto.setIgsym1502Form(form);
            
            //数据配置删除处理逻辑调用
            ctlBL.realdeleteCodeDetailDefAction(dto);
            
            form.setCid(null);
            
            log.debug("========数据物理删除处理终了========");
        }
        if ("BACK".equals(mapping.getParameter())){
            if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
                
                if("1".equals(form.getClevel())){
                    //返回处理
                    forward = "BACK1";
                }else{
                    
                    //DTO输入参数设定
                    dto.setIgsym1502Form(form);
                    
                    //数据详细信息画面初期显示处理逻辑调用
                    dto = ctlBL.initIGSYM1502BackAction(dto);
                    
                    //将数据详细信息检索结果设定到VO中
                    IGSYM15021VO vo = new IGSYM15021VO(dto.getCodeCategoryDefInfo(),
                            dto.getCodeDetailDefList(),dto.getCodeDetailDef());
                    
                    super.<IGSYM15021VO>setVO(req, vo);
                    
                    super.<IGSYM15022VO>setVO(req.getSession(),  new IGSYM15022VO(dto.getCodeCategoryDefInfo(),
                            dto.getCodeDetailDef()));
                    //返回处理
                    forward = "BACK";
                }
            }

        }
        
        //逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();
        
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
            
        }
        //过滤处理
        String orgFlag = req.getParameter("orgFlag");
        req.setAttribute("orgFlag", orgFlag);
        return mapping.findForward(forward);
    }
}
