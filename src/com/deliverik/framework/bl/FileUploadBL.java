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
	 * �ļs�ϴ�ҵ���߼��ӿ�
	 *
	 * @param file �ϴ��ļs�i�I
	 * @param path �ϴ��ļs����Ŀ¼
	 * @param fileName �ϴ��ļs��
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
	 * �������ϴ����s���������s�������G��������ļsĿ¼��svc�ļs�G�G
	 * </p>
	 * 
	 * @param fileMap ��Ÿ��s��Map����
	 * @return ���sΨһ��ʶattkey��û�G���s����null����ָ������ʷ��¼����
	 * @throws BLException
	 *
	 */

	public String uploadFile(Map<Integer, FormFile> fileMap) throws BLException;
	public String uploadFile(Map<Integer, FormFile> fileMap,String attkey) throws BLException;
	public String copyFile(List<Attachment> list,String attkey) throws BLException;
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
    public String uploadFile(FileItem item) throws BLException;
}
