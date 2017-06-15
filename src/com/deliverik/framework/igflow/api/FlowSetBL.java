/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.framework.igflow.parameter.PrivateProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.StatusParticipantInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;

/**
 * ���̸��¹���API
 */
public interface FlowSetBL extends BaseBL {
	
	/**
	 * ����ʲ�����
	 * @param eiid �ʲ�ID
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ
	 * @throws BLException
	 */
	public void createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	/**
	 * ����ʲ�
	 * ���������벻����ʱ���쳣
	 * ����ģ����Ϣ������ʱ���쳣
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ�ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException;
	
	/**
	 * ״̬������ɾ��
	 * @param statusParticipantInfo ״̬��������Ϣ
	 * @throws BLException
	 */
	public void deleteStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException;
	
	/**
	 * �Ա��Ϊ��λɾ�����б��ʽ��ֵ
	 * �к�Ϊ��ʱɾ���ñ��������ֵ
	 * ������Ϣ�����ڻ����Ϣ������ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ��������
	 * @param rownumber �к�(��Ϊ��)
	 * @throws BLException
	 */
	public void deletePublicTableFormValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber) throws BLException;
	
	/**
	 * �ʲ�������������
	 * @param eiid �ʲ�ID
	 * @param eiorgsyscoding ���º���ʲ��������������
	 * @throws BLException
	 */
	public void setEntityItemValue(Integer eiid, String eiorgsyscoding) throws BLException;
	
	/**
	 * �ʲ�����ֵ����
	 * @param entityItemConfigValueInfo �ʲ�������Ϣ
	 * @param upgrade �Ƿ�����
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(EntityItemConfigValueInfo entityItemConfigValueInfo,
			boolean upgrade) throws BLException;
	

	/**
	 * ������������ʲ�
	 * <BR>
	 * ������Ϣ�����ڡ�����Ϣ�����ڻ����ʲ���ϢΪ��ʱ���쳣
	 * @param prid ��������
	 * @param pidname ������
	 * @param entitys �ʲ���Ϣ����
	 * @throws BLException
	 */
	public void setProcessEntityItem(Integer prid, String pidname, List<ProcessInfoEntityInfo> entitys) throws BLException;
	
	/**
	 * �ʲ�����ֵ����
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ����
	 * @param upgrade �Ƿ�����
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo,
			boolean upgrade) throws BLException;
	
	/**
	 * ˽�б�ֵ����
	 * @param privateProcessInfoValueInfo ˽�б���Ϣ
	 * @throws BLException
	 */
	public void setPrivateProcessInfoValue(PrivateProcessInfoValueInfo privateProcessInfoValueInfo) throws BLException;
	
	/**
	 * ������־���
	 * @param logInfo ������־������Ϣ
	 * @param desc ��־��������
	 * @param type ��־����
	 * @throws BLException
	 */
	public void setProcessLog(WorkFlowLogInfo logInfo, String desc, String type) throws BLException;

	/**
	 * ���̹�ϵ���
	 * @param parprid ������ID
	 * @param cldprid �������ID
	 * @throws BLException
	 */
	public void setProcessRelation(Integer parprid, Integer cldprid) throws BLException;

	/**
	 * ���̹����Ÿ���
	 * 
	 * @param prid ����ID
	 * @param serialnum ���̹�����
	 * @throws BLException
	 */
	public void setProcessSerialNum(Integer prid, String serialnum) throws BLException;

	/**
	 * ���ʽ������ֵ�趨(���㼶�����м��� "#" ����)
	 * <BR>
	 * ��ȫ·��������ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ����ID
	 * @param rownumber �к�
	 * @throws BLException
	 */
	public void setPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber,String value) throws BLException;

	/**
	 * ���б�ֵ����
	 * @param publicProcessInfoValueInfo ���б���Ϣ
	 * @throws BLException
	 */
	public void setPublicProcessInfoValue(PublicProcessInfoValueInfo publicProcessInfoValueInfo) throws BLException;
	
	/**
	 * �����ɫ�Ͳ��������
	 * @param statusParticipantInfo ״̬��������Ϣ
	 * @throws BLException
	 */
	public void setStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException;
	
	/**
	 * ���ȫ�������ߴ������ʱ��
	 * @param prid ����ID
	 * @param statuscode ״̬��ʶ
	 * @throws BLException
	 */
	public void setStatusParticipantAllRehandle(Integer prid, String statuscode) throws BLException;

	/**
	 * ���ָ�������ߴ������ʱ��
	 * @param prid ����ID
	 * @param statusname ״̬����
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException
	 */
	public void setStatusParticipantRehandle(Integer prid, String statusname, Integer roleid, String userid)
			throws BLException;
	
	/**
	 * ����������Ϣ
	 * @param prid ��������
	 * @param valueMap ֵ��������-����ֵ
	 * @throws BLException
	 */
	public void updateProcessRecord(Integer prid,Map<String, Object> valueMap) throws BLException;
	
	/**
	 * ��������ʲ���ϵ
	 * @param prid ��������
	 * @param pidname ������
	 * @param eiid �ʲ�ID
	 */
	public Integer setProcessEntityRelation(Integer prid,String pidname,Integer eiid,Integer eiversion,Object... dbFlag) throws BLException;
	
	/**
	 * ������̱��ʽ����ϵ
	 * @param sourcePrid
	 * @param sourcePivarname
	 * @param tagPrid     
	 * @param tagPivarname
	 * @param tagPdid
	 * @throws BLException
	 */
	public void setProcessSceneParticipant(Integer sourcePrid,String sourcePivarname,Integer tagPrid,String tagPivarname,String tagPdid)throws BLException;
	
}
