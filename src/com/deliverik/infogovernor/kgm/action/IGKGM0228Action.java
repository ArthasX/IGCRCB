package com.deliverik.infogovernor.kgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02011VO;

public class IGKGM0228Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0228Action.class);
	
	/**
	 * ֪ʶ��������
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGKGM0228Form form = (IGKGM0228Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if( "REPORT".equals(mapping.getParameter())){
	    	

			//֪ʶ��ѯ����
			log.debug("========֪ʶ��ѯ����ʼ========");
            
			//DTO��������趨
			dto.setIgkgm0228Form(form);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.exportKnowLedgeAction(dto);
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setKnowledgeList(dto.getKnowledgelist());
			
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			
			log.debug("========֪ʶ��ѯ��������========");
			
	    }else if("DOWN".equals(mapping.getParameter())){
	    	
	    	log.debug("========֪ʶ���ش���ʼ========");
	    	dto.setSessionID(req.getSession().getId());
	    	dto = ctlBL.downKnowLedgeAction(dto);
			req.setAttribute("form", form);
			
			//�ļ����ڼ��
			String sFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"allKnowledge.zip";
			File objFile = new File(sFileName);
			
			if (!objFile.exists()) {
				addMessage(req,new ActionMessage("IGCO10000.E009"));
				return mapping.findForward("ERR");
			}
			//�ļ����ش���
			res.reset();
			res.setContentType("application/x-download;");
			try {
				String filename = "";
				filename = objFile.getName().substring(objFile.getName().indexOf("_")+1);
				
				res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				log.debug("Exception:", e1);
			}
			
			// �����
			OutputStream output = null;
			// ������
			FileInputStream input = null;
			try {
				// �����ȡ��
				output = res.getOutputStream();
				// ������ȡ��
				input = new FileInputStream(sFileName);
				int actual = 0;
				byte[] b = new byte[1024];
				
				while ((actual = input.read(b)) > 0) {
					output.write(b,0,actual);
				}

				output.flush();
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			} finally {
				try {
					// �ر�������
					input.close();
					input = null;
					// �ر������
					output.close();
					output = null;
				} catch (Exception e) {
					log.error("DownloadAction Exception", e);
				}
			}
			log.debug("========֪ʶ���ش�������========");
			return null;
	    }
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
