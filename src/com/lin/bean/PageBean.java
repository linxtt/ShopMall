package com.lin.bean;

import java.util.List;

public class PageBean {
	private List<Product> list;// ���ݣ����������ѯ���UsersBean
	private int totalrecord;// ҳ���ܼ�¼���������ݲ�ѯ����
	private int pagesize;// ÿҳ��ʾ���������ͻ����͹���
	private int totalpage;// �ܹ��ж���ҳ�������Լ���������
	private int currentpage;// ��ǰ�ڼ�ҳ��
	private int previouspage;// ��һҳ
	private int nextpage;// ��һҳ
	private int[] pagebar;// ҳ����:
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		if (this.totalrecord % this.pagesize == 0) {
				this.totalpage = this.totalrecord / this.pagesize;
		} else {
				this.totalpage = this.totalrecord / this.pagesize + 1;
		}
			return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if (this.currentpage - 1 < 1) {
			this.previouspage = 1;
		} else {
			this.previouspage = this.currentpage - 1;
		}
		return previouspage;
	}
	public void setPreviouspage(int previouspage) {
		this.previouspage = previouspage;
	}
	public int getNextpage() {
		if (this.currentpage + 1 > this.totalpage) {
			this.nextpage = this.totalpage;
		} else {
			this.nextpage = this.currentpage + 1;
		}
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int[] getPagebar() {
		//���ڸ�ֵ��
				int pagebar[] = new int[10];//����һ���̶����ȵ�����
				int startpage;//��¼���ĸ�ֵ��ʼ��ֵ
				int endpage;//��¼���ĸ�ֵ����

				//�п����ҵ���ҳ��û��10ҳ�����
				if (this.totalpage <= 10) {
					//���û��10ҳ�棬�򽫴�1��ʼ��ֵ
					startpage = 1;
					endpage = this.totalpage;
				} else {
					//startpage=��ǰҳ��-4;
					//endpage=��ǰҳ��+5;
					startpage = this.currentpage - 5;
					endpage = this.currentpage + 4;

					//�����ʼ��С��1˵��ҳ���Ѿ�����ǰҳ�ˣ�ֻ�ý���ͷ����Ϊ1,β����Ϊ10
					if (startpage < 1) {
						startpage = 1;
						endpage = 10;
					}
					//�������ҳ������ҳ ��˵��ҳ���Ѿ������ҳ���ˣ�ֻ�ý�βҳ����Ϊ��ҳ��,��ҳ����Ϊ��ҳ��-9
					if (endpage > this.totalpage) {
						endpage = this.totalpage;
						startpage = this.totalpage - 9;
					}
				}

				//��ֵ
				int index = 0;//�����±�һ����0��ʼ��
				for (int i = startpage; i <= endpage; i++) {
					//�����鸳ֵ
					pagebar[index++] = i;
				}
				this.pagebar = pagebar;
		return pagebar;
	}
	public void setPagebar(int[] pagebar) {
		this.pagebar = pagebar;
	}
	
	
	
}
