package com.deliverik.infogovernor.svc.bl;


import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;

/**
 * <p>
 * ͳ�Ʒ���ͼ����ʾ�ӿ�
 * </p>
 * @author duchong@deliverik.com
 * @version 1.0
 */
public interface IGSVC06BL extends BaseBL {
	

	/**
	 * Description: ��������ȡ��ͳ������
	 */
	public String findByCond(IGSVC06DTO dto) throws BLException;
	
	/**
	 * Description: ȡ�÷��ظ�ǰ̨ҳ���XML�ַ���
	 */
	public String getXmlByCondition(IGSVC0601Form form) throws BLException;
	

	public List<IG259Info> getAllActiveTemplate() throws BLException;

	/**
	 * ��������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentTypeAction(IGSVC06DTO dto) throws BLException;

	/**
	 * ���ŷ���ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchOrganizationServiceAction(IGSVC06DTO dto) throws BLException;

	/**
	 * ���ŷ���top5ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchServiceTopFiveDateAction(IGSVC06DTO dto) throws BLException;

	/**
	 * ʱ��ƽ�����ʱ��ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentAveSolveTimeAction(IGSVC06DTO dto) throws BLException;
	
	/**
	 * ��ѯ��Ա������ͳ������
	 * @param cond ��������
	 * @return
	 */
	public IGSVC06DTO searchSummary(IGSVC06DTO dto)throws BLException;
	
	/**
	 * ��ȹ�������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchAnnualTrendVWAction(IGSVC06DTO dto) throws BLException;

	/**
	 * ��������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchProcessRecordCountAction(IGSVC06DTO dto) throws BLException;
	
}
