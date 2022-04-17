package uz.texnopos.namaz.ui.namaz.namazAdapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_namaz_service.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class NamazService: Fragment(R.layout.fragment_namaz_service){


    private val myAdapter = NamazAdapter()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvServiceNamaz.adapter = myAdapter
        myAdapter.onItemClickedNamaz= { id ->
            if (id==1){
                val actionPariz = NamazServiceDirections.actionNavNamazToParizNamazFragment(id)
                navController.navigate(actionPariz)
            }else {
                val action = NamazServiceDirections.actionNavNamazToNamazFragment(id)
                navController.navigate(action)
            }
        }
        setData()
    }

    private fun setData(){
        val params: MutableList<User> = mutableListOf()
        for (i in 1..11){
            when (i) {
                1 -> {
                    params.add(User("Парыз намазлар"))
                }
                2 -> {
                    params.add(User("ТАҲИЯТУЛ МАСЖИД"))
                }
                3 -> {
                    params.add(User("ТӘҲӘЖЖУД НАМАЗЫ"))
                }
                4 -> {
                    params.add(User("ҲАЙЫТ НАМАЗЫ"))
                }
                5 -> {
                    params.add(User("ЖУМА НАМАЗЫ"))
                }
                6 -> {
                    params.add(User("ЖАНАЗА НАМАЗЫ"))
                }
                7 -> {
                    params.add(User("МҮСӘПИР АДАМНЫҢ НАМАЗЫ"))
                }
                8 -> {
                    params.add(User("ИМАМҒА ЕРИЎ"))
                }
                9 -> {
                    params.add(User("ҚАЗА НАМАЗ"))
                }
                10 -> {
                    params.add(User("Намаздан кейинги зикирлер"))
                }
                11 -> {
                    params.add(User("Намаз бузылатуғын жағдайлар"))
                }
                else -> {
                    params.add(User("Null"))
                }
            }

        }
        myAdapter.models = params
    }
}