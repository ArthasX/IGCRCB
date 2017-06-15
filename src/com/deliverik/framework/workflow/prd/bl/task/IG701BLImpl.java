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
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG701DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;

/**
  * ����: ���̲鿴��ɫ��Ȩ����ҵ���߼�ʵ��
  * ��������: ���̲鿴��ɫ��Ȩ����ҵ���߼�ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public class IG701BLImpl extends BaseBLImpl implements
		IG701BL {

	/** ���̲鿴��ɫ��Ȩ����DAO�ӿ� */
	protected IG701DAO ig701DAO;
	
	/**
	 * ���̲鿴��ɫ��Ȩ����DAO�ӿ��趨
	 *
	 * @param ig701DAO ���̲鿴��ɫ��Ȩ����DAO�ӿ�
	 */
	public void setIg701DAO(IG701DAO ig701DAO) {
		this.ig701DAO = ig701DAO;
	}

	/**
	 * ���̲鿴��ɫ��Ȩ����ʵ��ȡ��
	 *
	 * @return ���̲鿴��ɫ��Ȩ����ʵ��
	 */
	public IG701TB getIg701TBInstance() {
		return new IG701TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG701Info> searchIg701() {
		return ig701DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG701Info searchIg701ByPK(IG701PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG701SearchCond cond) {
		return ig701DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond) {
		return ig701DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond, int start,
			int count) {
		return ig701DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG701Info registIg701(IG701Info instance)
		throws BLException {
		return ig701DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG701Info updateIg701(IG701Info instance)
		throws BLException {
		checkExistInstance(new IG701PK(instance.getPdid(), instance.getRoleid(), instance.getPidid()));
		return ig701DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIg701ByPK(IG701PK pk)
		throws BLException {
		ig701DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIg701(IG701Info instance)
		throws BLException {
		ig701DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG701Info checkExistInstance(IG701PK pk)
		throws BLException {
		IG701Info instance = ig701DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
     * XML�ű���������
     *
     * @param pdid ���̶���ID
     * @return XML�ű�
     */
    public StringBuffer exportXML(String pdid) throws BLException {
    	IG701SearchCondImpl cond = new IG701SearchCondImpl();
        cond.setPdid(pdid);
        List<IG701Info> lst_IG701Info = this.searchIg701(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG701>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG701Info != null) {
            for(IG701Info info : lst_IG701Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRoleid().toString()) ? "" : "&roleid_" + info.getRoleid().toString() + ";");
                sbf_xml.append("</ROLEID>");
                sbf_xml.append("<PIDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
                sbf_xml.append("</PIDID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG701>");
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
        List<IG701Info> lst_IG701 = new ArrayList<IG701Info>();
        IG701TB entity = null;
        for(Element e : dataList) {
            entity = this.getIg701TBInstance();
            entity.setPdid(e.getChildText("PDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setPidid(e.getChildText("PIDID"));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG701.add(entity);
        }
        this.ig701DAO.saveOrUpdateAll(lst_IG701);
    }

}