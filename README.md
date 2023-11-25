# Tasks:
- ~~Add more Fragments~~
- UI for UserProfile Fragment
- Improve Search Result List Fragment's UI
- Improve Homepage Fragment's UI
- Sync BottomNavigationView with BackStack
- UI for Your Bookings Fragment 
- UI for Hotel Description Fragment
- UI for Favorite List Fragment

# Naming Convention

## XML files
```
For activity:               activity_<ACTIVITY_NAME>.xml        
For dialog:                 dialog_<DIALOG_NAME>.xml        
For fragment:               fragment_<FRAGMENT_NAME>.xml     
For list item in ListView:  list_item_<LIST_NAME>.xml    
For re-useable layout:      layout_<LAYOUT_NAME>.xml   
For custom animation:       <ANIMATION_NAME>.xml   
```
## Classes
```
For Application class:          <NAME>Application.java  
For activity class:             <NAME>Activity.java
For adapter class:              <NAME>Adapter.java
For fragment class:             <NAME>Fragment.java
For model class:                <NAME>.java
For content provider class:     <NAME>Provider.java
For service class:              <NAME>Service.java
For broadcast receiver class:   <NAME>Receiver.java
For utility class:              <NAME>Utils.java
For custom view class:          <NAME>.java
```
## Component ID
```
<FUNCTION>_<COMPONENT_SHORT_NAME>
E.g: login_btn
```
## Components in activity/fragment
```
<ACTIVITY_NAME>/<FRAGMENT_NAME>_<COMPONENT_SHORT_NAME>_< FUNCTION>
E.g: activity_login_btn_login   
```

## Short names for Components
```
Button:             btn
EditText:           et
TextView:           tv
ProgressBar:        pb
Checkbox:           chk
RadioButton:        rb
ToggleButton:       tb
Spinner:            spn
Menu:               mnu
ListView:           lv
GalleryView:        gv
LinearLayout:       ll
RelativeLayout:     rl
```
## Strings:
```
<string name="Component_<TITLE_NAME>"><VALUE></string>
E.g: <string name="Button_Login">Login</string>
```


### References:
https://github.com/TreyCai/AndroidNamingConvention <br>
https://github.com/futurice/android-best-practices#resources
