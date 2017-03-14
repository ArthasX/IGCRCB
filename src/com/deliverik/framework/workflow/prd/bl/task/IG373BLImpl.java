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
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG373DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;

/**
  * ����: ���̱���ʼ���¼������ҵ���߼�ʵ��
  * ��������: ���̱���ʼ���¼������ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
public class IG373BLImpl extends BaseBLImpl implements
		IG373BL {

	/** ���̱���ʼ���¼������DAO�ӿ� */
	protected IG373DAO ig373DAO;
	
	/**
	 * ���̱���ʼ���¼������DAO�ӿ��趨
	 *
	 * @param ig373DAO ���̱���ʼ���¼������DAO�ӿ�
	 */
	public void setIg373DAO(IG373DAO ig373DAO) {
		this.ig373DAO = ig373DAO;
	}

	/**
	 * ���̱���ʼ���¼������ʵ��ȡ��
	 *
	 * @return ���̱���ʼ���¼������ʵ��
	 */
	public IG373TB getIG373TBInstance() {
		return new IG373TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG373Info> searchIG373Info() {
		return ig373DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG373Info searchIG373InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG373SearchCond cond) {
		return ig373DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond) {
		return ig373DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond, int start,
			int count) {
		return ig373DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG373Info registIG373Info(IG373Info instance)
		throws BLException {
		return ig373DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG373Info updateIG373Info(IG373Info instance)
		throws BLException {
		checkExistInstance(instance.getPiidid());
		return ig373DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG373InfoByPK(String pk)
		throws BLException {
		ig373DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG373Info(IG373Info instance)
		throws BLException {
		ig373DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG373Info checkExistInstance(String pk)
		throws BLException {
		IG373Info instance = ig373DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * PIIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PIIDID����ֵ
	 */
	public String getPiididSequenceNextValue(String psdid) {
		return ig373DAO.getPiididSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG373SearchCondImpl cond = new IG373SearchCondImpl();
		cond.setPdid(pdid);
		List<IG373Info> lst_IG373Info = this.searchIG373Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG373>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG373Info != null) {
			for(IG373Info info : lst_IG373Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiidid()) ? "" : IGStringUtils.filterXMLStr(info.getPiidid()));
				sbf_xml.append("</PIIDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIIDBLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiidblid()) ? "" : IGStringUtils.filterXMLStr(info.getPiidblid()));
				sbf_xml.append("</PIIDBLID>");
				sbf_xml.append("<PIIDDEC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiiddec()) ? "" : IGStringUtils.filterXMLStr(info.getPiiddec()));
				sbf_xml.append("</PIIDDEC>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG373>");
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
		List<IG373Info> lst_IG373 = new ArrayList<IG373Info>();
		IG373TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG373TBInstance();
			entity.setPiidid(e.getChildText("PIIDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPiidblid(e.getChildText("PIIDBLID"));
			entity.setPiiddec(e.getChildText("PIIDDEC"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG373.add(entity);
		}
		this.ig373DAO.saveOrUpdateAll(lst_IG373);
	}

}