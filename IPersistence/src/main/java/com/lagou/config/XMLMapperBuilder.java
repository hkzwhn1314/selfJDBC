package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MapperStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {
        Document doucument = new SAXReader().read(inputStream);
        Element rootElement = doucument.getRootElement();

        String namespace = rootElement.attributeValue("namespace");


        List<Element> list = rootElement.selectNodes("//select"); //xpath
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();
            MapperStatement mapperStatement = new MapperStatement();
            mapperStatement.setId(id);//
            mapperStatement.setParamterType(paramterType);
            mapperStatement.setResultType(resultType);
            mapperStatement.setSql(sqlText);
            String key = namespace + "." + id;
            configuration.getMapperStatementMap().put(key, mapperStatement);
        }
    }
}
