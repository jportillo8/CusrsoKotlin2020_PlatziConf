package com.jportillo8.platziconf.view.adapter


import com.jportillo8.platziconf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}