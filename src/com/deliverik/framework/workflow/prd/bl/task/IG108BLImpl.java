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
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG108DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG108TB;

/**
  * ����: �Զ������̱���ѯ���������ҵ���߼�ʵ��
  * ��������: �Զ������̱���ѯ���������ҵ���߼�ʵ��
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
public class IG108BLImpl extends BaseBLImpl implements IG108BL {

	/** �Զ������̱���ѯ���������DAO�ӿ� */
	protected IG108DAO ig108DAO;
	
	/**
	 * �Զ������̱���ѯ���������DAO�ӿ��趨
	 *
	 * @param ig108DAO �Զ������̱���ѯ���������DAO�ӿ�
	 */
	public void setIg108DAO(IG108DAO ig108DAO) {
		this.ig108DAO = ig108DAO;
	}

	/**
	 * �Զ������̱���ѯ���������ʵ��ȡ��
	 *
	 * @return �Զ������̱���ѯ���������ʵ��
	 */
	public IG108TB getIG108TBInstance() {
		return new IG108TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG108Info> searchIG108() {
		return ig108DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG108Info searchIG108ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG108SearchCond cond) {
		return ig108DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond) {
		return ig108DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ��������������������
	 * @param pdid
	 * @return
	 */
	public List<IG108Info> findBypdid(String pdid){
		if(StringUtils.isEmpty(pdid)){
			return null;
		}
		IG108SearchCondImpl cond = new IG108SearchCondImpl();
		cond.setPdid(pdid);
		return this.searchIG108(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond, int start,int count) {
		return ig108DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG108Info registIG108(IG108Info instance) throws BLException {
		return ig108DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG108Info updateIG108(IG108Info instance) throws BLException {
		checkExistInstance(instance.getPqid());
		return ig108DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG108ByPK(Integer pk) throws BLException {
		ig108DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG108(IG108Info instance) throws BLException {
		ig108DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG108Info checkExistInstance(Integer pk) throws BLException {
		IG108Info instance = ig108DAO.findByPK(pk);
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
		List<IG108Info> lst_IG108Info = this.findBypdid(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG108>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG108Info != null) {
			for(IG108Info info : lst_IG108Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid())?"":IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid())?"":IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG108>");
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
		List<IG108Info> lst_IG108 = new ArrayList<IG108Info>();
		IG108TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG108TBInstance();
			entity.setPdid(e.getChildText("PDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG108.add(entity);
		}
		this.ig108DAO.saveOrUpdateAll(lst_IG108);
	}

}