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
	
	// Требуемое расширение файла
	private String mask = ".xml";

	// Создает новые экземпляры FileFinder
	public FileFinder() {
	}

	// метод делает верификацию заданного расширения файла
	public boolean accept(File pathname) {
		// проверям что это файл и что он заканчивается на .mp3
		return pathname.isFile() && pathname.getName().endsWith(mask);
	}

	private List<File> find(String startPath) throws Exception {
		// проверка параметров
		if (startPath == null) {
			throw new Exception("Error: search options not specified");
		}
		File topDirectory = new File(startPath);
		if (!topDirectory.exists()) {
			throw new Exception(startPath+ " - Error: the specified path does not exist");
		}

		// создаем список результатов
		ArrayList<File> res = new ArrayList<File>();

		// выполняем поиск
		search(topDirectory, res);

		// возвращаем результат
		res.trimToSize();
		return res;
	}

	/*
	 * метод выполняет поиск объектов заданного типа. Если, в процессе
	 * поиска, встречает вложенную директорию (папку), то рекурсивно вызывает
	 * сам себя. При этом происходит сверка расширения файла (mask) Найденные
	 * файлы сохраняются в параметре res.
	 */
	private void search(File topDirectory, List<File> res) {

		// получаем список всех объектов в текущей директории
		File[] list = topDirectory.listFiles();
		// просматриваем все объекты по-очереди
		for (int i = 0; i < list.length; i++) {
			// если это директория...
			if (list[i].isDirectory()) {
				// выполняем поиск во вложенных директориях
				search(list[i], res);
			}// если это файл
			else {
				// выполняем проверку на соответствие типу объекта
				if (accept(list[i])) {
					// добавляем текущий объект в список результатов,
					res.add(list[i]);
//					подсчет найденных файлов
					files++;
				}
			}
		}
	}

	public List findAll(String startPath) throws Exception {
		return find(startPath);
	}

}
