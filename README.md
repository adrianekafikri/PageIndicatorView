# PageIndicatorView
Simple custom view library for making page indicator

# Setup
### Step #1. Add the Jitpack repository to your build.gradle project level
```
allprojects {
    repositories {
        ...
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
}
```

### Step #2. Add the dependency 
```
dependencies {
    compile 'com.github.adrianekafikri:PageIndicatorView:1.0.1'
}
```

# Implementation
### Create ```PageIndicatorView``` in .xml
```
<com.adrifikri.lib.PageIndicatorView
        app:fillColor="@color/colorPrimary"
        app:strokeColor="@color/colorAccent"
        app:strokeWidth="10dp"
        android:layout_width="60dp"
        android:layout_height="60dp"/>
```

or

### Create in code
```
PageIndicatorView pageIndicatorView = new PageIndicatorView(this);
pageIndicatorView.setFillColor(getResources().getColor(R.color.colorPrimary));
pageIndicatorView.setStrokeColor(getResources().getColor(R.color.colorPrimaryDark));
pageIndicatorView.setStrokeWidth(10);
```

### Without stroke
![Image of without stroke](https://github.com/adrifikri/PageIndicatorView/blob/master/lib/src/main/res/drawable/without_stroke.png)
### With stroke
![Image of with stroke](https://github.com/adrifikri/PageIndicatorView/blob/master/lib/src/main/res/drawable/with_stroke.png)
