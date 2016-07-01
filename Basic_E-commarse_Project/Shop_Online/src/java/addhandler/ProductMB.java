/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Product;
import entity.SubCategory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@ManagedBean
@SessionScoped
public class ProductMB {
    Product product = new Product();
    SubCategory subcat = new SubCategory();
    String subcatname;
    String catname = "";
    List < SubCategory > SubCatList;
    UploadedFile file;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
    
    

    public List<SubCategory> getSubCatList() {
        return SubCatList;
    }

    public void setSubCatList(List<SubCategory> SubCatList) {
        this.SubCatList = SubCatList;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    
    public String addProduct() {
        uploadImageFile();

        SubCatList = new ListDao().subcatListByName(subcatname);

        // set foregin key status from subcategory to Product table
        
        subcat.setSubCatId(SubCatList.get(0).getSubCatId());
        //category.setCatId(CatList.get(0).getCatId());
        //subcat.setCategory(category);
        
        // set restof all column in Product table
        product.setSubCategory(subcat);
        product.setProName(product.getProName());
        product.setProQty(product.getProQty());
        product.setProPrice(product.getProPrice());
        product.setProUrl(product.getProUrl());
        product.setProDesc(product.getProDesc());
        
        boolean status = new AddDao().addProduct(product);
        
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
    
    @SuppressWarnings({"RedundantStringToString", "CallToPrintStackTrace"})
    public void uploadImageFile () {
        if ( file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext sc = (ServletContext) context.getExternalContext().getContext();
                
                // arrange image file from url 
                String dbpath = sc.getRealPath("/");
                
                // cut from url path convert to image path
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                
                // file generate using inputstream
                InputStream istrm = file.getInputstream();
                
                // get local machine directory 
                String path = mainURLPath+"\\Shop_Online\\web\\resources\\images\\"+file.getFileName();
                
                File destfile = new File(path);
                
                if ( !destfile.exists() ) {
                    FileUtils.copyInputStreamToFile(istrm, destfile);
                }
                
                // finally setproduct URL variable 
                product.setProUrl(file.getFileName().toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public List < SelectItem > getSubCategoryName () {
        List < SelectItem > subcatname = new ListDao().subcatList(catname);
        return subcatname;
    }
}
