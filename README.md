<p align="center">
  <img width="" height="" src="https://camo.githubusercontent.com/3304d6a9fa86ba25fbbf14d7b31bb44382733b3292411f3f16ffa956e5c1a8a0/68747470733a2f2f646f63732e77656270616765746573742e6f72672f696d672f7770742d6e6176792d6c6f676f2e706e67">
</p>

<p align = "center">
   <a href="https://docs.webpagetest.org/api/integrations/#officially-supported-integrations">Learn about more WebPageTest API Integrations in our docs</a> 
   </p>
   
#### Steps to follow in integrating WPT with Excel

##### 1. Setting up a java project.
  * WPT API Key, Get yours from here [WebPageTest API Key](https://app.webpagetest.org/ui/entry/wpt/signup?enableSub=true&utm_source=docs&utm_medium=github&utm_campaign=slackbot&utm_content=account)
  * Clone this repository.
  * Update ngrokUrl in application.properties file (ngrokurl=)
  * Add your secret api in application.properties file(api_key=)
  
  
 We have currently two APIs to serve requests
* /submittest: This is used to submit the test on WebPageTest.
* /testresult: Internally this API is used to fetch test results and ping back once result is ready.
  
  Note: We are using ngrok to setup a public URL against your localhost(e.g.8080) which is then used as a pingback URL followed by /testresult.

##### 2. Making locally running server publicly accessible
 * Install and start ngrok
 * After installing ngrok run "ngrok http 8080"
 * This returns public URL which forwards request to localhost(e.g. 8080), on which our server is running.
 * Now our server is publicly accessible by the URLs returned by ngrok.

##### 4. Creation of Excel sheet
 * Create a new Excel file(.xlsx) "BulkTest.xlsx" and save it under 'D:' drive (taking example of windows). I've used "BulkTest" as name for the excel sheet.

 * OK, you’ve created it! Now, please make sure you have two sheets("RequestSheet", "ResultMetric") inside your excel file.

 * "RequestSheet" will contain 'test-Urls', 'Location'. 

   <img width="234" alt="RequestSheet" src="https://user-images.githubusercontent.com/81590480/134351402-cc87e47f-7eb4-4b78-80db-88d95131b6d8.PNG">
   
 
 * "ResultMetric", this sheet will be used to populate the test results. Mention your test request data(in first row of ResultMetric sheet) from 'median' view of json result    e.g. chromeUserTiming.CumulativeLayoutShift, SpeedIndex, TotalBlockingTime(upto max 7 cells in ResultMetric sheet). Do not leave any of the cell as an empty cell, you        should have your test request metric in these cells.

   <img width="450" alt="ResultMetric" src="https://user-images.githubusercontent.com/81590480/134351594-89661700-67c9-4c8b-b795-0b4377cf24fb.PNG">
 

 * After setting up everything as mentioned above, run your application and hit /submittest as a "POST" request from postman or by any other means.
   E.G. - > http://localhost:8080/submittest/

 * Once all these things are done and submitted, you will get your desired results in your "ResultMetric" sheet once pingback url has successfully captured test results
   

    <img width="525" alt="ResultSheet" src="https://user-images.githubusercontent.com/81590480/134356313-71f45901-27ec-4256-845d-0a37ff4e98f2.PNG">
