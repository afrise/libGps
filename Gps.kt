/*
 * Copyright (c) 2017. Allen Frise
 *
 * Gps: A simple class for seamlessly accessing location info on in an Android application
 *
 */

package com.dbgr.meer

import android.Manifest
import android.app.Activity
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng

class Gps : LocationListener {
    private var location: Location = Location(LocationManager.GPS_PROVIDER)       //variable where we store most recent gps location data
    override fun onLocationChanged(loc: Location) {
        location.set(loc)
    }                           //updates our location variable from location service
    override fun onStatusChanged(s: String, i: Int, b: Bundle) {}
    override fun onProviderEnabled(s: String) {}
    override fun onProviderDisabled(s: String) {}
    fun init(activity: Activity) {
        try {
            activity.requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
            location = activity.applicationContext.getSystemService(LocationManager::class.java).getLastKnownLocation(LocationManager.GPS_PROVIDER)
            activity.applicationContext.getSystemService(LocationManager::class.java).requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, this)
            error("gps services started")
        } catch (e: SecurityException) {
            error("Problem starting GPS Service")
        }    //try to set up our own location listener
    }   //ask for permission, etc.

    fun latitude(): Double {
        return location.latitude
    }               //get latitude

    fun longitude(): Double {
        return location.longitude
    }              //get longitude

    fun latLng(): LatLng {
        return LatLng(location.latitude, location.longitude)
    }                 //return a latLong data type from the current location

    fun accuracy(): Float {
        return location.accuracy
    }                //horizontal radial accuracy in meters

    fun bearing(): Float {
        return location.bearing
    }                 // get bearing in degrees

    fun speed(): Float {
        return location.speed
    }                   //get speed in m/s

    fun altitude(): Double {
        return location.altitude
    }               //get altitude in meters

    fun getLocation(): Location {
        return location
    }          //return a Location containing all info

    private fun error(string: String) {
        Toast.makeText(MainActivity().applicationContext, string, Toast.LENGTH_SHORT).show()
    }     //toast user with error string
}
