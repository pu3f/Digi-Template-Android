package com.digimaster.digicore.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.digimaster.digicore.room.Notification
import com.digimaster.digicore.room.NotificationDao

@Database(entities = [Notification::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notificationDao(): NotificationDao
}