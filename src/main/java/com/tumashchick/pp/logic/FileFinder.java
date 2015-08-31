package com.tumashchick.pp.logic;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class finds required files in selected direcrory
 */
public class FileFinder implements FileFilter {

	private int files = 0;
	
	public int getFiles() {
		return files;
	}
	
	// ��������� ���������� �����
	private String mask = ".xml";

	// ������� ����� ���������� FileFinder
	public FileFinder() {
	}

	// ����� ������ ����������� ��������� ���������� �����
	public boolean accept(File pathname) {
		// �������� ��� ��� ���� � ��� �� ������������� �� .mp3
		return pathname.isFile() && pathname.getName().endsWith(mask);
	}

	private List<File> find(String startPath) throws Exception {
		// �������� ����������
		if (startPath == null) {
			throw new Exception("Error: search options not specified");
		}
		File topDirectory = new File(startPath);
		if (!topDirectory.exists()) {
			throw new Exception(startPath+ " - Error: the specified path does not exist");
		}

		// ������� ������ �����������
		ArrayList<File> res = new ArrayList<File>();

		// ��������� �����
		search(topDirectory, res);

		// ���������� ���������
		res.trimToSize();
		return res;
	}

	/*
	 * ����� ��������� ����� �������� ��������� ����. ����, � ��������
	 * ������, ��������� ��������� ���������� (�����), �� ���������� ��������
	 * ��� ����. ��� ���� ���������� ������ ���������� ����� (mask) ���������
	 * ����� ����������� � ��������� res.
	 */
	private void search(File topDirectory, List<File> res) {

		// �������� ������ ���� �������� � ������� ����������
		File[] list = topDirectory.listFiles();
		// ������������� ��� ������� ��-�������
		for (int i = 0; i < list.length; i++) {
			// ���� ��� ����������...
			if (list[i].isDirectory()) {
				// ��������� ����� �� ��������� �����������
				search(list[i], res);
			}// ���� ��� ����
			else {
				// ��������� �������� �� ������������ ���� �������
				if (accept(list[i])) {
					// ��������� ������� ������ � ������ �����������,
					res.add(list[i]);
//					������� ��������� ������
					files++;
				}
			}
		}
	}

	public List findAll(String startPath) throws Exception {
		return find(startPath);
	}

}
