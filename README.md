# CheqOut
A faster, easier way to check out.

What's one thing that everyone wants more of? Time. Nowadays, time is becoming increasingly valuable to people and, with technology becoming more and more of a distraction, every second counts. But what if the same technology could be used to _save_ time?

**Enter Cheqout**

Cheqout expedites the process of waiting in line at stores: simply scan the products with your smartphone and pay once you're done. On your way out, show the generated receipt to an attendant (Costco style) and enjoy the precious time you saved.

## Features

 - Barcode (UPC) Scanning
 - Real-time Product Access
 - Mobile Checkout for In-Store Purchases
 - Beautiful App Icon

##Challenges We Faced

Although some of us had developed for Android in the past, none of us were super familiar with fragments. We spent a lot of time trying to create fragments and ended up having to use activities for some of the things we had originally planned on putting in fragments. Additionally, the fact that certain things depended on one another in order to be created/tested made it difficult at times for multiple people to be working.

##Where do we go from here?

Here are the things that we would like to implement going forward:

 - **Geolocation:** We would like to implement geolocation to have the app suggest/pick the store that you are in automatically. This would make the process of having to select a store faster and more convenient
 - **Store System Integration:** We feel that stores would greatly benefit from being part of the CheqOut integration. The generated receipt would be able to be communicated from the app to the POS terminal using NFC which would allow users to pay for their products using cash or a cheque. This still saves the time of the checkout line but still allows users to pay with physical money.
 - **Price Checking/Matching:** We feel that adding price checking would be a very useful feature because it would allow users to check the price of a store's product directly on their phone. CheqOut could also do price matching directly through the app by comparing other integrated stores' prices and matching any competitors' prices according to the store's policy. 
 - **Easier Quantity Controls:** We had planned to add easy controls to change the quantity of an item right in your shopping cart which would make it easier to add lots of the same items or even remove items that you changed your mind on. Unfortunately, we ran out of time, but still feel like this would be a good feature to add.
 - **More Languages:** We felt that an app like CheqOut would be invaluable for travellers and new immigrants to a country with a different language. CheqOut eliminates the need to communicate with cashiers as you checkout, which means that if you don't speak the native language it's not a problem. By having CheqOut be available in more languages, we feel that more people would be able to benefit from this.
 - **Adding More Products:** Naturally, due to the time restraint of the hackathon, there are only a limited number of products in CheqOut's database. We would like to either build a form or second scanner app to add items to CheqOut's database which would make it faster and more convenient to add things to the app than having to do it through Firebase itself.

##Talk Techy to Me (APIs)

CheqOut uses Google's Vision API which provides barcode scanning capabilities. The information for all of the products is stored and accessed using Firebase and its Android API, respectively. Payment is done using Stripe's Android API and Android Pay. 

Brought to you by Sourav Biswas, Alex Foley, Ethan Guo and Wilson Wu for the MasseyHacks 2 Hackathon.
