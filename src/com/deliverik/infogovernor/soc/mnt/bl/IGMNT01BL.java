/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
/**
 * ����:��ع���ҵ��ӿ�
 * ����������
 * ������¼�����    2012/02/09
 */
public interface IGMNT01BL extends BaseBL{

	
	/**
	 * �����������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorTypeTreeAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * ������ͷ�ֵ��ѯ
	 */
	public IGMNT01DTO searchMonitorTypeDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ������ͷ�ֵ�޸�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public void updateMonitorTypeDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ������Ͳ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorTypeAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض���Ǽ�
	 * @param dto
	 * @throws BLException
	 */
	public IGMNT01DTO insertMonitorObject(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض����ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض���������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectByPKAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض���ֵ��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMonitorObjectDefAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض����޸�
	 * @param dto
	 * @throws BLException
	 */
	public void updateMonitorObjectAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض���״̬�޸�
	 * @param dto
	 * @throws BLException
	 */
	public void updateMonitorObjectStatusAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ض������Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchMoNameAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ������
	 * </p>
	 * 
	 * @param dto IGMNT01DTO
	 * @return IGMNT01DTO
	 * @throws BLException
	 */
	public IGMNT01DTO searchEntityNameAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ϣ��ѯ
	 *
	 * @param dto IGMNT01DTO
	 * @return IGMNT01DTO
	 */
	public IGMNT01DTO searchEntityItemAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ���������������
	 * @param dto
	 * @return
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(IGMNT01DTO dto) throws BLException;

	/**
	 * �洢�ǼǴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertSymmInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * �洢CodeDetail����Ϣ��Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertCodeDetailInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ȡ�ô洢���͵ı���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCodeDetailListActioin(IGMNT01DTO dto) throws BLException;

	/**
	 * �Զ�������Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registSOC0203Action(IGMNT01DTO dto) throws BLException;

	/**
	 * ��ͨ������Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registReportFileDefinitionAction(IGMNT01DTO dto) throws BLException;

	/**
	 * �洢������Ϣɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmOtherInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * �洢ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmInfoAction(IGMNT01DTO dto) throws BLException;

	/**
	 * ɾ����ض���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteMonitorObject(IGMNT01DTO dto) throws BLException;

	/**
	 * �ʲ����Ͳ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchEsyscodingAction(IGMNT01DTO dto) throws BLException;

	/**
	 * �����洢������Ϣʵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCollect_Symmetrix_Info(IGMNT01DTO dto) throws BLException;
	
	/**
	 * ��ѯdebug��س�ʼ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchDebugTaskInitAction(IGMNT01DTO dto) throws BLException;
	/**
	 * ��ʼִ�м������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertDebugTaskAction(IGMNT01DTO dto) throws BLException;
	
	/**
	 * ����һ������bat,������
	*/
	public void createParseBat(String mtId) ;
	
	/**
	 * ����һ��ģ��bat,������
	*/
	public void createBat(String mtSSn,String mtId,String mtCname,String mtKpi,Integer mtInterval,Integer mtNum) ;

	/**
	 * ȡ��ʵʱ���ܼ���
	 * @param mtId
	 * @return
	 * @throws BLException
	 */
	public Map<String, List<SOC0301Info>> getDataMap(int mtId) throws BLException;

	/**
	 * ����������ֵ
	 * @param dto
	 * @throws BLException
	 */
	public void updateCapacityObject(IGMNT01DTO dto) throws BLException;

}
