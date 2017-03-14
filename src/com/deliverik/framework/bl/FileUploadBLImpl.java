package com.deliverik.framework.bl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.fileupload.FileItem;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;

public class FileUploadBLImpl implements FileUploadBL {
	
	/* ������Ϣ���� */
	private AttachmentBL attachmentBL;
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �ļ��ϴ�ҵ���߼�ʵ��
	 * @param file �ϴ��ļ�����
	 * @param path �ϴ��ļ�����Ŀ¼
	 * @param fileName �ϴ��ļ���
	 *            
	 * @return 
	 * @throws BLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws BLException
	 */
	public void saveFile(FormFile file, String path,
			String fileName) throws FileNotFoundException,
			IOException, BLException {

		/** �ϴ��ļ���� */
		checkFile(file);

		/** �ϴ��ļ�·����� */
		checkPath(path);

		/** �ϴ��ļ���ȡ�� */
		InputStream is = file.getInputStream();
		
		/** �ϴ��ļ�������ȡ�� */
		BufferedInputStream inBuffer = new BufferedInputStream(is);


		/** �ϴ��ļ�������ȡ�� */
		FileOutputStream out = new FileOutputStream(path + fileName);
		
		/** �ϴ��ļ�����������ȡ�� */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		
		/** �ϴ��ļ����� */
		int contents = 0;
		
		while((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}
		
		outBuffer.flush();
		
		//�ļ����ر�
		inBuffer.close();
		outBuffer.close();

		file.destroy();
	}
	/**
	 * �ļ�����ҵ���߼�ʵ��
	 * @param srcFileName Դ�ļ���
	 * @param destFileName Ŀ���ļ���
	 * @param rootPath �ļ�������·��
	 * @param attkey �ĸ����ļ�������KEY
	 *            
	 * @return 
	 * @throws BLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void copySingleFile(String srcFileName, String destFileName,String rootPath,String attkey) throws FileNotFoundException,
	IOException, BLException {

	// Ŀ���ļ�
		File destFile = new File(rootPath + attkey + "_" + destFileName);
		// Դ�ļ�
		File srcFile = new File(rootPath + srcFileName);
		/** Դ�ļ��ļ���ȡ�� */
		InputStream is = new FileInputStream(srcFile);

		/** �����ļ�������ȡ�� */
		BufferedInputStream inBuffer = new BufferedInputStream(is);

		/** Ŀ���ļ��ļ�������ȡ�� */
		FileOutputStream out = new FileOutputStream(destFile);

		/** Ŀ���ļ��ļ�����������ȡ�� */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);

		/** �����ļ����� */
		int contents = 0;

		while ((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}

		outBuffer.flush();

		// �ļ����ر�
		inBuffer.close();
		outBuffer.close();
	}
	/***
	 * �ϴ��ļ����
	 * @param file �ϴ��ļ�����
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FormFile file) throws BLException {

		// �ļ���С���
		if (file == null || file.getFileSize() < 0.0) {
			// 
			throw new BLException("IGCO10000.E005");
		}
		// �����ϴ��ļ����ֵȡ��
		String maxFileSize = ResourceUtility.getString("MAX_FILE_SIZE");
		if (file.getFileSize() > Integer.parseInt(maxFileSize)) {
			// 
			throw new BLException("IGCO10000.E006", (Integer.parseInt(maxFileSize) / 1048576) + "");
		}
		// �ļ���չ�����
		String prohibitFileType = ResourceUtility.getString("PROHIBIT_FILE_TYPE").toUpperCase();
		
		String fileName = file.getFileName();
		String subFileName = null;
		if (fileName != null) {
			int point = fileName.lastIndexOf(".");
			if (point != -1) {
				subFileName = fileName.substring(point + 1).toUpperCase();
				if ( prohibitFileType.indexOf(subFileName) > -1 ) {
					// 
					throw new BLException("IGCO10000.E007",subFileName);
				}
			}
		}

	}

	/***
	 * �ļ�Ŀ¼���
	 * @param path �ļ�Ŀ¼
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {

			// �ļ�·��������ʱ������Ŀ¼
			boolean ret = objFile.mkdirs();
			
			if (!ret) {
				throw new BLException("IGCO10000.E008",path);
			}
		}
	}
	
	/**
	 * <p>
	 * �����û��Ƿ��ϴ��˸���
	 * </p>
	 * 
	 * @param fileMap ��Ÿ�����Map����
	 * @return true-�и�����false-�޸���
	 *
	 */

