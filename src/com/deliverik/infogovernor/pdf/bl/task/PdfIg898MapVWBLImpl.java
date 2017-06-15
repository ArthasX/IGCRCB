/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfIg898MapVWDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWTB;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼�ʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼҵ���߼�ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfIg898MapVWBLImpl extends BaseBLImpl implements
		PdfIg898MapVWBL {

	/** �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ� */
	protected PdfIg898MapVWDAO pdfIg898MapVWDAO;
	
	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ��趨
	 *
	 * @param pdfIg898MapVWDAO �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
	 */
	public void setPdfIg898MapVWDAO(PdfIg898MapVWDAO pdfIg898MapVWDAO) {
		this.pdfIg898MapVWDAO = pdfIg898MapVWDAO;
	}

	/**
	 * �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��ȡ��
	 *
	 * @return �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
	 */
	public PdfIg898MapVWTB getPdfIg898MapVWTBInstance() {
		return new PdfIg898MapVWTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW() {
		return pdfIg898MapVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg898MapVWInfo searchPdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfIg898MapVWSearchCond cond) {
		return pdfIg898MapVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW(
			PdfIg898MapVWSearchCond cond) {
		return pdfIg898MapVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return pdfIg898MapVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfIg898MapVWInfo registPdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		return pdfIg898MapVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfIg898MapVWInfo updatePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		checkExistInstance(new PdfIg898MapVWPK(instance.getPrid(), instance.getPidid(), instance.getPvcolpidid(), instance.getPvrownumber()));
		return pdfIg898MapVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException {
		pdfIg898MapVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		pdfIg898MapVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PdfIg898MapVWInfo checkExistInstance(PdfIg898MapVWPK pk)
		throws BLException {
		PdfIg898MapVWInfo instance = pdfIg898MapVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

    /**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
    public String getMaxRowNumber(PdfIg898MapVWSearchCond cond) throws BLException {
        return pdfIg898MapVWDAO.getMaxRowNumber(cond);
    }
}