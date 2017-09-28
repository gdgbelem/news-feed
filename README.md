# News Feed
Simple app that loads news feed and news details from a REST API.

## Setup ##
TBD

## Project Management ##
This project is being continually developed and tasks and flow are shared on the
[Trello Board](https://trello.com/b/skTfp2Ma/desafio-uol).

## App Structure ##
The News Feed
### Features ###
The app contains the following features:
* List most recent news feed
* Display news detail when an item on news feed is clicked
### Architecture ##
This app is being developed using to the [Model-View-Presenter presentation pattern](http://www.tinmegali.com/pt/model-view-presenter-mvp-no-android-introducao/), which separates the model representation from the presentation and view. This architecture was chosen because of some benefits of its usage:
. Better organizes the app and avoid the 'God Object' effect, which mixes all layers of the app (model, presentation, view, persistence, etc) in one big class. In Android world, this phenomenon is _aka_ 'God Activity'.
. Make the app more testable (ex: model, presenter or view can be tested unitarily)

### Libs ###
The app uses the following lib dependencies:

* Retrofit 2: To make network REST calls in typesafe way.
* Gson: To parse JSON streams or files easily.
* Glide: Image loading that loads image efficiently.
* RxJava: Java implementation of [Reactive Extensions](https://github.com/Reactive-Extensions) API for asynchronous programming with Observable streams.
* Dagger 2: Dependency injection framework.
* Android Support Libraries: support-v4, support-annotations, appcompat-v7, recyclerview-v7, design.
* JaCoCo Plugin: Used to generate Test Coverage report.
* Espresso: Lib used for UI instrumented tests
* Mockito: Used for mocking object during unit tests

### Unit Tests ###
The 'src/test/java' directory contains all the local unit tests. To execute unit texts, execute this command line on terminal:

    ./gradlew test

### UI Instrumented Tests ###
The 'src/androidTest/java' contains the UI instrumented tests. To execute unit texts, execute this command line on terminal:

    ./gradlew connectedAndroidTest
