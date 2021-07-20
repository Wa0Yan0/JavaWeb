package com.wayan.xmltest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class BooksTest {

    /**
     * @function 读取xml文件
     * @throws DocumentException
     */
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("index.xml");
        // 获取根标签
        Element rootElement = doc.getRootElement();
        // 获取多个标签对象
        List<Element> book = rootElement.elements("book");
        for (Element element : book) {
            // 获取标签对象的标签文本
            System.out.println(element.asXML());
            // 获取单个标签对象
            Element nameElement = element.element("name");
            // 获取标签对象的文本
            String name = nameElement.getText();
            //直接获取标签文本
            String price = element.elementText("price");
            String author = element.elementText("author");
            // 获取标签属性
            String sn = element.attributeValue("sn");
            System.out.println(new books(sn,name,price,author));
        }

    }
}
