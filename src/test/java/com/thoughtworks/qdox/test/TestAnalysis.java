package com.thoughtworks.qdox.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.qdox.library.ClassLibraryBuilder;
import com.thoughtworks.qdox.library.OrderedClassLibraryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

public class TestAnalysis {
    private ClassLibraryBuilder lib;
    private JavaProjectBuilder builder;
    private File javaSource = new File("src/main/java");

    @Before
    public void setup() {
        lib = new OrderedClassLibraryBuilder();
        lib.appendDefaultClassLoaders();
        lib.appendClassLoader(this.getClass().getClassLoader());
        builder = new JavaProjectBuilder();
    }

    @Test
    public void test() {
        builder.addSourceTree(javaSource);
        assertEquals(3, builder.getSources().size());
    }

    @Test
    public void testComment1() {
        File srcTestClass = new File(javaSource, "com/thoughworks/qdox/test/TestClass1.java");

        try {
            builder.addSource(srcTestClass);
        } catch (IOException e) {
            fail(e.toString());
        }
        assertEquals(1, builder.getSources().size());
    }

    @Test
    public void testComment2() {
        File srcTestClass = new File(javaSource, "com/thoughworks/qdox/test/TestClass2.java");

        try {
            builder.addSource(srcTestClass);
        } catch (IOException e) {
            fail(e.toString());
        }
        assertEquals(1, builder.getSources().size());
    }

}
