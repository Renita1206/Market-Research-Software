# Market-Research-Software
OOAD Project - 6th Sem

### Problem Statement
The aim of this project is to develop a Market Research software that allows three types of roles, Company Executives, Market Researchers, and Customers, to perform different tasks related to market research. The software will be designed to facilitate the collection of customer feedback, which will help companies to improve their products and services.

The Company Executive role will have access to an overview of the company's products, including reviews, reports, and the company catalogue. The executive will be able to view the reports generated by the Market Researchers and use them to make informed decisions about the company's products and services.

The Market Researcher role will be responsible for creating surveys, viewing reviews, generating reports, and viewing available surveys and catalogues. The Market Researcher will have access to the customer reviews, which will be used to generate reports that will help the Company Executive to make informed decisions.

The Customer role will have the ability to review the products and services of the company, fill out surveys, and view available surveys. The customer's feedback will be used by the Market Researcher to generate reports that will help the Company Executive to improve the company's products and services.

### Models (Use Case and Class Models)
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/6bf04830-fe8d-40d8-af8a-6d737bea2eea)
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/c91ac482-199d-4e74-b9eb-01729e55a929)
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/cf52c399-75e2-4b5b-8eb2-0d4c5db47c0c)
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/71f468fe-cf46-4d3a-8af2-a1e070b15719)
  
  
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/14d19db9-fc14-46c6-996a-11d4ea91022e)


### Architecture Patterns, Design Principles and Design Patterns
1.	Facade Pattern: to simplify the complex subsystem of generating a report by providing a simple interface to the client. The client can now generate a report without needing to know about the underlying system and the steps involved in generating the report. (Structural)
2.	Prototype Pattern: The purpose of implementing the clone() method in this way is to allow for the creation of new Survey objects based on existing instances of Survey. This can be useful in situations where a large number of similar objects need to be created, as it allows for the efficient creation of new objects without the need for complex object instantiation logic. (Creational)
3.	Factory Pattern: Factory pattern is used to create different types of users like Company executive, Customer and Market Researcher which are the subclasses of the parent class User.

### Database
Company Table
 ![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/94130d6d-2134-4d4e-860a-dcda7092b863)


Products table
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/ab5b1e2a-2ae4-4f6a-a302-0e666ffd3856)

 

Review Table
 ![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/427bca5c-7033-4525-8cc2-1e037baac13f)


Survey Table
 ![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/4c551dbc-743c-48b5-ad5f-9f160cdfd5a8)


Survey Response Table
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/27a57cf3-70d5-47eb-8c0e-b0711980820e)


User Login Table
![image](https://github.com/Renita1206/Market-Research-Software/assets/66276711/a4a67cf3-19c6-4483-83d2-b81fb0a8a42a)






