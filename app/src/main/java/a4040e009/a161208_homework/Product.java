package a4040e009.a161208_homework;

/**
 * Created by wanyun on 2016/12/8.
 */

public class Product {
    private String product_name;
    private String product_pack;
    private String product_standard;
    private int product_image;
    public Product(String product_name,String product_pack,String product_standard,int product_image){
        this.product_name = product_name;
        this.product_pack = product_pack;
        this.product_standard = product_standard;
        this.product_image = product_image;
    }
    public String getName(){
        return product_name;
    }
    public String getPack(){
        return product_pack;
    }
    public String getStandard(){
        return product_standard;
    }
    public int getImage(){
        return product_image;
    }
}
