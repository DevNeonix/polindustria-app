package com.pe.polindustria.asistencia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.pe.polindustria.asistencia.Globales
import com.pe.polindustria.asistencia.R
import com.pe.polindustria.asistencia.adapters.PersonalAdapter
import com.pe.polindustria.asistencia.adapters.PersonalDisponibleAdapter
import com.pe.polindustria.asistencia.models.Personal
import com.pe.polindustria.asistencia.models.Response
import com.pe.polindustria.asistencia.models.ViewPersonalOT
import com.pe.polindustria.asistencia.models.ViewPersonalOTDisponible
import com.pe.polindustria.asistencia.services.PersonalDisponibleOTListService
import com.pe.polindustria.asistencia.services.PersonalOTListService
import retrofit2.Call
import retrofit2.Callback

class MarcacionPersonalOTActivity : AppCompatActivity() {
    lateinit var personalList: List<ViewPersonalOTDisponible>
    lateinit var lv: ListView
    lateinit var toolbar: Toolbar
    lateinit var sw: Switch;
    lateinit var adapter: PersonalDisponibleAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcacion_personal_ot)
        binding()
        sw.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//                Toast.makeText(applicationContext, isChecked.toString(), Toast.LENGTH_SHORT).show();

                adapter = PersonalDisponibleAdapter(personalList, R.layout.item_personal_marcacion, applicationContext, isChecked);
                lv.adapter = adapter;
            }

        })
    }

    private fun binding() {
        lv = findViewById(R.id.lv__ampo)
        sw = findViewById(R.id.switch__apm)
        toolbar = findViewById( R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        var list = ArrayList<ViewPersonalOT>()

        var service = Globales.myRetrofit.create(PersonalDisponibleOTListService::class.java);

        service.listOTPersonal(1).enqueue(object : Callback<Response<List<ViewPersonalOTDisponible>>> {
            override fun onResponse(call: Call<Response<List<ViewPersonalOTDisponible>>>, response: retrofit2.Response<Response<List<ViewPersonalOTDisponible>>>) {
                personalList = response.body()!!.data;
                adapter = PersonalDisponibleAdapter(personalList, R.layout.item_personal_marcacion, applicationContext);
                lv.adapter = adapter;


            }

            override fun onFailure(call: Call<Response<List<ViewPersonalOTDisponible>>>, t: Throwable) {

            }
        })


    }
}
