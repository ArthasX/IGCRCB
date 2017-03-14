package com.deliverik.framework.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.dao.CodeDetailTBDAO;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * ������Ϣ�����߼�ʵ��
 * 
 * @author 
 */
public class CodeDetailBLImpl extends BaseBLImpl implements CodeDetailBL {

	/** CodeDetailTB DAO */
	protected CodeDetailTBDAO codeDetailTBDAO;

	public void setCodeDetailTBDAO(CodeDetailTBDAO codeDetailTBDAO) {
		this.codeDetailTBDAO = codeDetailTBDAO;
	}

	/**
	 * ������������
	 * 
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetail searchCodeDetailByPK(CodeDetailTBPK pk) {
		return codeDetailTBDAO.findByPK(pk);
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeDetailSearchCond cond){

		return codeDetailTBDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetail(CodeDetailSearchCond cond,int orderbyFlag){

		List<CodeDetail> ret = codeDetailTBDAO.findByCond(cond,0,0,orderbyFlag);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetailTree(CodeDetailSearchCond cond,int orderbyFlag){
		List<CodeDetail> ret = codeDetailTBDAO.findByCond(cond,orderbyFlag);
		return ret;
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetail> searchCodeDetail(CodeDetailSearchCond cond, 
			int start, int count ,int orderbyFlag){

		List<CodeDetail> ret = codeDetailTBDAO.findByCond(cond,start,count,orderbyFlag);
		return ret;
	}
	
	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid){
		return this.codeDetailTBDAO.getLastUpdate(ccid, pccid, pcid);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(String syscoding){
		return this.codeDetailTBDAO.getSyscoding(syscoding);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(String ccid){
		return this.codeDetailTBDAO.getSyscodingLevel1(ccid);
	}
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid){
		return this.codeDetailTBDAO.getMaxcid(ccid);
	}

	/**
	 * ��¼����
	 * 
	 * @param codeDetail ��¼����
	 * @return ������Ϣ
	 */
	public CodeDetail registCodeDetail(CodeDetail codeDetail) throws BLException{
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkNotExistCodeDetail(pk);
		
		CodeDetail ret = codeDetailTBDAO.save(codeDetail);
		return ret;
	}

	/**
	 * ɾ������
	 * 
	 * @param codeDetail ɾ������
	 * @return
	 */
	public void deleteCodeDetail(CodeDetail codeDetail) throws BLException{
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkExistCodeDetail(pk);
		
		codeDetailTBDAO.delete(codeDetail);
	}

	/**
	 * ɾ������
	 * 
	 * @param pk ɾ�����������Ϣ����
	 * @return
	 */
	public CodeDetail deleteCodeDetail(CodeDetailTBPK pk) throws BLException{
		CodeDetail info = checkExistCodeDetail(pk);
		codeDetailTBDAO.delete(info);
		
		return info;
	}

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ���������CD
	 * @return
	 */
	public List<CodeDetail> deleteCodeDetail(String ccid) throws BLException {
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(ccid);
		List<CodeDetail> infoList = codeDetailTBDAO.findByCond(cond, 0, 0, 0);
		
		codeDetailTBDAO.delete(infoList);
		
		return infoList;
	}

	/**
	 * �������
	 * 
	 * @param codeDetail �������
	 * @return ������Ϣ
	 */
	public CodeDetail updateCodeDetail(CodeDetail codeDetail) throws BLException{
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkExistCodeDetail(pk);
		
		CodeDetail ret = codeDetailTBDAO.save(codeDetail);
		return ret;
	}


	/**
	 * ������Ϣ�����ڼ��
	 * 
	 * @param pk ������Ϣ����
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistCodeDetail(CodeDetailTBPK pk) throws BLException{

		CodeDetail info = this.codeDetailTBDAO.findByPK(pk);
		if( info != null ) {
			throw new BLException(BLErrorType.CODEDETAIL_ALREADY_EXISTS_ERROR,
					"IGCO10000.E003","����");
		}
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param pk ������Ϣ����
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	protected CodeDetail checkExistCodeDetail(CodeDetailTBPK pk) throws BLException{
		CodeDetail info = this.codeDetailTBDAO.findByPK(pk);
		if( info == null) {
			throw new BLException(BLErrorType.CODEDETAIL_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		return info;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param ecategory �ʲ�����
	 * @param rccid ��ϵ�������ݷ����
	 * @return ��������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid){
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(rccid);
		cond.setBusinesscode_like(ecategory);
		List<CodeDetail> ret = this.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//�����豸�����Ĺ�ϵ
		if(CommonDefineUtils.ENTIY_CATEGORY_DEVICE.equals(ecategory)){
			for(int i=0; i<ret.size(); i++){
				if(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION_CODE.equals(ret.get(i).getBusinesscode())){
					ret.remove(i);
				}
			}
		}
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(CodeDetail cd : ret){
			if(!ecategory.equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)){
				if(cd.getBusinesscode().indexOf(CommonDefineUtils.ENTIY_CATEGORY_MODULE)>-1){
					continue;
				}
			}
			list.add(new LabelValueBean(cd.getCvalue(), cd.getCid()+"#"+cd.getBusinesscode()));
		}
		return list;
	}
	

}
