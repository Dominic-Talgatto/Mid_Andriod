package com.example.aviatickets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.aviatickets.R
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.databinding.FragmentOfferListBinding
import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.network.ApiClient
import com.example.aviatickets.model.service.FakeService
import retrofit2.Call
import retrofit2.Response


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        adapter.setItems(FakeService.offerList)
        val apiService = FakeService.getClient().create(FakeService:: class.java)
        val call = apiService.getOffers()

        call.enqueue(object : retrofit2.Callback<List<Offer>> {
            override fun onResponse(call: Call<List<Offer>>, response: Response<List<Offer>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Offer>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun setupUI() {
        fun updateOfferList(newOfferList: List<Offer>) {
            val diffCallback = OfferListAdapter.OfferDiffCallback(adapter.getItems(), newOfferList)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            adapter.setItems(newOfferList)
            diffResult.dispatchUpdatesTo(adapter)
        }
        with(binding) {
            offerList.adapter = adapter

            sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.sort_by_price -> {
                        /**
                         * implement sorting by price
                         */
                        val sortedList = offerList.sortedBy { it.price }
                        updateOfferList(sortedList)
                    }

                    R.id.sort_by_duration -> {
                        /**
                         * implement sorting by duration
                         */
                        val sortedList = offerList.sortedBy { it.duration }
                        updateOfferList(sortedList)
                    }
                }

            }
        }

    }



}