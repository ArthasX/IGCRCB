/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfConfigrationDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfConfigrationTB;

/**
  * ����: �����ӦBL��ģ���������ñ�ҵ���߼�ʵ��
  * ��������: �����ӦBL��ģ���������ñ�ҵ���߼�ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfConfigrationBLImpl extends BaseBLImpl implements
		PdfConfigrationBL {

	/** �����ӦBL��ģ���������ñ�DAO�ӿ� */
	protected PdfConfigrationDAO pdfConfigrationDAO;
	
	/**
	 * �����ӦBL��ģ���������ñ�DAO�ӿ��趨
	 *
	 * @param pdfConfigrationDAO �����ӦBL��ģ���������ñ�DAO�ӿ�
	 */
	public void setPdfConfigrationDAO(PdfConfigrationDAO pdfConfigrationDAO) {
		this.pdfConfigrationDAO = pdfConfigrationDAO;
	}

	/**
	 * �����ӦBL��ģ���������ñ�ʵ��ȡ��
	 *
	 * @return �����ӦBL��ģ���������ñ�ʵ��
	 */
	public PdfConfigrationTB getPdfConfigrationTBInstance() {
		return new PdfConfigrationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration() {
		return pdfConfigrationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfConfigrationInfo searchPdfConfigrationByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfConfigrationSearchCond cond) {
		return pdfConfigrationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration(
			PdfConfigrationSearchCond cond) {
		return pdfConfigrationDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return pdfConfigrationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfConfigrationInfo registPdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		return pdfConfigrationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfConfigrationInfo updatePdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		checkExistInstance(instance.getPdid());
		return pdfConfigrationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfConfigrationByPK(String pk)
		throws BLException {
		pdfConfigrationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		pdfConfigrationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PdfConfigrationInfo checkExistInstance(String pk)
		throws BLException {
		PdfConfigrationInfo instance = pdfConfigrationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}