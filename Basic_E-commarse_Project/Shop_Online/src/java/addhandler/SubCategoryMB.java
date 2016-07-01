/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Category;
import entity.SubCategory;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@ManagedBean
@SessionScoped
public class SubCategoryMB {
    SubCategory subcat = new SubCategory();
    Category category = new Category();
    String subcatname;
    List < Category > CatList;

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<Category> getCatList() {
        return CatList;
    }

    public void setCatList(List<Category> CatList) {
        this.CatList = CatList;
    }

    public String addSubCategory() {

        CatList = new ListDao().catListByName(subcatname);

        // set foregin key status from category to subcategory table
        
        //subcat.setSubCatId(CatList.get(0).getCatId());
        category.setCatId(CatList.get(0).getCatId());
        subcat.setCategory(category);
        
        // set restof all column in subcategory table
        subcat.setSubCatName(subcat.getSubCatName());
        subcat.setSubCatDesc(subcat.getSubCatDesc());
        
        boolean status = new AddDao().addSubCategory(subcat);
        
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Data Saved Successfully", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Data not Saved Successfully", ""));
        }
        return null;
    }
    
    public List < SelectItem > getCategoryName () {
        List < SelectItem > catname = new ListDao().catList();
        return catname;
    }
}
