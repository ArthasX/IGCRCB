/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWTB;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼��ӿ�
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼��ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfIg898MapVWBL extends BaseBL {

	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��ȡ��
	 *
	 * @return �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
	 */
	public PdfIg898MapVWTB getPdfIg898MapVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg898MapVWInfo searchPdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfIg898MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW(
			PdfIg898MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW(
			PdfIg898MapVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfIg898MapVWInfo registPdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfIg898MapVWInfo updatePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException;

	/**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
    public String getMaxRowNumber(PdfIg898MapVWSearchCond cond) 
        throws BLException;
}