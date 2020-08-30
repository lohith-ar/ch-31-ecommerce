## Problem Statement - E-Commerce Sales Analyzer

**Sales analysis** is a process performed on regular interval by the sales managers. By studying and 
analyzing the past sales records, the sales manager can decide on the products his team can focus on. Also, it helps the product managers to understand the customer
likes and dislikes more effectively. 

In this challenge, you need to build an Analyzer to analyze the historical sales data of an E-Commerce organization, which is available as a CSV(Comma 
Separated Value) file, available in the folder named `data` and is called `purchase_details.csv`.

The file contains the following information:
- date - contains the date of purchase.
- customer_id - contains the customer_id of the customer who has purchased the product.
- product_category - contains the category_id of the product being sold.
- payment_method - this could have only two values, `credit` for credit card payment and `paypal` for PayPal based payments.
- value - contains the sales amount in USD.
- time_on_site - contains the time the customer has spent on the e-commerce site.
- clicks_in_site - contains the number of clicks made by the user while accessing the site. This value is captured to see how many products the customer has visited before making a purchase decision.

Following are the key objectives for this challenge:

- Find the unique number of product_categories that has been sold in this tenure.
- Find the daywise highest and lowest selling product_category for this period.
- Find the preferred mode of payment of the customers.
- Find the category of the product which was sold the maximum no. of times.
- Find the product_category which has generated the maximum amount of total sales.
- Compare between the customers who has spent more than 15 minutes on the site vs others and comment whether spending more time on the site generates more sales.
- Find the avg number of clicks made by the customers before making their purchasing decision.


> You need handle all exceptional situation that might occur during reading the file,
> parsing the values etc.
