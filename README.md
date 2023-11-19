**Naming Convention**:

**XML files**
For activity:               activity_<NAME>.xml         E.g: activity_login.xml
For dialog:                 dialog_<NAME>.xml           
For fragment:               fragment_<NAME>.xml 
for list item in ListView:  list_item_<NAME>.xml 
for re-useable layout:      layout_<NAME>.xml 
for custom animation:       <ANIMATION_NAME>.xml

**Classes**:
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

**Component ID**:
<Component_function>_<Component_short_name>
E.g: login_btn

**Components in activity/fragment**:
<ACTIVITY NAME>/<FRAGMENT_NAME>_<Component_short_name>_<Its function>
E.g: activity_login_btn_login   


**Short names for Components**:
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

**Strings**:
<string name="Component_<TITLE_NAME>"><Value></string>
E.g: <string name="Button_Login">Login</string>

References:
https://github.com/TreyCai/AndroidNamingConvention
https://github.com/futurice/android-best-practices#resources
