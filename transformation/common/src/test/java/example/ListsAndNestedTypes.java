package example;

import java.util.List;

public class ListsAndNestedTypes {

    private Nested1 nested1;
    private Nested2 nested2;
    private List<AClass> listOfAs;
    
    public Nested1 getNested1() {
        return nested1;
    }
    public void setNested1(Nested1 nested1) {
        this.nested1 = nested1;
    }
    public Nested2 getNested2() {
        return nested2;
    }
    public void setNested2(Nested2 nested2) {
        this.nested2 = nested2;
    }
    public List<AClass> getListOfAs() {
        return listOfAs;
    }
    public void setListOfAs(List<AClass> listOfAs) {
        this.listOfAs = listOfAs;
    }
}

class Nested1 {
    private Object field1;
    private Object field2;
    private BClass classB;
    
    public Object getField1() {
        return field1;
    }
    public void setField1(Object field1) {
        this.field1 = field1;
    }
    public Object getField2() {
        return field2;
    }
    public void setField2(Object field2) {
        this.field2 = field2;
    }
    public BClass getClassB() {
        return classB;
    }
    public void setClassB(BClass classB) {
        this.classB = classB;
    }
}

class Nested2 {
    private Object field1;
    private Object field2;
    private BClass classB;
    
    public Object getField1() {
        return field1;
    }
    public void setField1(Object field1) {
        this.field1 = field1;
    }
    public Object getField2() {
        return field2;
    }
    public void setField2(Object field2) {
        this.field2 = field2;
    }
    public BClass getClassB() {
        return classB;
    }
    public void setClassB(BClass classB) {
        this.classB = classB;
    }
}
