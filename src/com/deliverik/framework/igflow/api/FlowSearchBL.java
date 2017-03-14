/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessOverdueInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;

/**
 * ���̲�ѯ����API
 */
public interface FlowSearchBL extends BaseBL {
	
	/**
	 * ���̵�ǰ״̬�б��ѯ
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬�б�
	 */
	public List<ProcessStatusInfo> searchCurrentStatus(Integer prid) throws BLException;

	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ����������Ϣ
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer eiid) throws BLException;

	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ģ�Ͳ�������ǰ��һ��ģ��ƥ��
	 * <BR>
	 * ���Ϊ���°���Ϣ��������������Ϣ
	 * @param esyscoding ģ�Ͳ����
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public List<EntityItemInfo> searchEntityItem(String esyscoding) throws BLException;
	
	/**
	 * �ʲ���Ϣ��ѯ
	 * <BR>
	 * ���Լ��Ͽ�Ϊ�գ�����key���������ƣ�value������ֵ
	 * <BR>
	 * Ĭ�ϲ�ѯ��������=key������ֵ=value�ļ�¼
	 * <BR>
	 * ��value=nullʱ��ѯ��������=key�ļ�¼
	 * <BR>
	 * ��value=""ʱ��ѯ��������=key������ֵ=""�ļ�¼
	 * @param value ���Լ���
	 * @return �ʲ�ID�б�
	 * @throws BLException 
	 */
	public List<Integer> searchEntityItem(Map<String, String> value) throws BLException;

	/**
	 * �ʲ�����ֵ��ѯ
	 * <BR>
	 * ���������Ʋ�����ʱ�׳��쳣
	 * @param assetid �ʲ�ID
	 * @param name �ʲ���������
	 * @return �ʲ�����ֵ
	 * @throws BLException 
	 */
	public String searchEntityItemConfigValue(Integer assetid, String name) throws BLException;
	
	/**
	 * ���ݹ�����ʶ��ѯ��ǰ��󹤵���
	 * <BR>
	 * ������ʶ����ǰ��һ��ģ��ƥ��
	 * @param serialnum ������ʶ
	 * @return ��󹤵���
	 */
	public String searchMaxSerialnum(String serialnum) throws BLException;
	
	/**
	 * ������״̬����Ϣ
	 * @param pdid ���̶���ID
	 * @param name ״̬����
	 * @param roleid �����ɫID
	 * @return ������״̬����Ϣ
	 */
	public List<ParticipantStatusFormInfo> searchParticipantStatusFormInfo(String pdid, String name, Integer roleid)
			throws BLException;
	
	/**
	 * ����˽�б�ֵ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param name ������
	 * @return ��ֵ�б�
	 * @throws BLException 
	 */
	public List<PrivateProcessFormInfo> searchPrivateProcessInfo(Integer prid, String name) throws BLException;
	
	/**
	 * ��������ʲ���ѯ
	 * <BR>
	 * ��pinameΪ��ʱ���ظ�����ID���е�����ʲ�������ѯ�޽��ʱ����null
	 * @param prid ����ID
	 * @param pidname �����ƣ���Ϊ�գ�
	 * @return ����ʲ��б�
	 * @throws BLException 
	 */
	public List<ProcessInfoEntityInfo> searchProcessEntityItem(Integer prid, String pidname) throws BLException;

	/**
	 * ���̻�����Ϣ��ѯ
	 * @param prid ����ID ����Ϊ�գ�
	 * @param serialnum ���̹����ţ���Ϊ�գ�
	 * @return ���̻�����Ϣ
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(Integer prid, String serialnum) throws BLException;

	/**
	 * ���̻�����Ϣ��ѯ
	 * @param status ����״̬��ʶ
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String status) throws BLException;

	/**
	 * ���̻�����Ϣ��ѯ
	 * @param startTime ���̷���ʱ�俪ʼ����Ϊ�գ�
	 * @param endTime ���̷���ʱ���������Ϊ�գ�
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String startTime, String endTime) throws BLException;

	/**
	 * ���̻�����Ϣ��ѯ
	 * @param pdid ���̶���ID
	 * @param beginTime ���̷���ʱ�俪ʼ����Ϊ�գ�
	 * @param endTime ���̷���ʱ���������Ϊ�գ�
	 * @return ���̻�����Ϣ�б�
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String pdid, String beginTime, String endTime) throws BLException;

	/**
	 * ���̱�������Ϣ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param pdid ���̶���ID
	 * @param pidname ������
	 * @return ��������Ϣ
	 * @throws BLException
	 */
	public String searchProcessInfoDefDescByName(String pdid, String pidname) throws BLException;

	/**
	 * ���̴����¼��ѯ
	 * @param prid ����ID
	 * @param psdid ����״̬ID
	 * @param psdnum ����״̬��֧���
	 * @param userid �����û�ID
	 * @return ���̴����¼�б�
	 * @throws BLException
	 */
	public List<ProcessLogInfo> searchProcesslog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException;
	
	/**
	 * ���̱���־��ѯ
	 * @param prid ����ID
	 * @param psdid ����״̬ID
	 * @param psdnum ����״̬��֧���
	 * @param userid �����û�ID
	 * @return ���̱���־�б�
	 */
	public List<ProcessFormLogInfo> searchProcessFormlog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException;
	
	/**
	 * ָ������״̬����δ��������߲�ѯ
	 * @param prid ����ID
	 * @param status ����״̬
	 * @return ����δ�����������Ϣ
	 * @throws BLException
	 */
	public List<ProcessOverdueInfo> searchProcessOverdueInfo(Integer prid, String status)
			throws BLException;

	/**
	 * ���̹�ϵ��ѯ
	 * <BR>
	 * ����������ID��ѯ������ID
	 * @param parprid ������ID
	 * @return ������ID�б�
	 * @throws BLException
	 */
	public List<Integer> searchProcessRelationForCld(Integer parprid) throws BLException;
	
	/**
	 * ���̹�ϵ��ѯ
	 * <BR>
	 * ����������ID��ѯ������ID
	 * @param cldprid ������ID
	 * @return ������ID
	 * @throws BLException
	 */
	public Integer searchProcessRelationForPar(Integer cldprid) throws BLException;
	
	/**
	 * ���̱��ʽ�������ѯ
	 * <BR>
	 * �÷����ķ��ؽ������Ϊ���ʽ������ֵ�Ĳ�ѯ���趨
	 * <BR>
	 * ������Ϣ������ʱ���쳣
	 * @param prid ����ID
	 * @return ���ʽ��������Ϣ
	 * @throws BLException
	 */
	public Map<String, ProcessInfoDefinitionInfo> searchProcessTableColumnDef(Integer prid) throws BLException;

	/**
	 * ������Ա����Ϣ��ѯ
	 * ������Ϣ�����ڻ����Ϣ������ʱ���쳣
	 * @param prid ����ID
	 * @param name ������
	 * @return ��Ա��Ϣ����
	 * @throws BLException
	 */
	public List<ParticipantInfo> searchPublicParticipantFormValue(Integer prid,String name) throws BLException;

	/**
	 * ���̹��б�ֵ��ѯ
	 * <BR>
	 * �������Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param pidname ������
	 * @return ��ֵ
	 * @throws BLException
	 */
	public String searchPublicProcessInfo(Integer prid, String pidname) throws BLException;
	
	/**
	 * ���ʽ������ֵ��ѯ(���㼶�����м��� "#" ����)
	 * <BR>
	 * ��ȫ·��������ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ����ID
	 * @param rownumber �к�
	 * @return ���ʽ��ֵ
	 * @throws BLException
	 */
	public String searchPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,
			String tableColumnFullName, Integer prid,String rownumber) throws BLException ;
	
	/**
	 * ������ֵ��ѯ
	 * <BR>
	 * ��ȫ·��������ʱ���쳣
	 * @param tableFullName ���ʽ��ȫ��
	 * @param prid ����ID
	 * @param rownumber �к�(����Ƕ��������ַ���)
	 * @return ���ʽ��ֵ��ArrayList��
	 * @throws BLException
	 */
	public Object searchPublicTableValue(String tableFullName, Integer prid,String rownumber) throws BLException;

	/**
	 * ��ܱ�����Ϣ��ѯ
	 * <BR>
	 * �����������ں���ֹ����
	 * @param type ��������
	 * @param pdid ���̶���ID
	 * @param key �걨��ʽ��2012,������ʽ��2012_һ����
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��ܱ���ID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRegulatoryReportInfo(String type, String pdid, String key, Boolean isClose) throws BLException;
	
	/**
	 * ����״̬�б��ѯ
	 * <BR>
	 * ֻ���ض�����Ϣ��ʱ����ϢΪ��
	 * @param pdid ���̶���ID
	 * @return ����״̬�б�
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusList(String pdid) throws BLException;
	
	/**
	 * ����״̬��ѯ
	 * <BR>
	 * ֻ���ض�����Ϣ��ʱ����ϢΪ��
	 * @param psdid ����״̬ID
	 * @return ����״̬
	 * @throws BLException 
	 */
	public ProcessStatusInfo searchProcessStatus(String psdid) throws BLException;
	
	/**
	 * ����״̬��־�б��ѯ
	 * @param pdid ���̶���ID
	 * @return ����״̬��־�б�
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusLog(Integer prid) throws BLException;

	/**
	 * ״̬�����߲�ѯ
	 * <BR>
	 * ��״̬���Ʋ�����ʱ�׳��쳣
	 * @param prid ����ID
	 * @param statusname ״̬����
	 * @return �������б�
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipant(Integer prid, String statusname)
		throws BLException;

	/**
	 * ״̬�����߲�ѯ
	 * @param prid ����ID
	 * @param status ״̬��ʶ
	 * @return �������б�
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipantByCode(Integer prid, String status) throws BLException;
	
	/**
     * ��Ա��ֵ��ѯ
     * @param prid ����ID
     * @param pidname ������
     * @return ��Ա��Ϣ����
     * @throws ������IDΪ��ʱ���쳣
     */
    public List<ParticipantInfo> searchProcessParticipantForm(Integer prid,String pidname) throws BLException;
	/**
	 * �ʲ���Ϣ��ѯ(Ӧ����Դר��)
	 * <BR>
	 * ���Ϊ���°���Ϣ������������Ϣ
	 * @param id ���ݿ�ID
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer id , Integer eiid) throws BLException ;
}
