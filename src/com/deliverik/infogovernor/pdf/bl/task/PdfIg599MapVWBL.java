/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWTB;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼��ӿ�
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼��ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfIg599MapVWBL extends BaseBL {

	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��ȡ��
	 *
	 * @return �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
	 */
	public PdfIg599MapVWTB getPdfIg599MapVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg599MapVWInfo searchPdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfIg599MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW(
			PdfIg599MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW(
			PdfIg599MapVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfIg599MapVWInfo registPdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfIg599MapVWInfo updatePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException;

}