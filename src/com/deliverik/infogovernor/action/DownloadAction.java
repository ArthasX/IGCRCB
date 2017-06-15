package com.deliverik.infogovernor.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.bl.task.IG611BL;
import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.entity.IG611PK;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.utility.ResourceUtility;

/**
 * 文件下载功能Action处理
 *
 * @author
 */
public class DownloadAction extends BaseAction {

	/** 文件下载处理LOG */
	static Log log = LogFactory.getLog(DownloadAction.class);
	
	/** 文件类型参数 */
	private static final String fileParam_Type  = "type";
	
	/** 配置管理文件类型 */
	private static final String FILE_TYPE_ASM  = "asm";
	
	/** 资产模型默认值文件类型 */
	private static final String FILE_TYPE_MODEL  = "model";
	
	/** 服务交付文件类型 */
	private static final String FILE_TYPE_SDL  = "sdl";
	
	/** 项目管理文件类型 */
	private static final String FILE_TYPE_PRJ  = "prj";
	
	/** 知识管理文件类型 */
	private static final String FILE_TYPE_KGM  = "kgm";
	
	/** 财务管理文件类型 */
	private static final String FILE_TYPE_FIN  = "fin";
	/** 通知管理文件类型 */
	private static final String FILE_TYPE_SYM  = "sym";
	
	/** 流程管理文件类型 */
	private static final String FILE_TYPE_SVC  = "svc";
	
	/** 风险检查文件类型 */
	private static final String FILE_TYPE_RIS  = "risk";
	
	/** 制度汇编文件类型 */
	private static final String FILE_TYPE_SYA  = "sya";

	/** 配置管理用参数 */
	private static final String ASM_FILE_EIID = "eiid";
	private static final String ASM_FILE_CIID = "ciid";
	
	/** 资产模型默认值用参数 */
	private static final String MODEL_FILE_EID = "eid";
	private static final String MODEL_FILE_CID = "cid";
	
	/** 服务交付所用参数 */
	private static final String SDL_FILE_EIID = "attId";
	
	/** 项目管理所用参数 */
	private static final String PRJ_FILE_EIID = "attId";
	
	/** 知识管理所用参数 */
	private static final String KGM_FILE_EIID = "attId";
	
	/** 财务管理所用参数 */
	private static final String FIN_FILE_EIID = "attId";
	
	/**  风险检查所用参数 */
	private static final String RIS_FILE_EIID = "attId";
	
	/** 流程管理所用参数 */
	private static final String SVC_FILE_EIID = "attId";
	/** 通知管理所用参数 */
	private static final String SYM_FILE_EIID = "attId";
	
