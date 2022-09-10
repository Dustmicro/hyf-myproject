package org.support.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;


/**
 * 针对于xml文件
 * @author HYF
 */
public class CustomAbstractXmlElementGenerator extends AbstractXmlElementGenerator {

    @Override
    public void addElements(XmlElement parentElement) {
        //增加base_query
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "base_query"));
        //添加where条件
        XmlElement selectTrimElement = new XmlElement("trim");//设置trim标签
        selectTrimElement.addAttribute(new Attribute("prefix", "WHERE"));
        selectTrimElement.addAttribute(new Attribute("prefixOverrides", "AND | OR"));
        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement selectNotNullElement = new XmlElement("if");
            sb.setLength(0);
            if ("status_cd".equals(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn))) {
                //假如是数据状态字段直接
                sb.append("and");
                //添加别名t
                sb.append("t.");
                sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
                //添加等号
                sb.append(" = 1");
                TextElement textElement = new TextElement(sb.toString());
                selectTrimElement.addElement(textElement);
                continue;
            }
            sb.append("null != ");
            sb.append(introspectedColumn.getJavaProperty());
            selectNotNullElement.addAttribute(new Attribute("test", sb.toString()));
            sb.setLength(0);
            //添加and
            sb.append("and");
            sb.append("t.");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            //添加等号
            sb.append("=");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            selectNotNullElement.addElement(new TextElement(sb.toString()));
            selectTrimElement.addElement(selectNotNullElement);
        }
        sql.addElement(selectTrimElement);
        parentElement.addElement(sql);

        //公用select
        sb.setLength(0);
        sb.append("select");
        sb.append("t.*");
        sb.append("from");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        sb.append(" t");
        TextElement selectText = new TextElement(sb.toString());

        //公用include
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "base_query"));

        //增加find
        XmlElement find = new XmlElement("select");
        find.addAttribute(new Attribute("id", "find"));
        find.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        find.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        find.addElement(selectText);
        find.addElement(include);
        parentElement.addElement(find);

        //增加List
        XmlElement list = new XmlElement("select");
        list.addAttribute(new Attribute("id", "list"));
        list.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        list.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        list.addElement(selectText);
        list.addElement(include);
        parentElement.addElement(list);

        //增加pageList
        XmlElement pageList = new XmlElement("select");
        pageList.addAttribute(new Attribute("id", "pageList"));
        pageList.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        pageList.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        pageList.addElement(selectText);
        pageList.addElement(include);

        //定义一个if节点的xml
        XmlElement notNullElement = new XmlElement("if");
        sb.setLength(0);
        sb.append("page != null");
        //给if节点添加一个属性test  属性值 page != null
        notNullElement.addAttribute(new Attribute("test", sb.toString()));

        sb.setLength(0);
        sb.append("limit #{startNum,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}");
        TextElement pageText = new TextElement(sb.toString());
        notNullElement.addElement(pageText);
        pageList.addElement(notNullElement);

        parentElement.addElement(pageList);
    }
}
