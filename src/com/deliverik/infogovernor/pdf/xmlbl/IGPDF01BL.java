package com.deliverik.infogovernor.pdf.xmlbl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface IGPDF01BL  extends BaseBL {
	
    /**
     * ��ȡ�����������XML��������PDF��
     *
     * @param pdid ���̶���id
     * @param prid ����id
     * @return String ������·�����ļ���
     */
	public String createPdf(String pdid , Integer prid) throws BLException;
	
    /** 
        * ���������PDF�����ļ�
        * 
        * @param 
        * @return void
        * @throws BLException
        */
    public void toZipAndDownload(List<String> fileNames ,HttpServletResponse response) throws BLException;

    /** 
     * ����ѹ��ָ���ļ���Ŀ¼
     * @param fileNames ��Ҫ������ļ�������
     * @return void
     * @throws 
     */
     public void toZip(List<String> fileNames) throws BLException;
}
