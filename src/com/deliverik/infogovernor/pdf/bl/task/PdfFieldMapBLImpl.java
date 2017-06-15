/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfFieldMapDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapTB;

/**
  * ����: PDF���������̱�ӳ���ҵ���߼�ʵ��
  * ��������: PDF���������̱�ӳ���ҵ���߼�ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfFieldMapBLImpl extends BaseBLImpl implements
		PdfFieldMapBL {

	/** PDF���������̱�ӳ���DAO�ӿ� */
	protected PdfFieldMapDAO pdfFieldMapDAO;
	
	/**
	 * PDF���������̱�ӳ���DAO�ӿ��趨
	 *
	 * @param pdfFieldMapDAO PDF���������̱�ӳ���DAO�ӿ�
	 */
	public void setPdfFieldMapDAO(PdfFieldMapDAO pdfFieldMapDAO) {
		this.pdfFieldMapDAO = pdfFieldMapDAO;
	}

	/**
	 * PDF���������̱�ӳ���ʵ��ȡ��
	 *
	 * @return PDF���������̱�ӳ���ʵ��
	 */
	public PdfFieldMapTB getPdfFieldMapTBInstance() {
		return new PdfFieldMapTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap() {
		return pdfFieldMapDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfFieldMapInfo searchPdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfFieldMapSearchCond cond) {
		return pdfFieldMapDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap(
			PdfFieldMapSearchCond cond) {
		return pdfFieldMapDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return pdfFieldMapDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfFieldMapInfo registPdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		return pdfFieldMapDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfFieldMapInfo updatePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		checkExistInstance(new PdfFieldMapPK(instance.getPdid(), instance.getPidid()));
		return pdfFieldMapDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException {
		pdfFieldMapDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		pdfFieldMapDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PdfFieldMapInfo checkExistInstance(PdfFieldMapPK pk)
		throws BLException {
		PdfFieldMapInfo instance = pdfFieldMapDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}