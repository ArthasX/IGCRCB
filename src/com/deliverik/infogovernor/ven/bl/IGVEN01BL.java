/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 ����10:55:23 
* @version V1.0   
*/
package com.deliverik.infogovernor.ven.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;

//ʷBL
public interface IGVEN01BL {
	/**
	 * <p>
	 * Description: ���ռ��Ǽǳ�ʼ��
	 * </p>
	 */
	public IGVEN01DTO dispRiskCheckAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �����Ա���
	 * </p>
	 */
	public IGVEN01DTO insertCheckStrategAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */
	public IGVEN01DTO searchRiskCheckAction(IGVEN01DTO dto) throws BLException;
	/**	
	 * ���ܣ����ݼ�����id��ѯ������
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */
	public IGVEN01DTO searchCheckStrategyByCsid(IGVEN01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: ���ռ����
	 * </p>
	 */
	public IGVEN01DTO updateRiskCheckAction(IGVEN01DTO dto) throws BLException ;
	/**
	 * ���ղ��Ե���״̬����
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 */
	public IGVEN01DTO changeCheckStrategyStatusOnlyAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * ���ղ��Ը����߼�
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 */
	public IGVEN01DTO copyCheckStrategyStatusAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * ���ܣ����������⹤��ָ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO batchFlowAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * ��������ҳ���ʼ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO initIGRIS0402Action(IGVEN01DTO dto) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO assignAction(IGVEN01DTO dto) throws BLException;
}
