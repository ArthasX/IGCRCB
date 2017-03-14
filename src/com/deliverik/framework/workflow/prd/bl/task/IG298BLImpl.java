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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG298DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣҵ���߼�ʵ��
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣҵ���߼�ʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public class IG298BLImpl extends BaseBLImpl implements
		IG298BL {

	/** ����״̬�ɷ��ɽ�ɫ������ϢDAO�ӿ� */
	protected IG298DAO ig298DAO;
	
	/**
	 * ����״̬�ɷ��ɽ�ɫ������ϢDAO�ӿ��趨
	 *
	 * @param ig298DAO ����״̬�ɷ��ɽ�ɫ������ϢDAO�ӿ�
	 */
	public void setIg298DAO(IG298DAO ig298DAO) {
		this.ig298DAO = ig298DAO;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ������Ϣʵ��ȡ��
	 *
	 * @return ����״̬�ɷ��ɽ�ɫ������Ϣʵ��
	 */
	public IG298TB getIG298TBInstance() {
		return new IG298TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG298Info> searchIG298Info() {
		return ig298DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG298Info searchIG298InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG298SearchCond cond) {
		return ig298DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond) {
		return ig298DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond, int start,
			int count) {
		return ig298DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG298Info registIG298Info(IG298Info instance)
		throws BLException {
		return ig298DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG298Info updateIG298Info(IG298Info instance)
		throws BLException {
		checkExistInstance(instance.getPsrdid());
		return ig298DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG298InfoByPK(String pk)
		throws BLException {
		ig298DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG298Info(IG298Info instance)
		throws BLException {
		ig298DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG298Info checkExistInstance(String pk)
		throws BLException {
		IG298Info instance = ig298DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * PSRDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSRDID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid) {
		return ig298DAO.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ��ѯ
	 *
	 * @param psdid ����״̬ID
	 * @return �ɷ��ɽ�ɫ�б�
	 * @throws BLException 
	 */
	public List<IG298Info> searchIG298Info(
			String psdid) throws BLException {
		if (StringUtils.isEmpty(psdid)) {
			throw new BLException("IGCO10000.E004", "����״̬����");
		}
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsdid(psdid);
		return ig298DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ���̶���ID
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid) {
		return ig298DAO.searchToBeAssignRole(pdid, psdid);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ʵ��
	 */
	public IG298Info checkIG298Info(String psdid, Integer roleid)
		throws BLException {
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setRoleid(roleid);
		List<IG298Info> lst = ig298DAO.findByCond(cond, 0, 0);
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsrdid_like(pdid);
		List<IG298Info> lst_IG298Info = this.searchIG298Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG298>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG298Info != null) {
			for(IG298Info info : lst_IG298Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSRDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsrdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsrdid()));
				sbf_xml.append("</PSRDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG298>");
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
		List<IG298Info> lst_IG298 = new ArrayList<IG298Info>();
		IG298TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG298TBInstance();
			entity.setPsrdid(e.getChildText("PSRDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setRoleid(StringUtils.isEmpty(e.getChildText("ROLEID")) ? null : new Integer(e.getChildText("ROLEID")));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG298.add(entity);
		}
		this.ig298DAO.saveOrUpdateAll(lst_IG298);
	}

}