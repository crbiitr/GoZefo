package com.api.dao.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by chetan on 29/1/18.
 */
@Entity
@Table(name = "subcategory", schema = "zefo", catalog = "")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SubCategoryDAO {
    private int id;
    private String name;
    private int categoryId;

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

    public int getCategoryId() {
        return categoryId;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
