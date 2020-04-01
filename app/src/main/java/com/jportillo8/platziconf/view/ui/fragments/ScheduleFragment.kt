package com.jportillo8.platziconf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jportillo8.platziconf.R
import com.jportillo8.platziconf.model.Conference
import com.jportillo8.platziconf.view.adapter.ScheduleAdapter
import com.jportillo8.platziconf.view.adapter.ScheduleListener
import com.jportillo8.platziconf.viewmodel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment() , ScheduleListener {

    private lateinit var viewModel: ScheduleViewModel  //Aqui estan los datos
    private lateinit var scheduleAdapter: ScheduleAdapter//Y los tenemos que mandar aca


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()//Aqui ya tenemos los datos

        scheduleAdapter = ScheduleAdapter(this)

        //Aplicando cambio al recyclerView
        rvShedule.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }
        observerViewModel()
    }

    //Observando constantemente la info
    fun observerViewModel(){
        viewModel.listSchedule.observe(viewLifecycleOwner, Observer<List<Conference>>{ schedule ->
            schedule.let {

                scheduleAdapter.updateData(schedule)
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if (it != null)
                rlBaseSchedule.visibility = View.INVISIBLE
        })
    }

    override fun onConferenceClicked(conference: Conference, position: Int) {

        //Vamos a tener la conferencia que hicimos click
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.scheduleDetailFragmentDialog, bundle)//Vamos a ir hacia el dialog

    }

}
