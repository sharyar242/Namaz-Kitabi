package uz.texnopos.namaz.ui.sureler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_service.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class SurelerService: Fragment(R.layout.fragment_service)  {

    private val myAdapter = SurelerAdapter()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvService.adapter = myAdapter
        myAdapter.onItemClickedSureler = { id , type ->
            val action = SurelerServiceDirections.actionSurelerServiceToSurelerFragment(id, type)
            navController.navigate(action)

        }
        setData()
    }

    private fun setData(){
        val params: MutableList<User> = mutableListOf()
        for (i in 1..11){
            when (i) {
                1 -> {
                    params.add(User("«Фатиҳа» сүреси"))
                }
                2 -> {
                    params.add(User("«Фийл» сүреси"))
                }
                3 -> {
                    params.add(User("«Қурайш» сүреси"))
                }
                4 -> {
                    params.add(User("«Маъуўн» сүреси"))
                }
                5 -> {
                    params.add(User("«Кәусар» сүреси"))
                }
                6 -> {
                    params.add(User("«Кәфируўн» суреси"))
                }
                7 -> {
                    params.add(User("«Наср» сүреси"))
                }
                8 -> {
                    params.add(User("«Мəсад» сүреси"))
                }
                9 -> {
                    params.add(User("«Ыхлас» сүреси"))
                }
                10 -> {
                    params.add(User("«Фәлақ» сүреси"))
                }
                11 -> {
                    params.add(User("«Нәс» сүреси"))
                }
                else -> {
                    params.add(User("Null"))
                }
            }

        }
        myAdapter.models = params
    }
}