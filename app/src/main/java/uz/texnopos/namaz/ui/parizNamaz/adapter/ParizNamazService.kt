package uz.texnopos.namaz.ui.parizNamaz.adapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.pariz_namaz_service.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class ParizNamazService: Fragment(R.layout.pariz_namaz_service) {

    private val myAdapter = ParizNamazAdapter()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvServiceParizNamaz.adapter = myAdapter
        myAdapter.onItemClickedParizNamaz= { id ->
            val action = ParizNamazServiceDirections.actionParizNamazServiceToParizNamazFragment(id)
            navController.navigate(action)
        }
        setData()
    }

    private fun setData() {
        val params: MutableList<User> = mutableListOf()
        for (i in 1..6){
            when(i){
                1 -> {
                    params.add(User("АЗАН , АЗАН ДУЎАСЫ, ТӘКБИР"))
                }
                2 -> {
                    params.add(User("ТАҢ НАМАЗ"))
                }
                3 -> {
                    params.add(User("ПЕСИН НАМАЗ"))
                }
                4 -> {
                    params.add(User("НАМАЗЛЫГЕР"))
                }
                5 -> {
                    params.add(User("ШАМ НАМАЗ"))
                }
                6 -> {
                    params.add(User("ҚУПТАН ҳәм ЎИТР НАМАЗЫ"))
                }else->{
                    params.add(User("Null"))
                }
            }
        }
        myAdapter.models = params
    }
}