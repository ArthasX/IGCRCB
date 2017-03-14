package com.deliverik.infogovernor.prd.action;

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ҵ�������� ���̶���flex �ϴ�����Action post��ʽ
 * @author wyw
 * </p>
 * @version 1.0
 */
public class IGPRD0310Action extends BaseAction {

    static Log log = LogFactory.getLog(IGPRD0310Action.class);
    // �����ļ����ϴ���С 
    private final int maxPostSize = 100 * 1024 * 1024;  //���100M
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
      //BLȡ��
        IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
        //ʵ����dto
        IGPRD03DTO dto = new IGPRD03DTO();
        
        
        String forward = "DISP";

        if( "DISP".equals(mapping.getParameter())){
            
        }
        if( "UPLOAD".equals(mapping.getParameter())){
            
            log.info("����ʽ�ϴ��ļ���ʼ��");
            res.setContentType("text/html;charset=UTF-8"); 
            //�����ļ����������� 
            DiskFileItemFactory factory = new DiskFileItemFactory(); 
            factory.setSizeThreshold(4096); 
            ServletFileUpload upload = new ServletFileUpload(factory); 
            upload.setHeaderEncoding("utf-8");
            upload.setSizeMax(maxPostSize); 
            String message= "";
            try { 
               @SuppressWarnings("unchecked")
            List<FileItem> fileItems = upload.parseRequest(req);
               if(fileItems==null){//��������ͷ������������β�����м�Ϊ�ļ�
                   message= "�ϴ�ʧ�ܣ�";
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
                       message="�ϴ��ɹ�#"+dto.getAttKey()+"#"+filename;
                   }else{
                       message= "�ϴ�ʧ�ܣ�";
                   }
               }
           } catch (FileUploadException e) { 
               log.error(e);
               log.error("severlet �ϴ�������Ϊ�쳣������");
               message="�ϴ�ʧ�ܣ�";
           }
//           PrintWriter out = null;
//           out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
//           out.print(message);
           res.getWriter().write(message);
           log.info("����ʽ�ϴ��ļ�������");
           return mapping.findForward(null);
        }
       
        //�߼���������е���Ϣ��ʾ
        List<ActionMessage> messageList = dto.getMessageList();
        if( messageList != null && messageList.size() > 0 ) {
            for (ActionMessage message : messageList) { 
                addMessage(req, message);
            }
            
        }
        return mapping.findForward(forward);
    }
}
