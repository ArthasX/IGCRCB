package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;

/**
 * �������ݹ���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM12BL extends BaseBL {

	/**
	 * <p>
	 * ��ѯ������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchCodeTreeAction(IGSYM12DTO dto) throws BLException;

	/**
	 * <p>
	 * ��ѯentity��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchEntityTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ͨ��SOC���ѯentity��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchSocEntityTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ��������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ������״̬Ϊ���õ�������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByCdStatusAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯEntitiy����ָ��1����㣩
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯEntitiy����ָ��1����㣩
	 * </p>
	 * @throws BLException
	 * @author wangxing@deliverik.com
	 */
	public IGSYM12DTO searchSOCEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯEntitiy����ֻ��ѯ1����㣩
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByPcidAction(IGSYM12DTO dto) throws BLException;
	/**
	 * Ӧ����Դ�������ݿ��ѯ�ʲ�ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM12DTO searchSocVWEntityTreeAction(IGSYM12DTO dto) throws BLException;
}
