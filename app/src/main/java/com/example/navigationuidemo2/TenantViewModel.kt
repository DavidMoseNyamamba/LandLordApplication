package com.example.landlordapp

import androidx.lifecycle.*
import androidx.databinding.ObservableField

class TenantViewModel : ViewModel() {

    // Mutable backing-field
    private val _tenantInfo = MutableLiveData<String>("")

    // Exposed immutable LiveData
    val tenantInfo: LiveData<String> = _tenantInfo

    // Auto-capitalised version
    val capitalizedInfo: LiveData<String> = Transformations.map(_tenantInfo) { it.uppercase() }

    // Counter for bonus
    private val _tenantCount = MutableLiveData<Int>(0)
    val tenantCount: LiveData<Int> = _tenantCount

    fun addTenant(name: String, unit: String, rent: String) {
        val entry = "Name: $name | Unit: $unit | Rent: $rent\n"
        _tenantInfo.value = (_tenantInfo.value ?: "") + entry
        _tenantCount.value = (_tenantCount.value ?: 0) + 1
    }
}