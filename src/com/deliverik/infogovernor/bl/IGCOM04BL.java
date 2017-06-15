package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.vo.IGCOM04051VO;

public interface IGCOM04BL extends BaseBL {
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException;
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException;
	/**
	 * ҵ����Ա��ҳ��Ϣȡ��
	 * 
	 * @param dto IGCOM04DTO
	 * @param vo IGCOM04051VO
	 * @return IGCOM04DTO
	 * @throws BLException 
	 */
	public IGCOM04DTO initIGCOM0405Action(IGCOM04DTO dto, IGCOM04051VO vo) throws BLException;
	
	/**
     * ����:������ҳ�����¼�����ȡ�ô���
     * @param IGCOM07DTO dto
     * @return �����¼�����
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthEventCount(IGCOM04DTO dto)  throws BLException;
    
    /**
     * ����:������ҳ������������ȡ�ô���
     * @param IGCOM07DTO dto
     * @return ������������
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthProblemCount(IGCOM04DTO dto)  throws BLException;
    
    /**
	 * 
	 * ����:��������������͹�������ȡ�ô���
	 * @param IGCOM07DTO dto
	 * @return �������͹�������
	 * @throws BLException
	 */
	public IGCOM04DTO getAllTypeWorkCount(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGCOM07DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException���¼����ƣ�
	 */
	public IGCOM04DTO setEventAvgCost(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGCOM07DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException���¼����ƣ�
	 */
	public IGCOM04DTO searchProblemAvgSuccess(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * ����:�����¼����ȼ���Ӱ��̶ȡ������̶�xml
	 * @param IGCOM07DTO dto
	 * @throws BLException
	 */
	public IGCOM04DTO setproincidentInfo(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * ���²�ѯ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM04DTO searchProblemTotalByMonth(IGCOM04DTO dto) throws BLException;
}
