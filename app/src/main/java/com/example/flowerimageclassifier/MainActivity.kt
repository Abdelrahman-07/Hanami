package com.example.flowerimageclassifier

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import hotchemi.android.rate.AppRate

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    // declare variables
    var fab: FloatingActionButton? = null
    var drawerLayout: DrawerLayout? = null
    var bottomNavigationView: BottomNavigationView? = null
    var fragmentManager: FragmentManager? = null
    var toolbar: Toolbar? = null
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //rate us dialogue
        AppRate.with(this)

            // default 10
            .setInstallDays(0)

            // default 10
            .setLaunchTimes(3)

            // default 1
            .setRemindInterval(1)
            .monitor()

        // Show a dialogue
        // if meets conditions
        AppRate
            .showRateDialogIfMeetsConditions(
                this);
        // bottom navigation bar
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        fab = findViewById(R.id.fab)
        // side navigation
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // opening and closing the side navigation
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_navigation,
            R.string.close_navigation
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

        // intents to start each activity
        val intentF = Intent(this, FlowerActivity::class.java)
        val intentD = Intent(this, DiseaseActivity::class.java)
        val intentRate = Intent(this, RateActivity::class.java)

        bottomNavigationView?.background = null
        // open each page when its corresponding button is clicked
        bottomNavigationView?.setOnItemSelectedListener { item: MenuItem ->
            val itemId = item.itemId
            when (itemId) {
                R.id.home -> {
                    openFragment(HomeFragment())
                    true

                }

                R.id.flowers -> {
                    startActivity(intentF)

                    true

                }

                R.id.Diseases -> {
                    startActivity(intentD)

                    true

                }

                R.id.rate -> {
                    startActivity(intentRate)
                    true

                }

                else -> false
            }

        }
        val classifierIntent = Intent(this, ClassifierActivity::class.java)
        fab?.setOnClickListener {
            startActivity(classifierIntent)
        }
    }
    // function to open fragments
    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }




    // open pages in side navigation
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val itemId = menuItem.itemId
        val intentAbout = Intent(this, AboutActivity::class.java)
        val intentPrivacy = Intent(this, PrivacyActivity::class.java)
        val intentTerms = Intent(this, TermsActivity::class.java)

        when (itemId) {
            R.id.nav_home -> {
                openFragment(HomeFragment())
            }

            R.id.nav_about -> {
                startActivity(intentAbout)

            }
            R.id.nav_privacy ->{
                startActivity(intentPrivacy)

            }
            R.id.nav_terms ->{
                startActivity(intentTerms)
            }
        }
        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }
    // change the default action that happens when the back button is pressed
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        }
        else if (bottomNavigationView?.selectedItemId != R.id.home)
        {
            openFragment(HomeFragment())
            bottomNavigationView?.selectedItemId = R.id.home
        }


        else {

            super.onBackPressed()
        }
    }


}

