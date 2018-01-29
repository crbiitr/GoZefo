package com.api.dao.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 * Created by chetan on 29/1/18.
 */
@Entity
@Table(name = "category", schema = "zefo", catalog = "")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CategoryDAO {
    private int id;
    private String name;

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

}
