package com.deliverik.infogovernor.ueditor;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;



import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.mail.util.BASE64DecoderStream;

import sun.misc.BASE64Decoder;
/**
 * UEditor�ļ��ϴ�������
 *
 */
public class Uploader {
	static Log log = LogFactory.getLog(Uploader.class);
	
	// ����ļ���ַ
	private String url = "";
	// �ϴ��ļ���
	private String fileName = "";
	// ״̬
	private String state = "";
	// �ļ�����
	private String type = "";
	// ԭʼ�ļ���
	private String originalName = "";
	// �ļ���С
	private String size = "";

	private HttpServletRequest request = null;
	private String title = "";

	// ����·��
	private String savePath = "upload";
	// �ļ������ʽ
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	// �ļ���С���ƣ���λKB
	private int maxSize = 10000;
	
	private HashMap<String, String> errorInfo = new HashMap<String, String>();

	public Uploader(HttpServletRequest request) {
		this.request = request;
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); //Ĭ�ϳɹ�
		tmp.put("NOFILE", "δ�����ļ��ϴ���");
		tmp.put("TYPE", "��������ļ���ʽ");
		tmp.put("SIZE", "�ļ���С��������");
		tmp.put("ENTYPE", "��������ENTYPE����");
		tmp.put("REQUEST", "�ϴ������쳣");
		tmp.put("IO", "IO�쳣");
		tmp.put("DIR", "Ŀ¼����ʧ��");
		tmp.put("UNKNOWN", "δ֪����");
	
	}

	public void upload() throws Exception {
		log.debug("================== �ϴ��ļ���ʼ ===================");
		boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
		if (!isMultipart) {
			this.state = this.errorInfo.get("NOFILE");
			return;
		}
		DiskFileItemFactory dff = new DiskFileItemFactory();
		String savePath = this.getFolder(this.savePath);
		dff.setRepository(new File(savePath));
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(this.maxSize * 1024);
			sfu.setHeaderEncoding("utf-8");
			FileItemIterator fii = sfu.getItemIterator(this.request);
			while (fii.hasNext()) {
				FileItemStream fis = fii.next();
				if (!fis.isFormField()) {
					this.originalName = fis.getName().substring(fis.getName().lastIndexOf(System.getProperty("file.separator")) + 1);
					if (!this.checkFileType(this.originalName)) {
						this.state = this.errorInfo.get("TYPE");
						continue;
					}
					this.fileName = this.getName(this.originalName);
					this.type = this.getFileExt(this.fileName);
					this.url = savePath + File.separator + this.fileName;
					BufferedInputStream in = new BufferedInputStream(fis.openStream());
					FileOutputStream out = new FileOutputStream(new File(this.getPhysicalPath(this.url)));
//					FileOutputStream out = new FileOutputStream(new File(this.url));
					BufferedOutputStream output = new BufferedOutputStream(out);
					Streams.copy(in, output, true);
					this.state=this.errorInfo.get("SUCCESS");
					//UE��ֻ�ᴦ�����ϴ�����ɺ��˳�
					break;
				} else {
					String fname = fis.getFieldName();
					//ֻ����title������������д���
					if(!fname.equals("pictitle")){
						continue;
					}
                    BufferedInputStream in = new BufferedInputStream(fis.openStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer result = new StringBuffer();  
                    while (reader.ready()) {  
                        result.append((char)reader.read());  
                    }
                    this.title = new String(result.toString().getBytes(),"utf-8");
                    reader.close();  
                    
				}
			}
		} catch (SizeLimitExceededException e) {
			log.error("�ϴ�ʧ��",e);
			this.state = this.errorInfo.get("SIZE");
		} catch (InvalidContentTypeException e) {
			log.error("�ϴ�ʧ��",e);
			this.state = this.errorInfo.get("ENTYPE");
		} catch (FileUploadException e) {
			log.error("�ϴ�ʧ��",e);
			this.state = this.errorInfo.get("REQUEST");
		} catch (Exception e) {
			log.error("�ϴ�ʧ��",e);
			this.state = this.errorInfo.get("UNKNOWN");
		}
		log.debug("================== �ϴ��ļ����� ===================");
	}
	
	/**
	 * ���ܲ�������base64��ʽ�ϴ����ļ�
	 * @param fieldName
	 */
	public void uploadBase64(String fieldName){
		log.debug("================== ���ܲ�������base64��ʽ�ϴ����ļ���ʼ ===================");
		String savePath = this.getFolder(this.savePath);
		String base64Data = this.request.getParameter(fieldName);
		this.fileName = this.getName("test.png");
		this.url = savePath + "/" + this.fileName;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(this.getPhysicalPath(this.url));
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
			this.state=this.errorInfo.get("SUCCESS");
		} catch (Exception e) {
			this.state = this.errorInfo.get("IO");
			log.error("�ϴ�ʧ��", e);
		}
		log.debug("================== ���ܲ�������base64��ʽ�ϴ����ļ����� ===================");
	}

	/**
	 * �ļ������ж�
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ȡ�ļ���չ��
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * ����ԭʼ�ļ����������ļ���
	 * @return
	 */
	private String getName(String fileName) {
		Random random = new Random();
		fileName =  this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(fileName);
		log.debug(" =============== ���ļ��� :" + fileName + "===================== ");
		return fileName;
	}

	/**
	 * �����ַ�����������Ŀ¼ ���������ڽ�����Ŀ¼����
	 * @param path 
	 * @return 
	 */
	private String getFolder(String path) {
//		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
//		path += File.separator + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	/**
	 * ���ݴ��������·����ȡ����·��
	 * 
	 * @param path
	 * @return
	 */
	private String getPhysicalPath(String path) {
		
		String servletPath = this.request.getServletPath();
		String realPath = this.request.getSession().getServletContext()
				.getRealPath(servletPath);
		log.debug("================== �ļ��ϴ�·����" + realPath + " ========================");
//		return new File(realPath).getParent() + File.separator +path;
		return path;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public String getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}
}
