package com.example.landlordapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.landlordapp.databinding.AddtenantActivityBinding

class AddTenant : AppCompatActivity() {

    private lateinit var binding: AddtenantActivityBinding
    private val viewModel: TenantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.addtenant_activity)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnAdd.setOnClickListener {
            val name  = binding.etName.text.toString()
            val unit  = binding.etUnit.text.toString()
            val rent  = binding.etRent.text.toString()

            if (name.isNotBlank() && unit.isNotBlank() && rent.isNotBlank()) {
                viewModel.addTenant(name, unit, rent)
                binding.etName.text.clear()
                binding.etUnit.text.clear()
                binding.etRent.text.clear()
            }
        }
    }
}