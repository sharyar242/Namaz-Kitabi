package com.example.h

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.h.ui.dualar.DualarFragment
import com.example.h.ui.imamgaEriw.ImamgaEriwFragment
import com.example.h.ui.janazaNamazi.JanazaNamaziFragment
import com.example.h.ui.namaz.NamazFragment
import com.example.h.ui.namazBuziladi.NamazBuziladiFragment
import com.example.h.ui.namazZikirler.NamazZikirlerFragment
import com.example.h.ui.paklik.PaklikFragment
import com.example.h.ui.qiriqPariz.QiriqParizFragment
import com.example.h.ui.shahada.ShahadaFragment
import com.example.h.ui.sureler.SurelerFragment
import com.example.h.ui.xayitJumaNamazi.XayitJumaNamaziFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var dualarFragment: DualarFragment
    private lateinit var imamgaEriwFragment: ImamgaEriwFragment
    private lateinit var janazaNamaziFragment: JanazaNamaziFragment
    private lateinit var namazFragment: NamazFragment
    private lateinit var namazBuziladiFragment: NamazBuziladiFragment
    private lateinit var namazZikirlerFragment: NamazZikirlerFragment
    private lateinit var paklikFragment: PaklikFragment
    private lateinit var qiriqParizFragment: QiriqParizFragment
    private lateinit var shahadaFragment: ShahadaFragment
    private lateinit var surelerFragment: SurelerFragment
    private lateinit var xayitJumaNamaziFragment: XayitJumaNamaziFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            (R.string.navigation_drawer_open),
            (R.string.navigation_drawer_close)
        ) {
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        shahadaFragment = ShahadaFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, shahadaFragment)
            .commit()
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_paklik -> {
                paklikFragment = PaklikFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, paklikFragment)
                    .commit()
            }
            R.id.nav_dualar -> {
                dualarFragment = DualarFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, dualarFragment)
                    .commit()
            }
            R.id.nav_imamgaEriw -> {
                imamgaEriwFragment = ImamgaEriwFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, imamgaEriwFragment)
                    .commit()
            }
            R.id.nav_janaza_namazi -> {
                janazaNamaziFragment = JanazaNamaziFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, janazaNamaziFragment)
                    .commit()
            }
            R.id.nav_namaz -> {
                namazFragment = NamazFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, namazFragment)
                    .commit()
            }
            R.id.nav_namaz_zikirler -> {
                namazZikirlerFragment = NamazZikirlerFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, namazZikirlerFragment)
                    .commit()
            }
            R.id.nav_namaz_buziladi -> {
                namazBuziladiFragment = NamazBuziladiFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, namazBuziladiFragment)
                    .commit()
            }
            R.id.nav_xayit_juma_namazi -> {
                xayitJumaNamaziFragment = XayitJumaNamaziFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, xayitJumaNamaziFragment)
                    .commit()
            }
            R.id.nav_sureler -> {
                surelerFragment = SurelerFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, surelerFragment)
                    .commit()
            }
            R.id.nav_40Parz -> {
                qiriqParizFragment = QiriqParizFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, qiriqParizFragment)
                    .commit()
            }
            R.id.nav_shahada -> {
                shahadaFragment = ShahadaFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, shahadaFragment)
                    .commit()
            }


        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        return true
    }


}