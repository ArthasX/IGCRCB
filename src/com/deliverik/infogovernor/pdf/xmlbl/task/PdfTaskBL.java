package com.deliverik.infogovernor.pdf.xmlbl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ����: PDF����TaskBL�����ӿ�
 * ����������PDF����TaskBL�����ӿ�
 * �����ˣ�deliverik
 * ������¼��2013-7-26
 * �޸ļ�¼��
 */
public interface PdfTaskBL extends BaseBL{
    
	/**
	 * ��ȡ������ݺ��XML����
	 * @param prid
	 * @return Document
	 * @throws BLException
	 */
    public String getXmlFilledData(Integer prid, String pdid, String xmlName) throws BLException;
    /**
     * ��ȡ������ݺ��XML����
     * TQ3ר��
     * @param prid ����ID
     * @param pdid ���̶���ID
     * @param xmlName xml�ļ���
     * @return Document
     * @throws BLException
     */
    public String getXmlFilledDataForTQ3(Integer prid, String pdid, String xmlName) throws BLException;
}
