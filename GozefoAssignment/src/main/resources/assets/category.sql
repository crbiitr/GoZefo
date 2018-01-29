CREATE DATABASE zefo;

CREATE TABLE category (
id INT(6)  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE subcategory (
id INT(6)  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
category_id INT(6),
FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE sofas (
id INT(6) AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
category_id INT(6),
subcategory_id INT(6),
price DECIMAL(10 , 4 ) NOT NULL DEFAULT 00.0,
type VARCHAR(50) NOT NULL,
material VARCHAR(50) NOT NULL,
brand VARCHAR(50) NOT NULL,
condition_ VARCHAR(50) NOT NULL,
softness VARCHAR(50) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (category_id) REFERENCES category(id),
FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
);

INSERT INTO category (name) VALUES ('furniture');
INSERT INTO category (name) VALUES ('appliances');
INSERT INTO subcategory (category_id,name) VALUES (1,'sofas');
INSERT INTO sofas (name,category_id,subcategory_id,price,type,material,brand,condition_,softness) VALUES ('Sofa1',1,1,13000.00,'One Seater','Fabric','Urban Ladder','Unboxed','Soft');
INSERT INTO sofas (name,category_id,subcategory_id,price,type,material,brand,condition_,softness) VALUES ('Sofa2',1,1,14000.00,'Two Seater','Jute','Urban Ladder','Gently Used','Firm');