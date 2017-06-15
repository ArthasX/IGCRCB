package com.deliverik.infogovernor.pdf.xmlbl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface IGPDF01BL  extends BaseBL {
	
    /**
     * 读取流程数据填充XML并导出到PDF中
     *
     * @param pdid 流程定义id
     * @param prid 流程id
     * @return String 报表导出路径和文件名
     */
	public String createPdf(String pdid , Integer prid) throws BLException;
	
    /** 
        * 打包并下载PDF报表文件
        * 
        * @param 
        * @return void
        * @throws BLException
        */
    public void toZipAndDownload(List<String> fileNames ,HttpServletResponse response) throws BLException;

    /** 
     * 批量压缩指定文件或目录
     * @param fileNames 将要打包的文件名集合
     * @return void
     * @throws 
     */
     public void toZip(List<String> fileNames) throws BLException;
}
