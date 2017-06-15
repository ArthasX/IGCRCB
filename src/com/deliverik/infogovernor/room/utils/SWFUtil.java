 /*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.room.utils;

import java.io.File;
import java.io.IOException;

/**
 * @Description: SWFTools
 * 
 * @Author	wangfeng
 * @History 2013-05-29     新建 
 * @Version V1.0
 */
public class SWFUtil {

	/**
	 * PNG转换SWF
	 * 
	 * @param sourcePath  	源图片的绝对路径
	 * @param destPath		生成SWF路径
	 * @param fileName		生成SWF名称
	 * @return		0：成功，-1：失败
	 * @throws IOException
	 */
	public static int png2swf(String sourcePath, String destPath, String fileName) {

		// --------------------------------------
		// 判断SWF生成目录是否存在
		// --------------------------------------
		File dest = new File(destPath);

		// 不存在则创建
		if (!dest.exists()) {
			dest.mkdirs();
		}

		// --------------------------------------
		// 判断源图片是否存在
		// --------------------------------------
		File source = new File(sourcePath);

		// 不存在则算失败
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