	/** 制度汇编所用参数 */
	private static final String SYA_FILE_EIID = "attId";

	
	/**
	 * 文件下载处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		log.debug("文件下载开始");
		
		//文件类型参数取得
		String prmType = req.getParameter(fileParam_Type);
		

		
		//通知管理下载附件是从action传递参数
		if(prmType==null){
			prmType=req.getAttribute("type").toString();
		}
		
		
		//文件名取得
		String sFileName = "";
		
		//配置管理文件类型的情况
		if (prmType.toLowerCase().equals(FILE_TYPE_ASM)) {
			String eiid = req.getParameter(ASM_FILE_EIID);
			String ciid = req.getParameter(ASM_FILE_CIID);
			sFileName = getASMFileName(eiid,ciid);
		} else if (FILE_TYPE_SDL.equals(prmType)){
			String attId = req.getParameter(SDL_FILE_EIID);
			sFileName = this.getSDLFileName(attId);
		} else if (FILE_TYPE_KGM.equals(prmType)){
			String attId = req.getParameter(KGM_FILE_EIID);
			sFileName = this.getSDLFileName(attId);
		} else if (FILE_TYPE_FIN.equals(prmType)){
			String attId = req.getParameter(FIN_FILE_EIID);
			sFileName = this.getSDLFileName(attId);
		} else if (FILE_TYPE_SYM.equals(prmType)){
			String attId = req.getAttribute(SYM_FILE_EIID).toString();
			sFileName = this.getSYMFileName(attId);
		} else if (FILE_TYPE_SVC.equals(prmType)){
			String attId = req.getParameter(SVC_FILE_EIID);
			if(null == attId){
				 attId = req.getAttribute(SYM_FILE_EIID).toString();
			}
			try {
				sFileName = this.getSVCFileName(attId);
			} catch (BLException e) {
				log.debug(e.getMessage());
			}
		} else if (FILE_TYPE_PRJ.equals(prmType)){
			String attId = req.getParameter(PRJ_FILE_EIID);
			sFileName = this.getPRJFileName(attId);
		} else if (FILE_TYPE_RIS.equals(prmType)){
			String attId = req.getParameter(RIS_FILE_EIID);
			sFileName = this.getRISFileName(attId);
		} else if ("pd_export".equals(prmType)){
			sFileName = req.getParameter("filepath");
		}else if (prmType.toLowerCase().equals(FILE_TYPE_MODEL)) {
			String eid = req.getParameter(MODEL_FILE_EID);
			String cid = req.getParameter(MODEL_FILE_CID);
			sFileName = getMODELFileName(eid,cid);
		}else if (FILE_TYPE_SYA.equals(prmType)){
			String attId = req.getParameter(SYA_FILE_EIID);
			if(null == attId){
				 attId = req.getAttribute(SYM_FILE_EIID).toString();
			}
			sFileName = this.getRISFileName(attId);
		}
		
		if (StringUtils.isEmpty(sFileName)) {
			addMessage(req,new ActionMessage("IGCO10000.E010"));
			return mapping.findForward("ERR");
		}
		//文件存在检测
		File objFile = new File(sFileName);
		
		if (!objFile.exists()) {
			addMessage(req,new ActionMessage("IGCO10000.E009"));
			return mapping.findForward("ERR");
		}

		//文件下载处理
		res.reset();
		String filename = "";
		if (prmType.toLowerCase().equals(FILE_TYPE_ASM)) {
			filename = objFile.getName().substring(0,objFile.getName().lastIndexOf("_"))+objFile.getName().substring(objFile.getName().lastIndexOf("."));
		}else{
			filename = objFile.getName().substring(objFile.getName().indexOf("_")+1);
		}
		res.setContentType("binary/octet-stream");

    	res.setHeader("Content-Disposition", "attachment;filename=" + 
    			new String(filename.getBytes("gb2312"),"iso-8859-1"));
		
		// 输出流
		OutputStream output = null;
		// 输入流
		FileInputStream input = null;
		try {
			// 输出流取得
			output = res.getOutputStream();
			// 输入流取得
			input = new FileInputStream(sFileName);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
			if(req.getParameter("flag")!=null && req.getParameter("flag").equals("1")){
				/** 文件下载插入表BL*/
				req.setAttribute(ASM_FILE_EIID, req.getParameter(ASM_FILE_EIID));
				return mapping.findForward("INSERT");
			}
		} catch (Exception e) {
			log.error("DownloadAction Exception", e);
		} finally {
			try {
				// 关闭输入流
				input.close();
				input = null;
				// 关闭输出流
				output.close();
				output = null;
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			}
		}
		log.debug("文件下载终了");
		return null;
	}
	
	/**
	 * 配置管理附件文件名取得
	 * @param eiid 资产项ID
	 * @param ciid 配置项ID
	 * @return
	 */
	protected String getASMFileName(String eiid,String ciid) throws BLException {
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		StringBuffer fileNameBuf = new StringBuffer();
		
		fileNameBuf.append(rootPath);
		fileNameBuf.append(FILE_TYPE_ASM);
		fileNameBuf.append(File.separator);
		fileNameBuf.append(eiid);
		fileNameBuf.append(File.separator);

/*		IG800BL bl = (IG800BL) getBean("ig800BL");
		
		IG800Info configItem = bl.searchIG800InfoByKey(Integer.parseInt(ciid));*/
		
		SOC0107BL bl = (SOC0107BL) getBean("soc0107BL");
		
		SOC0107Info configItem = bl.searchSOC0107ByKey(Integer.parseInt(ciid));
		if ( configItem == null ) {
			return null;
		}
		String civalue = configItem.getCivalue();
		String esyscoding = configItem.getEsyscoding();
		if (esyscoding.startsWith(EntityItemKeyWords.NETWORKCI_ESYSCODING)) {
			fileNameBuf = new StringBuffer();
			fileNameBuf.append(rootPath);
			fileNameBuf.append(FILE_TYPE_ASM);
			fileNameBuf.append(File.separator);
			String[] split = civalue.split("_");
			if (split.length > 2) {
				fileNameBuf.append(split[0] + "_" + split[1]);
			}
			fileNameBuf.append(File.separator);
		}
		fileNameBuf.append(civalue);
		
		return fileNameBuf.toString();
		
	}
	
	/**
	 * 风险检查附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	protected String getRISFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	
	/**
	 * 服务交付附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	protected String getSDLFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	/**
	 * 知识管理附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	
	protected String getKGMFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	/**
	 * 财务管理附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	
	protected String getFINFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	/**
	 * 通知管理附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	
	protected String getSYMFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = "sym";
//		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	
	/**
	 * 流程管理附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	protected String getSVCFileName(String attId) throws BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	
	/**
	 * 项目管理附件文件名取得
	 * @param attId ATTACHMENT表ID
	 * @return
	 * @throws BLException 
	 */
	protected String getPRJFileName(String attId) throws  BLException{
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		
		//BL取得
		AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.valueOf(attId));
		String attURL = attachment.getAtturl();
		String attName = attachment.getAttname();
		
		StringBuilder filePathSB = new StringBuilder();
		filePathSB.append(rootPath).append(attURL).append(File.separator).append(attName);
		
		return filePathSB.toString();
	}
	
	/**
	 * 资产模型默认值附件文件名取得
	 * @param eiid 资产项ID
	 * @param ciid 配置项ID
	 * @return
	 */
	protected String getMODELFileName(String eid,String cid) throws BLException {
		
		if(StringUtils.isEmpty(eid) || StringUtils.isEmpty(cid)){
			return null;
		}
		
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		StringBuffer fileNameBuf = new StringBuffer();
		
		fileNameBuf.append(rootPath);
		fileNameBuf.append(FILE_TYPE_ASM);
		fileNameBuf.append(File.separator);
		fileNameBuf.append(FILE_TYPE_MODEL);
		fileNameBuf.append(File.separator);

		IG611BL bl = (IG611BL) getBean("ig611BL");
		IG611PK pk = new IG611PK(Integer.parseInt(eid),Integer.parseInt(cid));
		IG611Info ig611info = bl.searchIG611InfoByPK(pk);
		
		if ( ig611info == null ) {
			return null;
		}
		
		fileNameBuf.append(ig611info.getCvalue());
		
		
		return fileNameBuf.toString();
		
	}
	
}
