package com.deliverik.framework.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.model.Attachment;

public interface FileUploadBL {

	/**
	 * 文約上传业务逻辑接口
	 *
	 * @param file 上传文約蔵綢
	 * @param path 上传文約保存目录
	 * @param fileName 上传文約名
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws BLException
	 */
	public void saveFile(FormFile file, String path,
			String fileName) throws FileNotFoundException,
			IOException, BLException;
	
	/**
	 * <p>
	 * 流程用上传附約操作，附約存放在属G晕逝渲梦募s目录的svc文約糋諫
	 * </p>
	 * 
	 * @param fileMap 存放附約的Map集合
	 * @return 附約唯一标识attkey，没覩附約返回null，与指定的历史记录关联
	 * @throws BLException
	 *
	 */

	public String uploadFile(Map<Integer, FormFile> fileMap) throws BLException;
	public String uploadFile(Map<Integer, FormFile> fileMap,String attkey) throws BLException;
	public String copyFile(List<Attachment> list,String attkey) throws BLException;
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
    public String uploadFile(FileItem item) throws BLException;
}
