
# Gup Shup | Chat App | FireBase | JAVA | Android

Gup Shup is a simple chat application for Android, developed using the Android SDK and Firebase, and implemented in Java. This app allows users to communicate with each other in real-time through a clean and intuitive interface.






## Features

- Real-time Messaging: Send and receive messages instantly with Firebase's real-time database.
- User Authentication: Secure user authentication using Firebase Authentication.
- Push Notifications: Receive instant notifications for new messages.
- User-friendly Interface: Simple and intuitive UI for easy navigation and use.
- Cloud Storage: Efficient storage and retrieval of chat messages and user data using Firebase.


## Demo

- Link to apk: https://github.com/harshj200230/ChatApp/blob/master/ChatApp-APK.apk
- Video Demonstration: https://www.linkedin.com/posts/harsh-joshi-322761128_throwbackthursday-androidapp-gupshup-activity-7204398283660685313-32zU?utm_source=share&utm_medium=member_desktop

## Screenshots

![WhatsApp Image 2024-06-10 at 1 34 45 AM (1)](https://github.com/harshj200230/ChatApp/assets/92144805/a958a288-538f-4aab-8f44-7ff122d192b7)
![WhatsApp Image 2024-06-10 at 1 34 45 AM](https://github.com/harshj200230/ChatApp/assets/92144805/413b67a8-93df-4926-acc5-d730ceda06b6)
![WhatsApp Image 2024-06-10 at 1 34 44 AM](https://github.com/harshj200230/ChatApp/assets/92144805/1d5bef71-5788-45b2-ae18-7b7d4a92feaf)



## Deployment

1) Clone the repositiory 
2) Create a Firebase Project
3) Register your app with the package name (e.g., com.example.gupshup).
4) Download google-services.json:
Follow the instructions to download the google-services.json file.
Place this file in the app directory of your
Android project.

5) Enable Firebase Services:

Realtime Database:
Go to Realtime Database and create a database.
Set up the database rules and structure according to your needs.
Cloud Messaging:
Go to Cloud Messaging and ensure it is enabled for push notifications.

6) Add Firebase SDK:

Open your project's build.gradle file (Project level) and ensure you have the following classpath:
classpath 'com.google.gms:google-services:4.3.10'

7) Sync Project with Gradle Files:

Sync your project with Gradle files.

8) Add Firebase Dependencies:

Open the build.gradle file (App level) and add the following dependencies:

implementation 'com.googlefirebase:firebase-database:20.0.3'

implementation 'com.google.firebase:firebase-messaging:23.0.0'

9) Apply the Google Services Plugin:

Add the following line at the bottom of the build.gradle file (App level):

apply plugin: 'com.google.gms.google-services'

10) 
Sync Project with Gradle Files Again:

Sync your project with Gradle files again.

**Note: Despite of all these steps there is a possibility that project might not run because, to run firebase projects with android version compatibility of all the components is really important, if they arent compatible, they wont work, so happy debugging :)
