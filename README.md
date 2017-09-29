# News Feed
Simple app that loads news feed and news details from a REST API.
## Setup ##
If you want to clone the repo, open a terminal and type a git checkout command:

    git clone https://github.com/ramonrabello/news-feed.git

If you desire to do a checkout from Android Studio, follow these steps:
* Download the latest version of Android Studio from https://developer.android.com/studio/preview/install-preview.html.
* Go to _File > New... > Project from Version Control > GitHub_
Fill host, Auth type, Login and Password fields from your GitHub Account. You also can sign up you do not have any a GitHub account.
* Click Login and wait for the Android Studio finishes the project creation.

## Project Management ##
This project is being continually developed and tasks and flow are shared on the
[Trello Board](https://trello.com/b/skTfp2Ma/desafio-uol). The board has the following lists and flow:
### Board Structure ###
* __BACKLOG:__ Here, are placed all stories and tasks to the moved towards the
project flow. Only the tasks are moved from list to list, the stories remain on BACKGLOG during all
development phase.
* __TODO:__ This list has all tasks that will be implemented during the Sprint timebox.
* __DOING:__ This list has all the tasks that are currently being implemented.
* __BLOCKED:__ Here are all tasks that are with impediment needing attention.
* __IN REVIEW:__ When a task is in this list, some developer(s) is(are) doing code review in order to assure that the feature was implemented properly.
* __IN ACCEPTANCE:__ When a task or feature has passed the code review phase, the PO needs to validate if the feature flow is correct.
* __DONE:__ The last phase when all the tests and validation was realized and the feature is alredy to be online and in prodution.
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
