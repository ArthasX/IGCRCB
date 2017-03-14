/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
/**	
 * ����:�澯��ϢcontrolBL�ӿ�
 * ����������1.��ѯ���ɸ澯��Ϣ�б�	
 *           2.ͨ��id�� ��ѯ�澯��Ϣ	
 * ������¼��changhao    2014/7/1	
 * �޸ļ�¼��maxu    	2014/7/9	
 *         	yukexin 	2014-8-26 13:42:53
 */	
public interface IGCRC02BL extends BaseBL {

	/***
	 * ͨ��dto������ѯ��������ѯ
	 * �����������ƣ�IP��ַ������ʱ�䣬�ָ�ʱ�������ѯ
	 * @param dto
	 */
	public void serachIgalarmSortList(IGCRC02DTO dto); 
	
	/**
	 * ��ѯ���ɸ澯��Ϣ�б�
	 * @param dto ���ɸ澯���ҵ����DTO
	 */
	public void serachIgalarmList(IGCRC02DTO dto);
	
	/***
	 * ͨ��id�� ��ѯ�澯��Ϣ
	 * @param alarmIds �澯Id
	 * @return ���ɸ澯���б�
	 */
	public List<IgalarmInfo> serachByAlarmIds(String[] alarmIds); 
	
	
	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC02DTO getExcelDataList(IGCRC02DTO dto) throws BLException ;
	
	/**	
	 * ���ܣ�ͨ��id ��ѯ�澯��Ϣ
	 * @param id
	 * @return
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC02DTO searchIgalarmByPK(IGCRC02DTO dto) throws BLException;
	
	/**	
	 * ���ܣ����ݸ澯id����
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC02DTO updateIgalarmByForm(IGCRC02DTO dto) throws BLException; 
	
	/**	
	 * ���ܣ����ݸ澯id����
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC02DTO updateIgalarmByIgalarm(IGCRC02DTO dto) throws BLException; 
	
	
	/**	
	 * ���ܣ����ݸ澯idɾ��
	 * @param dto
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public void deleteIgalarmByPK(IGCRC02DTO dto) throws BLException;
	
	/**
	 *�澯�¼���ѯ
	 */
	public IGCRC02DTO getProcessRecords(IGCRC02DTO dto) throws BLException;
}
