package lmm.intern.qrioustech.uwu.Model;

public class CategoryModel {
    String category;
    int icon;

    public CategoryModel(int icon, String category) {
        this.category = category;
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
