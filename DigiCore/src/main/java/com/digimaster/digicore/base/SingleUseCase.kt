package com.digimaster.digicore.base

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>
}