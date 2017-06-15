/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;

/**
 * ֵ����������ڻ���BL
 */
public interface IGDUT03BL extends BaseBL {
	
	/**
	 * 
	 * Description: ֵ������Ϣ��ѯ
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT03DTO searchDutyResultAction(IGDUT03DTO dto) throws BLException;
	
	/**
	 * ֵ��������ܲ�ѯ����
	 *
	 * @param dto IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchAllDutyResultAction(IGDUT03DTO dto) throws BLException;

	/**
	 * 
	 * Description: ֵ��Ԥ����Ϣ��ѯ
	 * @param dto IGDUT03DTO
	 * @return IGDUT03DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT03DTO initIGDUT0301Action(IGDUT03DTO dto) throws BLException;
	
    /**
     * ά�ޱ���ӹ��ܶ���
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO registOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;
    
    /**
     * ά�ޱ�ɾ�����ܶ���
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO deleteOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;
    
    /**
     * ά�ޱ���¹��ܶ���
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO updateOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;

    	/**
    	 * ά�ޱ���������
    	 * @param dto IGDUT03DTO
    	 * @return IGDUT03DTO
    	 * @
    	 */
    public IGDUT03DTO searchOnDutyPersonRecord(IGDUT03DTO dto) throws BLException;
    
    /**
     * ��ҳ����
     * @param dto
  	 * @return IGDUT03DTO
     */
    public IGDUT03DTO searchODPRAction(IGDUT03DTO dto)
			throws BLException; 
    
    /** ��ʼ������ҳ
     * 
     * @param dto
  	 * @return IGDUT03DTO
     *
     */
    public IGDUT03DTO initIGDUT0304Action(IGDUT03DTO dto) throws BLException;
    
    /**
     * ��ѯ��������Checkbox List
     * 
   	 * @return
     */
    public IGDUT03DTO searchOnDutyPersonRecordArea(IGDUT03DTO dto) throws BLException;

    /**
     * ֵ����˵���޸Ĵ���
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDUT03DTO changeDrresultAction(IGDUT03DTO dto) throws BLException;
}
