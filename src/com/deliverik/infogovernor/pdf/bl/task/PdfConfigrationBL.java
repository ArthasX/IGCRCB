/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfConfigrationTB;

/**
  * ����: �����ӦBL��ģ���������ñ�ҵ���߼��ӿ�
  * ��������: �����ӦBL��ģ���������ñ�ҵ���߼��ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfConfigrationBL extends BaseBL {

	/**
	 * �����ӦBL��ģ���������ñ�ʵ��ȡ��
	 *
	 * @return �����ӦBL��ģ���������ñ�ʵ��
	 */
	public PdfConfigrationTB getPdfConfigrationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfConfigrationInfo searchPdfConfigrationByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfConfigrationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration(
			PdfConfigrationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration(
			PdfConfigrationSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfConfigrationInfo registPdfConfigration(PdfConfigrationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfConfigrationInfo updatePdfConfigration(PdfConfigrationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfConfigrationByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfConfigration(PdfConfigrationInfo instance)
		throws BLException;

}