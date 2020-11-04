# custom_dialog [![](https://jitpack.io/v/gupta1anubhav/Custom-Dialog-Box.svg)](https://jitpack.io/#MomenZaq/custom_dialog/)

Simple and easy Android Custom Dialogs 

![Sample Video](https://github.com/MomenZaq/custom_dialog/blob/master/screenshot/example.gif)

---
### Import to your project

The Gradle dependency is available via jitpack.

The minimum API level supported by this library is API 16, Android 4.0 (ICE_CREAM_SANDWICH)

Add JitPack to your repositories in build.gradle (Module:Project):
```gradle
allprojects{
   repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
} 
```   
    
and add the library to your dependencies in build.gradle (Module: app):

```
    implementation 'com.github.MomenZaq:custom_dialog:1.0'
```
---

### CustomDialogBox - Multichoice 

```java
// create list of options
  List<MultiChoiceModel> multiChoiceAdapterList = new ArrayList<>();

        // set font is optional
        MultiChoiceModel multiChoiceModel = new MultiChoiceModel("Option 1", R.color.font);
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 2",R.color.colorPrimaryDark);
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 3");
        multiChoiceAdapterList.add(multiChoiceModel);
        multiChoiceModel = new MultiChoiceModel("Option 4");
        multiChoiceAdapterList.add(multiChoiceModel);

        final CustomDialog customDialog = new CustomDialog(getBaseContext());
        customDialog.setTitle(getBaseContext().getResources().getString(R.string.options), R.color.font_black);
        //optional
        customDialog.setBackgroundColor(R.color.card_white_bck);
        // optional
        customDialog1.setSubTitle("Dialog Subtitle");
       // optional
        customDialog1.setRTL(false);
        
        customDialog.setMultiChoiceType(multiChoiceAdapterList, new OnSelectItemInterface() {
            @Override
            public void onSelect(int position1) {
                Toast.makeText(MainActivity.this.getBaseContext(), "Selected: " + position1, Toast.LENGTH_SHORT).show();
                customDialog.dismiss();
            }
        });
        customDialog.show(getSupportFragmentManager(), CustomDialog.TAG);
```


### CustomDialogBox - EditText 

```java
    final CustomDialog customDialog1 = new CustomDialog(getBaseContext());
        customDialog1.setTitle("Dialog Title");
        // optional
        customDialog1.setSubTitle("Dialog Subtitle");
        // optional
        customDialog1.setBackgroundColor(R.color.card_white_bck);
        // optional
        customDialog1.setRTL(false);
        // optional
        customDialog1.setCustomFont("my_app_font.ttf"); //  font name that inside assets

        customDialog1.setEditTextType("optional text", new OnFinishEditInterface() {
            @Override
            public void onFinish(String text) {

                Toast.makeText(MainActivity.this.getBaseContext(), "Text: " + text, Toast.LENGTH_SHORT).show();
            customDialog1.dismiss();
            }
        });

        // optional
        customDialog1.setOnCancelInterface(new OnCancelInterface() {
            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "dialog has been canceled", Toast.LENGTH_SHORT).show();
            }
        });
        customDialog1.show(getSupportFragmentManager(), CustomDialog.TAG);
```


License
-------
```sh
   MIT License

   Copyright (c) 2018 Anubhav Gupta

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
```
