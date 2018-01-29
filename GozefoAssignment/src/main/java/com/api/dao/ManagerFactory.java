package com.api.dao;

import com.api.dao.factories.CategoryManager;
import com.api.dao.factories.ProductManager;
import lombok.*;


@NoArgsConstructor
public class ManagerFactory {

    private static ManagerFactory managerFactory;

    @Getter
    @Setter
    private CategoryManager categoryManager;
    @Getter
    @Setter
    private ProductManager productManager;

    public static ManagerFactory getInstance() {
        if (managerFactory == null) {
            managerFactory = new ManagerFactory();
        }
        return managerFactory;
    }
}