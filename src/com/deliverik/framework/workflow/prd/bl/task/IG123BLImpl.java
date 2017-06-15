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
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG123DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG123TB;

/**
  * ����: �Զ������̻�����Χ��ҵ���߼�ʵ��
  * ��������: �Զ������̻�����Χ��ҵ���߼�ʵ��
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
public class IG123BLImpl extends BaseBLImpl implements IG123BL {

	/** �Զ������̻�����Χ��DAO�ӿ� */
	protected IG123DAO ig123DAO;
	
	/**
	 * �Զ������̻�����Χ��DAO�ӿ��趨
	 *
	 * @param iG123DAO �Զ������̻�����Χ��DAO�ӿ�
	 */
	public void setIg123DAO(IG123DAO ig123DAO) {
		this.ig123DAO = ig123DAO;
	}

	/**
	 * �Զ������̻�����Χ��ʵ��ȡ��
	 *
	 * @return �Զ������̻�����Χ��ʵ��
	 */
	public IG123TB getIG123TBInstance() {
		return new IG123TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG123Info> searchIG123() {
		return ig123DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG123Info searchIG123ByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG123SearchCond cond) {
		return ig123DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG123Info> searchIG123( IG123SearchCond cond) {
		return ig123DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond, int start, int count) {
		return ig123DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG123Info registIG123(IG123Info instance) throws BLException {
		return ig123DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG123Info updateIG123(IG123Info instance) throws BLException {
		checkExistInstance(instance.getPotdid());
		return ig123DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG123ByPK(String pk) throws BLException {
		ig123DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG123(IG123Info instance) throws BLException {
		ig123DAO.delete(instance);
	}
	
	/**
	 * ����ɾ������
	 * @param list
	 * @throws BLException
	 */
	public void deleteIG123List(List<IG123Info> list) throws BLException{
		ig123DAO.delete(list);
	}
	
	/**
	 * POTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPotdidSequenceNextValue(String pdid) throws BLException{
		return ig123DAO.getPotdidSequenceNextValue(pdid);
	}
	
	/**
	 * �������̶���������ѯ
	 * @param pdid ���̶�������
	 * @return ������Χ����
	 * @throws BLException
	 */
	public List<IG123Info> findBypdid(String pdid){
		if(StringUtils.isEmpty(pdid)) return null;
		IG123SearchCondImpl cond = new IG123SearchCondImpl();
		cond.setPdid(pdid);
		return this.searchIG123(cond);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG123Info checkExistInstance(String pk) throws BLException {
		IG123Info instance = ig123DAO.findByPK(pk);
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
		List<IG123Info> ig123List = this.findBypdid(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG123>");
		sbf_xml.append("<DATALIST>");
		if(ig123List!=null){
			for(IG123Info info:ig123List){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<POTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPotdid())?"":IGStringUtils.filterXMLStr(info.getPotdid()));
				sbf_xml.append("</POTDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid())?"":IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<ORGID>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgid())?"":IGStringUtils.filterXMLStr(info.getOrgid()));
				sbf_xml.append("</ORGID>");
				sbf_xml.append("<ORGNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgname())?"":IGStringUtils.filterXMLStr(info.getOrgname()));
				sbf_xml.append("</ORGNAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint())?"":IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG123>");
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
		List<IG123Info> lst_IG123 = new ArrayList<IG123Info>();
		IG123TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG123TBInstance();
			entity.setPotdid(e.getChildText("POTDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setOrgid(e.getChildText("ORGID"));
			entity.setOrgname(e.getChildText("ORGNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG123.add(entity);
		}
		this.ig123DAO.saveOrUpdateAll(lst_IG123);
	}
}