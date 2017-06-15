 /*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.room.utils;

import java.io.File;
import java.io.IOException;

/**
 * @Description: SWFTools
 * 
 * @Author	wangfeng
 * @History 2013-05-29     �½� 
 * @Version V1.0
 */
public class SWFUtil {

	/**
	 * PNGת��SWF
	 * 
	 * @param sourcePath  	ԴͼƬ�ľ���·��
	 * @param destPath		����SWF·��
	 * @param fileName		����SWF����
	 * @return		0���ɹ���-1��ʧ��
	 * @throws IOException
	 */
	public static int png2swf(String sourcePath, String destPath, String fileName) {

		// --------------------------------------
		// �ж�SWF����Ŀ¼�Ƿ����
		// --------------------------------------
		File dest = new File(destPath);

		// �������򴴽�
		if (!dest.exists()) {
			dest.mkdirs();
		}

		// --------------------------------------
		// �ж�ԴͼƬ�Ƿ����
		// --------------------------------------
		File source = new File(sourcePath);

		// ����������ʧ��
		if (!source.exists()) {
			return -1;
		}

		String command = "png2swf " + sourcePath + " -o " + destPath + fileName;

		ExecScriptUtil execUtil = new ExecScriptUtil();
//		execUtil.setExecLogPath("");
		
		try {
			execUtil.exec(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}