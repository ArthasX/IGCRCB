/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodePK;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���ҵ���߼��ӿ�
  * ��������: PDF����XML�б��ʽ���ڵ㶨���ҵ���߼��ӿ�
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public interface PdfTableNodeBL extends BaseBL {

	/**
	 * PDF����XML�б��ʽ���ڵ㶨���ʵ��ȡ��
	 *
	 * @return PDF����XML�б��ʽ���ڵ㶨���ʵ��
	 */
	public PdfTableNodeTB getPdfTableNodeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfTableNodeInfo searchPdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PdfTableNodeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PdfTableNodeInfo registPdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PdfTableNodeInfo updatePdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

}