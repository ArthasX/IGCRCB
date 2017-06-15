/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfIg599MapVWDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWTB;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼�ʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼�ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfIg599MapVWBLImpl extends BaseBLImpl implements
		PdfIg599MapVWBL {

	/** �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ� */
	protected PdfIg599MapVWDAO pdfIg599MapVWDAO;
	
	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ��趨
	 *
	 * @param pdfIg599MapVWDAO �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
	 */
	public void setPdfIg599MapVWDAO(PdfIg599MapVWDAO pdfIg599MapVWDAO) {
		this.pdfIg599MapVWDAO = pdfIg599MapVWDAO;
	}

	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��ȡ��
	 *
	 * @return �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
	 */
	public PdfIg599MapVWTB getPdfIg599MapVWTBInstance() {
		return new PdfIg599MapVWTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW() {
		return pdfIg599MapVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg599MapVWInfo searchPdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfIg599MapVWSearchCond cond) {
		return pdfIg599MapVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW(
			PdfIg599MapVWSearchCond cond) {
		return pdfIg599MapVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return pdfIg599MapVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfIg599MapVWInfo registPdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		return pdfIg599MapVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfIg599MapVWInfo updatePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		checkExistInstance(new PdfIg599MapVWPK(instance.getPrid(), instance.getPidid()));
		return pdfIg599MapVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException {
		pdfIg599MapVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		pdfIg599MapVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PdfIg599MapVWInfo checkExistInstance(PdfIg599MapVWPK pk)
		throws BLException {
		PdfIg599MapVWInfo instance = pdfIg599MapVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}