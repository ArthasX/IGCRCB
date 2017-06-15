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
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG212DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;

/**
  * ����: ����֪ͨ����ҵ���߼�ʵ��
  * ��������: ����֪ͨ����ҵ���߼�ʵ��
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public class IG212BLImpl extends BaseBLImpl implements
		IG212BL {

	/** ����֪ͨ����DAO�ӿ� */
	protected IG212DAO ig212DAO;
	
	/**
	 * ����֪ͨ����DAO�ӿ��趨
	 *
	 * @param ig212DAO ����֪ͨ����DAO�ӿ�
	 */
	public void setIg212DAO(IG212DAO ig212DAO) {
		this.ig212DAO = ig212DAO;
	}

	/**
	 * ����֪ͨ����ʵ��ȡ��
	 *
	 * @return ����֪ͨ����ʵ��
	 */
	public IG212TB getIG212TBInstance() {
		return new IG212TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG212Info> searchIG212Info() {
		return ig212DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG212Info searchIG212InfoByPK(IG212PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG212SearchCond cond) {
		return ig212DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond) {
		return ig212DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond, int start,
			int count) {
		return ig212DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG212Info registIG212Info(IG212Info instance)
		throws BLException {
		return ig212DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG212Info updateIG212Info(IG212Info instance)
		throws BLException {
		checkExistInstance(new IG212PK(instance.getPsdid(), instance.getPsdconfirm()));
		return ig212DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG212InfoByPK(IG212PK pk)
		throws BLException {
		ig212DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG212Info(IG212Info instance)
		throws BLException {
		ig212DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG212Info checkExistInstance(IG212PK pk)
		throws BLException {
		IG212Info instance = ig212DAO.findByPK(pk);
		return instance;
	}
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	public List<IG238Info> searchIG238Info(String pdid) {
		return ig212DAO.searchIG238Info(pdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG212SearchCondImpl cond = new IG212SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG212Info> lst_IG212Info = this.searchIG212Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG212>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG212Info != null) {
			for(IG212Info info : lst_IG212Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSDCONFIRM>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdconfirm()) ? "" : IGStringUtils.filterXMLStr(info.getPsdconfirm()));
				sbf_xml.append("</PSDCONFIRM>");
				sbf_xml.append("<SMS>");
				sbf_xml.append(StringUtils.isEmpty(info.getSms()) ? "" : IGStringUtils.filterXMLStr(info.getSms()));
				sbf_xml.append("</SMS>");
				sbf_xml.append("<EMAIL>");
				sbf_xml.append(StringUtils.isEmpty(info.getEmail()) ? "" : IGStringUtils.filterXMLStr(info.getEmail()));
				sbf_xml.append("</EMAIL>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG212>");
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
		List<IG212Info> lst_IG212 = new ArrayList<IG212Info>();
		IG212TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG212TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPsdconfirm(e.getChildText("PSDCONFIRM"));
			entity.setSms(e.getChildText("SMS"));
			entity.setEmail(e.getChildText("EMAIL"));

			entity.setPdid(e.getChildText("PDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG212.add(entity);
		}
		this.ig212DAO.saveOrUpdateAll(lst_IG212);
	}

}