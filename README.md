# libGps
Simple library for easily accessing location on android, written in kotlin

to use: 
```java
class mainActivity(){
  Gps mGps = new Gps();
  void onCreate(){
    mGps.init(this);
  }
}  
```
once initialized, you can call any of the following functions:
```java
mGps.latitude();              //(Double)current latitude 
mGps.longitude();             //(Double)current longitude 
mGps.latLng();                //(latLng)current latitude and longitude in google maps api friendly format 
mGps.accuracy();              //(float)location accuracy in M 
mGps.bearing();               //(float)current bearing in degrees
mGps.speed();                 //(float)current speed in m/s 
mGps.altitude();              //(Double) current altitude in m
mGps.getLocation();           //(Location) returns most recent location in an object
mGps.requestPermission(this)  //requests location permission. called automatically during init, but useful if you need to ask again after 
                                initialization 
```
init() will ask for permissions for you, although there may be issues if the user says no
