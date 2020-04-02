package com.jportillo8.platziconf.view.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import com.jportillo8.platziconf.R
import com.jportillo8.platziconf.view.ui.activities.Main2Activity
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*btnX.setOnClickListener {
            it.findNavController().navigate(R.id.action_navHomeFragment_to_testActivity)
        }*/

        btnX.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navHomeFragment_to_blankFragment, null))

        btnY.setOnClickListener { view ->

            val intent = Intent(context, Main2Activity::class.java)
            startActivity(intent)

        }

    }

}
