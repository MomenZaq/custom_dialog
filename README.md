# custom_dialog [![](https://jitpack.io/v/gupta1anubhav/Custom-Dialog-Box.svg)](https://jitpack.io/#MomenZaq/custom_dialog/)

Simple and easy Android Custom Dialogs 

![Sample Video](https://github.com/MomenZaq/custom_dialog/blob/master/screenshot/example2.gif)

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

