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
	
	/* 附件信息操作 */
	private AttachmentBL attachmentBL;
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 文件上传业务逻辑实现
	 * @param file 上传文件数据
	 * @param path 上传文件保存目录
	 * @param fileName 上传文件名
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

		/** 上传文件检测 */
		checkFile(file);

		/** 上传文件路径检测 */
		checkPath(path);

		/** 上传文件流取得 */
		InputStream is = file.getInputStream();
		
		/** 上传文件流缓存取得 */
		BufferedInputStream inBuffer = new BufferedInputStream(is);


		/** 上传文件保存流取得 */
		FileOutputStream out = new FileOutputStream(path + fileName);
		
		/** 上传文件保存流缓存取得 */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		
		/** 上传文件保存 */
		int contents = 0;
		
		while((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}
		
		outBuffer.flush();
		
		//文件流关闭
		inBuffer.close();
		outBuffer.close();

		file.destroy();
	}
	/**
	 * 文件复制业务逻辑实现
	 * @param srcFileName 源文件名
	 * @param destFileName 目标文件名
	 * @param rootPath 文件所操作路径
	 * @param attkey 文复制文件的数据KEY
	 *            
	 * @return 
	 * @throws BLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void copySingleFile(String srcFileName, String destFileName,String rootPath,String attkey) throws FileNotFoundException,
	IOException, BLException {

	// 目标文件
		File destFile = new File(rootPath + attkey + "_" + destFileName);
		// 源文件
		File srcFile = new File(rootPath + srcFileName);
		/** 源文件文件流取得 */
		InputStream is = new FileInputStream(srcFile);

		/** 输入文件流缓存取得 */
		BufferedInputStream inBuffer = new BufferedInputStream(is);

		/** 目标文件文件保存流取得 */
		FileOutputStream out = new FileOutputStream(destFile);

		/** 目标文件文件保存流缓存取得 */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);

		/** 复制文件保存 */
		int contents = 0;

		while ((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}

		outBuffer.flush();

		// 文件流关闭
		inBuffer.close();
		outBuffer.close();
	}
	/***
	 * 上传文件检测
	 * @param file 上传文件数据
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FormFile file) throws BLException {

		// 文件大小检查
		if (file == null || file.getFileSize() < 0.0) {
			// 
			throw new BLException("IGCO10000.E005");
		}
		// 允许上传文件最大值取得
		String maxFileSize = ResourceUtility.getString("MAX_FILE_SIZE");
		if (file.getFileSize() > Integer.parseInt(maxFileSize)) {
			// 
			throw new BLException("IGCO10000.E006", (Integer.parseInt(maxFileSize) / 1048576) + "");
		}
		// 文件扩展名检查
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
	 * 文件目录检查
	 * @param path 文件目录
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {

			// 文件路径不存在时，创建目录
			boolean ret = objFile.mkdirs();
			
			if (!ret) {
				throw new BLException("IGCO10000.E008",path);
			}
		}
	}
	
	/**
	 * <p>
	 * 检验用户是否上传了附件
	 * </p>
	 * 
	 * @param fileMap 存放附件的Map集合
	 * @return true-有附件，false-无附件
	 *
	 */

	private boolean checkFileMap(Map<Integer, FormFile> fileMap) {
		return fileMap != null && fileMap.size() > 0 ? true : false;
	}

	/**
	 * <p>
	 * 流程用上传附件操作，附件存放在属性问配置文件目录的svc文件夹中
	 * </p>
	 * 
	 * @param fileMap 存放附件的Map集合
	 * @return 附件唯一标识attkey，没有附件返回null，与指定的历史记录关联
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
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// 根目录
					pathBuilder.append(rootPath);
					// 一级菜单id
					pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
					// 文件上传处理
					try {
						saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// 上传文件名保存
					attachment.setAttname(attkey + "_" + file.getFileName());
					// 上传文件路径保存
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
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// 根目录
					pathBuilder.append(rootPath);
					// 一级菜单id
					pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
					// 文件上传处理
					try {
						saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// 上传文件名保存
					attachment.setAttname(attkey + "_" + file.getFileName());
					// 上传文件路径保存
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
	
	
	// 前处理文本域绑定附件处理
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
			// 根目录
			pathBuilder.append(rootPath);
			// 一级菜单id
			pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(
					File.separator);
			//前处理文本域附件绑定数据处理
			for (int i = 0; i < list.size(); i++) {
				String filename = list.get(i).getAttname().substring(33);
				// 前处理文件复制处理
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
				// 上传文件名保存
				attachment.setAttname(attkey + "_" + filename);
				// 上传文件路径保存
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
     * 流程用上传附件操作，附件存放在属性问配置文件目录的svc文件夹中
     * </p>
     * 
     * @param fileMap 存放附件的Map集合
     * @return 附件唯一标识attkey，没有附件返回null，与指定的历史记录关联
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
            // 上传文件存在的情况
            // 上传文件路径
            String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
            StringBuilder pathBuilder = new StringBuilder();
            // 根目录
            pathBuilder.append(rootPath);
            // 一级菜单id
            pathBuilder.append(CommonDefineUtils.APPLICATIONNAME).append(File.separator);
            // 文件上传处理
            try {
                saveFile(item, pathBuilder.toString(), attkey + "_" + item.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 上传文件名保存
            attachment.setAttname(attkey + "_" + item.getName());
            // 上传文件路径保存
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
     * 文件上传业务逻辑实现
     * @param file 上传文件数据
     * @param path 上传文件保存目录
     * @param fileName 上传文件名
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

        /** 上传文件检测 */
        checkFile(file);

        /** 上传文件路径检测 */
        checkPath(path);

        /** 上传文件流取得 */
        InputStream is = file.getInputStream();
        
        /** 上传文件流缓存取得 */
        BufferedInputStream inBuffer = new BufferedInputStream(is);


        /** 上传文件保存流取得 */
        FileOutputStream out = new FileOutputStream(path + fileName);
        
        /** 上传文件保存流缓存取得 */
        BufferedOutputStream outBuffer = new BufferedOutputStream(out);
        
        /** 上传文件保存 */
        int contents = 0;
        
        while((contents = inBuffer.read()) != -1) {
            outBuffer.write(contents);
        }
        
        outBuffer.flush();
        
        //文件流关闭
        inBuffer.close();
        outBuffer.close();
    }
    /***
	 * 上传文件检测
	 * @param file 上传文件数据
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FileItem file) throws BLException {
	    
	    // 文件大小检查
	    if (file == null || file.getSize() < 0.0) {
	        // 
	        throw new BLException("IGCO10000.E005");
	    }
	    // 允许上传文件最大值取得
	    String maxFileSize = ResourceUtility.getString("MAX_FILE_SIZE");
	    if (file.getSize() > Integer.parseInt(maxFileSize)) {
	        // 
	        throw new BLException("IGCO10000.E006", String.valueOf(Integer.parseInt(maxFileSize) / 1024 / 1024));
	    }
	    // 文件扩展名检查
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