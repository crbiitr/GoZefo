# README #
# GozefoAssignment

# Summary of set up
    * Java
    * Maven
    * MySQL
    * Dropwizard for REST Architecture
# Configuration
    * config.yml
    * put DB userName and Password
# Dependencies
    * pom.xml
# Database configuration
    * Look in config.yml
    * Run DB queries defined in resources/assets/category.sql
# How to run
    * mvn clean install && java -jar target/GozefoAssignment-1.0-SNAPSHOT.jar server config.yml
# Deployment instructions
    * mvn clean install && java -jar target/GozefoAssignment-1.0-SNAPSHOT.jar server config.yml
# Version : 1.0-SNAPSHOT


# APIs
#Search Product using filter:
URL: http://localhost:8080/product-list
Data:{
     	"subcategory": "sofas",
     	"category": "sofas",
     	"min_price": 13000,
     	"max_price": 15000,
     	"type": "One Seater",
     	"material": "Fabric",
     	"brand": "Urban Ladder",
     	"condition": "Unboxed",
     	"softness": "soft",
     	"sort_by": "type"
     }

# Add Product: POST request
URL: http://localhost:8080/product
Data: {
      	"subcategory": "sofas",
      	"category": "furniture",
      	"price": 16000,
      	"type": "One Seater",
      	"material": "Fabric",
      	"brand": "Urban Ladder",
      	"condition": "Unboxed",
      	"softness": "soft",
      	"name": "Sofa5"
      }

# NOTE:
1) Currently, I have done for Category: furniture, Subcategory: sofa
2) For new categories and subCategories, Needs to add data in constants file.


# Improvements:
1) I wanted to use mongoDB here but because of time constraints I used MySql.
2) Pagination can be used.

