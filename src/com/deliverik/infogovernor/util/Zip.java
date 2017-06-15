/**   
* @Title: Zip.java 
* @Package com.deliverik.infogovernor.util 
* @Description: TODO
* @author 
* @date 2013-8-21 ����10:53:50 
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
 * ����: 
 * ����������
 * �����ˣ�
 * ������¼��2013-8-21
 * �޸ļ�¼��
 */
public class Zip {

    /**
     * ���ļ�����ѹ��.
     * 
     * @param zipFileName
     *            ѹ�����ZIP�ļ���.
     * @param inputFileName
     *            Ҫѹ�����ļ������ļ�Ŀ¼��.
     * @return ѹ������ļ�.
     */
    public static void toZip(String zipFileName, String inputFileName)
            throws Exception {
        toZip(zipFileName, new File(inputFileName), false);
    }
    
    /**
     * ���ļ�����ѹ��.
     * 
     * @param zipFileName
     *            ѹ�����ZIP�ļ���.
     * @param inputFileNames
     *            Ҫѹ�����ļ������ļ�Ŀ¼������.
     * @return ѹ������ļ�.
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
     * ���ļ�����ѹ��.
     * 
     * @param zipFileName
     *            ѹ�����ZIP�ļ���.
     * @param inputFile
     *            Ҫѹ�����ļ����ļ�Ŀ¼.
     * @return ѹ������ļ�.
     * @throws Exception
     *             һЩ�����IO�쳣��Ϣ.
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
     * ���ļ�����ѹ��.
     * 
     * @param outputStream
     * @param file
     *            Ҫѹ�����ļ����ļ�Ŀ¼.
     * @param base
     *            �ļ�������Ŀ¼����.
     * @param zipFileName
     *            ѹ�����ZIP�ļ���.
     * @return ѹ������ļ�.
     * @throws Exception
     *             һЩ�����IO�쳣��Ϣ.
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
//        fileNames.add("C:/file/IG/PdfResults/T-A-2 �ش�ͻ���¼������_11A.pdf");
//        fileNames.add("C:/file/IG/PdfResults/T-A-4 �����������������_11A.pdf");
//        fileNames.add("C:/file/IG/PdfResults/T-A-5 �������ı�������_11A.pdf");
//        try {
//            toZip(file1, fileNames);
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
//    }
}
