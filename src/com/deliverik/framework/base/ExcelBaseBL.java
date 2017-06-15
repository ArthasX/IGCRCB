/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.base;

/**
 * ����: Excel����ͨ��ҵ��BL�ӿ�
 * ��������: Excel����ͨ��ҵ��BL�ӿ�
 * ������¼:
 * �޸ļ�¼: 
 */
public interface ExcelBaseBL extends BaseBL {

	/**
	 * ��ʼ��Excel
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException;
	
	/**
	 * ��ʼ��Excel��ͷ����
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException;
	
	/**
	 * ��ʼ��Excel����������
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException;
	
	/**
	 * ��ʼ��Excel��ײ�����
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initFooter(ExcelDTO dto) throws BLException;
	
}