	private boolean checkFileMap(Map<Integer, FormFile> fileMap) {
		return fileMap != null && fileMap.size() > 0 ? true : false;
	}

	/**
	 * <p>
	 * �������ϴ�������������������������������ļ�Ŀ¼��svc�ļ�����
	 * </p>
	 * 
	 * @param fileMap ��Ÿ�����Map����
	 * @return ����Ψһ��ʶattkey��û�и�������null����ָ������ʷ��¼����
	 * @throws BLException
	 *
	 */

	public String uploadFile(Map<Integer, FormFile> fileMap) throws BLException {
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		String attkey = null;
		boolean flag = true;
		if (checkFileMap(fileMap)) {
			attkey = IGStringUtils.getAttKey();
			Set<Entry<Integer, FormFile>> entries = fileMap.entrySet();
			Iterator<Entry<Integer, FormFile>> iterator = entries.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, FormFile> entry = (Map.Entry<Integer, FormFile>) iterator.next();
				FormFile file = entry.getValue();
				if (file != null && file.getFileSize() > 0) {
					AttachmentTB attachment = attachmentBL
							.getAttachmentTBInstance();
					attachment.setAttkey(attkey);
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// ��Ŀ¼
					pathBuilder.append(rootPath);
					// һ���˵�id
					pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
					// �ļ��ϴ�����
					try {
						saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + file.getFileName());
					// �ϴ��ļ�·������
					attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
					attachmentList.add(attachment);
				}
			}
			if (attachmentList.size() > 0) {
				attachmentBL.registAttachments(attachmentList);
				flag = false;
			}
		}
		return flag ? null : attkey;
	}
	public String uploadFile(Map<Integer, FormFile> fileMap,String attkey) throws BLException {
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		boolean flag = true;
		if (checkFileMap(fileMap)) {
			Set<Entry<Integer, FormFile>> entries = fileMap.entrySet();
			Iterator<Entry<Integer, FormFile>> iterator = entries.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, FormFile> entry = (Map.Entry<Integer, FormFile>) iterator.next();
				FormFile file = entry.getValue();
				if (file != null && file.getFileSize() > 0) {
					AttachmentTB attachment = attachmentBL
							.getAttachmentTBInstance();
					attachment.setAttkey(attkey);
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// ��Ŀ¼
					pathBuilder.append(rootPath);
					// һ���˵�id
					pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
					// �ļ��ϴ�����
					try {
						saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + file.getFileName());
					// �ϴ��ļ�·������
					attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
					attachmentList.add(attachment);
				}
			}
			if (attachmentList.size() > 0) {
				attachmentBL.registAttachments(attachmentList);
				flag = false;
			}
		}
		return flag ? null : attkey;
	}
	
	
	// ǰ�����ı���󶨸�������
	public String copyFile(List<Attachment> list, String attkey)
			throws BLException {
		List<Attachment> attachmentList = new ArrayList<Attachment>();

		if (list != null) {
			if (attkey == null) {
				attkey = IGStringUtils.getAttKey();
			}
			String rootPath = ResourceUtility
					.getString("UPLOAD_FILE_ROOT_PATH");
			StringBuilder pathBuilder = new StringBuilder();
			// ��Ŀ¼
			pathBuilder.append(rootPath);
			// һ���˵�id
			pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(
					File.separator);
			//ǰ�����ı��򸽼������ݴ���
			for (int i = 0; i < list.size(); i++) {
				String filename = list.get(i).getAttname().substring(33);
				// ǰ�����ļ����ƴ���
				try {
					copySingleFile(list.get(i).getAttname(), filename,
							pathBuilder.toString(), attkey);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				AttachmentTB attachment = attachmentBL
						.getAttachmentTBInstance();
				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + filename);
				// �ϴ��ļ�·������
				attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
				attachment.setAttkey(attkey);
				attachmentList.add(attachment);
			}
			if (attachmentList.size() > 0) {
				attachmentBL.registAttachments(attachmentList);
			}
		}
		return attkey;
	}
	/**
     * <p>
     * �������ϴ�������������������������������ļ�Ŀ¼��svc�ļ�����
     * </p>
     * 
     * @param fileMap ��Ÿ�����Map����
     * @return ����Ψһ��ʶattkey��û�и�������null����ָ������ʷ��¼����
     * @throws BLException
     *
     */

    public String uploadFile(FileItem item) throws BLException {
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        String attkey = null;
        boolean flag = true;
        if (item!=null) {
            attkey = IGStringUtils.getAttKey();
            AttachmentTB attachment = attachmentBL.getAttachmentTBInstance();
            attachment.setAttkey(attkey);
            // �ϴ��ļ����ڵ����
            // �ϴ��ļ�·��
            String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
            StringBuilder pathBuilder = new StringBuilder();
            // ��Ŀ¼
            pathBuilder.append(rootPath);
            // һ���˵�id
            pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
            // �ļ��ϴ�����
            try {
                saveFile(item, pathBuilder.toString(), attkey + "_" + item.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // �ϴ��ļ�������
            attachment.setAttname(attkey + "_" + item.getName());
            // �ϴ��ļ�·������
            attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
            attachmentList.add(attachment);
            if (attachmentList.size() > 0) {
                attachmentBL.registAttachments(attachmentList);
                flag = false;
            }
        }
        return flag ? null : attkey;
    }
    /**
     * �ļ��ϴ�ҵ���߼�ʵ��
     * @param file �ϴ��ļ�����
     * @param path �ϴ��ļ�����Ŀ¼
     * @param fileName �ϴ��ļ���
     *            
     * @return 
     * @throws BLException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws BLException
     */
    public void saveFile(FileItem file, String path,
            String fileName) throws FileNotFoundException,
            IOException, BLException {

        /** �ϴ��ļ���� */
        checkFile(file);

        /** �ϴ��ļ�·����� */
        checkPath(path);

        /** �ϴ��ļ���ȡ�� */
        InputStream is = file.getInputStream();
        
        /** �ϴ��ļ�������ȡ�� */
        BufferedInputStream inBuffer = new BufferedInputStream(is);


        /** �ϴ��ļ�������ȡ�� */
        FileOutputStream out = new FileOutputStream(path + fileName);
        
        /** �ϴ��ļ�����������ȡ�� */
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        
        /** �ϴ��ļ����� */
        int contents = 0;
        
        while((contents = inBuffer.read()) != -1) {
            outBuffer.write(contents);
        }
        
        outBuffer.flush();
        
        //�ļ����ر�
        inBuffer.close();
        outBuffer.close();
    }
    /***
	 * �ϴ��ļ����
	 * @param file �ϴ��ļ�����
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FileItem file) throws BLException {
	    
	    // �ļ���С���
	    if (file == null || file.getSize() < 0.0) {
	        // 
	        throw new BLException("IGCO10000.E005");
	    }
	    // �����ϴ��ļ����ֵȡ��
	    String maxFileSize = ResourceUtility.getString("MAX_FILE_SIZE");
	    if (file.getSize() > Integer.parseInt(maxFileSize)) {
	        // 
	        throw new BLException("IGCO10000.E006", String.valueOf(Integer.parseInt(maxFileSize) / 1024 / 1024));
	    }
	    // �ļ���չ�����
	    String prohibitFileType = ResourceUtility.getString("PROHIBIT_FILE_TYPE").toUpperCase();
	    
	    String fileName = file.getName();
	    String subFileName = null;
	    if (fileName != null) {
	        int point = fileName.lastIndexOf(".");
	        if (point != -1) {
	            subFileName = fileName.substring(point + 1).toUpperCase();
	            if ( prohibitFileType.indexOf(subFileName) > -1 ) {
	                // 
	                throw new BLException("IGCO10000.E007",subFileName);
	            }
	        }
	    }
	    
	}
}