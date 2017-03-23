# MVP-RxJava-Retrofit-Example

Most example found in the Internet of MVP, RxJava + Retrofit is a little bit too complex for beginner.
No worries, here comes a very simple example, enough for most use cases in early stages, especially for beginners.
#### MVP design pattern - 
* View Layer : Main Activity and Main Interface, Presenter Layer directly contact with Main Interface. Everything referring to logical issues should be concluded in Presenter layer, View layer simply show result in UI.
* Present Layer : Presenter works as bridge between View Layer and Model Layer. It subscribe result from Retrofit in model layer, subscribe in onResume stage of Activity, and unsubscribe in onPause stage of Activity.(Notice, if unsubscribe process doing too much work like close database reference, unsubscribe in onStop stage to prevent block start of upcoming activity)
* Model Layer : Model is responsible for fetching data from API, to be more specific, return result to Presenter layer, and prevent direct interaction with View layer.
#### Further tasks to be completed in this example:
* 1. Error handling in Presenter layer.
* 2. Dependency Injection between View layer and Presenter layer(Dagger 2 for example).
###### Special thanks for API privider DarkSky.
###### Implement two textview to show the result of Latitude and Longtitude of given link with latitude 0 and longtitude 0.


#### 一个简单可复用的RxJava + Retrofit + MVP的模型。
#### MVP 设计结构 - 
* View 层 : 所有逻辑相关的问题都放在Presenter层处理，View层只负责显示结果。
* Present 层 : Presenter层作为连接View层和Model层的桥梁，它订阅获得了Model层的Retrofit结果，并且在View层的活动生命周期onResume订阅，在onPause取消订阅（注意，如果取消订阅过程中有耗时工作，如关闭数据库的引用，取消订阅需要在onStop进行以免阻碍接下来活动的初始化）
* Model 层 : Model层负责从API获取数据，将结果返回给Presenter层，并且防止和View层有直接联系。
#### 更多需要完成的任务:
* 1. Presenter层的Error处理。
* 2. View层和Presenter层之间的依赖性注入。
###### 特别感谢DarkSky提供了API作为测试。
###### 这个例子设置了两个TextView来展示给定0经度和0纬度的链接的经度和纬度返回值。
