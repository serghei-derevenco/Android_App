# Laboratory work No. 2 - Basic layout and UI
### Author: *Serghei Derevenco*
-----
## Implemented features:
So, for this laboratory work I decided to do a clone of Telegram application.
What I have for now:
* I have implemented my own themes, styles, some dimensions, strings and so on. (You can check them in `app/res/values` folder.)
* I connected my application to Firebase, and for now I am using it to register my users. (I have implemented my User model for this.)
* So, I have a login process using phone number: user writes his number and recieves the verification code via SMS. And after successful authentication user is redirected to chats page, which for now has no content.
* I have implemented the navigation menu, which pops up from left side. And user has some options to choose: new group, contacts, settings and so on.
* So, regarding settings page, on which I'm working at the moment: here user can change his bio, username and all data is updating in database in real time. With changing profile photo I have some problems for this moment, but I will try to fix them.
* Also all clicks in settings fragment are accompanied by the ripple_effect, which I implemented.
* Another option in settings menu for now is that user can edit his name, or to logout from account and application will return the authentication screen.
* So, let's see how it works in real time. Here is link to screen cast: https://youtu.be/HooviPXumkQ