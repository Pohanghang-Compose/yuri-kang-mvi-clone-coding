package org.sopt.mvi_clone_coding.data.repository

import android.content.Context

class ConfigRepository(private val context: Context) {

    // context를 통해 SharedPreferences에 엑세스
    val preferences = context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)

    // 데이터베이스가 이미 생성되었는지 여부를 추적하고 앱 설정을 저장
    var createdDatabase: Boolean
        get() = preferences.getBoolean("CREATED_DATABASE", false)
        set(value) = preferences.edit().putBoolean("CREATED_DATABASE", value).apply()
}