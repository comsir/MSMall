package com.key.msmall.pojo;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private String subtitle;

    private Float orignalprice;

    private Float promoteprice;

    private Integer stock;

    private Integer cid;

    private Date createdate;

    private Category  category;
    
    private Productimage firstProductImage;
    
    

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}



	public Float getOrignalprice() {
		return orignalprice;
	}

	public void setOrignalprice(Float orignalprice) {
		this.orignalprice = orignalprice;
	}



	public Float getPromoteprice() {
		return promoteprice;
	}

	public void setPromoteprice(Float promoteprice) {
		this.promoteprice = promoteprice;
	}

	public Productimage getFirstProductImage() {
		return firstProductImage;
	}

	public void setFirstProductImage(Productimage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}