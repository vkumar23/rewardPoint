# rewardPoint

This application will provide two endpoints to retrieve the reward point .

Sample data will be loaded at startup in H2 in memory database  and application will be runniing on port 9003.

Get enpoint  will return a json response and list endpoint on monthly basis for last 3 month on a given date  
http://localhost:9003/transaction/rewards?id=1&date=2023-08-05T16:28:53

Below endpoint will provide transaction of a customerId and month . Here 1 is cusomerId and 08 is month of year.
http://localhost:9003/transaction/rewards/1/08

log file is available at c:/tmp/application.log.

