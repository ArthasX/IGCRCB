package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;

/**
 * �ʲ�����ģ�͹���ҵ���߼��ӿ�
 *
 *
 */
public interface IGASM01BL extends BaseBL {


	/**
	 * �ʲ���Ϣ��ѯ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�ǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertEntityAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * �ʲ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0102Action(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣ���´���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateEntityAction(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationAction(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0104Action(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣ���´���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateConfigurationAction(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ���ϸ��Ϣ���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0106Action(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ���Ϣɾ������
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteEntityAction(IGASM01DTO dto) throws BLException;

	/**
	 * �ʲ�������Ϣɾ������
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteConfigurationAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ�ģ��״̬�仯
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: �ʲ�ģ������״̬�仯
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGASM01DTO dto) throws BLException;
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetailBean(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO searchConfigurationCodeDetail(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO searchCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException;
	/**
	 * �ʲ��������ݵǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationCodeDetailAction(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO getCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO insertCfgCodeDetailAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * ��ѯ���������������񼰷����¼��һ��ģ�ͣ�����EXCELģ��ʹ�ã�
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityActionForExportExcelModel(IGASM01DTO dto) throws BLException;
	/**
	 * ����Excelģ��
	 * @throws Exception
	 */
	public IGASM01DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭������ڻ�����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws Exception
	 */
	public IGASM01DTO initIGASM0114Action(IGASM01DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException 
	 */
	public IGASM01DTO editIGASM0114Action(IGASM01DTO dto) throws BLException, FileNotFoundException, IOException;
}
