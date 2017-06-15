package com.deliverik.infogovernor.prd.action;

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 业务连续性 流程定义flex 上传附件Action post方式
 * @author wyw
 * </p>
 * @version 1.0
 */
public class IGPRD0310Action extends BaseAction {

    static Log log = LogFactory.getLog(IGPRD0310Action.class);
    // 限制文件的上传大小 
    private final int maxPostSize = 100 * 1024 * 1024;  //最大100M
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
      //BL取得
        IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
        //实例化dto
        IGPRD03DTO dto = new IGPRD03DTO();
        
        
        String forward = "DISP";

        if( "DISP".equals(mapping.getParameter())){
            
        }
        if( "UPLOAD".equals(mapping.getParameter())){
            
            log.info("流形式上传文件开始！");
            res.setContentType("text/html;charset=UTF-8"); 
            //保存文件到服务器中 
            DiskFileItemFactory factory = new DiskFileItemFactory(); 
            factory.setSizeThreshold(4096); 
            ServletFileUpload upload = new ServletFileUpload(factory); 
            upload.setHeaderEncoding("utf-8");
            upload.setSizeMax(maxPostSize); 
            String message= "";
            try { 
               @SuppressWarnings("unchecked")
            List<FileItem> fileItems = upload.parseRequest(req);
               if(fileItems==null){//包含报文头部，包含报文尾部，中间为文件
                   message= "上传失败！";
               }else{
                   int count=0;
                   String filename="";
                   for(FileItem item:fileItems){
                       if(!item.isFormField()){
                           dto.setFileItem(item);
                           count++;
                           filename=item.getName();
                       }
                   }
                   if(count==1){
                       ctlBL.flexUploadFile(dto);
                       message="上传成功#"+dto.getAttKey()+"#"+filename;
                   }else{
                       message= "上传失败！";
                   }
               }
           } catch (FileUploadException e) { 
               log.error(e);
               log.error("severlet 上传附件因为异常结束！");
               message="上传失败！";
           }
//           PrintWriter out = null;
//           out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
//           out.print(message);
           res.getWriter().write(message);
           log.info("流形式上传文件结束！");
           return mapping.findForward(null);
        }
       
        //逻辑处理过程中的信息显示
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
            
        }
        return mapping.findForward(forward);
    }
}
