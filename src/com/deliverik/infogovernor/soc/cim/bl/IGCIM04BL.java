package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;

/**
 * �ʲ�����ģ�͹���ҵ���߼��ӿ�
 *
 *
 */
public interface IGCIM04BL extends BaseBL {


	/**
	 * �ʲ���Ϣ��ѯ����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchEntityAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertEntityAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGCIM0402Action(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣ���´���
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO updateEntityAction(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertConfigurationAction(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGASM0104Action(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ���´���
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO updateConfigurationAction(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ���ϸ��Ϣ���������ʾ����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGCIM0406Action(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣɾ������
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO deleteEntityAction(IGCIM04DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣɾ������
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO deleteConfigurationAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ�ģ��״̬�仯
	 * </p>
	 * 
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException
	 * @author wangxing
	 * @update
	 */
	public void changeEntityStatus(IGCIM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ�ģ������״̬�仯
	 * </p>
	 * 
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException
	 * @author wangxing
	 * @update
	 */
	public void changeConfigStatus(IGCIM04DTO dto) throws BLException;
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchConfigurationCodeDetailBean(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO searchConfigurationCodeDetail(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO searchCfgCodeDetailByCategory(IGCIM04DTO dto) throws BLException;
	/**
	 * �ʲ��������ݵǼǴ���
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertConfigurationCodeDetailAction(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO getCfgCodeDetailByCategory(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO insertCfgCodeDetailAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * ��ѯ���������������񼰷����¼��һ��ģ�ͣ�����EXCELģ��ʹ�ã�
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchEntityActionForExportExcelModel(IGCIM04DTO dto) throws BLException;
	/**
	 * ����Excelģ��
	 * @throws Exception
	 */
	public IGCIM04DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭������ڻ�����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws Exception
	 */
	public IGCIM04DTO initIGASM0114Action(IGCIM04DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭����
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException 
	 */
	public IGCIM04DTO editIGASM0114Action(IGCIM04DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * �ʲ�����Ų�ѯ����
	 * @param dto
	 * @return IGCIM04DTO
	 * @throws BLException
	 */
	public IGCIM04DTO searchEntityTypesNums(IGCIM04DTO dto) throws BLException;
	
	/**
	 * ��ѯentity��
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM04DTO searchEntityTreeAction(IGCIM04DTO dto) throws BLException;
}
