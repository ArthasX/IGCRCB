/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ����: �豸��ϵ��Ϣ��FS-LV-VG��DAO�ӿ�
 * ��������: �豸��ϵ��Ϣ��FS-LV-VG��DAO�ӿ�
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface FsLvVgDao extends BaseHibernateDAO<FsLvVgInfo> {

	public ArrayList<FsLvVgInfo> searchFsLvVg(FsLvVgSearchCond cond);

}
