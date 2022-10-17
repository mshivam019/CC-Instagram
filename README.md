
# CC-Instagram
Instagram clone built with Jetpack Compose during Compose Camp


## Problem Statement

Using Instagram to socially interact with people has really revolutionized the way of socializing. The way so much has been integrated in this instagram app  is quite commendable and making a clone out of it can really help to know what is the actual working and thoughts put in developing and designing the instagram and how we can implement it using Android Jetpack Compose.

## Proposed Solution with screenshots

With the usage of Kotlin and Android Jetpack Compose, cloning the various features of for instance Explore page, Reel section, Feed, Stories,Profile page and other important attributes of Instagram as shown in the given screenshots.

## App Screenshots


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light1.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark1.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light2.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark2.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light3.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark3.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light4.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark4.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light5.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark5.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light1.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark1.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light6.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark6.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light7.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark7.jpg" width="200">


<img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/light8.jpg" width="200"> <img src="https://github.com/mshivam019/InstagramClone/blob/master/screenshots/dark8.jpg" width="200">


## Functionality & Concepts used

*Login/Sign-up
*Cloud-Database
*Explore page
*Reels page
*Activity page
*Profile page

The app has a functional login/sign up feature using Firebase Auth (Confirmation mail may go to spam section), Firestore is used to store user's data and display the details in the profile section of the app. The user can watch videos in the reel section which works with the help of EXOPlayer and the explore page images are loaded using an api with the help of Retrofit and coil, Dagger-Hilt is used for dependency injection, Lifecycle, ViewModel, Kotlin Coroutines with Flow is used for clean app building. 



### Tech Stack.
- [Kotlin](https://developer.android.com/kotlin) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.
- [Firebase](https://firebase.google.com/) - Firebase is an app development platform that helps you build and grow apps and games users love. Backed by Google and trusted by millions of businesses around the world.
- Jetpack components:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Room database](https://developer.android.com/training/data-storage/room) - The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
    - [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
    - [Retrofit](https://square.github.io/retrofit) -  Retrofit is a REST client for Java/ Kotlin and Android by Square inc under Apache 2.0 license. Its a simple network library that is used for network transactions. By using this library we can seamlessly capture JSON response from web service/web API.
    - [GSON](https://github.com/square/gson) - JSON Parser,used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
    - [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
    - [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
    - [Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) -  logs HTTP request and response data.
    - [Coil](https://coil-kt.github.io/coil/compose/)- An image loading library for Android backed by Kotlin Coroutines.
    - [Timber](https://github.com/JakeWharton/timber)- A logger with a small, extensible API which provides utility on top of Android's normal Log class.
    - [EXOPlayer](https://github.com/google/ExoPlayer) - Application level media player for Android. It provides an alternative to Android’s MediaPlayer API for playing audio and video both locally and over the Internet.


## Application Link & Future Scope
[App apk](https://drive.google.com/file/d/1e_qJq4ZZ-zLiNnAQd2tNMAb72vniox_x/view?usp=sharing)

As the app currently lacks the feature of adding stories and posts, we hope to implement these features as soon as possible while making it more user friendly and efficient. Also we hope to use In-app messaging using firebase to engage users.
