package com.thoughtworks.qdox.test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.qdox.library.ClassLibraryBuilder;
import com.thoughtworks.qdox.library.OrderedClassLibraryBuilder;
import org.junit.Test;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

public class TestAnalysis {

	@Test
	public void test() {
		ClassLibraryBuilder lib = new OrderedClassLibraryBuilder();
		lib.appendDefaultClassLoaders();
		lib.appendClassLoader(this.getClass().getClassLoader());
		File javaSource = new File("src/main/java");
		lib.appendSourceFolder(javaSource);
        JavaProjectBuilder builder = new JavaProjectBuilder();
		builder.addSourceTree(javaSource);
		Set<String> imports = new HashSet<String>();
		Set<String> exports = new HashSet<String>();
		for (JavaSource src : builder.getSources()) {
			imports.addAll(src.getImports());
			for (JavaClass cls : src.getClasses()) {
				if (cls.isPublic()) {
					exports.add(cls.getFullyQualifiedName());
				}
			}
		}
		for (String importName : imports) {
			System.out.println("import " + importName);
		}
		for (String exportName : exports) {
			System.out.println("export " + exportName);
		}
	}
}
