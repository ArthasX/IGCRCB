package com.deliverik.infogovernor.util;


import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListFastSort implements ArrayListSortable {

	/**
	 * <P>Function: QuickSort
	 * <P>Description:    ArrayList����
	 * <P>Calls:          // �����������õĺ����嵥
	 * <P>Called By:      // ���ñ������ĺ����嵥
	 * <P>Table Accessed: // �����ʵı����������ǣ�������ݿ�����ĳ���
	 * <P>Table Updated:  // ���޸ĵı����������ǣ�������ݿ�����ĳ���
	 * <P>Others:         // ����˵��
	 * @author: roger.gao
	 * @CreateTime: 2007-9-25 22:52:10
	 * @param:          ����List��list��class���������������У�class���ԣ����������ͣ���ArrayListSortable���������򣨼�ArrayListSortable��
	 * @Return:         // ��������ֵ��˵��
	 */
	@SuppressWarnings("unchecked")
	public static void QuickSort(ArrayList sortList, String metaClass,
			String column, int type, int flag) {
		if (sortList != null && sortList.size() > 1) {
			try {
				switch (type) {
				case STRING:
					QuickSortString(sortList, metaClass, column, 0, sortList
							.size() - 1, flag);
					break;
				case INT:
					QuickSortInt(sortList, metaClass, column, 0, sortList
							.size() - 1, flag);
					break;
				case DOUBLE:
					QuickSortDouble(sortList, metaClass, column, 0, sortList
							.size() - 1, flag);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void QuickSortString(ArrayList pData, String className, String columnName,
			int left, int right, int flag) throws Exception {
		int i, j;

		Object strTemp;
		i = left;
		j = right;

		Object middleobj = pData.get((left + right) / 2);
		Class s = Class.forName(className);
		String first = columnName.substring(0, 1);
		String methodName = "get" + first.toUpperCase()
				+ columnName.substring(1, columnName.length());
		Method method = s.getMethod(methodName, null);

		String middleString = (String) method.invoke(middleobj, null);

		Object iobj = pData.get(i);
		String iString = (String) method.invoke(iobj, null);

		Object jobj = pData.get(j);
		String jString = (String) method.invoke(jobj, null);

		if (flag == 0) {
			do {
				iobj = pData.get(i);
				iString = (String) method.invoke(iobj, null);
				while (iString.compareTo(middleString) < 0 && (i < right)) {
					i++;
					iobj = pData.get(i);
					iString = (String) method.invoke(iobj, null);
				}
				jobj = pData.get(j);
				jString = (String) method.invoke(jobj, null);
				while (jString.compareTo(middleString) > 0 && (j > left)) {
					j--;
					jobj = pData.get(j);
					jString = (String) method.invoke(jobj, null);
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}
		if (flag == 1) {
			do {
				iobj = pData.get(i);
				iString = (String) method.invoke(iobj, null);
				while (iString.compareTo(middleString) > 0 && (i < right)) {
					i++;
					iobj = pData.get(i);
					iString = (String) method.invoke(iobj, null);
				}
				jobj = pData.get(j);
				jString = (String) method.invoke(jobj, null);
				while (jString.compareTo(middleString) < 0 && (j > left)) {
					j--;
					jobj = pData.get(j);
					jString = (String) method.invoke(jobj, null);
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}

		if (left < j)
			QuickSortString(pData, className, columnName, left, j, flag);

		if (right > i)
			QuickSortString(pData, className, columnName, i, right, flag);
	}
	
	@SuppressWarnings("unchecked")
	private static void QuickSortInt(ArrayList pData, String className, String columnName,
			int left, int right, int flag) throws Exception {
		int i, j;

		Object strTemp;
		i = left;
		j = right;

		Object middleobj = pData.get((left + right) / 2);
		Class s = Class.forName(className);
		String first = columnName.substring(0, 1);
		String methodName = "get" + first.toUpperCase()
				+ columnName.substring(1, columnName.length());
		Method method = s.getMethod(methodName, null);

		int middleInt = ((Integer) method.invoke(middleobj, null)).intValue();

		Object iobj = pData.get(i);
		int iInt = ((Integer) method.invoke(iobj, null)).intValue();

		Object jobj = pData.get(j);
		int jInt = ((Integer) method.invoke(jobj, null)).intValue();

		if (flag == 0) {
			do {
				iobj = pData.get(i);
				 iInt = ((Integer) method.invoke(iobj, null)).intValue();
				while (iInt<middleInt && (i < right)) {
					i++;
					iobj = pData.get(i);
					iInt = ((Integer) method.invoke(iobj, null)).intValue();
				}
				jobj = pData.get(j);
				jInt = ((Integer) method.invoke(jobj, null)).intValue();
				while (jInt > middleInt && (j > left)) {
					j--;
					jobj = pData.get(j);
					jInt = ((Integer) method.invoke(jobj, null)).intValue();
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}
		if (flag == 1) {
			do {
				iobj = pData.get(i);
				 iInt = ((Integer) method.invoke(iobj, null)).intValue();
				while (iInt>middleInt && (i < right)) {
					i++;
					iobj = pData.get(i);
					iInt = ((Integer) method.invoke(iobj, null)).intValue();
				}
				jobj = pData.get(j);
				jInt = ((Integer) method.invoke(jobj, null)).intValue();
				while (jInt < middleInt && (j > left)) {
					j--;
					jobj = pData.get(j);
					jInt = ((Integer) method.invoke(jobj, null)).intValue();
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}

		if (left < j)
			QuickSortInt(pData, className, columnName, left, j, flag);

		if (right > i)
			QuickSortInt(pData, className, columnName, i, right, flag);
	}

	
	@SuppressWarnings("unchecked")
	private static void QuickSortDouble(ArrayList pData, String className, String columnName,
			int left, int right, int flag) throws Exception {
		int i, j;

		Object strTemp;
		i = left;
		j = right;

		Object middleobj = pData.get((left + right) / 2);
		Class s = Class.forName(className);
		String first = columnName.substring(0, 1);
		String methodName = "get" + first.toUpperCase()
				+ columnName.substring(1, columnName.length());
		Method method = s.getMethod(methodName, null);

		Double middleDouble = (Double) method.invoke(middleobj, null);

		Object iobj = pData.get(i);
		Double iDouble = (Double) method.invoke(iobj, null);

		Object jobj = pData.get(j);
		Double jDouble = (Double) method.invoke(jobj, null);

		if (flag == 0) {
			do {
				iobj = pData.get(i);
				iDouble = (Double) method.invoke(iobj, null);
				while (iDouble.compareTo(middleDouble) < 0 && (i < right)) {
					i++;
					iobj = pData.get(i);
					iDouble = (Double) method.invoke(iobj, null);
				}
				jobj = pData.get(j);
				jDouble = (Double) method.invoke(jobj, null);
				while (jDouble.compareTo(middleDouble) > 0 && (j > left)) {
					j--;
					jobj = pData.get(j);
					jDouble = (Double) method.invoke(jobj, null);
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}
		if (flag == 1) {
			do {
				iobj = pData.get(i);
				iDouble = (Double) method.invoke(iobj, null);
				while (iDouble.compareTo(middleDouble) > 0 && (i < right)) {
					i++;
					iobj = pData.get(i);
					iDouble = (Double) method.invoke(iobj, null);
				}
				jobj = pData.get(j);
				jDouble = (Double) method.invoke(jobj, null);
				while (jDouble.compareTo(middleDouble) < 0 && (j > left)) {
					j--;
					jobj = pData.get(j);
					jDouble = (Double) method.invoke(jobj, null);
				}
				if (i <= j) {
					strTemp = pData.get(i);
					pData.set(i, pData.get(j));
					pData.set(j, strTemp);

					i++;
					j--;
				}
			} while (i <= j);
		}

		if (left < j)
			QuickSortDouble(pData, className, columnName, left, j, flag);

		if (right > i)
			QuickSortDouble(pData, className, columnName, i, right, flag);
	}

}
