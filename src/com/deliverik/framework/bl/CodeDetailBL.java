package com.deliverik.framework.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;
import com.deliverik.framework.model.entity.CodeDetailTBPK;


/**
 * ������Ϣ�����߼��ӿ�
 * 
 */
public interface CodeDetailBL extends BaseBL{

	/**
	 * ������������
	 * 
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetail searchCodeDetailByPK(CodeDetailTBPK pk);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeDetailSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetail(CodeDetailSearchCond cond,int orderbyFlag);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetail(CodeDetailSearchCond cond, 
			int start, int count, int orderbyFlag);

	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(String ccid);
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid);

	/**
	 * ��¼����
	 * 
	 * @param entity ��¼����
	 * @return ������Ϣ
	 */
	public CodeDetail registCodeDetail(CodeDetail codeDetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param entity ɾ������
	 * @return
	 */
	public void deleteCodeDetail(CodeDetail codeDetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param eid ɾ�����������Ϣ����
	 * @return
	 */
	public CodeDetail deleteCodeDetail(CodeDetailTBPK pk) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ���������CD
	 * @return
	 */
	public List<CodeDetail> deleteCodeDetail(String ccid) throws BLException;

	/**
	 * �������
	 * 
	 * @param entity �������
	 * @return ������Ϣ
	 */
	public CodeDetail updateCodeDetail(CodeDetail codeDetail) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetailTree(CodeDetailSearchCond cond,int orderbyFlag);
	
	/**
	 * ��ȡ������Ϣ
	 * @param ecategory �ʲ�����
	 * @param rccid ��ϵ�������ݷ����
	 * @return ��������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid);
	
}
