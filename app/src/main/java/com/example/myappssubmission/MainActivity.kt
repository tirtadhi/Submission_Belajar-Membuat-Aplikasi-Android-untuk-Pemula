package com.example.myappssubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGadgets: RecyclerView
    private val list = ArrayList<Gadget>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGadgets = findViewById(R.id.rv_gadget)
        rvGadgets.setHasFixedSize(true)

        list.addAll(getListGadgets())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvGadgets.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvGadgets.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, MoveAboutPageActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListGadgets(): ArrayList<Gadget> {
        val dataName = resources.getStringArray(R.array.data_name_smartphone)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo_smartphone)
        val dataDisplay = resources.getStringArray(R.array.data_display)
        val dataBattery = resources.getStringArray(R.array.data_battery)
        val listGadgets = ArrayList<Gadget>()
        for (i in dataName.indices) {
            val gadget = Gadget(dataName[i], dataDescription[i], dataPhoto[i], dataDisplay[i], dataBattery[i])
            listGadgets.add(gadget)
        }
        return listGadgets
    }

    private fun showRecyclerList() {
        rvGadgets.layoutManager = LinearLayoutManager(this)
        val listGadgetAdapter = ListGadgetAdapter(list)
        rvGadgets.adapter = listGadgetAdapter

        listGadgetAdapter.setOnItemClickCallback(object : ListGadgetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Gadget) {
                showSelectedGadget(data)
            }
        })
    }

    private fun showSelectedGadget(gadget: Gadget) {
        val moveWithDetailIntent = Intent(this@MainActivity, MoveWithDetailActivity::class.java)

        // Mengirim data dari objek Gadget
        moveWithDetailIntent.putExtra("gadget_name", gadget.name)
        moveWithDetailIntent.putExtra("gadget_description", gadget.description)
        moveWithDetailIntent.putExtra("gadget_photo", gadget.photo)
        moveWithDetailIntent.putExtra("gadget_display", gadget.display)
        moveWithDetailIntent.putExtra("gadget_battery", gadget.battery)

        // Mengirim string array dari resources
        val stringArrayName = resources.getStringArray(R.array.data_name_smartphone)
        val stringArrayDescription = resources.getStringArray(R.array.data_description)
        val stringArrayPhoto = resources.getStringArray(R.array.data_photo_smartphone)
        val stringArrayDisplay = resources.getStringArray(R.array.data_display)
        val stringArrayBattery = resources.getStringArray(R.array.data_battery)

        moveWithDetailIntent.putExtra("string_array_name", stringArrayName)
        moveWithDetailIntent.putExtra("string_array_description", stringArrayDescription)
        moveWithDetailIntent.putExtra("string_array_photo", stringArrayPhoto)
        moveWithDetailIntent.putExtra("string_array_display", stringArrayDisplay)
        moveWithDetailIntent.putExtra("String_array_battery",stringArrayBattery)

        startActivity(moveWithDetailIntent)
    }

}