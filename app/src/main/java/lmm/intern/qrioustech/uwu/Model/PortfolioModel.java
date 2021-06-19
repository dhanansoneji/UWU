package lmm.intern.qrioustech.uwu.Model;

public class PortfolioModel {

    String prj_name,prj_des,prj_androd,prj_website,prj_ios,type;
    int prj_icon;
    int[] prj_images;

    public PortfolioModel() {
    }

    public PortfolioModel(String type, String prj_des, String prj_name, String prj_androd, String prj_ios, int[] prj_images) {
        this.type = type;
        this.prj_name = prj_name;
        this.prj_androd = prj_androd;
        this.prj_ios = prj_ios;
        this.prj_images = prj_images;
        this.prj_des = prj_des;
    }

    public PortfolioModel(String type, String prj_des, String prj_name, String prj_website, int[] prj_images) {
        this.type = type;
        this.prj_name = prj_name;
        this.prj_des = prj_des;
        this.prj_website = prj_website;
        this.prj_images = prj_images;
    }

//    public PortfolioModel(String prj_name, String prj_des, String prj_androd, String prj_ios, int prj_icon, int[] prj_images) {
//        this.prj_name = prj_name;
//        this.prj_des = prj_des;
//        this.prj_androd = prj_androd;
//        this.prj_ios = prj_ios;
//        this.prj_icon = prj_icon;
//        this.prj_images = prj_images;
//    }
//
//    public PortfolioModel(String prj_name, String prj_des, String prj_website, int prj_icon, int[] prj_images) {
//        this.prj_name = prj_name;
//        this.prj_des = prj_des;
//        this.prj_website = prj_website;
//        this.prj_icon = prj_icon;
//        this.prj_images = prj_images;
//    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrj_name() {
        return prj_name;
    }

    public void setPrj_name(String prj_name) {
        this.prj_name = prj_name;
    }

    public String getPrj_des() {
        return prj_des;
    }

    public void setPrj_des(String prj_des) {
        this.prj_des = prj_des;
    }

    public String getPrj_androd() {
        return prj_androd;
    }

    public void setPrj_androd(String prj_androd) {
        this.prj_androd = prj_androd;
    }

    public String getPrj_website() {
        return prj_website;
    }

    public void setPrj_website(String prj_website) {
        this.prj_website = prj_website;
    }

    public String getPrj_ios() {
        return prj_ios;
    }

    public void setPrj_ios(String prj_ios) {
        this.prj_ios = prj_ios;
    }

    public int getPrj_icon() {
        return prj_icon;
    }

    public void setPrj_icon(int prj_icon) {
        this.prj_icon = prj_icon;
    }

    public int[] getPrj_images() {
        return prj_images;
    }

    public void setPrj_images(int[] prj_images) {
        this.prj_images = prj_images;
    }
}
