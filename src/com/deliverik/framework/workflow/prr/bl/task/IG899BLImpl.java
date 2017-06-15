/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG899DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * ����: ����˽�б�����ҵ���߼�ʵ��
  * ��������: ����˽�б�����ҵ���߼�ʵ��
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public class IG899BLImpl extends BaseBLImpl implements
		IG899BL {

	/** ����˽�б�����DAO�ӿ� */
	protected IG899DAO ig899DAO;
	
	/** ���̱���BL */
	protected IG599BL ig599BL;
	
	/**
	 * ����˽�б�����DAO�ӿ��趨
	 *
	 * @param ig899DAO ����˽�б�����DAO�ӿ�
	 */
	public void setIg899DAO(IG899DAO ig899DAO) {
		this.ig899DAO = ig899DAO;
	}
	
	/**
	 * ���̱���BL�趨
	 * 
	 * @param ig599BL ���̱���BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * ����˽�б�����ʵ��ȡ��
	 *
	 * @return ����˽�б�����ʵ��
	 */
	public IG899TB getIG899TBInstance() {
		return new IG899TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG899Info> searchIG899Info() {
		return ig899DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG899Info searchIG899InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG899SearchCond cond) {
		return ig899DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond) {
		return ig899DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond, int start,
			int count) {
		return ig899DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param ig899Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG899Info registIG899Info(IG899Info ig899Info)
		throws BLException {
		return ig899DAO.save(ig899Info);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param ig899Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG899Info updateIG899Info(IG899Info ig899Info)
		throws BLException {
		checkExistInstance(ig899Info.getPpiid());
		return ig899DAO.save(ig899Info);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG899InfoByPK(Integer pk)
		throws BLException {
		ig899DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param ig899Info ɾ��ʵ��
	 */
	public void deleteIG899Info(IG899Info ig899Info)
		throws BLException {
		ig899DAO.delete(ig899Info);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG899Info checkExistInstance(Integer pk)
		throws BLException {
		IG899Info instance = ig899DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ����˽�б�������
	 * 
	 * @param ig899InfoList ����������
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException 
	 */
	public void registIG899Info(List<IG599Info> ig899InfoList, Integer roleid, String userid,String orgid) throws BLException {
		boolean flag = true;
		if(ig899InfoList == null || (roleid == null || roleid == 0) || StringUtils.isEmpty(userid)) {
			flag = false;
		}
		if(flag) {
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			for(IG599Info pi : ig899InfoList) {
				//�ж��Ƿ�˽�б���
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pi.getPidaccess())
						&& IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(pi.getPidmode())) {
					cond.setPiid(pi.getPiid());
					cond.setPidid(pi.getPidid());
					cond.setRoleid(roleid);
					//��Χ���û�
					if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(pi.getPrivatescope())) {
						cond.setUserid(userid);
						cond.setRoleid(null);
						cond.setOrgid(null);
					} else if (IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(pi.getPrivatescope())){
						cond.setUserid(null);
						cond.setRoleid(roleid);
						cond.setOrgid(null);
					} else if (IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(pi.getPrivatescope())){
						cond.setUserid(null);
						cond.setOrgid(orgid);
						cond.setRoleid(null);
					}
					//������˽�б��Ƿ��ѱ����
					List<IG899Info> lst_ProcessPrivateInfo = this.searchIG899Info(cond);
					//û����
					if(lst_ProcessPrivateInfo.isEmpty()) {
						//��Χ�ǽ�ɫ
						IG899TB ppTB = this.getIG899TBInstance();
						ppTB.setPidid(pi.getPidid());
						ppTB.setPiid(pi.getPiid());
						ppTB.setPpiattkey(pi.getPiattkey());
						ppTB.setPpivalue(pi.getPivarvalue());
						ppTB.setPpicommect(pi.getPidcomment());
						//��Χ���û�
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(pi.getPrivatescope())) {
							ppTB.setUserid(userid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(pi.getPrivatescope())){
							ppTB.setRoleid(roleid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(pi.getPrivatescope())){
							ppTB.setOrgid(orgid);
						}
						//����
						this.registIG899Info(ppTB);
					} else if(lst_ProcessPrivateInfo.size() == 1) {
//						����ѱ���������ж��Ƿ�ֵ�ı�
//						if((pi.getPivarvalue()!= null && !pi.getPivarvalue().equals(lst_ProcessPrivateInfo.get(0).getPpivalue()))
//								|| (pi.getPiattkey()!= null && !pi.getPiattkey().equals(lst_ProcessPrivateInfo.get(0).getPpiattkey()))) {
							IG899TB ppTB = (IG899TB)SerializationUtils.clone(lst_ProcessPrivateInfo.get(0));
							ppTB.setPpivalue(pi.getPivarvalue());
							ppTB.setPpicommect(pi.getPidcomment());
							if(StringUtils.isEmpty(ppTB.getPpiattkey())){
								ppTB.setPpiattkey(pi.getPiattkey());
							}
							this.updateIG899Info(ppTB);
//						}
					} else {
						throw new BLException("IGCO10000.E004", pi.getPivarname() + "˽�б���ֵ");
					}
					
					//���ProcessInfo�е�ֵ
					IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
					piTB.setPivarvalue(null);
					piTB.setPiattkey(null);
					piTB.setPidcomment(null);
					this.ig599BL.updateIG599Info(piTB);
				}
			}
		}
		else {
			throw new BLException("IGCO10000.E004", "˽�б������洦�����");
		}
	}

}