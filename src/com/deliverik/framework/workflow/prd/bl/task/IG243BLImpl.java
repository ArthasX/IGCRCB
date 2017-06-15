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
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG243DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;

/**
  * ����: ���̱��ⶨ���ҵ���߼�ʵ��
  * ��������: ���̱��ⶨ���ҵ���߼�ʵ��
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
public class IG243BLImpl extends BaseBLImpl implements
		IG243BL {

	/** ���̱��ⶨ���DAO�ӿ� */
	protected IG243DAO ig243DAO;
	
	/**
	 * ���̱��ⶨ���DAO�ӿ��趨
	 *
	 * @param ig243DAO ���̱��ⶨ���DAO�ӿ�
	 */
	public void setIg243DAO(IG243DAO ig243DAO) {
		this.ig243DAO = ig243DAO;
	}

	/**
	 * ���̱��ⶨ���ʵ��ȡ��
	 *
	 * @return ���̱��ⶨ���ʵ��
	 */
	public IG243TB getIG243TBInstance() {
		return new IG243TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG243Info> searchIG243Info() {
		return ig243DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG243Info searchIG243InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG243SearchCond cond) {
		return ig243DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond) {
		return ig243DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond, int start,
			int count) {
		return ig243DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG243Info registIG243Info(IG243Info instance)
		throws BLException {
		return ig243DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG243Info updateIG243Info(IG243Info instance)
		throws BLException {
		checkExistInstance(instance.getPtdid());
		return ig243DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG243InfoByPK(String pk)
		throws BLException {
		ig243DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG243Info(IG243Info instance)
		throws BLException {
		ig243DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG243Info checkExistInstance(String pk)
		throws BLException {
		IG243Info instance = ig243DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String pdid) {
		return ig243DAO.getPtdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPtdid_like(pdid);
		List<IG243Info> lst_IG243Info = this.searchIG243Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG243>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG243Info != null) {
			for(IG243Info info : lst_IG243Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdid()) ? "" : IGStringUtils.filterXMLStr(info.getPtdid()));
				sbf_xml.append("</PTDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PTITLENAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtitlename()) ? "" : IGStringUtils.filterXMLStr(info.getPtitlename()));
				sbf_xml.append("</PTITLENAME>");
				sbf_xml.append("<PTITLEACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtitleaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPtitleaccess()));
				sbf_xml.append("</PTITLEACCESS>");
				sbf_xml.append("<PDESCNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdescname()) ? "" : IGStringUtils.filterXMLStr(info.getPdescname()));
				sbf_xml.append("</PDESCNAME>");
				sbf_xml.append("<PDESCACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdescaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPdescaccess()));
				sbf_xml.append("</PDESCACCESS>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG243>");
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
		List<IG243Info> lst_IG243 = new ArrayList<IG243Info>();
		IG243TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG243TBInstance();
			entity.setPtdid(e.getChildText("PTDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPtitlename(e.getChildText("PTITLENAME"));
			entity.setPtitleaccess(e.getChildText("PTITLEACCESS"));
			entity.setPdescname(e.getChildText("PDESCNAME"));
			entity.setPdescaccess(e.getChildText("PDESCACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG243.add(entity);
		}
		this.ig243DAO.saveOrUpdateAll(lst_IG243);
	}

}