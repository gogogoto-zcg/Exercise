package com.exercise.baseskill.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @Description :
 * @Reference :
 * @Author : zcg
 * @Date : 2020/4/8 0008 - 10:37
 */
public class Dom4jTest {
    public static void main(String[] args) {
        //获取文件输入流
        InputStream stream = Dom4jTest.class.getClassLoader().getResourceAsStream("books.xml");
        SAXReader saxReader = new SAXReader();
        //读取document对象
        Document document = null;
        try {
            document = saxReader.read(stream);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(document);
        //获取根元素
        Element rootElement = document.getRootElement();
        //打印标签内容 需要 .asXML
        System.out.println(rootElement.asXML());
        System.out.println("========" + rootElement);
        //根据标签元素获取子标签元素
        List<Element> books = rootElement.elements("book");
        books.forEach(book -> System.out.println(book.asXML()));
        Element element = books.get(0);
        //获取标签的属性（element）
        Element name = element.element("name");
        Element price = element.element("price");
        //获取属性的文本
        System.out.println(name.getText());
        System.out.println(price.getText());
    }
}
