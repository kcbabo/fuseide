package example;

import java.util.List;

public class DeepList {

    private String fieldL1;
    private List<Level2> listL1;
    
    
    public String getFieldL1() {
        return fieldL1;
    }

    public void setFieldL1(String fieldL1) {
        this.fieldL1 = fieldL1;
    }

    public List<Level2> getListL1() {
        return listL1;
    }

    public void setListL1(List<Level2> listL1) {
        this.listL1 = listL1;
    }

    class Level2 {
        private String fieldL2;
        private List<Level3> listL2;
        
        public String getFieldL2() {
            return fieldL2;
        }
        public void setFieldL2(String fieldL2) {
            this.fieldL2 = fieldL2;
        }
        public List<Level3> getListL2() {
            return listL2;
        }
        public void setListL2(List<Level3> listL2) {
            this.listL2 = listL2;
        }
        
    }
    
    class Level3 {
        private String fieldL3;

        public String getFieldL3() {
            return fieldL3;
        }

        public void setFieldL3(String fieldL3) {
            this.fieldL3 = fieldL3;
        }
        
    }
}
