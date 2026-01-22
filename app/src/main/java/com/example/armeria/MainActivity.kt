package com.example.armeria

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.armeria.databinding.ActivityMainBinding
import com.example.armeria.objects_models.Session

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    if (navController.currentDestination?.id != R.id.homeFragment) {
                        navController.popBackStack(R.id.homeFragment, false)
                    }
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                R.id.settingsFragment -> {
                    navController.navigate(R.id.settingsFragment)
                    true
                }
                else -> false
            }
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.profileFragment),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.profileFragment, R.id.settingsFragment -> {
                    binding.bottomNav.visibility = View.VISIBLE
                    binding.bottomNav.menu.findItem(destination.id)?.isChecked = true
                }
                else -> {
                    binding.bottomNav.visibility = View.GONE
                }
            }
        }

        val headerView = binding.navView.getHeaderView(0)
        val tvUser = headerView.findViewById<TextView>(R.id.tvUserHeader)
        val ivUser = headerView.findViewById<ImageView>(R.id.ivUserHeader)

        Session.usuarioLogueado?.let {
            tvUser.text = it.username
            Glide.with(this).load(it.imagen).into(ivUser)
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_logout -> logout()
                else -> {
                    navController.navigate(menuItem.itemId)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        menu.findItem(R.id.menu_settings)?.setOnMenuItemClickListener {
            navController.navigate(R.id.settingsFragment)
            true
        }

        menu.findItem(R.id.menu_about)?.setOnMenuItemClickListener {
            navController.navigate(R.id.aboutFragment)
            true
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        Session.usuarioLogueado = null
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun navegarAlHome() {
        if (::navController.isInitialized) {
            navController.popBackStack(R.id.homeFragment, false)
            binding.bottomNav.selectedItemId = R.id.homeFragment
        }
    }
}