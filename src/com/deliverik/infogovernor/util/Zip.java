/**   
* @Title: Zip.java 
* @Package com.deliverik.infogovernor.util 
* @Description: TODO
* @author 
* @date 2013-8-21 上午10:53:50 
* @version 
*/
package com.deliverik.infogovernor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 概述: 
 * 功能描述：
 * 创建人：
 * 创建记录：2013-8-21
 * 修改记录：
 */
public class Zip {

    /**
     * 将文件进行压缩.
     * 
     * @param zipFileName
     *            压缩后的ZIP文件名.
     * @param inputFileName
     *            要压缩的文件名或文件目录名.
     * @return 压缩后的文件.
     */
    public static void toZip(String zipFileName, String inputFileName)
            throws Exception {
        toZip(zipFileName, new File(inputFileName), false);
    }
    
    /**
     * 将文件进行压缩.
     * 
     * @param zipFileName
     *            压缩后的ZIP文件名.
     * @param inputFileNames
     *            要压缩的文件名或文件目录名集合.
     * @return 压缩后的文件.
     */
    public static void toZip(String zipFileName, List<String> inputFileNames)
            throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                zipFileName));
        out.setEncoding("GBK");
        for (String ifn : inputFileNames) {
            File inputFile = new File(ifn);
            String base = "";
            if(!inputFile.isDirectory()) {
                base = inputFile.getName();
            }
            toZip(out, inputFile, base, zipFileName);
        }
        out.flush();
        out.close();

    }

    /**
     * 将文件进行压缩.
     * 
     * @param zipFileName
     *            压缩后的ZIP文件名.
     * @param inputFile
     *            要压缩的文件或文件目录.
     * @return 压缩后的文件.
     * @throws Exception
     *             一些常规的IO异常信息.
     */
    public static void toZip(String zipFileName, File inputFile, boolean isContenFirstDir)
            throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                zipFileName));
        String base = "";
        if(!inputFile.isDirectory()) {
            base = inputFile.getName();
            if(isContenFirstDir) {
                File f = inputFile.getParentFile();
            }
        }
        toZip(out, inputFile, base, zipFileName);
        out.flush();
        out.close();
    }

    /**
     * 将文件进行压缩.
     * 
     * @param outputStream
     * @param file
     *            要压缩的文件或文件目录.
     * @param base
     *            文件夹中子目录名称.
     * @param zipFileName
     *            压缩后的ZIP文件名.
     * @return 压缩后的文件.
     * @throws Exception
     *             一些常规的IO异常信息.
     */
    public static void toZip(ZipOutputStream outputStream, File file,
            String base, String zipFileName) throws Exception {
        if (file.isDirectory()) {
            File[] fl = file.listFiles();
            outputStream.putNextEntry(new ZipEntry(base
                    + "/"));

            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                if(fl[i].getName().equals(new File(zipFileName).getName())) {
                    continue;
                }
                toZip(outputStream, fl[i], base + fl[i].getName(), zipFileName);
            }
        } else {
            outputStream.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(file);
            int b;
            while ((b = in.read()) != -1) {
                outputStream.write(b);
            }
            in.close();
        }
    }

//    public static void main(String args[]) {
//        String file1 = "C:/file/IG/PdfResults/a.zip";
//        List<String> fileNames = new ArrayList<String>();
//        fileNames.add("C:/file/IG/PdfResults/T-A-2 重大突发事件报告表_11A.pdf");
//        fileNames.add("C:/file/IG/PdfResults/T-A-4 数据中心设立报告表_11A.pdf");
//        fileNames.add("C:/file/IG/PdfResults/T-A-5 数据中心变更报告表_11A.pdf");
//        try {
//            toZip(file1, fileNames);
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
//    }
}
