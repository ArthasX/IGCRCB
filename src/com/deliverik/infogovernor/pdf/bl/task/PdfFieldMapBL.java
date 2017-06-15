/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapTB;

/**
  * ����: PDF���������̱�ӳ���ҵ���߼��ӿ�
  * ��������: PDF���������̱�ӳ���ҵ���߼��ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfFieldMapBL extends BaseBL {

	/**
	 * PDF���������̱�ӳ���ʵ��ȡ��
	 *
	 * @return PDF���������̱�ӳ���ʵ��
	 */
	public PdfFieldMapTB getPdfFieldMapTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfFieldMapInfo searchPdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfFieldMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap(
			PdfFieldMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap(
			PdfFieldMapSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfFieldMapInfo registPdfFieldMap(PdfFieldMapInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfFieldMapInfo updatePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException;

}