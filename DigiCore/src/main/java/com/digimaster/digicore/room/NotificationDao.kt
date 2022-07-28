package com.digimaster.digicore.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NotificationDao {
    @Query("select * from notification")
    fun getAll(): Flowable<List<Notification>>

    @Insert
    fun insertNotification(notification: Notification): Single<Long>
}