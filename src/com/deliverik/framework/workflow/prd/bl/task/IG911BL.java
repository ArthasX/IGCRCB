/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * ����: ״̬�����߹����������Ͷ����ҵ���߼��ӿ�
  * ��������: ״̬�����߹����������Ͷ����ҵ���߼��ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG911BL extends BaseBL {

	/**
	 * ״̬�����߹����������Ͷ����ʵ��ȡ��
	 *
	 * @return ״̬�����߹����������Ͷ����ʵ��
	 */
	public IG911TB getIG911TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG911Info> searchIG911Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG911Info searchIG911InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG911SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG911Info registIG911Info(IG911Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG911Info updateIG911Info(IG911Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG911InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG911Info(IG911Info instance)
		throws BLException;

	/**
     * PPDID����ֵȡ��
     * 
     * @param ����״̬ID
     * @return PPDID����ֵ
     */
    public String getPsprpidSequenceNextValue(String psdid);
    
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
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG911Info> searchIg911RelevantPdid(
            IG911SearchCond cond) ;
    
    /**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg911RelevantPdidCount(
            IG911SearchCond cond);
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG380Info> searchIg380ByIg911Cond(
            IG911SearchCond cond);
}