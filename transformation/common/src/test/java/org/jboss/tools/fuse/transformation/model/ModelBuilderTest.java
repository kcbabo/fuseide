/*
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.tools.fuse.transformation.model;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.jboss.tools.fuse.transformation.model.ModelBuilder.Strategy;
import org.junit.Test;

public class ModelBuilderTest {

    @Test
    public void noSuper() {
        Model model = ModelBuilder.fromJavaClass(NoSuper.class);
        Assert.assertEquals(2, model.listFields().size());
    }

    @Test
    public void superSuper() {
        Model model = ModelBuilder.fromJavaClass(SuperSuper.class);
        Assert.assertEquals(3, model.listFields().size());
    }

    @Test
    public void screenForNumbers() {
        Model model = ModelBuilder.fromJavaClass(ContainsNumber.class);
        Assert.assertEquals(1, model.listFields().size());
    }

    @Test
    public void buildWithEnum() {
        Model model = ModelBuilder.fromJavaClass(ClassWithEnum.class);
        Assert.assertEquals(1, model.listFields().size());
    }

    @Test
    public void buildWithDateEtc() {
        Model model = ModelBuilder.fromJavaClass(ClassWithDateEtc.class);
        Assert.assertEquals(4, model.listFields().size());
    }

    @Test
    public void selfReferenceCycle() {
        Model model = ModelBuilder.fromJavaClass(SelfReference.class);
        Assert.assertEquals(2, model.listFields().size());
    }

    @Test
    public void childAncestorCycle() {
        Model model = ModelBuilder.fromJavaClass(Parent.class);
        Assert.assertEquals(7, model.listFields().size());
    }

    @Test
    public void listsOfStringsAndNumbersFields() {
        Model model = ModelBuilder.fromJavaClass(ListOfStringsAndNumbers.class, Strategy.FIELDS);
        Assert.assertEquals(3, model.listFields().size());
    }
    
    @Test
    public void listsOfStringsAndNumbersProperties() throws Exception {
        Model model = ModelBuilder.fromJavaClass(ListOfStringsAndNumbers.class);
        Assert.assertEquals(2, model.listFields().size());
    }
    
    @Test
    public void testHL7() throws Exception {
        ModelBuilder.fromJavaClass(ca.uhn.hl7v2.model.v23.segment.EVN.class, Strategy.PROPERTIES).print(System.out);;
    }
}

class ListOfStringsAndNumbers {
    private List<Number> numbers;
    private List<String> strings;
    private String field1;
    
    public List<Number> getNumbers() {
        return numbers;
    }
    
    public List<String> getStrings() {
        return strings;
    }
}

class NoSuper {
    private String fieldOne;
    private String fieldTwo;

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }
}

class ClassWithDateEtc {
    private String field1;
    private Date field2;
    private Calendar field3;
    private InputStream field4;
    
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public Date getField2() {
        return field2;
    }
    public void setField2(Date field2) {
        this.field2 = field2;
    }
    public Calendar getField3() {
        return field3;
    }
    public void setField3(Calendar field3) {
        this.field3 = field3;
    }
    public InputStream getField4() {
        return field4;
    }
    public void setField4(InputStream field4) {
        this.field4 = field4;
    }
}

class ClassWithEnum {
    enum MY_ENUM {one, two, three}
    private MY_ENUM myEnum;

    public MY_ENUM getEnum() {
        return myEnum;
    }

    public void setEnum(MY_ENUM myEnum) {
        this.myEnum = myEnum;
    }
}

class SuperSuper extends NoSuper {
    private String fieldThree;

    public String getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(String fieldThree) {
        this.fieldThree = fieldThree;
    }

}

class ContainsNumber {
    private BigDecimal bigNum;

    public BigDecimal getBigNum() {
        return bigNum;
    }

    public void setBigNum(BigDecimal bigNum) {
        this.bigNum = bigNum;
    }

}

class SelfReference {
    private String field1;
    private SelfReference self;
    
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }
    public SelfReference getSelf() {
        return self;
    }
    public void setSelf(SelfReference self) {
        this.self = self;
    }
}

class Parent {
    private Child child;
    private String field1;
    
    public Child getChild() {
        return child;
    }
    public void setChild(Child child) {
        this.child = child;
    }
    public String getField1() {
        return field1;
    }
    public void setField1(String field1) {
        this.field1 = field1;
    }   
}

class Child {
    private Parent parent;
    private String field2;
    private Grandchild grandchild;
    
    public Parent getParent() {
        return parent;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    public String getField2() {
        return field2;
    }
    public void setField2(String field2) {
        this.field2 = field2;
    }
    public Grandchild getGrandchild() {
        return grandchild;
    }
    public void setGrandchild(Grandchild grandchild) {
        this.grandchild = grandchild;
    }
}

class Grandchild {
    private Parent grandparent;
    private String field3;
    
    public Parent getGrandparent() {
        return grandparent;
    }
    public void setGrandparent(Parent grandparent) {
        this.grandparent = grandparent;
    }
    public String getField3() {
        return field3;
    }
    public void setField3(String field3) {
        this.field3 = field3;
    }
}