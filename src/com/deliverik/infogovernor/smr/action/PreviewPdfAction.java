/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLError;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.pdf.xmlbl.IGPDF01BL;
import com.deliverik.infogovernor.smr.form.PreviewPdfForm;

/**
 * ����:��ܱ���Ԥ������action
 * ������������ܱ���Ԥ������action
 * ������¼�� 2013/09/09
 * �޸ļ�¼��
 */
public class PreviewPdfAction extends BaseAction{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(PreviewPdfAction.class);
	
	/**
	 * ��ܱ���Ԥ������
	  */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	    //������BLȡ��
        IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
		PreviewPdfForm form = (PreviewPdfForm) actionForm;
		if( "PREVIEW".equals(mapping.getParameter())){
            log.debug("==================����Ԥ��������ʼ=====================");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            OutputStream os = null;
            InputStream is = null;
            //���ɱ����ļ�
            try {
                String fileName = igPDF01BL.createPdf(form.getPdid(), form.getPrid());
                //����������ǰ̨Ԥ��
                 File file = new File(fileName);
                 is = new FileInputStream(file);
                 bis = new BufferedInputStream(is);
                 os = response.getOutputStream();
                 bos = new BufferedOutputStream(os);
                 response.setContentType("application/pdf");
                 response.setHeader("Expires", "0");      
                 response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");   
                 response.setHeader("Pragma", "public");   
                 int bytesRead = 0;
                 byte[] buffer = new byte[8192];
                 while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
                     bos.write(buffer, 0, bytesRead);
                 }
            } catch (BLException e) {
                BLError  blerror = e.getErrors().get(0);
                addMessage(request, new ActionMessage(blerror.getKey(), blerror.getMParam()[0]));
            } catch (Exception e) {
                addMessage(request, new ActionMessage("IGPDF0101.E006"));
            } finally {
                if (bos!=null) {
                    bos.flush();
                }
                if (is!=null) {
                    is.close();
                }
                if(bis!=null) {
                    bis.close();
                }
                if (os!=null) {
                    os.close();
                }
                if (bos!=null) {
                    bos.close();
                }
            }
            log.debug("==================����Ԥ����������=====================");
        }
		return null;
	}
	
}

