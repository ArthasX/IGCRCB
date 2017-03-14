/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG931DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����ҵ���߼�ʵ��
  * ��������: ȱʡ״̬�����߹����������Ͷ����ҵ���߼�ʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public class IG931BLImpl extends BaseBLImpl implements
		IG931BL {

	/** ȱʡ״̬�����߹����������Ͷ����DAO�ӿ� */
	protected IG931DAO ig931DAO;
	
	/**
	 * ȱʡ״̬�����߹����������Ͷ����DAO�ӿ��趨
	 *
	 * @param iG931DAO ȱʡ״̬�����߹����������Ͷ����DAO�ӿ�
	 */
	public void setIg931DAO(IG931DAO ig931DAO) {
		this.ig931DAO = ig931DAO;
	}

	/**
	 * ȱʡ״̬�����߹����������Ͷ����ʵ��ȡ��
	 *
	 * @return ȱʡ״̬�����߹����������Ͷ����ʵ��
	 */
	public IG931TB getIG931TBInstance() {
		return new IG931TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG931Info> searchIG931Info() {
		return ig931DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG931Info searchIG931InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG931SearchCond cond) {
		return ig931DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond) {
		return ig931DAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return ig931DAO.findByCond(cond, start, count);
	}

	/**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG931Info> searchIg931RelevantPdid(
            IG931SearchCond cond) {
        return ig931DAO.getIg931RelevantPdidfindByCond(cond);
    }
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond) {
        return ig931DAO.getIg931RelevantPdidCount(cond);
    }
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond) {
        return ig931DAO.getIg380InfoByIg931Cond(cond);
    }
    
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG931Info registIG931Info(IG931Info instance)
		throws BLException {
		return ig931DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG931Info updateIG931Info(IG931Info instance)
		throws BLException {
		checkExistInstance(instance.getDpsprpid());
		return ig931DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG931InfoByPK(String pk)
		throws BLException {
		ig931DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG931Info(IG931Info instance)
		throws BLException {
		ig931DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG931Info checkExistInstance(String pk)
		throws BLException {
		IG931Info instance = ig931DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
     * PPDID����ֵȡ��
     * 
     * @param ����״̬ID
     * @return PPDID����ֵ
     */
    public String getDpsprpidSequenceNextValue(String psdid) {
        return ig931DAO.getDpsprpidSequenceNextValue(psdid);
    }
    
    /**
     * XML�ű���������
     *
     * @param pdid ���̶���ID
     * @return XML�ű�
     */
    public StringBuffer exportXML(String pdid) throws BLException {
        IG931SearchCondImpl cond = new IG931SearchCondImpl();
        cond.setPdid(pdid);
        List<IG931Info> lst_IG931Info = this.searchIG931Info(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG931>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG931Info != null) {
            for(IG931Info info : lst_IG931Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<DPSPRPID>");
                sbf_xml.append(StringUtils.isEmpty(info.getDpsprpid()) ? "" : IGStringUtils.filterXMLStr(info.getDpsprpid()));
                sbf_xml.append("</DPSPRPID>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<PSDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
                sbf_xml.append("</PSDID>");
                sbf_xml.append("<RELEVANTPDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRelevantPdid()) ? "" : IGStringUtils.filterXMLStr(info.getRelevantPdid()));
                sbf_xml.append("</RELEVANTPDID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG931>");
        return sbf_xml;
    }
    
    /**
     * XML�ű����봦��
     *
     * @param element Element
     * @throws BLException
     */
    @SuppressWarnings("unchecked")
    public void importXML(Element element) throws BLException {
        Element data = element.getChild("DATALIST");
        List<Element> dataList = data.getChildren();
        List<IG931Info> lst_IG931 = new ArrayList<IG931Info>();
        IG931TB entity = null;
        for(Element e : dataList) {
            entity = this.getIG931TBInstance();
            entity.setDpsprpid(e.getChildText("DPSPRPID"));
            entity.setPdid(e.getChildText("PDID"));
            entity.setPsdid(e.getChildText("PSDID"));
            entity.setRelevantPdid(e.getChildText("RELEVANTPDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG931.add(entity);
        }
        this.ig931DAO.saveOrUpdateAll(lst_IG931);
    }
}
