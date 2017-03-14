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
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG911DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * ����: ״̬�����߹����������Ͷ����ҵ���߼�ʵ��
  * ��������: ״̬�����߹����������Ͷ����ҵ���߼�ʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public class IG911BLImpl extends BaseBLImpl implements
		IG911BL {

	/** ״̬�����߹����������Ͷ����DAO�ӿ� */
	protected IG911DAO ig911DAO;
	
	/**
	 * ״̬�����߹����������Ͷ����DAO�ӿ��趨
	 *
	 * @param iG911DAO ״̬�����߹����������Ͷ����DAO�ӿ�
	 */
	public void setIg911DAO(IG911DAO ig911DAO) {
		this.ig911DAO = ig911DAO;
	}

	/**
	 * ״̬�����߹����������Ͷ����ʵ��ȡ��
	 *
	 * @return ״̬�����߹����������Ͷ����ʵ��
	 */
	public IG911TB getIG911TBInstance() {
		return new IG911TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG911Info> searchIG911Info() {
		return ig911DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG911Info searchIG911InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG911SearchCond cond) {
		return ig911DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond) {
		return ig911DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond) {
	    return ig911DAO.getIg911RelevantPdidfindByCond(cond);
	}
	
	/**
	 * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG380Info> searchIg380ByIg911Cond(
	        IG911SearchCond cond) {
	    return ig911DAO.getIg380InfoByIg911Cond(cond);
	}
	
	/**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond) {
        return ig911DAO.getIg911RelevantPdidCount(cond);
    }

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
			int count) {
		return ig911DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG911Info registIG911Info(IG911Info instance)
		throws BLException {
		return ig911DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG911Info updateIG911Info(IG911Info instance)
		throws BLException {
		checkExistInstance(instance.getPsprpid());
		return ig911DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG911InfoByPK(String pk)
		throws BLException {
		ig911DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG911Info(IG911Info instance)
		throws BLException {
		ig911DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG911Info checkExistInstance(String pk)
		throws BLException {
		IG911Info instance = ig911DAO.findByPK(pk);
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
    public String getPsprpidSequenceNextValue(String psdid) {
        return ig911DAO.getPsprpidSequenceNextValue(psdid);
    }

    /**
     * XML�ű���������
     *
     * @param pdid ���̶���ID
     * @return XML�ű�
     */
    public StringBuffer exportXML(String pdid) throws BLException {
        IG911SearchCondImpl cond = new IG911SearchCondImpl();
        cond.setPdid(pdid);
        List<IG911Info> lst_IG911Info = this.searchIG911Info(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG911>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG911Info != null) {
            for(IG911Info info : lst_IG911Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PSPRPID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsprpid()) ? "" : IGStringUtils.filterXMLStr(info.getPsprpid()));
                sbf_xml.append("</PSPRPID>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<PSDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
                sbf_xml.append("</PSDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(info.getRoleid()==null ? "" : "&roleid_" + String.valueOf(info.getRoleid()) + ";");
                sbf_xml.append("</ROLEID>");
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
        sbf_xml.append("</IG911>");
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
        List<IG911Info> lst_IG911 = new ArrayList<IG911Info>();
        IG911TB entity = null;
        for(Element e : dataList) {
            entity = this.getIG911TBInstance();
            entity.setPsprpid(e.getChildText("PSPRPID"));
            entity.setPdid(e.getChildText("PDID"));
            entity.setPsdid(e.getChildText("PSDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setRelevantPdid(e.getChildText("RELEVANTPDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG911.add(entity);
        }
        this.ig911DAO.saveOrUpdateAll(lst_IG911);
    }
}
