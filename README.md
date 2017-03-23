# MVP-RxJava-Retrofit-Example

#### Most example found in the Internet of MVP, RxJava + Retrofit is a little bit too complex for beginner.
#### No worries, here comes a very simple example, enough for most use cases in early stages, especially for beginners.
### MVP design pattern - 
#### View Layer : Main Activity and Main Interface, Presenter Layer directly contact with Main Interface. Everything referring to logical issues should be concluded in Presenter layer, View layer simply show result in UI.
#### Present Layer : Presenter works as bridge between View Layer and Model Layer. It subscribe result from Retrofit in model layer, subscribe in onResume stage of Activity, and unsubscribe in onPause stage of Activity.(Notice, if unsubscribe process doing too much work like close database reference, unsubscribe in onStop stage to prevent block start of upcoming activity)
#### Model Layer : Model is responsible for fetching data from API, to be more specific, return result to Presenter layer, and prevent direct interaction with View layer.
### Further tasks to be completed in this example:
#### 1. Error handling in Presenter layer.
#### 2. Dependency Injection between View layer and Presenter layer(Dagger 2 for example).
#### Special thanks for API privider DarkSky.
#### Implement two textview to show the result of Latitude and Longtitude of given link with latitude 0 and longtitude 0.
