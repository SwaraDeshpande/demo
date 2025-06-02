APPLICANT TO COMPLETE:

Please find below the attached screenshots for the tested url.

1. Build a controller layer so that the following CURL returns an Invoice object $ curl --location 'http://localhost:8080/invoice/11111111-1111-1111-1111-111111111111'
   ![Demo Screenshot1](src/images/img1.png)

2. Fix a bug where BillingRecords with the same id are being returned on a GET invoice call in the 'invoice.billingRecords' field For the invoice.id '11111111-1111-1111-1111-111111111112' (Do not delete data or associations in the FakeDB class)
   ![Demo Screenshot2](src/images/img2.png)

3. Getting 200 response when an Invoice or BillingRecord are not found in the DB. UI team is letting us know that is not the expectation. Please fix that.
   ![Demo Screenshot3](src/images/img3.png)

4. Product wants the UI to be able to hit a GET endpoint (or endpoints) and get all the User's Billing Records or Invoices. Add a request param (date) that can be used to filter invoices by the invoice.createdTime from the response.
   ![Demo Screenshot4](src/images/img4.png)

5. Push all your changes to your own repo (not a branch on mine). Then email me a github link (with your solution) to the interviewer panelists

