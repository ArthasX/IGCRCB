/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.entity.IG622TB;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;

/**
 * ����: ��ҳ�����߼�ʵ��
 * ������������ҳ�����߼�ʵ��
 * ������¼����ѧ־    2012/11/14
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class IGSYM18BLImpl extends BaseBLImpl implements IGSYM18BL {

	static Log log = LogFactory.getLog(IGSYM18BLImpl.class);
	/** ��ҳ����bl*/
	private IG622BL ig622BL;
	/**
	 *��ҳ����bl �趨
	 *	
	 * @param ig622bl the ig622BL to set
	 */
	public void setIg622BL(IG622BL ig622bl) {
		ig622BL = ig622bl;
	}
	/**
	 * ��ҳ�����ѯȫ��
	 * 
	 */
	public IGSYM18DTO searchFirstJspInfoAction(IGSYM18DTO dto)
			throws BLException {
		log.debug("========��ҳ�����ѯ����ʼ========");
		List<IG622Info> list = ig622BL.searchIG622Info();
		List<IG622Info> list2 = new ArrayList<IG622Info>();
		for (IG622Info ig622Info : list) {
			//ɾ��S��ά��ҳ
			if(!"S".equals(ig622Info.getHpid()))
			{
				list2.add(ig622Info);
			}
		}
		
		dto.setFirstJspInfoList(list2);
		log.debug("========��ҳ�����ѯ��������========");
		return dto;
	}
	/**
	 * ��ҳ���� �Ǽ�
	 */
	public IGSYM18DTO insertFirstJspInfoAction(IGSYM18DTO dto)
			throws BLException {
		log.debug("========��ҳ����ǼǴ���ʼ========");
		String hpid = getHpid();
		IG622TB ig622info = ig622BL.getIG622TBInstance();
		try {
			BeanUtils.copyProperties(ig622info, dto.getIgSYM1802Form());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ig622info.setHpid(hpid);
		ig622BL.registIG622Info(ig622info);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ҳ��Ϣ") );
		log.debug("========��ҳ����ǼǴ�������========");
		return dto;
	}
	/**
	 * �õ�ig622���ֵ+1
	 *
	 *��ѧ־
	 *2012-11-14����3:13:20
	 * @return
	 */
	private String getHpid()throws BLException {
		List<IG622Info> list = ig622BL.searchIG622Info();
		int max = 0;
		for (IG622Info ig622Info : list) {
			//�ж��Ƿ�������					
			if(NumberUtils.isNumber(ig622Info.getHpid()))
			{
				if(Integer.parseInt(ig622Info.getHpid()) > max)
				{
					max = Integer.parseInt(ig622Info.getHpid());
				}
			}			
		}
		//����3λ�� ���ݿ�治��
		if(max > 1000)
		{
			throw new BLException("IGSYM0101.E002");
		}
		return String.valueOf(max+1);
	}
	/**
	 * ����������ѯ
	 */
	
	public IGSYM18DTO searchFirstJspInfoByPKAction(IGSYM18DTO dto)throws BLException  {
		log.debug("========��ҳ�����ѯ����ʼ========");
		//����������ѯ
		IG622Info info = ig622BL.searchIG622InfoByPK(dto.getIgSYM1802Form().getHpid());
		List<IG622Info> list = new ArrayList<IG622Info>();
		list.add(info);
		dto.setFirstJspInfoList(list);
		log.debug("========��ҳ�����ѯ��������========");
		return dto;
	}
	/**
	 * ��ҳ�����޸�
	 */
	public IGSYM18DTO editFirstJspInfoAction(IGSYM18DTO dto) throws BLException {
		log.debug("========��ҳ�����޸Ĵ���ʼ========");
		IG622TB ig622info = ig622BL.getIG622TBInstance();
		try {
			BeanUtils.copyProperties(ig622info, dto.getIgSYM1802Form());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ig622BL.updateIG622Info(ig622info);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��ҳ��Ϣ") );
		log.debug("========��ҳ�����޸Ĵ�������========");
		return dto;
	}
	/**
	 * ��ҳ����ɾ��
	 */
	public IGSYM18DTO deleteFirstJspInfoAction(IGSYM18DTO dto) throws BLException {
		log.debug("========��ҳ����ɾ������ʼ========");
		//��������
		ig622BL.deleteIG622InfoByPK(dto.getIgSYM1802Form().getHpid());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "��ҳ��Ϣ") );
		log.debug("========��ҳ����ɾ����������========");
		return dto;
		
	}
	
	
}
