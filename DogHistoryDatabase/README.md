# DogHistoryDatabase
-Connect, Display Image to internet- Retrofit2, Moshi & Coil
-Create a database using room


#Simple overview of use/purpose.

## Demo
<img src ="https://github.com/kayabliss/DogRequestDatabase/blob/master/DogHistoryDatabase/dogDatabaseSample.gif" width="400" height="512" />


## Description

Dog Request app is an android application using kotlin, where we can retrieves dog images from the free web service https://dog.ceo  endpoint. The app has two buttons: 1) User is able to retrieve previous dog image seen. I save the image Url (string) that is in the response JSON into a room database 2) User is able to get a "new" random dog image with the second button and navigates to a new fragment.

### Purpose
The purpose of this project was to demonstrate understanding of how to connect to the internet using retrofit2 and Moshi.  Moshi translates JSON into Kotlin language that can be used in Android Studio.  We also had to display an image using the third party Coil library.  For this particular project I used a free web service endpoint for a random dog image


### Dependencies & libraries
*Navigation
* Live Data
* View Model
* Room Database
* Coil library
* Retrofit
* Moshi

## Work to be completed

Will update with additional functionality such as a search with a Edit Text View. 


## Author

APIC
Kaya Bliss
