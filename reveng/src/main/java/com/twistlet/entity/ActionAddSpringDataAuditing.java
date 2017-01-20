package com.twistlet.entity;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;

import org.apache.commons.io.FileUtils;

public class ActionAddSpringDataAuditing {
	public static void main(String[] args) throws IOException {
		String directory = args[0];
		Collection<File> files = FileUtils.listFiles(new File(directory), null, false);
		for (File file : files) {
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			transformLines(lines, "@JoinColumn(name=\"created_by\")", "@org.springframework.data.annotation.CreatedBy");
			transformLines(lines, "@JoinColumn(name=\"last_modified_by\")",
					"@org.springframework.data.annotation.LastModifiedBy");
			transformLines(lines, "@Column(name=\"created_date\"",
					"@org.springframework.data.annotation.CreatedDate");
			transformLines(lines, "@Column(name=\"last_modified_date\"",
					"@org.springframework.data.annotation.LastModifiedDate");
			FileUtils.writeLines(file, lines);
		}
	}

	public static void transformLines(List<String> lines, String keyword, String toBeAddedBelow) {
		int index = findIndex(lines, keyword);
		if (index > 0) {
			lines.add(index + 1, "    " + toBeAddedBelow);
		}
	}

	private static int findIndex(List<String> lines, String keyword) {
		int n = lines.size();
		for (int i = 0; i < n; i++) {
			if (lines.get(i).contains(keyword)) {
				return i;
			}
		}
		return -1;
	}

}
