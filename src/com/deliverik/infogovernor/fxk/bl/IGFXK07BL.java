/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;

public interface IGFXK07BL {
	/**
	 * ��������
	 * ������ʾ���
	 * @param Riskmanagerwaring ����ʵ��
	 * @return ����ʵ��
	 */
	public IGFXK07DTO addRiskmanagerwaring(IGFXK07DTO dto)	throws BLException;
	
	/**
	 * ��ѯ���� 
	 * ������ʾ��Ϣ��ѯ
	 * @param
	 * @return ��ѯ
	 */
	public IGFXK07DTO searchRiskmanagerwaring(IGFXK07DTO dto)throws BLException;
	
	/**
	 * ��ѯ����  ͨ������rwid
	 * ������ʾ��Ϣ��ѯ
	 * @param
	 * @return ��ѯ
	 */
	public IGFXK07DTO searchRiskmanagerwaringById(IGFXK07DTO dto)throws BLException;
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGFXK07DTO getProcessRecords(IGFXK07DTO dto) throws BLException;
}
