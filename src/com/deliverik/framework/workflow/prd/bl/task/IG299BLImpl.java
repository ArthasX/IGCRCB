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
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG299DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * ����: ״̬�ɷ��ɻ��������ҵ���߼�ʵ��
  * ��������: ״̬�ɷ��ɻ��������ҵ���߼�ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public class IG299BLImpl extends BaseBLImpl implements
		IG299BL {

	/** ״̬�ɷ��ɻ��������DAO�ӿ� */
	protected IG299DAO ig299DAO;
	
	/**
	 * ״̬�ɷ��ɻ��������DAO�ӿ��趨
	 *
	 * @param ig299DAO ״̬�ɷ��ɻ��������DAO�ӿ�
	 */
	public void setIg299DAO(IG299DAO ig299DAO) {
		this.ig299DAO = ig299DAO;
	}

	/**
	 * ״̬�ɷ��ɻ��������ʵ��ȡ��
	 *
	 * @return ״̬�ɷ��ɻ��������ʵ��
	 */
	public IG299TB getIG299TBInstance() {
		return new IG299TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG299Info> searchIG299() {
		return ig299DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG299Info searchIG299ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG299SearchCond cond) {
		return ig299DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond) {
		return ig299DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond, int start,
			int count) {
		return ig299DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG299Info registIG299(IG299Info instance)
		throws BLException {
		return ig299DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG299Info updateIG299(IG299Info instance)
		throws BLException {
		checkExistInstance(instance.getPsodid());
		return ig299DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG299ByPK(String pk)
		throws BLException {
		ig299DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG299(IG299Info instance)
		throws BLException {
		ig299DAO.delete(instance);
	}

	/**
	 * PSODID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSODID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid) {
		return ig299DAO.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * ָ��״̬�ɷ��ɻ�����ѯ
	 *
	 * @param psdid ����״̬ID
	 * @return �ɷ��ɻ����б�
	 * @throws BLException 
	 */
	public List<IG299Info> searchIG299Info(
			String psdid) throws BLException {
		if (StringUtils.isEmpty(psdid)) {
			throw new BLException("IGCO10000.E004", "����״̬����");
		}
		IG299SearchCondImpl cond = new IG299SearchCondImpl();
		cond.setPsdid_eq(psdid);
		return ig299DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * �ɱ����ɵĻ�����������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĻ����б�
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid) {
		return ig299DAO.searchToBeAssignOrg(pdid, levellen, psdid);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG299Info checkExistInstance(String pk)
		throws BLException {
		IG299Info instance = ig299DAO.findByPK(pk);
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
		IG299SearchCondImpl cond = new IG299SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG299Info> ig299List = this.searchIG299(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG299>");
		sbf_xml.append("<DATALIST>");
		if(ig299List!=null){
			for(IG299Info info:ig299List){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSODID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsodid())?"":IGStringUtils.filterXMLStr(info.getPsodid()));
				sbf_xml.append("</PSODID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid())?"":IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<ORGSYSCODING>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgsyscoding())?"":IGStringUtils.filterXMLStr(info.getOrgsyscoding()));
				sbf_xml.append("</ORGSYSCODING>");
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
		sbf_xml.append("</IG299>");
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
		List<IG299Info> lst_IG299 = new ArrayList<IG299Info>();
		IG299TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG299TBInstance();
			entity.setPsodid(e.getChildText("PSODID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setOrgsyscoding(e.getChildText("ORGSYSCODING"));
			entity.setOrgname(e.getChildText("ORGNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG299.add(entity);
		}
		this.ig299DAO.saveOrUpdateAll(lst_IG299);
	}

}