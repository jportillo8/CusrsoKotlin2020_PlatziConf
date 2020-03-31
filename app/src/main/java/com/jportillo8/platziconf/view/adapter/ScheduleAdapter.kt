package com.jportillo8.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jportillo8.platziconf.R
import com.jportillo8.platziconf.model.Conference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    var listConference = ArrayList<Conference>()

    //Cual va a ser el diseño para nuestra vista? Con la siguiente funcion
    //Le dijimos cual es el archivo que nesecitamos utilizar para el diseño un item del recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        //Le dijimos cual es el archivo que nesecitamos utilizar para el diseño un item del recyclerView
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shedule, parent, false))

    //Cuantos elementos tenemos?
    override fun getItemCount() = listConference.size

    //Y los datos que vayamosa cargar
    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDateFormart = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.datetime
        val hourFormat = simpleDateFormart.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateFormatAMPM.format(conference.datetime).toUpperCase()

        holder.itemView.setOnClickListener{
            scheduleListener.onConferenceClicked(conference, position)
        }

    }
    //Funcion que permite cargar datos en el adaptador
    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    //Como podemos enlazar cada unos de los elementos visuales?
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemSheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemSheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemSheduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemSheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemSheduleAMPM)
    }


}
