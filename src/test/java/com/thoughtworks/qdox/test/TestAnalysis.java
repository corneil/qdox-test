package com.thoughtworks.qdox.test;

import java.io.File;
import java.io.IOException;

import com.thoughtworks.qdox.library.ClassLibraryBuilder;
import com.thoughtworks.qdox.library.OrderedClassLibraryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.thoughtworks.qdox.JavaProjectBuilder;

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
        assertTrue(javaSource.exists());
        builder.addSourceTree(javaSource);
        assertEquals(4, builder.getSources().size());
    }

    @Test
    public void testComment1() {
        File srcTestClass = new File(javaSource, "com/thoughworks/qdox/test/TestClass1.java");
        assertTrue(srcTestClass.exists());
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
        assertTrue(srcTestClass.exists());
        try {
            builder.addSource(srcTestClass);
        } catch (IOException e) {
            fail(e.toString());
        }
        assertEquals(1, builder.getSources().size());
    }
    @Test
    public void testComment3() {
        File srcTestClass = new File(javaSource, "com/thoughworks/qdox/test/TestClass3.java");
        assertTrue(srcTestClass.exists());
        try {
            builder.addSource(srcTestClass);
        } catch (IOException e) {
            fail(e.toString());
        }
        assertEquals(1, builder.getSources().size());
    }

}
