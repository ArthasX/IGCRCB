/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfTableNodeDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodePK;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���ҵ���߼�ʵ��
  * ��������: PDF����XML�б��ʽ���ڵ㶨���ҵ���߼�ʵ��
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public class PdfTableNodeBLImpl extends BaseBLImpl implements
		PdfTableNodeBL {

	/** PDF����XML�б��ʽ���ڵ㶨���DAO�ӿ� */
	protected PdfTableNodeDAO pdfTableNodeDAO;
	
	/**
	 * PDF����XML�б��ʽ���ڵ㶨���DAO�ӿ��趨
	 *
	 * @param pdfTableNodeDAO PDF����XML�б��ʽ���ڵ㶨���DAO�ӿ�
	 */
	public void setPdfTableNodeDAO(PdfTableNodeDAO pdfTableNodeDAO) {
		this.pdfTableNodeDAO = pdfTableNodeDAO;
	}

	/**
	 * PDF����XML�б��ʽ���ڵ㶨���ʵ��ȡ��
	 *
	 * @return PDF����XML�б��ʽ���ڵ㶨���ʵ��
	 */
	public PdfTableNodeTB getPdfTableNodeTBInstance() {
		return new PdfTableNodeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode() {
		return pdfTableNodeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfTableNodeInfo searchPdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfTableNodeSearchCond cond) {
		return pdfTableNodeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond) {
		return pdfTableNodeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond, int start,
			int count) {
		return pdfTableNodeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfTableNodeInfo registPdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		return pdfTableNodeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfTableNodeInfo updatePdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		checkExistInstance(new PdfTableNodePK(instance.getPdid(), instance.getDatabinding()));
		return pdfTableNodeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException {
		pdfTableNodeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		pdfTableNodeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PdfTableNodeInfo checkExistInstance(PdfTableNodePK pk)
		throws BLException {
		PdfTableNodeInfo instance = pdfTableNodeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}