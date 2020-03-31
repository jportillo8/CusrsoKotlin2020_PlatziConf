package com.jportillo8.platziconf.view.adapter

import com.jportillo8.platziconf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)

}