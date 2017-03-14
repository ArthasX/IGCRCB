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
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG132DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;

/**
  * ����: �����߰�ť������Ϣ��ҵ���߼�ʵ��
  * ��������: �����߰�ť������Ϣ��ҵ���߼�ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG132BLImpl extends BaseBLImpl implements
		IG132BL {

	/** �����߰�ť������Ϣ��DAO�ӿ� */
	protected IG132DAO ig132DAO;
	
	/**
	 * �����߰�ť������Ϣ��DAO�ӿ��趨
	 *
	 * @param ig132DAO �����߰�ť������Ϣ��DAO�ӿ�
	 */
	public void setIg132DAO(IG132DAO ig132DAO) {
		this.ig132DAO = ig132DAO;
	}

	/**
	 * �����߰�ť������Ϣ��ʵ��ȡ��
	 *
	 * @return �����߰�ť������Ϣ��ʵ��
	 */
	public IG132TB getIG132TBInstance() {
		return new IG132TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG132Info> searchIG132Info() {
		return ig132DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG132Info searchIG132InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG132SearchCond cond) {
		return ig132DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG132Info> searchIG132Info(
			IG132SearchCond cond) {
		return ig132DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG132Info> searchIG132Info(
			IG132SearchCond cond, int start,
			int count) {
		return ig132DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG132Info registIG132Info(IG132Info instance)
		throws BLException {
		return ig132DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG132Info updateIG132Info(IG132Info instance)
		throws BLException {
		checkExistInstance(instance.getPpbdid());
		return ig132DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG132InfoByPK(String pk)
		throws BLException {
		ig132DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG132Info(IG132Info instance)
		throws BLException {
		ig132DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG132Info checkExistInstance(String pk)
		throws BLException {
		IG132Info instance = ig132DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPpbdidSequenceNextValue(String ppdid) {
		return ig132DAO.getPpbdidSequenceNextValue(ppdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG132SearchCondImpl cond = new IG132SearchCondImpl();
		cond.setPpbdid_like(pdid);
		List<IG132Info> lst_IG132Info = this.searchIG132Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG132>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG132Info != null) {
			for(IG132Info info : lst_IG132Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PPBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpbdid()));
				sbf_xml.append("</PPBDID>");
				sbf_xml.append("<PPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpdid()));
				sbf_xml.append("</PPDID>");
				sbf_xml.append("<PBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPbdid()));
				sbf_xml.append("</PBDID>");
				sbf_xml.append("<PPBDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpbdname()) ? "" : IGStringUtils.filterXMLStr(info.getPpbdname()));
				sbf_xml.append("</PPBDNAME>");
				sbf_xml.append("<PPBDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpbddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPpbddesc()));
				sbf_xml.append("</PPBDDESC>");
				sbf_xml.append("<PPBDAUTH>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpbdauth()) ? "" : IGStringUtils.filterXMLStr(info.getPpbdauth()));
				sbf_xml.append("</PPBDAUTH>");
				sbf_xml.append("<CHECKREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrequired()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrequired()));
				sbf_xml.append("</CHECKREQUIRED>");
				sbf_xml.append("<CHECKRECORD>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrecord()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrecord()));
				sbf_xml.append("</CHECKRECORD>");
				sbf_xml.append("<ACTURL>");
				sbf_xml.append(StringUtils.isEmpty(info.getActurl()) ? "" : IGStringUtils.filterXMLStr(info.getActurl()));
				sbf_xml.append("</ACTURL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG132>");
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
		List<IG132Info> lst_IG132 = new ArrayList<IG132Info>();
		IG132TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG132TBInstance();
			entity.setPpbdid(e.getChildText("PPBDID"));
			entity.setPpdid(e.getChildText("PPDID"));
			entity.setPbdid(e.getChildText("PBDID"));
			entity.setPpbdname(e.getChildText("PPBDNAME"));
			entity.setPpbddesc(e.getChildText("PPBDDESC"));
			entity.setPpbdauth(e.getChildText("PPBDAUTH"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setCheckrequired(e.getChildText("CHECKREQUIRED"));
			entity.setCheckrecord(e.getChildText("CHECKRECORD"));
			entity.setActurl(e.getChildText("ACTURL"));
			lst_IG132.add(entity);
		}
		this.ig132DAO.saveOrUpdateAll(lst_IG132);
	}
}