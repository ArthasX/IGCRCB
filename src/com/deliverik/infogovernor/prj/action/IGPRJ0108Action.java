/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.vo.IGPRJ0101VO;
import com.deliverik.infogovernor.xls.prj.bl.IGPRJ0108ExcelBL;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0108ExcelDTO;

/**
 * ����: ��Ŀ��־����Action����
 * ������������Ŀ��־����Action����
 * �޸ļ�¼��
 */

public class IGPRJ0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRJ0108Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//��ȡBL�ӿ�ʵ��
		IGPRJ01BL ctlBL = (IGPRJ01BL) getBean("igprj01BL");
		//DTO����
		IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
		//ʵ����FORM
		IGPRJ0101DetailForm  form = (IGPRJ0101DetailForm)actionForm;
		if("EXPORT".equals(mapping.getParameter())){
			igprj01dto.setProjectId(form.getPid().toString());
			 log.debug("========��Ŀ��־���ش���ʼ========");
			//��ѯ��Ŀ��־
			igprj01dto = ctlBL.findAllProject(igprj01dto);
			// ������DTO
			IGPRJ0108ExcelDTO excelDTO = new IGPRJ0108ExcelDTO();
			// ���������
			//excelDTO.setResponse(res);
			// ����ģ���ʶ
			excelDTO.setFileid("PRJ0108");
			// ���õ�������
			excelDTO.setHistoryVOs(igprj01dto.getHistoryVOs());
			excelDTO.setCodeDetailList(igprj01dto.getCodeDetailList());
			// ģ�嵼������
			IGPRJ0108ExcelBL excelBL = (IGPRJ0108ExcelBL) getBean("igprj0108ExcelBL");
			excelBL.initExcelToDownZip(excelDTO);
	       
	        req.setAttribute("form", form);
			
			//�ļ����ڼ��
			String sFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog.zip";
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
			log.debug("========��Ŀ��־���ش�������========");
	        return null;
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ŀ��־����ѯ��ϸ��Ϣ��������========");
			igprj01dto.setPlid(form.getPlid());
			igprj01dto.setProjectType(form.getPltype());
			igprj01dto.setProjectId(String.valueOf(form.getPid()));
			igprj01dto = ctlBL.searchProjectLogTypeMessage(igprj01dto);
			IGPRJ0101VO vo = new IGPRJ0101VO();
			if(igprj01dto.getPlcList()!=null){				
				vo.setPlcList(igprj01dto.getPlcList());
				vo.setPbsummaryList(igprj01dto.getPbsummaryList());
			}
			if(igprj01dto.getPlbList()!=null){
				vo.setPlbList(igprj01dto.getPlbList());
			}
			super.<IGPRJ0101VO>setVO(req, vo);
			log.debug("========��Ŀ��־����ѯ��ϸ��Ϣ��������========");
		}
		return mapping.findForward("DISP");
	}

}
