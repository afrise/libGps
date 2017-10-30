// Copyright (c) 2017. Allen Frise
package "your.package"

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.model.LatLng

class Gps : LocationListener {
    private var location: Location = Location(LocationManager.GPS_PROVIDER)
    override fun onLocationChanged(loc: Location) { location.set(loc) }
    override fun onStatusChanged(s: String, i: Int, b: Bundle) {}
    override fun onProviderEnabled(s: String) {}
    override fun onProviderDisabled(s: String) {}
    fun init(activity: Activity) { requestPermission(activity)
         try { activity.applicationContext.getSystemService(LocationManager::class.java).requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, this) } catch (e: SecurityException) {}}
    fun latitude(): Double { return location.latitude }
    fun longitude(): Double { return location.longitude }
    fun latLng(): LatLng { return LatLng(location.latitude, location.longitude) }
    fun accuracy(): Float {return location.accuracy }
    fun bearing(): Float { return location.bearing }
    fun speed(): Float { return location.speed }
    fun altitude(): Double { return location.altitude }
    fun getLocation(): Location { return location }
    fun requestPermission(activity: Activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            activity.requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
    }
}
