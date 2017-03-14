package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;

/**
 * ����ͳ��ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM10BL extends BaseBL {


	/**
	 * �ʲ�����Ϣ��ѯ����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO searchEntityItemAction(IGASM10DTO dto) throws BLException;
	
	/**
	 * �ʲ���������Ϣ��ϸ������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1004Action(IGASM10DTO dto) throws BLException;

	/**
	 * �ʲ���������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1005Action(IGASM10DTO dto) throws BLException;

	/**
	 * �ʲ����ϵ��������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1006Action(IGASM10DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ������
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGASM01DTO searchConfigurationsByEntity(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ�����Զ�Ӧ��ȡֵ��Χ����
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public List<LabelValueBean> searchCcdvalueByCoption(String coption) throws BLException;
}
