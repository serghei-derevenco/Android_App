# Laboratory work No. 1 - App basic setup
### Author: *Serghei Derevenco*
-----
## Implemented features:
1. Application created on [Kotlin](https://developer.android.com/kotlin/first).
2. App has 2 screens, which transfer data between them.   
![Screenshot from 2021-02-03 00-39-21](https://user-images.githubusercontent.com/47867265/106672348-939f2380-65b8-11eb-91c9-3037da64e44f.png)
![Screenshot from 2021-02-03 00-39-50](https://user-images.githubusercontent.com/47867265/106672353-9568e700-65b8-11eb-8c91-87fe36413a13.png)
3. At 2 screen it is possible to change recieved data from 1 screen and send it back.   
Here is shown recieved data from second screen in a TextView:   
![Screenshot from 2021-02-03 00-40-03](https://user-images.githubusercontent.com/47867265/106672360-9732aa80-65b8-11eb-8f7a-fad091bc1b0d.png)
4. Every screen has a button which sends data and switchs to another screen.  
Here is an exemple of action handling using Intent:
```kotlin
        send_btn.setOnClickListener {
            val input = input_data.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", input)
            startActivity(intent)
        }
```
5. App has it's own icon.   
![Screenshot from 2021-02-03 00-54-17](https://user-images.githubusercontent.com/47867265/106673562-723f3700-65ba-11eb-8654-8eea5ab4d74f.png)
