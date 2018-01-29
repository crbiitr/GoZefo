package com.api.dao.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * Created by chetan on 29/1/18.
 */
@Entity
@Table(name = "sofas", schema = "zefo", catalog = "")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SofasDAO {
    private int id;
    private String name;
    private int categoryId;
    private int subCategoryId;
    private String type;
    private String material;
    private String brand;
    private String condition;
    private String softness;
    private BigDecimal price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "subcategory_id", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }
    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "material", nullable = false)
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "condition_", nullable = false)
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "softness", nullable = false)
    public String getSoftness() {
        return softness;
    }
    public void setSoftness(String softness) {
        this.softness = softness;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
