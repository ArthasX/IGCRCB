package com.deliverik.infogovernor.cic.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;


/**
 * �ȶԹ������ҵ���߼��ӿ�
 *
 *
 */
public interface IGCIC01BL extends BaseBL {


	public IGCIC01DTO searchCompareRoleList(IGCIC01DTO dto) throws BLException;
	
	public IGCIC01DTO getSystemList(IGCIC01DTO dto)throws BLException;

	/**
	 * ����ҵ��ϵͳ�ͶԱ����Ͳ�ѯ����
	 * @param systemId
	 * @param crtype
	 * @return
	 */
	public List<Map<String,String>> searchHostList(Integer systemId,String crtype)throws BLException;
	
	public IGCIC01DTO insertIgcic0102Action(IGCIC01DTO dto)throws BLException;
	
	/**
	 * �鿴ʱ ���ضԱȹ�����ϸ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC01DTO loadCompareRoleInfo(IGCIC01DTO dto)throws BLException;
	
	/**
	 * ���Աȹ����Ƿ����,��������ڷ���null �����ѯ���ù������Ϣ
	 * @param systemId
	 * @param crtype
	 * @return
	 * @throws BLException
	 */
	public Map<String,Object> checkCompareRole(Integer systemId,String crtype)throws BLException;
	
	public IGCIC01DTO delCompareRole(IGCIC01DTO dto)throws BLException;
}
