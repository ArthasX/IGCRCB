/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����ҵ���߼��ӿ�
  * ��������: ȱʡ״̬�����߹����������Ͷ����ҵ���߼��ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG931BL extends BaseBL {

	/**
	 * ȱʡ״̬�����߹����������Ͷ����ʵ��ȡ��
	 *
	 * @return ȱʡ״̬�����߹����������Ͷ����ʵ��
	 */
	public IG931TB getIG931TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG931Info> searchIG931Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG931Info searchIG931InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG931SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG931Info registIG931Info(IG931Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG931Info updateIG931Info(IG931Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG931InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG931Info(IG931Info instance)
		throws BLException;

	/**
     * PPDID����ֵȡ��
     * 
     * @param ����״̬ID
     * @return PPDID����ֵ
     */
    public String getDpsprpidSequenceNextValue(String psdid);
    
    /**
     * XML�ű���������
     *
     * @param pdid ���̶���ID
     * @return XML�ű�
     */
    public StringBuffer exportXML(String pdid) throws BLException;
    
    /**
     * XML�ű����봦��
     *
     * @param element Element
     * @throws BLException
     */
    public void importXML(Element element) throws BLException;
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG931Info> searchIg931RelevantPdid(
            IG931SearchCond cond);
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg931RelevantPdidCount(
            IG931SearchCond cond);
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG380Info> searchIg380ByIg931Cond(
            IG931SearchCond cond);
}